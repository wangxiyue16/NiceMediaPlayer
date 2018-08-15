package com.ijkplayerlib;

import android.app.Application;
import android.content.Context;

/**
 * description:
 * author: WDSG
 * date 2018/8/15
 */
public class App extends Application {
    protected static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    /**
     * @return 返回getApplicationContext()
     */
    public static Context ct() {
        return sContext;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }
}
