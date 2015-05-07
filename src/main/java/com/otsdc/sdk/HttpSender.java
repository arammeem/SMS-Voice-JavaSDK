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
package com.otsdc.sdk;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import com.otsdc.sdk.cmns.stream.InputStreamUtil;

/**
 *
 * @author Eri Setiawan
 */
public class HttpSender {

    private static final Log log = LogFactory.getLog(HttpSender.class);
    private static final PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    private static final CloseableHttpClient httpClient;
    static{
    	connectionManager.setMaxTotal(200);
    	connectionManager.setDefaultMaxPerRoute(20);
    	httpClient = HttpClients.custom().setConnectionManager(new PoolingHttpClientConnectionManager()).build();
    }
    public OTSRestResponse request(String url, String data) throws IOException {
        return requestDefault(url, new StringEntity(data));
    }

    public OTSRestResponse request(String url, List<NameValuePair> data) throws IOException {
        log.debug("URL:" + url);
        log.debug("DATA:" + data);
        return requestDefault(url, new UrlEncodedFormEntity(data));
    }

    public OTSRestResponse requestDefault(String url, HttpEntity data) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setEntity(data);

        ResponseHandler<OTSRestResponse> rh = new ResponseHandler<OTSRestResponse>() {
            @Override
            public OTSRestResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                OTSRestResponse orr = new OTSRestResponse();
                orr.setStatusCode(response.getStatusLine().getStatusCode());
                orr.setReasonPhrase(response.getStatusLine().getReasonPhrase());
                String respContent = InputStreamUtil.readString(entity.getContent());
                log.debug("Response:" + orr.getStatusCode() + ":" + orr.getReasonPhrase() + ":" + respContent);
                if (orr.getStatusCode() == 400) {
                    respContent = respContent.replace(",\"data\":[]", "");
                }
                orr.setData(respContent);
                return orr;
            }
        };
        OTSRestResponse execute = httpClient.execute(post, rh);
        return execute;
    }
    public static PoolingHttpClientConnectionManager getConnectionmanager() {
		return connectionManager;
	}
}
