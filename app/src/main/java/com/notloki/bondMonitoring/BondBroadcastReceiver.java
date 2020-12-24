package com.notloki.bondMonitoring;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BondBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            BondAlarm alarm = new BondAlarm();
            BondMonitoring bM = new BondMonitoring();
            alarm.setAlarm(bM.getContext());
        }


    }




}
