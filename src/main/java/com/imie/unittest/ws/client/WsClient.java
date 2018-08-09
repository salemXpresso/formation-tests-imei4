package com.imie.unittest.ws.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WsClient {

    public int negative(int a) throws IOException, JSONException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/negative?a=" + a)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String jsonRaw = response.body().string();
        JSONObject jsonObject = new JSONObject(jsonRaw);
        return jsonObject.getInt("response");
    }

    public int multiply(int a, int b) throws IOException, JSONException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/multiply?a=" + a + "&b=" + b)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String jsonRaw = response.body().string();
        JSONObject jsonObject = new JSONObject(jsonRaw);
        return jsonObject.getInt("response");
    }

    public int divide(int a, int b) throws IOException, JSONException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/divide?a=" + a + "&b=" + b)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String jsonRaw = response.body().string();
        JSONObject jsonObject = new JSONObject(jsonRaw);
        return jsonObject.getInt("response");
    }
}
