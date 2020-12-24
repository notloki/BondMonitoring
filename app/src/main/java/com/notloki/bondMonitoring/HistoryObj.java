package com.notloki.bondMonitoring;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class HistoryObj {



    private String date;
    private int required_test;
    private String transaction_key;
    private String text;
    private int id;


    public HistoryObj() {

    }

    public HistoryObj(int required_test, String transaction_key, String text, Context ctx) {
        this.required_test = required_test;
        this.transaction_key = transaction_key;
        this.text = text;

        date = ((new SimpleDateFormat("MM, dd, yyyy", Locale.US)
                .format(Calendar.getInstance().getTime())));
        id = new HistoryPrefs(ctx).getNewId(ctx);

    }

    public HistoryObj(int required_test, String transaction_key, String text, String date, int id) {
        this.required_test = required_test;
        this.transaction_key = transaction_key;
        this.text = text;
        this.date = date;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String string) {
        this.text = string;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRequired_test() {
        return required_test;
    }

    public void setRequired_test(int required_test) {
        this.required_test = required_test;
    }


    public String getTransaction_key() {
        return transaction_key;
    }

    public void setTransaction_key(String transaction_key) {
        this.transaction_key = transaction_key;
    }

}




