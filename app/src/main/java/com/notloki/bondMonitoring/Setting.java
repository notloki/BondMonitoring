package com.notloki.bondMonitoring;



public class Setting {

    private boolean debug;
    private boolean auto;
    private boolean checkedToday;
    private String last_name;
    private String phone;
    private String lang;
    private String ivr_code;

    public Setting() {

    }

    public Setting(boolean debug, boolean auto, boolean checkedToday) {

        this.debug = debug;
        this.auto = auto;
        this.checkedToday = checkedToday;
    }

    public Setting(String last_name, String phone,
                   String ivr_code, String lang) {

        this.last_name = last_name;
        this.phone = phone;
        this.ivr_code = ivr_code;
        this.lang = lang;

    }

    public Setting(boolean debug, boolean auto, boolean checkedToday,
                   String last_name, String phone,
                   String ivr_code, String lang){

        this.debug = debug;
        this.auto = auto;
        this.checkedToday = checkedToday;
        this.last_name = last_name;
        this.phone = phone;
        this.ivr_code = ivr_code;
        this.lang = lang;
    }


    public boolean isCheckedToday() {

        return checkedToday;
    }

    public void setCheckedToday(boolean checkedToday) {

        this.checkedToday = checkedToday;
    }

    public boolean isDebug() {

        return debug;
    }

    public void setDebug(boolean debug) {

        this.debug = debug;
    }

    public boolean isAuto() {

        return auto;
    }

    public void setAuto(boolean auto) {

        this.auto = auto;
    }

    public String getLast_name() {

        return last_name;
    }

    public void setLast_name(String last_name) {

        this.last_name = last_name;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getLang() {

        return lang;
    }

    public void setLang(String lang) {

        this.lang = lang;
    }

    public String getIvr_code() {

        return ivr_code;
    }

    public void setIvr_code(String ivr_code) {

        this.ivr_code = ivr_code;
    }
}