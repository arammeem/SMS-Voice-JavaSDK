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
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.unifonic.sdk.OTSRestResponse;
import com.unifonic.sdk.model.ResponseModel;
import com.unifonic.sdk.model.Voids;
import com.unifonic.sdk.model.account.Balance;
import com.unifonic.sdk.model.account.SenderID;
import com.unifonic.sdk.model.account.SenderList;
import com.unifonic.sdk.parser.serialize.BooleanConverter;
import com.unifonic.sdk.parser.serialize.DateConverter;
import com.unifonic.sdk.resources.AResource;
import com.unifonic.sdk.resources.IAccountResource;
import com.unifonic.sdk.resources.url.IAccountUrl;

/**
 *
 * @author Eri Setiawan
 */
public class AccountResourceImpl extends AResource implements IAccountResource {

    private Gson GSON;
    private IAccountUrl accountUrl;

    public AccountResourceImpl(String appSid,IAccountUrl accountUrl) {
        super(appSid);
        this.accountUrl = accountUrl;
        GsonBuilder gsonBuilder = new GsonBuilder();
        BooleanConverter booleanConverter = new BooleanConverter();
        gsonBuilder.registerTypeAdapter(Boolean.class, booleanConverter);
        gsonBuilder.registerTypeAdapter(boolean.class, booleanConverter);
        gsonBuilder.registerTypeAdapter(Date.class, new DateConverter());
        GSON = gsonBuilder.create();
    }

    @Override
    public Balance getBalance() throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        OTSRestResponse response = sendRequest(accountUrl.urlGetBalance(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<Balance>>() {
            }.getType();
            ResponseModel<Balance> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else if (response.getStatusCode() == 400) {
            Balance resp = GSON.fromJson(response.getData(), Balance.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public SenderID addSenderId(String senderID) throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair(PARAM_SENDER_ID, senderID));

        OTSRestResponse response = sendRequest(accountUrl.urlAddSenderID(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<SenderID>>() {
            }.getType();
            ResponseModel<SenderID> respData = GSON.fromJson(response.getData(), type);
            SenderID sender = respData.create();
            sender.setSenderID(senderID);
            return sender;
        } else if (response.getStatusCode() == 400) {
            SenderID resp = GSON.fromJson(response.getData(), SenderID.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public SenderID getSenderIDStatus(String senderID) throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair(PARAM_SENDER_ID, senderID));
        OTSRestResponse response = sendRequest(accountUrl.urlGetSenderIDStatus(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<SenderID>>() {
            }.getType();
            ResponseModel<SenderID> respData = GSON.fromJson(response.getData(), type);
            SenderID sender = respData.create();
            sender.setSenderID(senderID);
            return sender;
        } else if (response.getStatusCode() == 400) {
            SenderID resp = GSON.fromJson(response.getData(), SenderID.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public SenderList getSenderIDS() throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        OTSRestResponse response = sendRequest(accountUrl.urlGetSenderIDs(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<SenderList>>() {
            }.getType();
            ResponseModel<SenderList> respData = GSON.fromJson(response.getData(), type);
            SenderList senderList = respData.create();
            return senderList;
        } else if (response.getStatusCode() == 400) {
            SenderList resp = GSON.fromJson(response.getData(), SenderList.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public ResponseModel<Voids> deleteSenderID(String senderID) throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair(PARAM_SENDER_ID, senderID));
        OTSRestResponse response = sendRequest(accountUrl.urlDeleteSenderID(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<Voids>>() {
            }.getType();
            ResponseModel<Voids> respData = GSON.fromJson(response.getData(), type);
            return respData;
        } else if (response.getStatusCode() == 400) {
            ResponseModel<Voids> respData = GSON.fromJson(response.getData(), ResponseModel.class);
            return respData;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public SenderID getAppDefaultSenderID() throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        OTSRestResponse response = sendRequest(accountUrl.urlGetAppDefaultSenderID(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<SenderID>>() {
            }.getType();
            ResponseModel<SenderID> respData = GSON.fromJson(response.getData(), type);
            SenderID sender = respData.create();
            return sender;
        } else if (response.getStatusCode() == 400) {
            SenderID resp = GSON.fromJson(response.getData(), SenderID.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public ResponseModel<Voids> changeAppDefaultSenderID(String senderID) throws IOException {
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair(PARAM_SENDER_ID, senderID));
        OTSRestResponse response = sendRequest(accountUrl.urlChangeDefaultSenderID(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<Voids>>() {
            }.getType();
            ResponseModel<Voids> respData = GSON.fromJson(response.getData(), type);
            return respData;
        } else if (response.getStatusCode() == 400) {
            ResponseModel<Voids> respData = GSON.fromJson(response.getData(), ResponseModel.class);
            return respData;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

}
