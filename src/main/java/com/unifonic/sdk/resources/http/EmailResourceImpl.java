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
package com.unifonic.sdk.resources.http;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpResponseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.unifonic.sdk.OTSRestResponse;
import com.unifonic.sdk.model.ResponseModel;
import com.unifonic.sdk.model.email.EmailReportRequest;
import com.unifonic.sdk.model.email.EmailReportResponse;
import com.unifonic.sdk.model.email.EmailRequest;
import com.unifonic.sdk.model.email.EmailResponse;
import com.unifonic.sdk.parser.serialize.DateConverter;
import com.unifonic.sdk.resources.AResource;
import com.unifonic.sdk.resources.IEmailResource;
import com.unifonic.sdk.resources.url.IEmailUrl;

/**
 *
 * @author Eri Setiawan
 */
public class EmailResourceImpl extends AResource implements IEmailResource {

    private Gson GSON;
    private IEmailUrl emailUrl;
    
    public EmailResourceImpl(String appSid,IEmailUrl emailUrl) {
        super(appSid);
        this.emailUrl = emailUrl;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateConverter());
        GSON = gsonBuilder.create();
    }

    @Override
    public EmailResponse send(EmailRequest request) throws IOException {
        return send(request.getData());
    }

    @Override
    public EmailResponse send(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(emailUrl.urlSend(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<EmailResponse>>() {
            }.getType();
            ResponseModel<EmailResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else if (response.getStatusCode() == 400) {
            EmailResponse resp = GSON.fromJson(response.getData(), EmailResponse.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public EmailReportResponse getEmailsReport() throws IOException {
        return getEmailsReport(new HashMap<String, String>(0));
    }

    @Override
    public EmailReportResponse getEmailsReport(EmailReportRequest request) throws IOException {
        return getEmailsReport(request.getData());
    }

    @Override
    public EmailReportResponse getEmailsReport(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(emailUrl.urlGetEmailReport(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<EmailReportResponse>>() {
            }.getType();
            ResponseModel<EmailReportResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else if (response.getStatusCode() == 400) {
            EmailReportResponse resp = GSON.fromJson(response.getData(), EmailReportResponse.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

}
