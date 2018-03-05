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
import com.otsdc.sdk.model.ResponseModel;
import com.otsdc.sdk.model.Voids;
import com.otsdc.sdk.model.account.Balance;
import com.otsdc.sdk.model.account.SenderID;
import com.otsdc.sdk.model.account.SenderList;
import com.otsdc.sdk.resources.AResource;
import com.otsdc.sdk.resources.ApiException;
import com.otsdc.sdk.resources.IAccountResource;
import com.otsdc.sdk.resources.url.IAccountUrl;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Eri Setiawan
 */
public class AccountResourceImpl extends AResource implements IAccountResource {
    private IAccountUrl accountUrl;

    public AccountResourceImpl(String appSid, IAccountUrl accountUrl) {
        super(appSid);
        this.accountUrl = accountUrl;
    }

    @Override
    public Balance getBalance() throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<>();
        OTSRestResponse response = sendRequest(accountUrl.urlGetBalance(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<Balance> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<Balance>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public SenderID addSenderId(String senderID) throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<>();
        param.add(new BasicNameValuePair(PARAM_SENDER_ID, senderID));
        OTSRestResponse response = sendRequest(accountUrl.urlAddSenderID(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<SenderID> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<SenderID>>() {
                }.getType());
        return getSenderID(senderID, response, statusCode, responseModel);
    }

    @Override
    public SenderID getSenderIDStatus(String senderID) throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<>();
        param.add(new BasicNameValuePair(PARAM_SENDER_ID, senderID));
        OTSRestResponse response = sendRequest(accountUrl.urlGetSenderIDStatus(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<SenderID> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<SenderID>>() {
                }.getType());
        return getSenderID(senderID, response, statusCode, responseModel);
    }

    private SenderID getSenderID(String senderID, OTSRestResponse response, int statusCode, ResponseModel<SenderID> responseModel) {
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            SenderID sender = responseModel.create();
            sender.setSenderID(senderID);
            return sender;
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public SenderList getSenderIDS() throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<>();
        OTSRestResponse response = sendRequest(accountUrl.urlGetSenderIDs(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<SenderList> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<SenderList>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public ResponseModel<Voids> deleteSenderID(String senderID) throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<>();
        param.add(new BasicNameValuePair(PARAM_SENDER_ID, senderID));
        OTSRestResponse response = sendRequest(accountUrl.urlDeleteSenderID(), param);
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

    @Override
    public SenderID getAppDefaultSenderID() throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<>();
        OTSRestResponse response = sendRequest(accountUrl.urlGetAppDefaultSenderID(), param);
        int statusCode = response.getStatusCode();
        ResponseModel<SenderID> responseModel = getResponseModel(response,
                new TypeToken<ResponseModel<SenderID>>() {
                }.getType());
        if (statusCode > 0 && statusCode < HttpStatus.SC_BAD_REQUEST) {
            return responseModel.create();
        } else {
            throw new ApiException(response.getReasonPhrase(), statusCode, responseModel.getMessage(), null);
        }
    }

    @Override
    public ResponseModel<Voids> changeAppDefaultSenderID(String senderID) throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<>();
        param.add(new BasicNameValuePair(PARAM_SENDER_ID, senderID));
        OTSRestResponse response = sendRequest(accountUrl.urlChangeDefaultSenderID(), param);
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
