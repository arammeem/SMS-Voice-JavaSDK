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
import com.otsdc.sdk.model.Voids;
import com.otsdc.sdk.model.verify.GetCodeRequest;
import com.otsdc.sdk.model.verify.GetCodeResponse;
import com.otsdc.sdk.resources.AResource;
import com.otsdc.sdk.resources.ApiException;
import com.otsdc.sdk.resources.IVerifyResource;
import com.otsdc.sdk.resources.url.IVerifyUrl;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eri Setiawan
 */
public class VerifyResourceImpl extends AResource implements IVerifyResource {
    private IVerifyUrl verifyUrl;

    public VerifyResourceImpl(String appSid, IVerifyUrl verifyUrl) {
        super(appSid);
        this.verifyUrl = verifyUrl;
    }

    @Override
    public GetCodeResponse getCode(GetCodeRequest request) throws IOException {
        return getCode(request.getData());
    }

    @Override
    public GetCodeResponse getCode(Map<String, String> map) throws IOException {
        OTSRestResponse response = sendRequest(verifyUrl.urlGetCode(), map);
        int statusCode = response.getStatusCode();
        ResponseModel<GetCodeResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<GetCodeResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public ResponseModel<Voids> verifyNumber(String recipient, String passCode) throws IOException {
        if (recipient == null || passCode == null) {
            throw new NullPointerException("Recipient and PassCode cannot Null");
        }
        Map<String, String> map = new HashMap<>();
        map.put(ParamConstant.RECIPIENT, recipient);
        map.put(ParamConstant.PASSCODE, passCode);
        return verifyNumber(map);
    }

    @Override
    public ResponseModel<Voids> verifyNumber(Map<String, String> map) throws IOException {
        OTSRestResponse response = sendRequest(verifyUrl.urlVerifyNumber(), map);
        int statusCode = response.getStatusCode();
        ResponseModel<Voids> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<Voids>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }
}
