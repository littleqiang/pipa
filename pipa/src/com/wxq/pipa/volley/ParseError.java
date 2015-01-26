/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wxq.pipa.volley;

import com.wxq.pipa.volley.NetworkResponse;
import com.wxq.pipa.volley.VolleyError;

/**
 * Indicates that the server's response could not be parsed.
 */
@SuppressWarnings("serial")
public class ParseError extends VolleyError {
    public ParseError() { }

    public ParseError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ParseError(Throwable cause) {
        super(cause);
    }
}
