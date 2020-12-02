package com.notloki.bondMonitoring;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import static com.notloki.bondMonitoring.R.string.package_name;

public class SettingStorage {

    public static final String SETTINGS_PREFS_NAME = package_name + ".SettingStorage";

    private static SharedPreferences settingStore;
    private static SharedPreferences.Editor editor;


    private static final String DEBUG_KEY = package_name + ".DEBUG_KEY";
    private static final String TEST_KEY = package_name + ".TEST_KEY";
    private static final String DATE_KEY = package_name + ".DATE_KEY";

    public SettingStorage(Context ctx) {
        if (settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);

        editor = settingStore.edit();

    }

    public Setting settingLoadAll() {
        int test = settingStore.getInt(TEST_KEY, 0);
        String date = settingStore.getString(DATE_KEY, "");
        boolean debug = settingStore.getBoolean(DEBUG_KEY, false);
        return new Setting(test, date, debug);

    }

    public static void saveDebug(boolean bool, Context ctx) {
        if(settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);

        editor = settingStore.edit();
        editor.putBoolean(DEBUG_KEY, bool);
        editor.commit();

    }

    public static boolean loadDebug(Context ctx) {

        if(settingStore == null)
            settingStore = ctx.getSharedPreferences(SETTINGS_PREFS_NAME, Context.MODE_PRIVATE);
        Toast.makeText(ctx, "Loadin Debug value"
                + settingStore.getBoolean(DEBUG_KEY, false), Toast.LENGTH_LONG).show();
        return settingStore.getBoolean(DEBUG_KEY, false);

    }

    public void settingSave(Setting setting) {
        if (setting == null)
            return;


        if (setting.toString().contains(DEBUG_KEY)) {
            editor.putBoolean(DEBUG_KEY, setting.isDebug());
            if (setting.isDebug()) {
                System.out.println("DEBUG: setting.isDebug is saving as TRUE");
            } else {
                System.out.println("DEBUG: setting.isDebug is saving as FALSE");
            }

            if (setting.toString().contains(DATE_KEY)) {
                editor.putString(DATE_KEY, setting.getDate());
                System.out.println(setting.getDate());
            }

            if (setting.toString().contains(TEST_KEY)) {
                editor.putInt(TEST_KEY, setting.getTest());
                System.out.println(setting.getTest());
            }

            editor.apply();

        }

    }
}
