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
package com.ots.sdk.model.email;

import com.ots.sdk.constant.EmailStatusConstant;
import com.ots.sdk.constant.ParamConstant;
import com.ots.sdk.model.ARequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eri Setiawan
 */
public class EmailReportRequest extends ARequest implements EmailStatusConstant {

    private SimpleDateFormat simpleDateFormat;
    private String dateFormat = DEFAULT_DATE_FORMAT;

    public EmailReportRequest() {
        simpleDateFormat = new SimpleDateFormat(dateFormat);
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        simpleDateFormat = new SimpleDateFormat(dateFormat);
    }

    public String getEmailStatus() {
        return get(ParamConstant.EMAIL_STATUS);
    }

    public void setEmailStatus(String emailStatus) {
        put(ParamConstant.EMAIL_STATUS, emailStatus);
    }

    public String getSubject() {
        return get(ParamConstant.SUBJECT);
    }

    public void setSubject(String subject) {
        put(ParamConstant.SUBJECT, subject);
    }

    public Date getDateCreated() throws ParseException {
        String get = get(ParamConstant.DATE_CREATED);
        if (get != null) {
            return simpleDateFormat.parse(get);
        }
        return null;
    }

    public void setDateCreated(Date dateCreated) {
        String format = simpleDateFormat.format(dateCreated);
        put(ParamConstant.DATE_CREATED, format);
    }

    public String getFrom() {
        return get(ParamConstant.FROM);
    }

    public void setFrom(String from) {
        put(ParamConstant.FROM, from);
    }

    public Date getDateFrom() throws ParseException {
        String get = get(ParamConstant.DATE_FROM);
        if (get != null) {
            return simpleDateFormat.parse(get);
        }
        return null;
    }

    public void setDateFrom(Date dateFrom) {
        String format = simpleDateFormat.format(dateFrom);
        put(ParamConstant.DATE_CREATED, format);
    }

    public Date getDateTo() throws ParseException {
        String get = get(ParamConstant.DATE_TO);
        if (get != null) {
            return simpleDateFormat.parse(get);
        }
        return null;
    }

    public void setDateTo(Date dateTo) {
        String format = simpleDateFormat.format(dateTo);
        put(ParamConstant.DATE_CREATED, format);
    }

}
