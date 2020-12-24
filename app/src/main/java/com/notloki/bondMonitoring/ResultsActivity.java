package com.notloki.bondMonitoring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Ignore;

import android.content.ContentProvider;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.widget.TextView;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.notloki.bondMonitoring.MainActivity.IVR_CODE;
import static com.notloki.bondMonitoring.MainActivity.LANG;
import static com.notloki.bondMonitoring.MainActivity.LAST_NAME;
import static com.notloki.bondMonitoring.MainActivity.PHONE;
import static com.notloki.bondMonitoring.MainActivity.URL;


import static com.notloki.bondMonitoring.MainActivity.debugVar;
import static com.notloki.bondMonitoring.MainActivity.isBrian;

public class ResultsActivity extends AppCompatActivity {

//    public static String results;

    private Long lastChecked = 0L;
    String resultsCache;
    String results = null;
    TextView textView;
    public static boolean checkedToday;
    private static String resultText;
    String resultText2 = "[{\"text\":\"Do not test today\",\"transaction_key\":\"ba0e5ca6\"," +
        "\"required_test\":0,\"date\":\"Tuesday, December 15, 2020  7:50AM MST\"}]";
    public static String getResultText() {
        return resultText;
    }

    private static final OkHttpClient client = new OkHttpClient();

    @Override
    protected final void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

//        Person person = new PersonPrefs(this).loadPerson(this);
        if(!(DateUtils.isToday(lastChecked))) {
            checkedToday = false;
        }

        Setting person = SettingStorage.loadPerson();
        if(!checkedToday) {
            if (!MainActivity.isBrian) {


                checkBond(
                        person.getLast_name(),
                        person.getPhone(),
                        person.getIvr_code(),
                        person.getLang());

            } else {
                Setting brian = new Setting(LAST_NAME, PHONE, IVR_CODE, LANG);
                checkBond(brian.getLast_name(),
                        brian.getPhone(),
                        brian.getIvr_code(),
                        brian.getLang());
            }
        } else {
            resultText = resultsCache;
        }

        displayResults();

    }


    public void displayResults() {
        if (textView == null)
            textView = findViewById(R.id.textView6);


        if (results == null) {
            for(int i = 3;i >= 0; i-- ) {
                if(debugVar) {
                    System.out.println("DEBUG: Counting back from " + i + " Iterations");
                }
                textView.setText(R.string.loading);
                results = getResultText();
                textView.setText("Taking longer than usual");

            }
        }


        textView.setText(results);

    }

    protected void onStart() {
//        displayResults();
        super.onStart();

    }

    protected void onResume() {
        super.onResume();
//       displayResults();
    }

    protected void onRestart() {
        displayResults();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


    public void checkBond(String last_name, String phone,
                          String ivr_code, String lang) {


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
                    checkedToday = true;
                    resultsCache = resultText;
                    lastChecked = Calendar.getInstance().getTimeInMillis();
                    HistoryObj historyObj = Histories.stringToObject(resultText);
                    HistoryPrefs hp = new HistoryPrefs(getApplicationContext());
                    hp.saveHistory(historyObj,getApplicationContext());

                    if (debugVar) {
                        System.out.println("DEBUG: " + resultText);
                    }

                }
            }
        });
    }

    public HistoryObj jsonToObj(String string) {
        Gson gson = new Gson();
        String finString = string.replace("[","")
                .replace("]","");
        return gson.fromJson(finString, HistoryObj.class);
    }
    public String objToJson(HistoryObj historyObj){
        Gson gson = new Gson();
        return  gson.toJson(historyObj);
    }






}









