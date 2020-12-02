package com.notloki.bondMonitoring;

import androidx.appcompat.app.AppCompatActivity;



import android.os.AsyncTask;
import android.os.Bundle;

import android.widget.TextView;

import java.io.IOException;
import java.util.Objects;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.notloki.bondMonitoring.MainActivity.URL;
import static com.notloki.bondMonitoring.MainActivity.debug;
import static java.util.Objects.requireNonNull;



public class ResultsActivity extends AppCompatActivity {

    public static String results;
    private int counter = 1;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        new MyTask().execute();

        TextView textView = (TextView) findViewById(R.id.textView6);

        textView.setText(results);

    }

    protected void onStart() {
        super.onStart();
        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText(results);
    }


    protected void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText(results);
        if(counter == 1) {
            counter --;
            onStart();
        }

    }

    private final class MyTask extends AsyncTask<String, Object, String> {

        PersonPrefs pp = new PersonPrefs(getApplicationContext());
        Person person = pp.loadPerson(getApplicationContext());
        Response response;
        private final OkHttpClient client = new OkHttpClient();


        @Override
        protected final String doInBackground(String... strings) {

            TextView textView = findViewById(R.id.textView6);
            // PersonPrefs personPrefs = new PersonPrefs(ctx);
            try {
                results = checkBond(
                        person.getLast_name(),
                        person.getPhone(),
                        person.getIvr_code(),
                        person.getLang());
            } catch (IOException e) {
                e.printStackTrace();
                results = e.getLocalizedMessage();

            }

            if (debug)
                System.out.println("DEBUG: " + results);

            String[] keys = {"too early", "Do not test today", "Information"};
            String[] values = {"R.string.error", "R.string.notest", "R.string.badinfo"};

        return null;
        }
//            switch (Objects.requireNonNull(results)) {
//                case "too early":
//                    return Integer.toString((R.string.error));
//
//                case "Do not test today":
//                    textView.setText(R.string.notest);
//                    break;
//                case "Information":
//                    textView.setText(R.string.badinfo);
//                    break;
//                case "You are required to test":
//                    textView.setText(R.string.dotest);
//                    break;
//                default:
//                    textView.setText(R.string.unknown);
//            }


//            return null;

//        }


            @Override
            protected final void onPostExecute (String string){
                super.onPostExecute(string);

            }

            String result;

            public final String checkBond (String last_name, String phone, String ivr_code, String
            lang) throws IOException
            {
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
                        .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), body))
                        .build();


                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                }

                ResponseBody responseBody = response.body();
                String resultText = requireNonNull(responseBody.string());
                if (debug) {
                    System.out.println("DEBUG: " + resultText);
                }
                return resultText;
            }

    }
}


