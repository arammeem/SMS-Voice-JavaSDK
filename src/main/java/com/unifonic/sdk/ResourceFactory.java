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
package com.unifonic.sdk;

import com.unifonic.sdk.resources.IAccountResource;
import com.unifonic.sdk.resources.IEmailResource;
import com.unifonic.sdk.resources.IMessageResource;
import com.unifonic.sdk.resources.IVerifyResource;
import com.unifonic.sdk.resources.IVoiceResource;
import com.unifonic.sdk.resources.http.AccountResourceImpl;
import com.unifonic.sdk.resources.http.EmailResourceImpl;
import com.unifonic.sdk.resources.http.MessagesResourceImpl;
import com.unifonic.sdk.resources.http.VerifyResourceImpl;
import com.unifonic.sdk.resources.http.VoiceResourceImpl;
import com.unifonic.sdk.resources.url.IOTSUrl;
import com.unifonic.sdk.resources.url.impl.AOTSUrl;
import com.unifonic.sdk.resources.url.impl.HttpOTSUrl;
import com.unifonic.sdk.resources.url.impl.HttpsOTSUrl;

/**
 *
 * @author Eri Setiawan
 */
public class ResourceFactory {
	private IOTSUrl otsUrl;
	
    public ResourceFactory(IOTSUrl otsUrl) {
		this.otsUrl = otsUrl;
	}
    
	public IAccountResource makeAccountResource(String appSid) {
        return new AccountResourceImpl(appSid, otsUrl.getAccountUrl());
    }

    public IEmailResource makeEmailResource(String appSid) {
        return new EmailResourceImpl(appSid, otsUrl.getEmailUrl());
    }

    public IVoiceResource makeVoiceResource(String appSid) {
        return new VoiceResourceImpl(appSid, otsUrl.getVoiceUrl());
    }

    public IMessageResource makeMessageResource(String appSid) {
        return new MessagesResourceImpl(appSid, otsUrl.getMessageUrl());
    }

    public IVerifyResource makeVerifyResource(String appSid) {
        return new VerifyResourceImpl(appSid, otsUrl.getVerifyUrl());
    }
}
