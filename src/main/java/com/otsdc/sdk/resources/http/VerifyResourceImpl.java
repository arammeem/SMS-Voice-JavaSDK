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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.otsdc.sdk.OTSRestResponse;
import com.otsdc.sdk.constant.ParamConstant;
import com.otsdc.sdk.model.ResponseModel;
import com.otsdc.sdk.model.Voids;
import com.otsdc.sdk.model.verify.GetCodeRequest;
import com.otsdc.sdk.model.verify.GetCodeResponse;
import com.otsdc.sdk.parser.serialize.DateConverter;
import com.otsdc.sdk.resources.AResource;
import com.otsdc.sdk.resources.IVerifyResource;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpResponseException;

/**
 *
 * @author Eri Setiawan
 */
public class VerifyResourceImpl extends AResource implements IVerifyResource {

    private Gson GSON;

    public VerifyResourceImpl(String appSid) {
        super(appSid);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateConverter());
        GSON = gsonBuilder.create();
    }

    @Override
    public GetCodeResponse getCode(GetCodeRequest request) throws IOException {
        return getCode(request.getData());
    }

    @Override
    public GetCodeResponse getCode(Map<String, String> map) throws IOException {
        OTSRestResponse response = sendRequest(URL_GET_CODE, map);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<GetCodeResponse>>() {
            }.getType();
            ResponseModel<GetCodeResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else if (response.getStatusCode() == 400) {
            GetCodeResponse resp = GSON.fromJson(response.getData(), GetCodeResponse.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
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
        OTSRestResponse otsResponse = sendRequest(URL_VERIFY_NUMBER, map);
        if (otsResponse.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<Voids>>() {
            }.getType();
            ResponseModel<Voids> respData = GSON.fromJson(otsResponse.getData(), type);
            return respData;
        } else if (otsResponse.getStatusCode() == 400) {
            ResponseModel<Voids> respData = GSON.fromJson(otsResponse.getData(), ResponseModel.class);
            return respData;
        } else {
            throw new HttpResponseException(otsResponse.getStatusCode(), otsResponse.getReasonPhrase());
        }
    }

}
