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
