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

import com.otsdc.sdk.model.messages.BulkRequest;
import com.otsdc.sdk.model.messages.BulkResponse;
import com.otsdc.sdk.model.messages.MessageIDStatus;
import com.otsdc.sdk.model.messages.MessageRequest;
import com.otsdc.sdk.model.messages.MessageResponse;
import com.otsdc.sdk.model.messages.MessagesDetailsRequest;
import com.otsdc.sdk.model.messages.MessagesDetailsResponse;
import com.otsdc.sdk.model.messages.MessagesReportRequest;
import com.otsdc.sdk.model.messages.MessagesReportResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Messages sub-resource is used to send text messages and to inquire sent
 * message details
 *
 * @author Eri Setiawan
 */
public interface IMessageResource extends IResource {

    public static final String URL_MESSAGES = URL_BASE_PROD + "Messages/";
    public static final String URL_SEND = URL_MESSAGES + "Send";
    public static final String URL_SEND_BULK = URL_MESSAGES + "SendBulk";
    public static final String URL_GET_MESSAGE_ID_STATUS = URL_MESSAGES + "GetMessageIDStatus";
    public static final String URL_GET_MESSAGE_REPORT = URL_MESSAGES + "GetMessagesReport";
    public static final String URL_GET_MESSAGE_DETAILS = URL_MESSAGES + "GetMessagesDetails";

    /**
     * Send enables API to send a message for only one recipient; you must have
     * sufficient balance or an active package to send to your desired
     * destination.
     *
     * @param param
     * @return
     * @throws IOException
     */
    public MessageResponse send(MessageRequest param) throws IOException;

    /**
     * Send enables API to send a message for only one recipient; you must have
     * sufficient balance or an active package to send to your desired
     * destination.
     *
     * @param param
     * @return
     * @throws IOException
     */
    public MessageResponse send(Map<String, String> param) throws IOException;

    /**
     * SendBulk enables API to send bulk messages for multi recipiencts
     * seperated by commas, Using SendBulk API requieres authorized API Access,
     * to get your authurized access contact us.
     *
     * @param param
     * @return
     * @throws IOException
     */
    public BulkResponse sendBulk(BulkRequest param) throws IOException;

    /**
     * SendBulk enables API to send bulk messages for multi recipiencts
     * seperated by commas, Using SendBulk API requieres authorized API Access,
     * to get your authurized access contact us.
     *
     * @param param
     * @return
     * @throws IOException
     */
    public BulkResponse sendBulk(Map<String, String> param) throws IOException;

    public MessageIDStatus getMessageIDStatus(String messageID) throws IOException;

    public MessagesReportResponse getMessagesReport() throws IOException;

    public MessagesReportResponse getMessagesReport(Map<String, String> param) throws IOException;

    public MessagesReportResponse getMessagesReport(MessagesReportRequest request) throws IOException;

    public MessagesDetailsResponse getMessagesDetails(MessagesDetailsRequest request) throws IOException;

    public MessagesDetailsResponse getMessagesDetails(Map<String, String> param) throws IOException;

    public MessagesDetailsResponse getMessagesDetails() throws IOException;
}
