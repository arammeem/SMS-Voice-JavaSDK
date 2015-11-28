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

import com.unifonic.sdk.resources.url.IVoiceUrl;

public class VoiceUrlImpl implements IVoiceUrl {

	private String urlCall;
	private String urlGetCallIDStatus;
	private String urlGetCallsDetails;
	private String urlTTSCall;

	public VoiceUrlImpl(String urlBase) {
		String urlVoice = urlBase + PATH_VOICE;
		urlCall = urlVoice + "Call";
		urlGetCallIDStatus = urlVoice + "GetCallIDStatus";
		urlGetCallsDetails = urlVoice + "GetCallsDetails";
		urlTTSCall = urlVoice + "TTSCall";
	}

	@Override
	public String urlCall() {
		return urlCall;
	}

	@Override
	public String urlGetCallIDStatus() {
		return urlGetCallIDStatus;
	}

	@Override
	public String urlGetCallsDetails() {
		return urlGetCallsDetails;
	}

	@Override
	public String urlTTSCall() {
		return urlTTSCall;
	}

}
