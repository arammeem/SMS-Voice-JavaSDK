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

import com.otsdc.sdk.model.ResponseModel;
import com.otsdc.sdk.model.Voids;
import com.otsdc.sdk.model.account.Balance;
import com.otsdc.sdk.model.account.SenderID;
import com.otsdc.sdk.model.account.SenderList;

import java.io.IOException;

/**
 * When you first sign up with OTS platform, you will have a master account,
 * where you can create your REST API Apps to connect your applications. Account
 * sub-resource is used to inquire data about your account such as Balance,
 * Sender IDs.
 *
 * @author Eri Setiawan
 */
public interface IAccountResource extends IResource {

    static final String URL_ACCOUNT = URL_BASE_PROD + "Account/";
    public static final String URL_GET_BALANCE = URL_ACCOUNT + "GetBalance";
    public static final String URL_ADD_SENDER_ID = URL_ACCOUNT + "addSenderID";
    public static final String URL_GET_SENDER_ID_STATUS = URL_ACCOUNT + "getSenderIDStatus";
    public static final String URL_GET_SENDER_IDS = URL_ACCOUNT + "getSenderIDs";
    public static final String URL_DELETE_SENDER_ID = URL_ACCOUNT + "DeleteSenderID";
    public static final String URL_GET_DEFAULT_SENDER_ID = URL_ACCOUNT + "GetAppDefaultSenderID";
    public static final String URL_CHANGE_DEFAULT_SENDER_ID = URL_ACCOUNT + "changeAppDefaultSenderID";

    public static final String PARAM_SENDER_ID = "SenderID";

    public Balance getBalance() throws IOException;

    public SenderID addSenderId(String senderID) throws IOException;

    public SenderID getSenderIDStatus(String senderID) throws IOException;

    public SenderList getSenderIDS() throws IOException;

    public ResponseModel<Voids> deleteSenderID(String senderID) throws IOException;

    public SenderID getAppDefaultSenderID() throws IOException;

    public ResponseModel<Voids> changeAppDefaultSenderID(String senderID) throws IOException;

}
