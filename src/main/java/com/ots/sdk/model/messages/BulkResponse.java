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
package com.ots.sdk.model.messages;

import com.google.gson.annotations.SerializedName;
import com.ots.sdk.model.ResponseModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eri Setiawan
 */
public class BulkResponse extends ResponseModel<BulkResponse> {

    @SerializedName("Messages")
    private List<BulkMessageStatus> messages;
    @SerializedName("NumberOfUnits")
    private Integer numberOfUnits;
    @SerializedName("Cost")
    private Double cost;
    @SerializedName("Balance")
    private Double balance;
    @SerializedName("TimeCreated")
    private Date timeCreated;
    @SerializedName("CurrencyCode")
    private String currencyCode;

    public List<BulkMessageStatus> getMessages() {
        return messages;
    }

    public void setMessages(List<BulkMessageStatus> messages) {
        this.messages = messages;
    }

    public Integer getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(Integer numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "BulkResponse{" + "messages=" + messages + ", numberOfUnits=" + numberOfUnits + ", cost=" + cost + ", balance=" + balance + ", timeCreated=" + timeCreated + ", currencyCode=" + currencyCode + '}';
    }

    public class BulkMessageStatus {

        @SerializedName("MessageID")
        private String messageID;
        @SerializedName("Recipient")
        private String recipient;
        @SerializedName("Status")
        private String status;

        public String getMessageID() {
            return messageID;
        }

        public void setMessageID(String messageID) {
            this.messageID = messageID;
        }

        public String getRecipient() {
            return recipient;
        }

        public void setRecipient(String recipient) {
            this.recipient = recipient;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "BulkMessageStatus{" + "messageID=" + messageID + ", recipient=" + recipient + ", status=" + status + '}';
        }

    }
}
