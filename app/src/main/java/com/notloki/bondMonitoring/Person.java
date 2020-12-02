package com.notloki.bondMonitoring;

public class Person {
    private final String last_name;
    private final String phone;
    private final String lang;
    private final String ivr_code;

    public Person(String last_name, String phone, String lang, String ivr_code) {
        this.last_name = last_name;
        this.phone = phone;
        this.lang = lang;
        this.ivr_code = ivr_code;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLang() {
        return lang;
    }

    public String getIvr_code() {
        return ivr_code;
    }
}
