package com.notloki.bondMonitoring;

import java.security.cert.CertificateRevokedException;
import java.util.Date;

public class HistoryObj {
    private int id;
    private Date date;
    private int required_test;
    private String text;
    private String transaction_key;
    private String error_msg;

    public HistoryObj(int id, Date date, String error_msg) {
        this.id = id;
        this.date = date;
        this.error_msg = error_msg;
    }

    public HistoryObj(int id, Date date, int required_test, String text, String transaction_key) {
        this.id = id;
        this.date = date;
        this.required_test = required_test;
        this.text = text;
        this.transaction_key = transaction_key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRequired_test() {
        return required_test;
    }

    public void setRequired_test(int required_test) {
        this.required_test = required_test;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTransaction_key() {
        return transaction_key;
    }

    public void setTransaction_key(String transaction_key) {
        this.transaction_key = transaction_key;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }


}




