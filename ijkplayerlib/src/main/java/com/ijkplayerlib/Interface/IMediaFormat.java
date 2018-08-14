package com.ijkplayerlib.Interface;

/**
 * description:
 * author: WDSG
 * date 2018/8/14
 */
public interface IMediaFormat {
    String KEY_MIME = "mime";
    String KEY_WIDTH = "width";
    String KEY_HEIGHT = "height";

    String getString(String var1);

    int getInteger(String var1);
}
