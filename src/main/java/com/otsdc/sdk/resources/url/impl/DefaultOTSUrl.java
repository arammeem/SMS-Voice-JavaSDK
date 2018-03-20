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
package com.otsdc.sdk.resources.url.impl;

import com.otsdc.sdk.resources.url.IAccountUrl;
import com.otsdc.sdk.resources.url.IEmailUrl;
import com.otsdc.sdk.resources.url.IMessageUrl;
import com.otsdc.sdk.resources.url.IVerifyUrl;
import com.otsdc.sdk.resources.url.IVoiceUrl;

public class DefaultOTSUrl extends AOTSUrl {

	public DefaultOTSUrl(String urlBase) {
		super(urlBase);
	}

	@Override
	IAccountUrl createAccountUrl() {
		return new AccountUrlImpl(getUrlBase());
	}

	@Override
	IMessageUrl createMessageUrl() {
		return new MessageUrlImpl(getUrlBase());
	}

	@Override
	IVoiceUrl createVoiceUrl() {
		return new VoiceUrlImpl(getUrlBase());
	}

	@Override
	IEmailUrl createEmailUrl() {
		return new EmailUrlImpl(getUrlBase());
	}

	@Override
	IVerifyUrl createVerifyUrl() {
		return new VerifyUrl(getUrlBase());
	}

}