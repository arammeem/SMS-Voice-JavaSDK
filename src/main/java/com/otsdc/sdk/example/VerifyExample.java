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
import com.otsdc.sdk.model.ResponseModel;
import com.otsdc.sdk.model.Voids;
import com.otsdc.sdk.model.verify.GetCodeRequest;
import com.otsdc.sdk.model.verify.GetCodeResponse;
import com.otsdc.sdk.resources.IVerifyResource;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eri Setiawan
 */
public class VerifyExample {

    public static void main(String[] args) {
        try {
            String appSid = "your appSid";
            OTSRestClient client = new OTSRestClient(appSid);
            IVerifyResource verifyResource = client.getVerifyResource();

            //Get Code
            GetCodeRequest codeRequest = new GetCodeRequest("962789xxxxxx", "98765543");
            GetCodeResponse codeResp = verifyResource.getCode(codeRequest);
            System.out.println("GetCodeResponse:" + codeResp);
            //verify Number
            ResponseModel<Voids> verifyNumber = verifyResource.verifyNumber("962789xxxxxx", "98765543");
            System.out.println("Verified?:" + verifyNumber);

        } catch (IOException ex) {
            Logger.getLogger(VerifyExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
