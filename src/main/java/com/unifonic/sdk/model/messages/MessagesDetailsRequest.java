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
package com.unifonic.sdk.model.messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.unifonic.sdk.constant.DLRConstant;
import com.unifonic.sdk.constant.MessageStatusConstant;
import com.unifonic.sdk.constant.ParamConstant;
import com.unifonic.sdk.model.ARequest;

/**
 *
 * @author Eri Setiawan
 */
public class MessagesDetailsRequest extends ARequest implements MessageStatusConstant, DLRConstant {

    private SimpleDateFormat simpleDateFormat;
    private String dateFormat = DEFAULT_DATE_FORMAT;

    public MessagesDetailsRequest() {
        simpleDateFormat = new SimpleDateFormat(dateFormat);
    }

    public String getDateFormat() {
        return dateFormat;
    }

    /**
     *
     * @return The Message ID
     */
    public String getMessageID() {
        return get(ParamConstant.MESSAGEID);
    }

    /**
     *
     * @param messageID The Message ID
     */
    public void setMessageID(String messageID) {
        put(ParamConstant.MESSAGEID, messageID);
    }

    /**
     *
     * @return Filter messages report according to a specific message status.
     * "Sent", "Queued", "Rejected" or "Failed"
     */
    public String getStatus() {
        return get(ParamConstant.STATUS);
    }

    /**
     *
     * @param status Filter messages report according to a specific message
     * status. "Sent", "Queued", "Rejected" or "Failed"
     */
    public void setStatus(String status) {
        put(ParamConstant.STATUS, status);
    }

    public String getSenderID() {
        return get(ParamConstant.SENDERID);
    }

    /**
     *
     * @param senderID Filter messages report according to a specific sender ID
     */
    public void setSenderID(String senderID) {
        put(ParamConstant.SENDERID, senderID);
    }

    /**
     *
     * @return The end date for the report time interval
     * @throws ParseException
     */
    public Date getDateTo() throws ParseException {
        String get = get(ParamConstant.DATE_TO);
        if (get != null) {
            return simpleDateFormat.parse(get);
        }
        return null;
    }

    /**
     *
     * @param dateTo The end date for the report time interval
     */
    public void setDateTo(Date dateTo) {
        String format = simpleDateFormat.format(dateTo);
        put(ParamConstant.DATE_TO, format);
    }

    /**
     *
     * @return The start date for the report time interval
     * @throws ParseException
     */
    public Date getDateFrom() throws ParseException {
        String get = get(ParamConstant.DATE_FROM);
        if (get != null) {
            return simpleDateFormat.parse(get);
        }
        return null;
    }

    /**
     *
     * @param dateFrom The start date for the report time interval
     */
    public void setDateFrom(Date dateFrom) {
        String format = simpleDateFormat.format(dateFrom);
        put(ParamConstant.DATE_FROM, format);
    }

    /**
     *
     * @return Number of messages to return in the report, where the limit
     * maximum is 10,000 and messages are sorted by sending date
     */
    public Integer getLimit() {
        String get = get(ParamConstant.LIMIT);
        if (get != null) {
            return Integer.valueOf(get);
        }
        return null;
    }

    /**
     *
     * @param limit Number of messages to return in the report, where the limit
     * maximum is 10,000 and messages are sorted by sending date
     */
    public void setLimit(Integer limit) {
        put(ParamConstant.LIMIT, limit.toString());
    }

    public Integer getPage() {
        String get = get(ParamConstant.PAGE);
        if (get != null) {
            return Integer.valueOf(get);
        }
        return null;
    }

    public void setPage(Integer page) {
        put(ParamConstant.PAGE, page.toString());
    }

    /**
     *
     * @param country Filter messages report according to a specific destination
     * country
     */
    public void setCountry(String country) {
        put(ParamConstant.COUNTRY, country);
    }

    public String getCountry() {
        return get(ParamConstant.COUNTRY);
    }

    /**
     *
     * @param dlr Message delivery status returned by networks, the possible
     * values are "Delivered" or "Undeliverable", and are available for advanced
     * plans
     */
    public void setDLR(String dlr) {
        put(ParamConstant.DLR, dlr);
    }

    public String getDLR() {
        return get(ParamConstant.DLR);
    }

}
