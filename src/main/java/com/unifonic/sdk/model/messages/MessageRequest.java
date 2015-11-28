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
package com.unifonic.sdk.model.messages;

import com.unifonic.sdk.constant.ParamConstant;
import com.unifonic.sdk.model.ARequest;

/**
 *
 * @author Eri Setiawan
 */
public class MessageRequest extends ARequest {

    public MessageRequest(String recipient, String body) {
        setRecipient(recipient);
        setBody(body);
    }

    public MessageRequest(String recipient, String body, String priority) {
        setRecipient(recipient);
        setBody(body);
        setPriority(priority);
    }

    public MessageRequest(String recipient, String body, String priority, String senderID) {
        setRecipient(recipient);
        setBody(body);
        setPriority(priority);
        setSenderID(senderID);
    }

    public String getRecipient() {
        return get(ParamConstant.RECIPIENT);
    }

    public void setRecipient(String recipient) {
        put(ParamConstant.RECIPIENT, recipient);
    }

    public String getBody() {
        return get(ParamConstant.BODY);
    }

    public void setBody(String body) {
        put(ParamConstant.BODY, body);
    }

    public String getSenderID() {
        return get(ParamConstant.SENDERID);
    }

    public void setSenderID(String senderID) {
        put(ParamConstant.SENDERID, senderID);
    }

    public String getPriority() {
        return get(ParamConstant.PRIORITY);
    }

    public void setPriority(String priority) {
        put(ParamConstant.PRIORITY, priority);
    }

}
