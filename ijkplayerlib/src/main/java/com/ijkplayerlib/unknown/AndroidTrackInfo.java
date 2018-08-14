package com.ijkplayerlib.unknown;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.TrackInfo;
import android.os.Build.VERSION;

import com.ijkplayerlib.Interface.IMediaFormat;
import com.ijkplayerlib.Interface.ITrackInfo;

/**
 * description:
 * author: WDSG
 * date 2018/8/14
 */
public class AndroidTrackInfo implements ITrackInfo {
    private final TrackInfo mTrackInfo;

    public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer mp) {
        return VERSION.SDK_INT >= 16 ? fromTrackInfo(mp.getTrackInfo()) : null;
    }

    private static AndroidTrackInfo[] fromTrackInfo(TrackInfo[] trackInfos) {
        if (trackInfos == null) {
            return null;
        } else {
            AndroidTrackInfo[] androidTrackInfo = new AndroidTrackInfo[trackInfos.length];

            for(int i = 0; i < trackInfos.length; ++i) {
                androidTrackInfo[i] = new AndroidTrackInfo(trackInfos[i]);
            }

            return androidTrackInfo;
        }
    }

    private AndroidTrackInfo(TrackInfo trackInfo) {
        this.mTrackInfo = trackInfo;
    }

    @TargetApi(19)
    public IMediaFormat getFormat() {
        if (this.mTrackInfo == null) {
            return null;
        } else if (VERSION.SDK_INT < 19) {
            return null;
        } else {
            MediaFormat mediaFormat = this.mTrackInfo.getFormat();
            return mediaFormat == null ? null : new AndroidMediaFormat(mediaFormat);
        }
    }

    @TargetApi(16)
    public String getLanguage() {
        return this.mTrackInfo == null ? "und" : this.mTrackInfo.getLanguage();
    }

    @TargetApi(16)
    public int getTrackType() {
        return this.mTrackInfo == null ? 0 : this.mTrackInfo.getTrackType();
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder out = new StringBuilder(128);
        out.append(this.getClass().getSimpleName());
        out.append('{');
        if (this.mTrackInfo != null) {
            out.append(this.mTrackInfo.toString());
        } else {
            out.append("null");
        }

        out.append('}');
        return out.toString();
    }

    @TargetApi(16)
    public String getInfoInline() {
        return this.mTrackInfo != null ? this.mTrackInfo.toString() : "null";
    }
}
