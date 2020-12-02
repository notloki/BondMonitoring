package com.notloki.bondMonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.switchmaterial.SwitchMaterial;

import static com.notloki.bondMonitoring.SettingStorage.loadDebug;
import static com.notloki.bondMonitoring.SettingStorage.saveDebug;

public class MainActivity extends AppCompatActivity {

//    public static final String LAST_NAME="Burke+Jr.";
//    public static final String PHONE="8662072911";
//    public static final String IVR_CODE="102874";
//    public static final String LANG="en";

    public static final String URL="https://sentry.cordanths.com/Sentry/WebCheckin/Log";
    public static boolean debug;
    public static SwitchMaterial switchMaterial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    protected  void onStart() {
        super.onStart();

    }



    @Override
    protected void onResume() {

//        switchMaterial = findViewById(R.id.debugSwitch);
//        switchMaterial.setChecked(loadDebug(getApplicationContext()));

        super.onResume();
        loadFromDisk();

    }

    protected void onPause() {

        super.onPause();

    }

    protected void onStop() {

        super.onStop();

    }



    @Override
    protected void onDestroy() {
        saveToDisk();
        super.onDestroy();
    }

    private void saveToDisk() {

        saveDebug(debug, getApplicationContext());

    }
    private void loadFromDisk() {

        debug = loadDebug(getApplicationContext());
        switchMaterial = findViewById(R.id.debugSwitch);
        switchMaterial.setChecked(debug);
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

        switchMaterial = findViewById(R.id.debugSwitch);
        debug = switchMaterial.isChecked();
        saveToDisk();

    }
    private void saveAll(Object ohj) {
        //Save
    }


}