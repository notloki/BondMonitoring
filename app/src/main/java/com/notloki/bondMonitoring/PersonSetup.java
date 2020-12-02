package com.notloki.bondMonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.material.switchmaterial.SwitchMaterial;
//
//import static com.notloki.bondMonitoring.MainActivity.IVR_CODE;
//import static com.notloki.bondMonitoring.MainActivity.LAST_NAME;
//import static com.notloki.bondMonitoring.MainActivity.PHONE;

public class PersonSetup extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_setup);

        editText =  (EditText) findViewById(R.id.person_name_editText);
        editText2 = (EditText) findViewById(R.id.person_phone_editText);
        editText3 = (EditText) findViewById(R.id.person_ivr_editText);
        editText4 = (EditText) findViewById(R.id.person_lang_editText);

        PersonPrefs personPrefs = new PersonPrefs(this.getApplicationContext());

            Person person = personPrefs.loadPerson(getApplicationContext());

            editText.setText(person.getLast_name());
            editText2.setText(person.getPhone());
            editText3.setText(person.getIvr_code());
            editText4.setText(person.getLang());

    }
    public void onClickSave(View view) {
        editText =  (EditText) findViewById(R.id.person_name_editText);
        editText2 = (EditText) findViewById(R.id.person_phone_editText);
        editText3 = (EditText) findViewById(R.id.person_ivr_editText);
        editText4 = (EditText) findViewById(R.id.person_lang_editText);

        Person person = new Person(editText.getText().toString(), editText2.getText().toString(),
                editText4.getText().toString(), editText3.getText().toString());

        PersonPrefs personPrefs = new PersonPrefs(this.getApplicationContext());
        personPrefs.savePerson(person, getApplicationContext());
        Toast.makeText(getApplicationContext(),R.string.saved + editText.getText().toString() +
                        editText2.getText().toString() + editText3.getText().toString() + editText4.getText().toString(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}