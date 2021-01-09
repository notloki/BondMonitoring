package com.notloki.bondMonitoring;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.notloki.bondMonitoring.Ref.URL;
import static com.notloki.bondMonitoring.Ref.debugVar;
import static com.notloki.bondMonitoring.Ref.resultText;

public class CheckBond {

    OkHttpClient client = new OkHttpClient();
    Context ctx;
    private final Handler mHandler = new Handler(Looper.getMainLooper());


    public void checkBond(String last_name, String phone,
                          String ivr_code, String lang, Context ctx) {

        this.ctx = ctx;
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
                .post(RequestBody
                        .create(body, MediaType
                                .parse("application/x-www-form-urlencoded")))
                .build();


        Call call = client.newCall(request);

        call.enqueue(new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                e.printStackTrace();

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {


                try {
                    if (response.isSuccessful()) {
                        ResponseBody responseBody = response.body();
                        resultText = Objects.requireNonNull(responseBody).string();

                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                if (debugVar) {
                    System.out.println("DEBUG: " + resultText);
                }

                if (!(resultText.contains("error"))) {

                    Ref.checkedToday = true;
                    Ref.resultsCache = resultText;
                    Ref.lastChecked = Calendar.getInstance().getTimeInMillis();
                    SettingStorage.saveLastChecked(ctx.getApplicationContext(),
                            Ref.lastChecked);
                    HistoryObj historyObj = Histories.stringToObject(resultText);
                    HistoryPrefs hp = new HistoryPrefs(ctx.getApplicationContext());
                    hp.saveHistory(historyObj, ctx.getApplicationContext());

                    if (debugVar) {
                        System.out.println("DEBUG: " + resultText);
                    }

                    mHandler.post(new Runnable() {


                        @Override
                        public void run() {


                        }


                    });
                }
            }


        });


    }
}