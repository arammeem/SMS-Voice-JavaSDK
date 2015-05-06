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
package com.ots.sdk.example;

import com.ots.sdk.OTSRestClient;
import com.ots.sdk.model.call.CallRequest;
import com.ots.sdk.model.call.CallResponse;
import com.ots.sdk.model.call.CallStatusResponse;
import com.ots.sdk.model.call.CallsDetailsRequest;
import com.ots.sdk.model.call.CallsDetailsResponse;
import com.ots.sdk.model.call.TTSCallRequest;
import com.ots.sdk.model.call.TTSCallResponse;
import com.ots.sdk.resources.IVoiceResource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eri Setiawan
 */
public class CallExample {

    public static void main(String[] args) {
        try {
            String appSid = "cYWr62UeR6mbGZw6qHWUhiVX8z5ed";
            OTSRestClient client = new OTSRestClient(appSid);
            IVoiceResource vr = client.getVoiceResource();

            //Call 1
            CallRequest callRequest = new CallRequest();
            callRequest.setContent("https://voiceusa.s3.amazonaws.com/voiceWavFiles1423399184883.wav");
            callRequest.setRecipient("962789309519");
            CallResponse callResponse = vr.call(callRequest);
            System.out.println("CallResponse:" + callResponse);
            // Same as Call 2
            Map<String, String> map = new HashMap<>();
            map.put("Recipient", "962789309519");
            map.put("Content", "https://voiceusa.s3.amazonaws.com/voiceWavFiles1423399184883.wav");
            CallResponse callResponse2 = vr.call(map);
            System.out.println("CallResponse2:" + callResponse2);

            //GetCallStatus
            CallStatusResponse callIDStatus = vr.getCallIDStatus(callResponse.getCallID());
            System.out.println("CallStatus:" + callIDStatus);

            // get Completed Calls
            CallsDetailsRequest cdr = new CallsDetailsRequest();
            cdr.setStatus(CallsDetailsRequest.STATUS_COMPLETED);
            CallsDetailsResponse callsDetails = vr.getCallsDetails(cdr);
            System.out.println("CallsDetails:" + callsDetails);
            List<CallsDetailsResponse.CallsDetails> calls = callsDetails.getCalls();
            for (CallsDetailsResponse.CallsDetails callsDetails1 : calls) {
                System.out.println(callsDetails1);
            }
            //get All CallDetails - No Filter
            CallsDetailsResponse callsDetails1 = vr.getCallsDetails();
            System.out.println("CallDetails1:" + callsDetails1);
            //TTS Call
            TTSCallRequest ttsCallRequest = new TTSCallRequest("962789309519", "Test Text To Speech");
            TTSCallResponse ttsCallResponse = vr.ttsCall(ttsCallRequest);
            System.out.println("TTS CAll Response:" + ttsCallResponse);
        } catch (IOException ex) {
            Logger.getLogger(CallExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
