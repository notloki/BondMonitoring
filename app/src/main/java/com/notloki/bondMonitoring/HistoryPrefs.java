package com.notloki.bondMonitoring;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class HistoryPrefs {

    public static final String PREFS_NAME = "com.notloki.bondMonitoring.HistoryPrefs";

    private static SharedPreferences settings;
    private static SharedPreferences.Editor editor;

    private static final String ID_KEY =
            "com.notloki.bondMonitoring.ID_KEY";
    private static final String DATE_KEY =
            "com.notloki.bondMonitoring.DATE_KEY";
    private static final String REQUIRED_TEST_KEY =
            "com.notloki.bondMonitoring.REQUIRED_TEST_KEY";
    private static final String TEXT_KEY =
            "com.notloki.bondMonitoring.TEXT_KEY";
    private static final String TRANSACTION_KEY_KEY =
            "com.notloki.bondMonitoring.TRANSACTION_KEY_KEY";
    private static final String ERROR_MSG =
            "com.notloki.bondMonitoring.ERROR_MSG_KEY";



}

//    public HistoryPrefs(Context ctx) {
//        if(settings == null) {
//            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
//        }
//    }

//    public void saveHistory(HistoryObj historyObj, Context ctx) {
//        if(historyObj == null)
//            return;
//
//        if(settings == null)
//            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
//
//        editor = settings.edit();
//
//        if(historyObj.getError_msg().isEmpty()) {
//            if(settings.getInt(ID_KEY, 0) == historyObj.getId()) {
//                // do stuff
//            }
//        }
//    }


