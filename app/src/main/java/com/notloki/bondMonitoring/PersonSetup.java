package com.notloki.bondMonitoring;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.notloki.bondMonitoring.Ref.brian;
import static com.notloki.bondMonitoring.Ref.isBrian;
import static com.notloki.bondMonitoring.SettingStorage.loadPerson;
import static com.notloki.bondMonitoring.SettingStorage.savePerson;
import static com.notloki.bondMonitoring.SettingStorage.savePersonLastName;

//import com.google.android.material.switchmaterial.SwitchMaterial;
//import static com.notloki.bondMonitoring.MainActivity.IVR_CODE;
//import static com.notloki.bondMonitoring.MainActivity.LAST_NAME;
//import static com.notloki.bondMonitoring.MainActivity.PHONE;

public class PersonSetup extends AppCompatActivity {

    EditText last_name_box;
    EditText phone_box;
    EditText ivr_box;
    EditText lang_box;

    private Setting savedPerson = null;
    private Setting currentPerson = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_setup);

        if(isBrian)
            currentPerson = brian;

        last_name_box = findViewById(R.id.person_name_editText);
        phone_box = findViewById(R.id.person_phone_editText);
        ivr_box = findViewById(R.id.person_ivr_editText);
        lang_box = findViewById(R.id.person_lang_editText);

        displayText(getCurrentPerson());
        last_name_box.setOnFocusChangeListener((view, bool) ->
                   savePersonLastName(last_name_box.getText().toString()));

    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onResume() {
        displayText(getCurrentPerson());
        super.onResume();
    }


    public void onFocusChanged(View view) {
        view.setOnFocusChangeListener(view.getOnFocusChangeListener());
    }


    public void onClickSave(View view) {


        currentPerson = new Setting(last_name_box.getText().toString(),
                                    phone_box.getText().toString(),
                                    ivr_box.getText().toString(),
                                    lang_box.getText().toString());

        savePerson(currentPerson);
        savedPerson  = currentPerson;
    }

    protected void onDestroy() {
        if((currentPerson != savedPerson) && (currentPerson != null)) {
            savePerson(currentPerson); }
        savedPerson = currentPerson;
        super.onDestroy();
    }

    private void displayText(Setting person) {

        if (currentPerson == null) {
            savedPerson = SettingStorage.loadPerson();
        currentPerson = savedPerson;
    }
        last_name_box.setText(person.getLast_name());
        phone_box.setText(person.getPhone());
        ivr_box.setText(person.getIvr_code());
        lang_box.setText(person.getLang());
    }
    private Setting getCurrentPerson() {
        if (currentPerson != null) {
            return currentPerson;
        } else if (savedPerson != null) {
            currentPerson = savedPerson;
            return currentPerson;
        } else {
            savedPerson = SettingStorage.loadPerson();
            currentPerson = savedPerson;
            return currentPerson;
        }

    }


}


//        editText =  (EditText) findViewById(R.id.person_name_editText);
//        editText2 = (EditText) findViewById(R.id.person_phone_editText);
//        editText3 = (EditText) findViewById(R.id.person_ivr_editText);
//        editText4 = (EditText) findViewById(R.id.person_lang_editText);

//                        Person person = new Person(editText.getText().toString(), editText2.getText().toString(),
//                editText4.getText().toString(), editText3.getText().toString());
//
//        PersonPrefs personPrefs = new PersonPrefs(this.getApplicationContext());
//        personPrefs.savePerson(person, getApplicationContext());
//        Toast.makeText(getApplicationContext(),R.string.saved + editText.getText().toString() +
//                        editText2.getText().toString() + editText3.getText().toString() + editText4.getText().toString(),
//                Toast.LENGTH_LONG).show();
 //   }}