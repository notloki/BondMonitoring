package com.notloki.bondMonitoring;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity
public class History {

    @PrimaryKey(autoGenerate = true)
    public int historyIds;
    @ColumnInfo(name = "dates")
    public Date date;
    @ColumnInfo(index = true)
    public int required_test;
    @ColumnInfo(name = "message" )
    public String text;
    @ColumnInfo(name = "transaction_key", index = true)
    public String key;
    @ColumnInfo
    public String error_msg;

}