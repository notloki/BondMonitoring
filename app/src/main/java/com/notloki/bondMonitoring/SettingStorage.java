package com.notloki.bondMonitoring;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static android.icu.lang.UCharacter.JoiningGroup.E;
import static android.os.Build.VERSION_CODES.R;
import static com.notloki.bondMonitoring.R.string.package_name;
import static com.notloki.bondMonitoring.R.string.app_name;
public class SettingStorage {

    public static final String SETTINGS_PREFS_NAME = "com.notloki.bondMonitoring.SettingStorage";

    private static SharedPreferences settingStore;
    private static SharedPreferences.Editor editor;

    StringBuilder sb = new StringBuilder();


    private static final String DEBUG_KEY =  ".DEBUG_KEY";
    private static final String AUTO_KEY = "com.notloki.bondMonitoring.AUTO_KEY";
    private static final String CHECKED_TODAY_KEY = "com.notloki.bondMonitoring.CHECKED_TODAY_KEY";
    private static final String LAST_NAME_KEY = "com.notloki.bondMonitoring.LAST_NAME_KEY";
    private static final String PHONE_KEY = package_name + ".PHONE_KEY";
    private static final String IVR_KEY = package_name + ".IVR_KEY";
    private static final String LANG_KEY = package_name + ".LANG_KEY";

    public SettingStorage(Context ctx) {
        if (settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);

    }

    public Setting settingLoadAll() {
    sb.append(package_name).append(".Key");


        boolean debug = settingStore.getBoolean(DEBUG_KEY, false);
        boolean auto = settingStore.getBoolean(AUTO_KEY, false);
        boolean checkedToday = settingStore.getBoolean(CHECKED_TODAY_KEY, false);
        String last_name = settingStore.getString(LAST_NAME_KEY, "");
        String phone = settingStore.getString(PHONE_KEY, "");
        String ivr_code = settingStore.getString(IVR_KEY, "");
        String lang = settingStore.getString(LANG_KEY, "");

    return new Setting(debug, auto, checkedToday,
            last_name, phone, ivr_code, lang);
    }

    public Setting loadAllBool() {

        boolean debug = settingStore.getBoolean(DEBUG_KEY, false);
        boolean auto = settingStore.getBoolean(AUTO_KEY, false);
        boolean checkedToday = settingStore.getBoolean(CHECKED_TODAY_KEY, false);
        return new Setting(debug, auto, checkedToday);
    }

    public static Setting loadPerson() {

        String last_name = settingStore.getString(LAST_NAME_KEY, "");
        String phone = settingStore.getString(PHONE_KEY, "");
        String ivr_code = settingStore.getString(IVR_KEY, "");
        String lang = settingStore.getString(LANG_KEY, "");

        return new Setting(last_name, phone, ivr_code, lang);
    }

    public static void savePerson(Setting person) {
        if(person != null) {

            editor = settingStore.edit();
            editor.putString(LAST_NAME_KEY, person.getLast_name());
            editor.putString(PHONE_KEY, person.getPhone());
            editor.putString(IVR_KEY, person.getIvr_code());
            editor.putString(LANG_KEY, person.getLang());
            editor.apply();

        }

    }

    public static void savePersonLastName(String last_name) {
        if(last_name != null) {

            editor = settingStore.edit();
            editor.putString(LAST_NAME_KEY, last_name);
            editor.apply();
        }
    }

    public static void saveDebug(boolean bool, Context ctx) {
        if(settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);

        editor = settingStore.edit();
        editor.putBoolean(DEBUG_KEY, bool);
        editor.apply();

    }

    public static void saveAuto(boolean bool, Context ctx) {
        editor = settingStore.edit();
        if(settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);

         editor = settingStore.edit();
         editor.putBoolean(AUTO_KEY, bool);
         editor.apply();
    }

    public void saveChecked(Context ctx, boolean bool) {

        if (settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);

        editor = settingStore.edit();
        editor.putBoolean(CHECKED_TODAY_KEY, bool);

        editor.apply();

    }


public static boolean loadDebug(Context ctx) {

        if(settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);
        Toast.makeText(ctx, "Loadin Debug value"
                + settingStore.getBoolean(DEBUG_KEY, false), Toast.LENGTH_LONG).show();
        return settingStore.getBoolean(DEBUG_KEY, false);

    }

    public static boolean loadAuto(Context ctx) {

        if(settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);
        Toast.makeText(ctx, "Loadin Auto value"
                + settingStore.getBoolean(AUTO_KEY, false), Toast.LENGTH_LONG).show();
        return settingStore.getBoolean(AUTO_KEY, false);

    }

    public void settingSave(Setting setting) {
        editor = settingStore.edit();
        if (setting == null)
            return;

        if (setting.toString().contains(DEBUG_KEY)) {
            editor.putBoolean(DEBUG_KEY, setting.isDebug());
            if (setting.isDebug()) {
                System.out.println("DEBUG: setting.isDebug is saving as TRUE");
            } else {
                System.out.println("DEBUG: setting.isDebug is saving as FALSE");
            }


            editor.apply();

        }

    }




}
