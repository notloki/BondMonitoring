package com.notloki.bondMonitoring;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;

public class BondMonitoring extends Application {

    private ContentProvider contentProvider;

    public Context getContext() {


        return contentProvider.getContext();
    }
}
