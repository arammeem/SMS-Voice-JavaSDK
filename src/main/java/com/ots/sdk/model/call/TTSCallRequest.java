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

import com.ots.sdk.constant.CallLangConstant;
import com.ots.sdk.constant.ParamConstant;
import com.ots.sdk.model.ARequest;

/**
 *
 * @author Eri Setiawan
 */
public class TTSCallRequest extends ARequest implements CallLangConstant {

    public TTSCallRequest(String recipient, String content, String language) {
        setRecipient(recipient);
        setContent(content);
        setLanguage(language);
    }
    /**
     * Default Lang English
     * @param recipient
     * @param content 
     */
    public TTSCallRequest(String recipient, String content) {
        setRecipient(recipient);
        setContent(content);
        setLanguage(LANG_ENGLISH);
    }

    public String getRecipient() {
        return get(ParamConstant.RECIPIENT);
    }

    public void setRecipient(String recipient) {
        put(ParamConstant.RECIPIENT, recipient);
    }

    public String getContent() {
        return get(ParamConstant.CONTENT);
    }

    public void setContent(String content) {
        put(ParamConstant.CONTENT, content);
    }

    public String getLanguage() {
        return get(ParamConstant.LANGUAGE);
    }

    public void setLanguage(String language) {
        put(ParamConstant.LANGUAGE, language);
    }

}
