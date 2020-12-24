package com.notloki.bondMonitoring;

import com.google.android.material.switchmaterial.SwitchMaterial;

public final class Ref {

//    MainActivity
    public static final String LAST_NAME="Burke+Jr.";
    public static final String PHONE="8662072911";
    public static final String IVR_CODE="102874";
    public static final String LANG="en";
    public static final String URL="https://sentry.cordanths.com/Sentry/WebCheckin/Log";
    public static final Setting brian = new Setting(LAST_NAME, PHONE, IVR_CODE, LANG);

    public static boolean checkedToday;
    public static long lastChecked;
    public static boolean debugVar;
    public static boolean autoVar;
    public static SwitchMaterial debugButton;
    public static SwitchMaterial autoButton;
    public static SwitchMaterial isBrianButton;
    public static boolean isBrian;

//    ResultsActivity

    public static String resultsCache;
    public static String results;
    public static String resultText;
    public static String resultText2 = "[{\"text\":\"Do not test today\",\"transaction_key\":\"ba0e5ca6\"," +
            "\"required_test\":0,\"date\":\"Tuesday, December 15, 2020  7:50AM MST\"}]";

}
