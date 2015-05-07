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
package com.otsdc.sdk.example;

import com.otsdc.sdk.OTSRestClient;
import com.otsdc.sdk.model.ResponseModel;
import com.otsdc.sdk.model.Voids;
import com.otsdc.sdk.model.account.Balance;
import com.otsdc.sdk.model.account.SenderID;
import com.otsdc.sdk.model.account.SenderList;
import com.otsdc.sdk.resources.IAccountResource;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eri Setiawan
 */
public class AccountExample {

    public static void main(String[] args) {
        try {
            String appSid = "cYWr62UeR6mbGZw6qHWUhiVX8z5ed";
            OTSRestClient client = new OTSRestClient(appSid);
            IAccountResource accountResource = client.getAccountResource();
            //ambil balance
            Balance balance = accountResource.getBalance();
            if (balance.isSuccess()) {
                System.out.println("Balance:" + balance);
                //Do something
            } else {
                System.out.println("Balance Fail:" + balance.getErrorCode() + "-" + balance.getMessage());
            }
            SenderID addSenderResp = accountResource.addSenderId("1234567890");
            System.out.println("AddSenderID"+addSenderResp);
            
            ResponseModel<Voids> changeSenderID = accountResource.changeAppDefaultSenderID("1234567890");
            System.out.println("ChangeSenderID:"+ changeSenderID);
            
            SenderID defaultSenderID = accountResource.getAppDefaultSenderID();
            System.out.println("DefaultSenderID:"+ defaultSenderID);
            
            SenderList senderIDS = accountResource.getSenderIDS();
            System.out.println("getSenderIDS:"+ senderIDS);
            
            SenderID senderIDStatus = accountResource.getSenderIDStatus("1234567890");
            System.out.println("getSenderStatus:" + senderIDStatus);
            
            ResponseModel<Voids> deleteSenderID = accountResource.deleteSenderID("1234567890");
            System.out.println("deleteSenderID:"+ deleteSenderID);
//            IMessageResource messageResource = client1.getMessageResource();
//            //kirim sms 
//            MessageRequest messageRequest = new MessageRequest();
//            messageRequest.setBody("Test Message SDK");
//            messageRequest.setRecipient("962789309519");
//            MessageResponse messageResponse = messageResource.send(messageRequest);
//            System.out.println("Response:" + messageResponse);
        } catch (IOException ex) {
            Logger.getLogger(AccountExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
