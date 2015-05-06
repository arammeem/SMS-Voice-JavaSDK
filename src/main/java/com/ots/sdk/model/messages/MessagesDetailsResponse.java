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
import com.ots.sdk.constant.DLRConstant;
import com.ots.sdk.constant.MessageStatusConstant;
import com.ots.sdk.model.ResponseModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eri Setiawan
 */
public class MessagesDetailsResponse extends ResponseModel<MessagesDetailsResponse> implements MessageStatusConstant, DLRConstant {

    private List<MessageDetail> messages;
    /**
     * The currency code used eith cost, either USD or SAR
     */
    @SerializedName("CurrencyCode")
    private String currencyCode;
    /**
     * Total number of returned messages
     */
    @SerializedName("TotalTextMessages")
    private Integer totalTextMessages;
    /**
     * The page to display
     */
    @SerializedName("Page")
    private Integer page;

    public List<MessageDetail> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDetail> messages) {
        this.messages = messages;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getTotalTextMessages() {
        return totalTextMessages;
    }

    public void setTotalTextMessages(Integer totalTextMessages) {
        this.totalTextMessages = totalTextMessages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public class MessageDetail {

        /**
         * The sent message unique ID
         */
        @SerializedName("MessageID")
        private String messageID;
        /**
         * The sent message body text
         */
        @SerializedName("MessageBody")
        private String messageBody;
        /**
         * The recipient mobile number the message was sent to
         */
        @SerializedName("RecipientNumber")
        private String recipientNumber;
        /**
         * The mobile number country the message was sent to
         */
        @SerializedName("Country")
        private String country;
        /**
         * The status of the sent message
         */
        @SerializedName("Status")
        private String status;
        /**
         * Message delivery status returned by networks, the possible values are
         * "Delivered" or "Undeliverable", and are available for advanced plans
         */
        @SerializedName("DLR")
        private String dlr;
        /**
         * The date in which the message was created
         */
        @SerializedName("DateCreated")
        private Date dateCreated;
        /**
         * The date in which the message was sent to network
         */
        @SerializedName("DateSent")
        private Date dateSent;
        /**
         * The related sender ID
         */
        @SerializedName("SenderID")
        private String senderID;
        /**
         * The message number of units
         */
        @SerializedName("NumberOfUnits")
        private Integer numberOfUnits;
        /**
         * The price of the message
         */
        @SerializedName("Cost")
        private Double cost;

        public String getMessageID() {
            return messageID;
        }

        public void setMessageID(String messageID) {
            this.messageID = messageID;
        }

        public String getMessageBody() {
            return messageBody;
        }

        public void setMessageBody(String messageBody) {
            this.messageBody = messageBody;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDlr() {
            return dlr;
        }

        public void setDlr(String dlr) {
            this.dlr = dlr;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
        }

        public Date getDateSent() {
            return dateSent;
        }

        public void setDateSent(Date dateSent) {
            this.dateSent = dateSent;
        }

        public String getSenderID() {
            return senderID;
        }

        public void setSenderID(String senderID) {
            this.senderID = senderID;
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

        @Override
        public String toString() {
            return "MessageDetail{" + "messageID=" + messageID + ", messageBody=" + messageBody + ", recipientNumber=" + recipientNumber + ", country=" + country + ", status=" + status + ", dlr=" + dlr + ", dateCreated=" + dateCreated + ", dateSent=" + dateSent + ", senderID=" + senderID + ", numberOfUnits=" + numberOfUnits + ", cost=" + cost + "}\n";
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MessagesDetailsResponse{ ");
        if (messages != null) {
            builder.append("messages=");
            for (MessageDetail messageDetail : messages) {
                builder.append(messageDetail);
            }
        }
        return builder.append(", currencyCode=").append(currencyCode)
                .append(", totalTextMessages=").append(totalTextMessages)
                .append(", page=").append(page).append('}').toString();
    }

}
