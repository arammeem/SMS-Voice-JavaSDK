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
package com.unifonic.sdk.resources;

import java.io.IOException;
import java.util.Map;

import com.unifonic.sdk.model.email.EmailReportRequest;
import com.unifonic.sdk.model.email.EmailReportResponse;
import com.unifonic.sdk.model.email.EmailRequest;
import com.unifonic.sdk.model.email.EmailResponse;
import com.unifonic.sdk.resources.IResource;

/**
 * Email sub-resource is used to send emails to your audience.
 *
 * @author Eri Setiawan
 */
public interface IEmailResource extends IResource {

    public EmailResponse send(EmailRequest request) throws IOException;

    public EmailResponse send(Map<String, String> param) throws IOException;

    public EmailReportResponse getEmailsReport() throws IOException;

    public EmailReportResponse getEmailsReport(EmailReportRequest request) throws IOException;

    public EmailReportResponse getEmailsReport(Map<String, String> param) throws IOException;
}
