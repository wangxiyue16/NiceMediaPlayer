package com.ijkplayerlib.unknown;

import android.annotation.TargetApi;
import android.media.MediaFormat;

import com.ijkplayerlib.Interface.IMediaFormat;

/**
 * description:
 * author: WDSG
 * date 2018/8/14
 */
public class AndroidMediaFormat implements IMediaFormat {
    private final MediaFormat mMediaFormat;

    public AndroidMediaFormat(MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    @TargetApi(16)
    public int getInteger(String name) {
        return this.mMediaFormat == null ? 0 : this.mMediaFormat.getInteger(name);
    }

    @TargetApi(16)
    public String getString(String name) {
        return this.mMediaFormat == null ? null : this.mMediaFormat.getString(name);
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder out = new StringBuilder(128);
        out.append(this.getClass().getName());
        out.append('{');
        if (this.mMediaFormat != null) {
            out.append(this.mMediaFormat.toString());
        } else {
            out.append("null");
        }

        out.append('}');
        return out.toString();
    }
}
