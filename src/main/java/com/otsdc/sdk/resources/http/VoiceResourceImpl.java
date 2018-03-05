/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 OTS
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.otsdc.sdk.resources.http;

import com.google.gson.reflect.TypeToken;
import com.otsdc.sdk.OTSRestResponse;
import com.otsdc.sdk.constant.ParamConstant;
import com.otsdc.sdk.model.ResponseModel;
import com.otsdc.sdk.model.call.*;
import com.otsdc.sdk.resources.AResource;
import com.otsdc.sdk.resources.ApiException;
import com.otsdc.sdk.resources.IVoiceResource;
import com.otsdc.sdk.resources.url.IVoiceUrl;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eri Setiawan
 */
public class VoiceResourceImpl extends AResource implements IVoiceResource {
    private IVoiceUrl voiceUrl;

    public VoiceResourceImpl(String appSid, IVoiceUrl voiceUrl) {
        super(appSid);
        this.voiceUrl = voiceUrl;
    }

    @Override
    public CallResponse call(CallRequest request) throws IOException {
        return call(request.getData());
    }

    @Override
    public CallResponse call(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(voiceUrl.urlCall(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<CallResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<CallResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public CallStatusResponse getCallIDStatus(String callID) throws IOException {
        Map<String, String> map = new HashMap<String, String>(2);
        map.put(ParamConstant.CALLID, callID);
        return getCallIDStatus(map);
    }

    @Override
    public CallStatusResponse getCallIDStatus(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(voiceUrl.urlGetCallIDStatus(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<CallStatusResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<CallStatusResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public CallsDetailsResponse getCallsDetails(CallsDetailsRequest request) throws IOException {
        return getCallsDetails(request.getData());
    }

    @Override
    public CallsDetailsResponse getCallsDetails(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(voiceUrl.urlGetCallsDetails(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<CallsDetailsResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<CallsDetailsResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public TTSCallResponse ttsCall(TTSCallRequest request) throws IOException {
        return ttsCall(request.getData());
    }

    @Override
    public TTSCallResponse ttsCall(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(voiceUrl.urlTTSCall(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<TTSCallResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<TTSCallResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public CallsDetailsResponse getCallsDetails() throws IOException {
        return getCallsDetails(new HashMap<>());
    }
}

