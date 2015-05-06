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

/**
 *
 * @author Eri Setiawan
 */
public class CallStatusResponse extends ResponseModel<CallStatusResponse> {

    @SerializedName("callStatus")
    private String callStatus;
    @SerializedName("CallDuration")
    private Integer callDuration;
    @SerializedName("Price")
    private Double price;
    @SerializedName("DateCreated")
    private Date dateCreated;
    @SerializedName("DateStarted")
    private Date dateStarted;
    @SerializedName("DateEnded")
    private Date dateEnded;

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public Integer getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Integer callDuration) {
        this.callDuration = callDuration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Date dateEnded) {
        this.dateEnded = dateEnded;
    }

    @Override
    public String toString() {
        return "CallStatusResponse{" + "callStatus=" + callStatus + ", callDuration=" + callDuration + ", price=" + price + ", dateCreated=" + dateCreated + ", dateStarted=" + dateStarted + ", dateEnded=" + dateEnded + '}';
    }

}
