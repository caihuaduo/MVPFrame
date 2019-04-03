package com.sx.mvpdemo.app;

import android.app.Activity;
import android.app.Application;

import java.util.HashSet;
import java.util.Set;

public class App extends Application {


    private static App instance;
    private Set<Activity> allActivities;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }


    public void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }
}
