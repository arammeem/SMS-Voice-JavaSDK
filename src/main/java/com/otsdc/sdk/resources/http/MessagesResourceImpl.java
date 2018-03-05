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
import com.otsdc.sdk.model.messages.*;
import com.otsdc.sdk.resources.AResource;
import com.otsdc.sdk.resources.ApiException;
import com.otsdc.sdk.resources.IMessageResource;
import com.otsdc.sdk.resources.url.IMessageUrl;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eri Setiawan
 */
public class MessagesResourceImpl extends AResource implements IMessageResource {
    private IMessageUrl messageUrl;

    public MessagesResourceImpl(String appSid, IMessageUrl messageUrl) {
        super(appSid);
        this.messageUrl = messageUrl;
    }

    @Override
    public MessageResponse send(MessageRequest param) throws IOException {
        return send(param.getData());
    }

    @Override
    public MessageResponse send(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(messageUrl.urlSend(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<MessageResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<MessageResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public BulkResponse sendBulk(BulkRequest param) throws IOException {
        return sendBulk(param.getData());
    }

    @Override
    public BulkResponse sendBulk(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(messageUrl.urlSendBulk(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<BulkResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<BulkResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public MessageIDStatus getMessageIDStatus(String messageID) throws IOException {
        ArrayList<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair(ParamConstant.MESSAGEID, messageID));
        OTSRestResponse response = sendRequest(messageUrl.urlGetMessageIDStatus(), params);
        int statusCode = response.getStatusCode();
        ResponseModel<MessageIDStatus> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<MessageIDStatus>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public MessagesReportResponse getMessagesReport(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(messageUrl.urlGetMessageReport(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<MessagesReportResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<MessagesReportResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public MessagesDetailsResponse getMessagesDetails(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(messageUrl.urlGetMessageDetails(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<MessagesDetailsResponse> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<MessagesDetailsResponse>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public MessagesReportResponse getMessagesReport() throws IOException {
        return getMessagesReport(new HashMap<>());
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
        return getMessagesDetails(new HashMap<>());
    }
}
