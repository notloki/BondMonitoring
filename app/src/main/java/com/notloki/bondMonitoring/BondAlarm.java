package com.notloki.bondMonitoring;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public  class BondAlarm {

    PendingIntent alarmIntent;
    AlarmManager  alarmMgr;


    public final void setAlarm(Context appContext) {

        try { alarmMgr =
                (AlarmManager) appContext.getSystemService(Context.ALARM_SERVICE);
              } catch (NullPointerException npe)
        {npe.printStackTrace();}


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        Intent intent = new Intent(appContext, BondBroadcastReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(appContext, 0, intent, 0);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);

        // Enable Reboot Receiver

        ComponentName receiver = new ComponentName(appContext, BondBroadcastReceiver.class);
        PackageManager pm = appContext.getPackageManager();
        if(pm.getComponentEnabledSetting(receiver)== PackageManager.COMPONENT_ENABLED_STATE_DISABLED) {
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
        }
    }

    public final void cancelAlarm(Context appContext) {
        try { alarmMgr =
                (AlarmManager) appContext.getSystemService(Context.ALARM_SERVICE);
        } catch (NullPointerException npe)
        {npe.printStackTrace();}

        Intent intent = new Intent(appContext, BondBroadcastReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(appContext, 0, intent, 0);

        if (alarmMgr != null) {
            alarmMgr.cancel(alarmIntent);
        }
// Disable Reboot Receiver
        ComponentName receiver = null;
        PackageManager pm = null;
        try {
            receiver = new ComponentName(appContext, BondBroadcastReceiver.class);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        try {
            pm = appContext.getPackageManager();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }


        try {
            if(pm.getComponentEnabledSetting(receiver) ==
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {

                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP);
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
}






