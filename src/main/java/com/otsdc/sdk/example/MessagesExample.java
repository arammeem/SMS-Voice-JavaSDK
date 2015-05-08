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
import com.otsdc.sdk.model.messages.BulkRequest;
import com.otsdc.sdk.model.messages.BulkResponse;
import com.otsdc.sdk.model.messages.MessageIDStatus;
import com.otsdc.sdk.model.messages.MessageRequest;
import com.otsdc.sdk.model.messages.MessageResponse;
import com.otsdc.sdk.model.messages.MessagesDetailsRequest;
import com.otsdc.sdk.model.messages.MessagesDetailsResponse;
import com.otsdc.sdk.model.messages.MessagesReportRequest;
import com.otsdc.sdk.model.messages.MessagesReportResponse;
import com.otsdc.sdk.resources.IMessageResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eri Setiawan
 */
public class MessagesExample {

    public static void main(String[] args) {
        try {
            String appSid = "your appSid";
            OTSRestClient client = new OTSRestClient(appSid);
            IMessageResource messageResource = client.getMessageResource();
            //Send Message 1
            MessageResponse sendResponse = messageResource.send(new MessageRequest("962789xxxxxx", "Content Message"));
            if (sendResponse.isSuccess()) {
                System.out.println("SendResponse:" + sendResponse);
                //Do something
            } else {
                System.out.println("SendResponse Fail:" + sendResponse.getErrorCode() + "-" + sendResponse.getMessage());
            }
            //Send Message 2
            Map<String, String> messageMap = new HashMap<>();
            messageMap.put("Recipient", "962789xxxxxx");
            messageMap.put("Body", "Content Message2");
            MessageResponse sendResponse2 = messageResource.send(messageMap);
            System.out.println("SendResponse2:" + sendResponse2);

            //Send Bulk 1
            //for multiple destination separated by commas
            BulkRequest bulkRequest1 = new BulkRequest("962789xxxxxx", "Bulk Request1");
            BulkResponse sendBulk1 = messageResource.sendBulk(bulkRequest1);
            System.out.println("SendBulk1:" + sendBulk1);
            //OR 
            //Send Bulk 2 recipient in List Using BulkRequest Class
            List<String> recipients = new ArrayList<String>();
            recipients.add("962789xxxxxx");
            BulkRequest bulkRequest2 = new BulkRequest(recipients, "Bulk Request2");
            BulkResponse sendBulk2 = messageResource.sendBulk(bulkRequest2);
            System.out.println("SendBulk2:" + sendBulk2);
            //OR
            //Send Bulk 3 recipient in Array Using BulkRequest Class
            String[] recipientArray = new String[1];
            recipientArray[0] = "962789xxxxxx";
            BulkRequest bulkRequest3 = new BulkRequest(recipientArray, "Bulk Request3");
            BulkResponse sendBulk3 = messageResource.sendBulk(bulkRequest3);
            System.out.println("SendBulk3:" + sendBulk3);
            //OR
            //Send Bulk 4 Using Map
            Map<String, String> bulkMap = new HashMap<String, String>();
            bulkMap.put("Recipient", "962789xxxxxx");
            bulkMap.put("Body", "Bulk Request4");
            BulkResponse sendBulk4 = messageResource.sendBulk(bulkMap);
            System.out.println("SendBulk4:" + sendBulk4);
            String messageID = sendResponse.getMessageID();

            //Get MessageStatus
            MessageIDStatus messageIDStatus = messageResource.getMessageIDStatus(messageID);
            System.out.println("MessageStatus:" + messageIDStatus);

            //GetMessagesDetails No Filter
            MessagesDetailsResponse messagesDetails = messageResource.getMessagesDetails();
            System.out.println("MessagesDetails:" + messagesDetails);

            //GetMessagesDetails 1 get 10 sent message detail
            MessagesDetailsRequest messagesDetailsRequest = new MessagesDetailsRequest();
            messagesDetailsRequest.setLimit(10);
            messagesDetailsRequest.setStatus(MessagesDetailsRequest.STATUS_SENT);
            MessagesDetailsResponse messagesDetails1 = messageResource.getMessagesDetails(messagesDetailsRequest);
            System.out.println("MessageDetails1:" + messagesDetails1);
            //or this way
            Map<String, String> map = new HashMap<String, String>();
            map.put("Limit", "10");
            map.put("Status", "Sent");
            MessagesDetailsResponse messagesDetails2 = messageResource.getMessagesDetails(map);
            System.out.println("MessageDetails2:" + messagesDetails2);

            //Message Report No Filter
            MessagesReportResponse messagesReport = messageResource.getMessagesReport();
            System.out.println("MessageReport:" + messagesReport);

            MessagesReportRequest mrr = new MessagesReportRequest();
            mrr.setStatus(MessagesReportRequest.STATUS_SENT);
            MessagesReportResponse messagesReport1 = messageResource.getMessagesReport(mrr);

            System.out.println("MessagesReport1:" + messagesReport1);
        } catch (IOException ex) {
            Logger.getLogger(MessagesExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
