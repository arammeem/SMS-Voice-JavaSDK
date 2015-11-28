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
package com.unifonic.sdk.resources.url.impl;

import com.unifonic.sdk.resources.url.IAccountUrl;
import com.unifonic.sdk.resources.url.IEmailUrl;
import com.unifonic.sdk.resources.url.IMessageUrl;
import com.unifonic.sdk.resources.url.IOTSUrl;
import com.unifonic.sdk.resources.url.IVerifyUrl;
import com.unifonic.sdk.resources.url.IVoiceUrl;

public abstract class AOTSUrl implements IOTSUrl {
	private String urlBase;
	private IAccountUrl accountURL;
	private IMessageUrl messageURL;
	private IVoiceUrl voiceURL;
	private IEmailUrl emailURL;
	private IVerifyUrl verifyURL;

	public AOTSUrl(String urlBase) {
		this.urlBase = urlBase;
		accountURL = createAccountUrl();
		messageURL = createMessageUrl();
		voiceURL = createVoiceUrl();
		emailURL = createEmailUrl();
		verifyURL = createVerifyUrl();
	}

	abstract IAccountUrl createAccountUrl();

	abstract IMessageUrl createMessageUrl();

	abstract IVoiceUrl createVoiceUrl();

	abstract IEmailUrl createEmailUrl();

	abstract IVerifyUrl createVerifyUrl();

	public String getUrlBase() {
		return urlBase;
	}

	@Override
	public IAccountUrl getAccountUrl() {
		return accountURL;
	}

	@Override
	public IMessageUrl getMessageUrl() {
		return messageURL;
	}

	@Override
	public IVoiceUrl getVoiceUrl() {
		return voiceURL;
	}

	@Override
	public IEmailUrl getEmailUrl() {
		return emailURL;
	}

	@Override
	public IVerifyUrl getVerifyUrl() {
		return verifyURL;
	}

}
