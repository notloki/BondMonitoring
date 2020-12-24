package com.notloki.bondMonitoring;


import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClient implements HttpClientInterface {

        private static final String TAG = OkHttpClient.class.getSimpleName();
        public static final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient httpClient = new OkHttpClient();

    @Override
        public String post(String url, String json) throws IOException {
            Log.i(TAG, "Sending a post request with body:\n" + json + "\n to URL: " + url);

            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = httpClient.newCall(request).execute();
            return response.body().string();
        }

}


