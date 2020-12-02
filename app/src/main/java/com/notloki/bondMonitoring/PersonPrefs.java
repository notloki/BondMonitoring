package com.notloki.bondMonitoring;

import android.content.Context;
import android.content.SharedPreferences;

public class PersonPrefs {

    public static final String PREFS_NAME = "com.notloki.bondMonitoring.PersonPrefs";

    private static SharedPreferences settings;
    private static SharedPreferences.Editor editor;

    private static final String LAST_NAME_KEY = "com.notloki.bondMonitoring.LAST_NAME_KEY";
    private static final String PHONE_KEY = "com.notloki.bondMonitoring.PHONE_KEY";
    private static final String IVR_KEY = "com.notloki.bondMonitoring.IVR_KEY";
    private static final String LANG_KEY = "com.notloki.bondMonitoring.LANG_KEY";

    public PersonPrefs(Context ctx) {
        if(settings == null) {
            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        }
    }

    public void savePerson(Person person, Context ctx)  {
        if(person == null)
            return;

        if(settings == null)
        settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        editor = settings.edit();

        String last_name = person.getLast_name();
        String phone = person.getPhone();
        String ivr = person.getIvr_code();
        String lang = person.getLang();

        editor.putString(LAST_NAME_KEY, last_name);
        editor.putString(PHONE_KEY, phone);
        editor.putString(IVR_KEY, ivr);
        editor.putString(LANG_KEY, lang);

        editor.commit();

        }
    public Person loadPerson(Context ctx){
        if(settings == null)
            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String last_name = settings.getString(LAST_NAME_KEY, "");
        String phone = settings.getString(PHONE_KEY, "");
        String ivr_code = settings.getString(IVR_KEY, "");
        String lang = settings.getString(LANG_KEY, "");

        return new Person(last_name, phone, lang, ivr_code);

    }

}

