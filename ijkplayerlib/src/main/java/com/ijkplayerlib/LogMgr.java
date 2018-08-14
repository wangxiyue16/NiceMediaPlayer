package com.ijkplayerlib;

import android.util.Log;

/**
 * description:
 * author: WDSG
 * date 2018/8/14
 */
public class LogMgr {
    private static boolean mDebug = true;

    public static boolean isDebug() {
        return mDebug;
    }

    public static void setDebug(boolean debug) {
        LogMgr.mDebug = debug;
    }

    public static int v(String tag, String msg) {
        if (mDebug) {
            return Log.v(tag, msg);
        } else {
            return 0;
        }
    }

    public static int v(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return Log.v(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static int d(String tag, String msg) {
        if (mDebug) {
            return Log.d(tag, msg);
        } else {
            return 0;
        }
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return Log.d(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static int i(String tag, String msg) {
        if (mDebug) {
            return Log.i(tag, msg);
        } else {
            return 0;
        }
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return Log.i(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static int e(String tag, String msg) {
        if (mDebug) {
            return Log.e(tag, msg);
        } else {
            return 0;
        }
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return Log.e(tag, msg, tr);
        } else {
            return 0;
        }
    }

    public static int w(String tag, String msg) {
        if (mDebug) {
            return Log.w(tag, msg);
        } else {
            return 0;
        }
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return Log.w(tag, msg, tr);
        } else {
            return 0;
        }
    }
}
