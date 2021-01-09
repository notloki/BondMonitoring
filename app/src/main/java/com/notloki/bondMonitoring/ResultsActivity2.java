package com.notloki.bondMonitoring;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;

import okhttp3.Call;
import okhttp3.Callback;

import static com.notloki.bondMonitoring.Ref.IVR_CODE;
import static com.notloki.bondMonitoring.Ref.LANG;
import static com.notloki.bondMonitoring.Ref.LAST_NAME;
import static com.notloki.bondMonitoring.Ref.PHONE;
public class ResultsActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);

        CheckBond cb = new CheckBond();

        cb.checkBond(
                LAST_NAME,
                PHONE,
                IVR_CODE,
                LANG,
                this);



    }

    public void displayResults(Context ctx) {


    }



}