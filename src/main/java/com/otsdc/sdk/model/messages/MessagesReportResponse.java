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
package com.otsdc.sdk.model.messages;

import com.google.gson.annotations.SerializedName;
import com.otsdc.sdk.model.ResponseModel;

/**
 *
 * @author Eri Setiawan
 */
public class MessagesReportResponse extends ResponseModel<MessagesReportResponse> {

    @SerializedName("Cost")
    private Double cost;
    @SerializedName("TotalTextMessages")
    private Integer totalTextMessages;
    @SerializedName("NumberOfUnits")
    private Integer numberOfUnits;
    @SerializedName("CurrencyCode")
    private String currencyCode;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getTotalTextMessages() {
        return totalTextMessages;
    }

    public void setTotalTextMessages(Integer totalTextMessages) {
        this.totalTextMessages = totalTextMessages;
    }

    public Integer getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(Integer numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "MessagesReportResponse{" + "cost=" + cost + ", totalTextMessages=" + totalTextMessages + ", numberOfUnits=" + numberOfUnits + ", currencyCode=" + currencyCode + '}';
    }

}
