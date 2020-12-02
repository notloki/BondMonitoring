package com.notloki.bondMonitoring;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.content.ContentProvider;
import com.google.android.material.switchmaterial.SwitchMaterial;

import static com.notloki.bondMonitoring.SettingStorage.loadAuto;
import static com.notloki.bondMonitoring.SettingStorage.loadDebug;
import static com.notloki.bondMonitoring.SettingStorage.saveAuto;
import static com.notloki.bondMonitoring.SettingStorage.saveDebug;


public class MainActivity extends AppCompatActivity {

//    public static final String LAST_NAME="Burke+Jr.";
//    public static final String PHONE="8662072911";
//    public static final String IVR_CODE="102874";
//    public static final String LANG="en";

    public static final String URL="https://sentry.cordanths.com/Sentry/WebCheckin/Log";
    public static boolean debugVar;
    public static boolean autoVar;
    public static SwitchMaterial debugButton;
    public static SwitchMaterial autoButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {

        super.onResume();
        loadFromDisk();

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
        saveToDisk();
        super.onDestroy();
    }

    private void saveToDisk() {

        saveDebug(debugVar, this);
        saveAuto(autoVar, this);

    }
    private void loadFromDisk() {

        autoVar = loadAuto(this);
        debugVar = loadDebug(this);
        debugButton = findViewById(R.id.debugSwitch);
        debugButton.setChecked(debugVar);
        autoButton = findViewById(R.id.mainAutoSched);
        autoButton.setChecked(autoVar);
    }


    public void onClickResults(View view) {

        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);

    }

    public void onClickPersonSetup(View view) {
        Intent intent = new Intent(this, PersonSetup.class);
        startActivity(intent);

    }

    public void onClickHistory(View view) {

        Intent intent = new Intent(this, BondHistory.class);
        startActivity(intent);
    }

    public void onClickDebug(View view) {

        debugButton = findViewById(R.id.debugSwitch);
        debugVar = debugButton.isChecked();
        saveToDisk();

    }

    public void onClickAuto(View view) {
        autoButton = findViewById(R.id.mainAutoSched);
        autoVar = autoButton.isChecked();
        saveToDisk();

//        BondAlarm bondAlarm = new BondAlarm(new BondMonitoring().getContext());
//        if (autoVar) {
//            bondAlarm.setAlarm();
//        } else {
//            bondAlarm.cancelAlarm();
//        }

    }

}