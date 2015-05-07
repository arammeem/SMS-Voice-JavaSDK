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

import com.otsdc.sdk.model.ResponseModel;
import com.otsdc.sdk.model.Voids;
import com.otsdc.sdk.model.verify.GetCodeRequest;
import com.otsdc.sdk.model.verify.GetCodeResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Verify API will help you verify your users' phone numbers, and secure your
 * online transactions by adding two-factor authentication during users' sign up
 * and login actions. Verify API confirms your users by sending something they
 * know, to something they own! With just few lines of code, you will enable
 * your system to send secure passcode to your user mobile number via text
 * message to be entered into your web or mobile app.
 *
 * @author Eri Setiawan
 */
public interface IVerifyResource extends IResource {

    public static final String URL_VERIFY = URL_BASE_PROD + "Verify/";
    public static final String URL_GET_CODE = URL_VERIFY + "GetCode";
    public static final String URL_VERIFY_NUMBER = URL_VERIFY + "VerifyNumber";

    /**
     * Provide a user number to be verified and the GetCode method will send the
     * passcode via text message number to the provided number
     *
     * @param request
     * @return
     * @throws IOException
     */
    public GetCodeResponse getCode(GetCodeRequest request) throws IOException;

    /**
     * Provide a user number to be verified and the GetCode method will send the
     * passcode via text message number to the provided number
     *
     * @param map
     * @return
     * @throws IOException
     */
    public GetCodeResponse getCode(Map<String, String> map) throws IOException;

    /**
     * Provide the pass code obtained from your user along with the mobile
     * number, VerifyNumber API will verify if the pass code matches the number
     * and authenticate or unauthenticated the user mobile number
     *
     * @param recipient
     * @param passCode
     * @return
     * @throws IOException
     */
    public ResponseModel<Voids> verifyNumber(String recipient, String passCode) throws IOException;

    /**
     * Provide the pass code obtained from your user along with the mobile
     * number, VerifyNumber API will verify if the pass code matches the number
     * and authenticate or unauthenticated the user mobile number
     *
     * @param map
     * @return
     * @throws IOException
     */
    public ResponseModel<Voids> verifyNumber(Map<String, String> map) throws IOException;

}
