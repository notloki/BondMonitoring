package com.notloki.bondMonitoring;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Http2Reader;

import static com.notloki.bondMonitoring.MainActivity.URL;
import static com.notloki.bondMonitoring.MainActivity.debugVar;



public class Network extends AppCompatActivity {

    private static String resultText;
    public static String getResultText(){
        return resultText;
    }
    Handler mHandler = new Handler();
    private static final OkHttpClient client = new OkHttpClient();







    public void checkBond(String last_name, String phone, String ivr_code, String
            lang)  {


        String body = ("phone=" + phone + "&" + "last_name="
                + last_name + "&" + "ivr_code=" + ivr_code + "&" + "lang=" + lang);

        body = body.replaceAll("\\s", "+");

        Request request = new Request.Builder()

                .url(URL)
                .addHeader("authority", "sentry.cordanths.com")
                .addHeader("accept", "application/json, text/javascript, */*; q=0.01")
                .addHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Mobile Safari/537.36")
                .addHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Origin", "https://www.mycallin.com")
                .addHeader("sec-fetch-site", "cross-site")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("referer", "https://www.mycallin.com/")
                .addHeader("accept-language", "en-US,en;q=0.9")
                .post(RequestBody.create(body, MediaType.parse("application/x-www-form-urlencoded")))
                .build();


        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response)  {


                try {
                    if (response.isSuccessful()) {
                        ResponseBody responseBody = response.body();
                        resultText = responseBody.string();
                    }

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                if (debugVar) {
                    System.out.println("DEBUG: " + resultText);
                }

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {


                    }

                });


            }


        });
    }
}








