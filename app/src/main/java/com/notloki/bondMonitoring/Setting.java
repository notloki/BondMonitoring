package com.notloki.bondMonitoring;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Setting {

    private int test;
    private String date;
    private boolean debug;
    private boolean auto;


    public Setting() {
        this(0, (new SimpleDateFormat("MM.dd.yyyy", Locale.US)
                .format(Calendar.getInstance().getTime())),false, false);

    }
    public Setting(boolean debug){
        this.debug = debug;
    }

    public Setting(int test, String date) {
        this.debug = false;
        this.test = test;
        this.date = date;

    }


    public Setting(int test, String date, boolean debug, boolean auto) {
        this.test = test;
        this.date = date;
        this.debug = debug;
        this.auto = auto;
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

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) { this.auto = auto; }

    public void setTest(int test) { this.test = test; }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}