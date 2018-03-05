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
package com.otsdc.sdk.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.otsdc.sdk.HttpSender;
import com.otsdc.sdk.OTSRestResponse;
import com.otsdc.sdk.constant.ParamConstant;
import com.otsdc.sdk.model.ResponseModel;
import com.otsdc.sdk.parser.serialize.BooleanConverter;
import com.otsdc.sdk.parser.serialize.DateConverter;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author Eri Setiawan
 */
public abstract class AResource implements IResource {
    private static final HttpSender HTTP_SENDER = new HttpSender();
    private Gson GSON;
    private String appSid;

    public AResource(String appSid) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        BooleanConverter booleanConverter = new BooleanConverter();
        gsonBuilder.registerTypeAdapter(Boolean.class, booleanConverter);
        gsonBuilder.registerTypeAdapter(boolean.class, booleanConverter);
        gsonBuilder.registerTypeAdapter(Date.class, new DateConverter());
        GSON = gsonBuilder.create();
        this.appSid = appSid;
    }

    @Override
    public String getAppSid() {
        return appSid;
    }

    @Override
    public void setAppSid(String appSid) {
        this.appSid = appSid;
    }

    protected OTSRestResponse sendRequest(String url, List<NameValuePair> params) throws IOException {
        params.add(new BasicNameValuePair(ParamConstant.APPSID, getAppSid()));
        return HTTP_SENDER.request(url, params);
    }

    protected OTSRestResponse sendRequest(String url, Map<String, String> param) throws IOException {
        ArrayList<NameValuePair> params = new ArrayList<>();
        Set<Map.Entry<String, String>> entrySet = param.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            params.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        return sendRequest(url, params);
    }

    protected <T extends ResponseModel> ResponseModel<T> getResponseModel(OTSRestResponse response, Type type) {
        try {
            return GSON.fromJson(response.getData(), type);
        } catch (JsonSyntaxException e) {
            throw new ApiException("Unable to parse the server's response", e);
        }
    }
}
