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
import com.otsdc.sdk.model.messages.BulkRequest;
import com.otsdc.sdk.model.messages.BulkResponse;
import com.otsdc.sdk.model.messages.MessageIDStatus;
import com.otsdc.sdk.model.messages.MessageRequest;
import com.otsdc.sdk.model.messages.MessageResponse;
import com.otsdc.sdk.model.messages.MessagesDetailsRequest;
import com.otsdc.sdk.model.messages.MessagesDetailsResponse;
import com.otsdc.sdk.model.messages.MessagesReportRequest;
import com.otsdc.sdk.model.messages.MessagesReportResponse;
import com.otsdc.sdk.parser.serialize.BooleanConverter;
import com.otsdc.sdk.parser.serialize.DateConverter;
import com.otsdc.sdk.resources.AResource;
import com.otsdc.sdk.resources.IMessageResource;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Eri Setiawan
 */
public class MessagesResourceImpl extends AResource implements IMessageResource {

    private Gson GSON;

    public MessagesResourceImpl(String appSid) {
        super(appSid);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateConverter());
        GSON = gsonBuilder.create();
    }

    @Override
    public MessageResponse send(MessageRequest param) throws IOException {
        return send(param.getData());
    }

    @Override
    public MessageResponse send(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(URL_SEND, param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<MessageResponse>>() {
            }.getType();
            ResponseModel<MessageResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public BulkResponse sendBulk(BulkRequest param) throws IOException {
        return sendBulk(param.getData());
    }

    @Override
    public BulkResponse sendBulk(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(URL_SEND_BULK, param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<BulkResponse>>() {
            }.getType();
            ResponseModel<BulkResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public MessageIDStatus getMessageIDStatus(String messageID) throws IOException {
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair(ParamConstant.MESSAGEID, messageID));
        OTSRestResponse response = sendRequest(URL_GET_MESSAGE_ID_STATUS, params);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<MessageIDStatus>>() {
            }.getType();
            ResponseModel<MessageIDStatus> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public MessagesReportResponse getMessagesReport(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(URL_GET_MESSAGE_REPORT, param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<MessagesReportResponse>>() {
            }.getType();
            ResponseModel<MessagesReportResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public MessagesDetailsResponse getMessagesDetails(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(URL_GET_MESSAGE_DETAILS, param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<MessagesDetailsResponse>>() {
            }.getType();
            ResponseModel<MessagesDetailsResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public MessagesReportResponse getMessagesReport() throws IOException {
        return getMessagesReport(new HashMap<String, String>());
    }

    @Override
    public MessagesReportResponse getMessagesReport(MessagesReportRequest mrr) throws IOException {
        return getMessagesReport(mrr.getData());
    }

    @Override
    public MessagesDetailsResponse getMessagesDetails(MessagesDetailsRequest request) throws IOException {
        return getMessagesDetails(request.getData());
    }

    @Override
    public MessagesDetailsResponse getMessagesDetails() throws IOException {
        return getMessagesDetails(new HashMap<String, String>());
    }

}
