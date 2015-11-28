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
package com.unifonic.sdk.model.email;

import com.unifonic.sdk.constant.ParamConstant;
import com.unifonic.sdk.model.ARequest;

/**
 *
 * @author Eri Setiawan
 */
public class EmailRequest extends ARequest {

    public EmailRequest() {
    }

    public EmailRequest(String from, String recipient, String body) {
        setFrom(from);
        setRecipient(recipient);
        setBody(body);
    }

    public EmailRequest(String from, String recipient, String body, String subject) {
        setFrom(from);
        setRecipient(recipient);
        setBody(body);
        setSubject(subject);
    }

    public String getRecipient() {
        return get(ParamConstant.RECIPIENT);
    }

    public void setRecipient(String recipient) {
        put(ParamConstant.RECIPIENT, recipient);
    }

    public String getFrom() {
        return get(ParamConstant.FROM);
    }

    public void setFrom(String from) {
        put(ParamConstant.FROM, from);
    }

    public String getBody() {
        return get(ParamConstant.BODY);
    }

    public void setBody(String body) {
        put(ParamConstant.BODY, body);
    }

    public String getSubject() {
        return get(ParamConstant.SUBJECT);
    }

    public void setSubject(String subject) {
        put(ParamConstant.SUBJECT, subject);
    }

}
