package com.notloki.bondMonitoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



import static com.notloki.bondMonitoring.Ref.autoButton;
import static com.notloki.bondMonitoring.Ref.autoVar;
import static com.notloki.bondMonitoring.Ref.debugButton;
import static com.notloki.bondMonitoring.Ref.debugVar;
import static com.notloki.bondMonitoring.Ref.isBrianButton;
import static com.notloki.bondMonitoring.Ref.lastChecked;
import static com.notloki.bondMonitoring.Ref.isBrian;
import static com.notloki.bondMonitoring.SettingStorage.loadAuto;
import static com.notloki.bondMonitoring.SettingStorage.loadDebug;
import static com.notloki.bondMonitoring.SettingStorage.loadLastChecked;
import static com.notloki.bondMonitoring.SettingStorage.saveAuto;
import static com.notloki.bondMonitoring.SettingStorage.saveDebug;

public class MainActivity extends AppCompatActivity {



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
        lastChecked = loadLastChecked(getApplicationContext());
    }


    public void onClickBrian(View view) {
        isBrianButton = findViewById(R.id.isBrianButtonXml);
        isBrianButton.setSaveEnabled(true);
        isBrian = isBrianButton.isChecked();
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

    public void onClickAuto(View view){
//        autoButton = findViewById(R.id.mainAutoSched);
//        autoVar = autoButton.isChecked();
//        saveToDisk();
//        BondMonitoring bondMonitoring = new BondMonitoring();
//        BondAlarm bondAlarm = new BondAlarm();
//        if (autoVar) {
//            bondAlarm.setAlarm(bondMonitoring.getContext());
//        } else {
//            bondAlarm.cancelAlarm(bondMonitoring.getContext());
//        }

        }
    }

