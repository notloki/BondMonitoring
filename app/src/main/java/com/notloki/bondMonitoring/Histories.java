package com.notloki.bondMonitoring;


import com.google.gson.Gson;

public class Histories {

    private int id;
    private String serializedObj;



    public static String objToString(HistoryObj historyObj) {

        Gson gson = new Gson();
        return gson.toJson(historyObj);
    }

    public static HistoryObj stringToObject(String string) {
        String finString = string.replace("[","")
                .replace("]","");
        Gson gson = new Gson();
        return gson.fromJson(finString, HistoryObj.class);
    }



}

