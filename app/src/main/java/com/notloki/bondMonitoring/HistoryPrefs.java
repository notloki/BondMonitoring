package com.notloki.bondMonitoring;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.net.ssl.SSLEngineResult;

import kotlin.collections.ArrayDeque;

import static com.notloki.bondMonitoring.Histories.objToString;


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
    private static final String TRANSACTION_KEY =
            "com.notloki.bondMonitoring.TRANSACTION_KEY_KEY";
    private static final String LAST_ID_KEY =
            "com.notloki.bondMonitoring.LAST_ID_KEY";
    private int last_id;


    public HistoryPrefs(Context ctx) {
        if (settings == null) {
            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        }
    }

    public void saveHistory(HistoryObj historyObj, Context ctx) {
        if (historyObj == null)
            return;

        if (settings == null)
            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        editor = settings.edit();
        editor.putString(Integer.toString(historyObj.getId()),objToString(historyObj));

        editor.apply();    }

    public HistoryObj loadHistory(int id, Context ctx) {
        if(settings == null)
            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        return Histories.stringToObject(Integer.toString(id));


    }
    public List<HistoryObj> loadTenHistories(Context ctx) {
        if(settings == null)
            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        int l_id = settings.getInt(LAST_ID_KEY, 0);
        List<HistoryObj> histories = new ArrayList<>();
        for(int i = l_id;i != 0; i--) {
            histories.add(loadHistory(i, ctx));
        }
        return histories;

    }


    public int getNewId(Context ctx) {
        if(settings == null)
            settings = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        last_id = settings.getInt(LAST_ID_KEY, 0);
        if(last_id == 0)
            return 1;
        return last_id + 1;
        }




}


