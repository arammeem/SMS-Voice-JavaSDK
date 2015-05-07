# OTSJavaSDK
OTS REST and SMPP APIs allows you to connect your apps directly to networks. Where you can integrate your apps to send text messages around the world. And also inquire meta-data about your account, text messages, and usage.

## Installation
The easiest way to install ots-java-sdk is from Maven. You can add the following dependency to your existing project, specifying the latest version in the version tag:

pom.xml
```xml
<dependency>
	<groupId>com.otsdc</groupId>
	<artifactId>ots-java-sdk</artifactId>
	<version>1.0</version>
	<scope>compile</scope>
</dependency>
```
If you want to compile it yourself, here's how:
```
$ git clone git@github.com:otsdc/OTSJavaSDK.git
$ cd OTSJavaSDK
$ mvn install       # Requires maven, download from http://maven.apache.org/download.html
```

## Example

Here is the example to Use Message API
```javva
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
            String appSid = "cYWr62UeR6mbGZw6qHWUhiVX8z5ed";
            OTSRestClient client = new OTSRestClient(appSid);
            IMessageResource messageResource = client.getMessageResource();
            //Send Message 1
            MessageResponse sendResponse = messageResource.send(new MessageRequest("962789309519", "Content Message"));
            if (sendResponse.isSuccess()) {
                System.out.println("SendResponse:" + sendResponse);
                //Do something
            } else {
                System.out.println("SendResponse Fail:" + sendResponse.getErrorCode() + "-" + sendResponse.getMessage());
            }
            //Send Message 2
            Map<String, String> messageMap = new HashMap<>();
            messageMap.put("Recipient", "962789309519");
            messageMap.put("Body", "Content Message2");
            MessageResponse sendResponse2 = messageResource.send(messageMap);
            System.out.println("SendResponse2:" + sendResponse2);

            //Send Bulk 1
            //for multiple destination separated by commas
            BulkRequest bulkRequest1 = new BulkRequest("962789309519", "Bulk Request1");
            BulkResponse sendBulk1 = messageResource.sendBulk(bulkRequest1);
            System.out.println("SendBulk1:" + sendBulk1);
            //OR 
            //Send Bulk 2 recipient in List Using BulkRequest Class
            List<String> recipients = new ArrayList<String>();
            recipients.add("962789309519");
            BulkRequest bulkRequest2 = new BulkRequest(recipients, "Bulk Request2");
            BulkResponse sendBulk2 = messageResource.sendBulk(bulkRequest2);
            System.out.println("SendBulk2:" + sendBulk2);
            //OR
            //Send Bulk 3 recipient in Array Using BulkRequest Class
            String[] recipientArray = new String[1];
            recipientArray[0] = "962789309519";
            BulkRequest bulkRequest3 = new BulkRequest(recipientArray, "Bulk Request3");
            BulkResponse sendBulk3 = messageResource.sendBulk(bulkRequest3);
            System.out.println("SendBulk3:" + sendBulk3);
            //OR
            //Send Bulk 4 Using Map
            Map<String, String> bulkMap = new HashMap<String, String>();
            bulkMap.put("Recipient", "962789309519");
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

```




