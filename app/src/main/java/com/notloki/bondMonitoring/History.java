//package com.notloki.bondMonitoring;
//
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.Ignore;
//import androidx.room.PrimaryKey;
//
//
//
//@Entity
//public class History {
//
//    @PrimaryKey(autoGenerate = true)
//    public int id;
//    @ColumnInfo(index = true)
//    public String date;
//    @ColumnInfo(index = true)
//    public int required_test;
//    @ColumnInfo(name = "message" )
//    public String text;
//    @ColumnInfo(index = true)
//    public String tKey;
//
//    public String error_msg;
//    @Ignore
//    public History(String date, int required_test,
//                   String text, String tKey, String error_msg) {
//        this.id = 0;
//        this.date = date;
//        this.required_test = required_test;
//        this.text = text;
//        this.tKey = tKey;
//        this.error_msg = error_msg;
//    }
//
//    public History(int id, String date, int required_test,
//                   String text, String tKey, String error_msg) {
//
//        this.id = id;
//        this.date = date;
//        this.required_test = required_test;
//        this.text = text;
//        this.tKey = tKey;
//        this.error_msg = error_msg;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public int getRequired_test() {
//        return required_test;
//    }
//
//    public void setRequired_test(int required_test) {
//        this.required_test = required_test;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public String getTKey() {
//        return tKey;
//    }
//
//    public void setTKey(String tKey) {
//        this.tKey = tKey;
//    }
//
//    public String getError_msg() {
//        return error_msg;
//    }
//
//    public void setError_msg(String error_msg) {
//        this.error_msg = error_msg;
//    }
//}
//
