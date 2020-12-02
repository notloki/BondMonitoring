package com.notloki.bondMonitoring;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.widget.TextView;
import java.io.IOException;




public class ResultsActivity extends AppCompatActivity{

//    public static String results;

    Network network = new Network();
    String results = null;
    TextView textView = findViewById(R.id.textView6);
    boolean useCache;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        Person person = new PersonPrefs(this).loadPerson(this);

        if(useCache)
        try{ network.checkBond(person.getLast_name(),
                person.getPhone(),
                person.getIvr_code(),
                person.getLang());} catch (IOException ioe) {
            ioe.printStackTrace(); }
        displayResults();

        }

    public void displayResults() {


        if(results == null && textView != null) {
            textView.setText(R.string.loading);
            results = Network.getResultText(); }
        if (textView != null && results != null) {
            textView.setText(results);
        }



    }

    protected void onStart() {
        displayResults();
        super.onStart();

    }

    protected void onResume() {
        super.onResume();
       displayResults();
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


//    private final class MyTask extends AsyncTask<String, Object, String> {
//
//        PersonPrefs pp = new PersonPrefs(getApplicationContext());
//        Person person = pp.loadPerson(getApplicationContext());
//
//
//
//
//        @Override
//        protected final String doInBackground(String... strings) {
//
//                TextView textView = findViewById(R.id.textView6);
//                // PersonPrefs personPrefs = new PersonPrefs(ctx);
//                try {
//                    results = Network.checkBond(
//                            person.getLast_name(),
//                            person.getPhone(),
//                            person.getIvr_code(),
//                            person.getLang());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    results = e.getLocalizedMessage();
//
//                }
//
//                if (debug)
//                    System.out.println("DEBUG: " + results);
//
//                String[] keys = {"too early", "Do not test today", "Information"};
//                String[] values = {"R.string.error", "R.string.notest", "R.string.badinfo"};
//
//                return null;
//            }

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

//
//            @Override
//            protected final void onPostExecute (String string){
//                super.onPostExecute(string);
//
//            }





    }



