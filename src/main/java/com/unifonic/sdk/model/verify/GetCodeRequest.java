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
package com.unifonic.sdk.model.verify;

import com.unifonic.sdk.constant.ParamConstant;
import com.unifonic.sdk.model.ARequest;

/**
 *
 * @author Eri Setiawan
 */
public class GetCodeRequest extends ARequest {

    public GetCodeRequest(String recipient, String body) {
        setRecipient(recipient);
        setBody(body);
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

    public String getSecurityType() {
        return get(ParamConstant.SECURITY_TYPE);
    }

    public void setSecurityType(String securityType) {
        put(ParamConstant.SECURITY_TYPE, securityType);
    }

    public String getExpiry() {
        return get(ParamConstant.EXPIRY);
    }

    public void setExpiry(String expiry) {
        put(ParamConstant.EXPIRY, expiry);
    }

    public String getSenderID() {
        return get(ParamConstant.SENDERID);
    }

    public void setSenderID(String senderID) {
        put(ParamConstant.SENDERID, senderID);
    }

}
