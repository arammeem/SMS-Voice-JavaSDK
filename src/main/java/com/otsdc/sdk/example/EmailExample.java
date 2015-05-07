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
import com.otsdc.sdk.model.email.EmailReportRequest;
import com.otsdc.sdk.model.email.EmailReportResponse;
import com.otsdc.sdk.model.email.EmailRequest;
import com.otsdc.sdk.model.email.EmailResponse;
import com.otsdc.sdk.resources.IEmailResource;
import com.otsdc.sdk.resources.IVoiceResource;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eri Setiawan
 */
public class EmailExample {

    public static void main(String[] args) {
        try {
            String appSid = "cYWr62UeR6mbGZw6qHWUhiVX8z5ed";
            OTSRestClient client = new OTSRestClient(appSid);
            IEmailResource er = client.getEmailResource();
            //Send Email without Subject
            EmailRequest emailReq = new EmailRequest("Test", "balnajjar@otsdc.com", "Test Send Email SDK");
            EmailResponse emailResponse = er.send(emailReq);
            System.out.println("EmailResponse:" + emailResponse);
            //Send Email With Subject
            EmailRequest emailReq1 = new EmailRequest("Test", "balnajjar@otsdc.com", "Test Send Email SDK with Subject", "The Subject, Test Email");
            EmailResponse emailResponse1 = er.send(emailReq1);
            System.out.println("EmailResponse1:" + emailResponse1);

            //Get Email Report No filter
            EmailReportResponse emailsReport = er.getEmailsReport();
            System.out.println("EmailReport:" + emailsReport);
            //Get Email Report where email from is Test and Email Status is Sent
            EmailReportRequest err = new EmailReportRequest();
            err.setFrom("Test");
            err.setEmailStatus(EmailReportRequest.STATUS_SENT);
            EmailReportResponse emailsReport1 = er.getEmailsReport(err);
            System.out.println("EmailReport1:" + emailsReport1);
        } catch (IOException ex) {
            Logger.getLogger(EmailExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
