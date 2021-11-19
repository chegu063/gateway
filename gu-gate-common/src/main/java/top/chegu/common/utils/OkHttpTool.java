/*
 * Copyright (c) 2021 chegu <1107313063@qq.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.chegu.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
import top.chegu.common.exception.GuGateException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author chegu
 * @date 2021/4/12  14:42
 */
public class OkHttpTool {

    public static final String HTTP_JSON = "application/json;charset=utf-8";

    public static Gson gson = new GsonBuilder().create();

    public static OkHttpClient client;

    static {
        client = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static <T> void doPost(String url, T t) {
        RequestBody requestBody = RequestBody.create(MediaType.parse(HTTP_JSON), gson.toJson(t));
        Request request = new Request.Builder()
                .post(requestBody)
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if (response.code() < 200 || response.code() >= 300) {
                throw new GuGateException("request " + url + " fail, http code:" + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GuGateException("request " + url + " fail");
        }
    }

}
