package com.notloki.bondMonitoring;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Setting {

    private int test;
    private String date;
    private boolean debug;


    public Setting() {
        this(0, (new SimpleDateFormat("MM.dd.yyyy", Locale.US)
                .format(Calendar.getInstance().getTime())),true);
    }
    public Setting(boolean debug){
        this.debug = debug;
    }

    public Setting(int test, String date) {
        this.debug = false;
        this.test = test;
        this.date = date;

    }


    public Setting(int test, String date, boolean debug) {
        this.test = test;
        this.date = date;
        this.debug = debug;
    }



    public int getTest() {
        return test;
    }

    public String getDate() {
        return date;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}