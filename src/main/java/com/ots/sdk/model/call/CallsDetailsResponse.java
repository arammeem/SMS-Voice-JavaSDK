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
package com.ots.sdk.model.call;

import com.google.gson.annotations.SerializedName;
import com.ots.sdk.model.ResponseModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eri Setiawan
 */
public class CallsDetailsResponse extends ResponseModel<CallsDetailsResponse> {

    @SerializedName("calls")
    private List<CallsDetails> calls;
    @SerializedName("CurrencyCode")
    private String currencyCode;
    @SerializedName("TotalVoiceMessages")
    private Integer totalVoiceMessages;
    @SerializedName("Page")
    private Integer page;

    public List<CallsDetails> getCalls() {
        return calls;
    }

    public void setCalls(List<CallsDetails> calls) {
        this.calls = calls;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getTotalVoiceMessages() {
        return totalVoiceMessages;
    }

    public void setTotalVoiceMessages(Integer totalVoiceMessages) {
        this.totalVoiceMessages = totalVoiceMessages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public class CallsDetails {

        @SerializedName("CallID")
        private String callID;
        @SerializedName("AudioURL")
        private String audioURL;
        @SerializedName("RecipientNumber")
        private String recipientNumber;
        @SerializedName("Country")
        private String country;
        @SerializedName("CallStatus")
        private String callStatus;
        @SerializedName("TimeCreated")
        private Date timeCreated;
        @SerializedName("TimeSent")
        private Date timeSent;
        @SerializedName("TimeAnswered")
        private Date timeAnswered;
        @SerializedName("TimeEnded")
        private Date timeEnded;
        @SerializedName("CallDuration")
        private Integer callDuration;
        @SerializedName("Cost")
        private Double cost;

        public String getCallID() {
            return callID;
        }

        public void setCallID(String callID) {
            this.callID = callID;
        }

        public String getAudioURL() {
            return audioURL;
        }

        public void setAudioURL(String audioURL) {
            this.audioURL = audioURL;
        }

        public String getRecipientNumber() {
            return recipientNumber;
        }

        public void setRecipientNumber(String recipientNumber) {
            this.recipientNumber = recipientNumber;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCallStatus() {
            return callStatus;
        }

        public void setCallStatus(String callStatus) {
            this.callStatus = callStatus;
        }

        public Date getTimeCreated() {
            return timeCreated;
        }

        public void setTimeCreated(Date timeCreated) {
            this.timeCreated = timeCreated;
        }

        public Date getTimeSent() {
            return timeSent;
        }

        public void setTimeSent(Date timeSent) {
            this.timeSent = timeSent;
        }

        public Date getTimeAnswered() {
            return timeAnswered;
        }

        public void setTimeAnswered(Date timeAnswered) {
            this.timeAnswered = timeAnswered;
        }

        public Date getTimeEnded() {
            return timeEnded;
        }

        public void setTimeEnded(Date timeEnded) {
            this.timeEnded = timeEnded;
        }

        public Integer getCallDuration() {
            return callDuration;
        }

        public void setCallDuration(Integer callDuration) {
            this.callDuration = callDuration;
        }

        public Double getCost() {
            return cost;
        }

        public void setCost(Double cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "CallsDetails{" + "callID=" + callID + ", audioURL=" + audioURL + ", recipientNumber=" + recipientNumber + ", country=" + country + ", callStatus=" + callStatus + ", timeCreated=" + timeCreated + ", timeSent=" + timeSent + ", timeAnswered=" + timeAnswered + ", timeEnded=" + timeEnded + ", callDuration=" + callDuration + ", cost=" + cost + '}';
        }

    }

    @Override
    public String toString() {
        return "CallsDetailsResponse{" + "calls=" + calls + ", currencyCode=" + currencyCode + ", totalVoiceMessages=" + totalVoiceMessages + ", page=" + page + '}';
    }

}
