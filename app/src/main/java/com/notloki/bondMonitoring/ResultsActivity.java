package com.notloki.bondMonitoring;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import okhttp3.OkHttpClient;

import static com.notloki.bondMonitoring.Ref.LANG;
import static com.notloki.bondMonitoring.Ref.LAST_NAME;
import static com.notloki.bondMonitoring.Ref.PHONE;
import static com.notloki.bondMonitoring.Ref.IVR_CODE;
import static com.notloki.bondMonitoring.Ref.checkedToday;
import static com.notloki.bondMonitoring.Ref.debugVar;
import static com.notloki.bondMonitoring.Ref.isBrian;
import static com.notloki.bondMonitoring.Ref.lastChecked;
import static com.notloki.bondMonitoring.Ref.resultText;
import static com.notloki.bondMonitoring.Ref.results;
import static com.notloki.bondMonitoring.Ref.resultsCache;

public class ResultsActivity extends AppCompatActivity {

//    public static String results;

    TextView textView;

    public String getResultText() {
        return resultText;
    }

    private static final OkHttpClient client = new OkHttpClient();

    @Override
    protected final void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        textView = findViewById(R.id.textView6);
//        Person person = new PersonPrefs(this).loadPerson(this);

        if (!(DateUtils.isToday(lastChecked))) {
            checkedToday = false;
        }
        CheckBond cb = new CheckBond();
        Setting person = SettingStorage.loadPerson();
        if (!checkedToday) {
            if (!isBrian) {


                cb.checkBond(person.getLast_name(),
                        person.getPhone(),
                        person.getIvr_code(),
                        person.getLang(),
                        getApplicationContext());

            } else {
                Setting brian = new Setting(LAST_NAME, PHONE, IVR_CODE, LANG);
               cb.checkBond(brian.getLast_name(),
                        brian.getPhone(),
                        brian.getIvr_code(),
                        brian.getLang(),
                        getApplicationContext());
            }
        } else {
            resultText = resultsCache;
        }



//   displayResults();

    }  //here


    public void displayResults(String resultsFinal) {
        if (textView == null)
            textView = findViewById(R.id.textView6);


        if (results == null) {
            if (debugVar) {
                System.out.println("DEBUG: " + results);
                results = getResultText();
            }
            textView.setText("Taking longer than usual");

        }

        textView.setText(resultsFinal);
    }


    protected void onStart() {
//        displayResults();
        super.onStart();

    }

    protected void onResume() {

        super.onResume();
        displayResults(resultText);
    }

    @Override
    protected void onPostResume() {
//        displayResults();
        super.onPostResume();
    }

    protected void onRestart() {
        displayResults(resultText);
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





}

