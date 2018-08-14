package com.ijkplayerlib.basePlayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;

import com.ijkplayerlib.Interface.IMediaDataSource;
import com.ijkplayerlib.Interface.ITrackInfo;
import com.ijkplayerlib.LogMgr;
import com.ijkplayerlib.bean.IjkTimedText;
import com.ijkplayerlib.bean.MediaInfo;
import com.ijkplayerlib.unknown.AndroidTrackInfo;

import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;

/**
 * description:
 * author: WDSG
 * date 2018/8/14
 */
public class AndroidMediaPlayer extends AbstractMediaPlayer {
    private final String TAG = "AndroidMediaPlayer";
    private final MediaPlayer mInternalMediaPlayer;
    private final AndroidMediaPlayer.AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    private String mDataSource;
    private MediaDataSource mMediaDataSource;
    private final Object mInitLock = new Object();
    private boolean mIsReleased;
    private static MediaInfo sMediaInfo;

    @RequiresApi(api = VERSION_CODES.CUPCAKE)
    public AndroidMediaPlayer() {
        Object var1 = this.mInitLock;
        synchronized (this.mInitLock) {
            this.mInternalMediaPlayer = new MediaPlayer();
        }

        this.mInternalMediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayer.AndroidMediaPlayerListenerHolder(this);
        this.attachInternalListeners();
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    public void setDisplay(SurfaceHolder sh) {
        Object var2 = this.mInitLock;
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(sh);
            }

        }
    }

    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    @TargetApi(14)
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(context, uri, headers);
    }

    public void setDataSource(FileDescriptor fd) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mInternalMediaPlayer.setDataSource(fd);
    }

    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mDataSource = path;
        Uri uri = Uri.parse(path);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(uri.getPath());
        } else {
            this.mInternalMediaPlayer.setDataSource(path);
        }

    }

    @TargetApi(23)
    public void setDataSource(IMediaDataSource mediaDataSource) {
        this.releaseMediaDataSource();
        this.mMediaDataSource = new AndroidMediaPlayer.MediaDataSourceProxy(mediaDataSource);
        this.mInternalMediaPlayer.setDataSource(this.mMediaDataSource);
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    private void releaseMediaDataSource() {
        if (this.mMediaDataSource != null) {
            try {
                this.mMediaDataSource.close();
            } catch (IOException var2) {
                var2.printStackTrace();
            }

            this.mMediaDataSource = null;
        }

    }

    public void prepareAsync() throws IllegalStateException {
        this.mInternalMediaPlayer.prepareAsync();
    }

    public void start() throws IllegalStateException {
        this.mInternalMediaPlayer.start();
    }

    public void stop() throws IllegalStateException {
        this.mInternalMediaPlayer.stop();
    }

    public void pause() throws IllegalStateException {
        this.mInternalMediaPlayer.pause();
    }

    public void setScreenOnWhilePlaying(boolean screenOn) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(screenOn);
    }

    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    public int getVideoSarNum() {
        return 1;
    }

    public int getVideoSarDen() {
        return 1;
    }

    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException var2) {
            LogMgr.e(TAG, var2.getMessage());
            return false;
        }
    }

    public void seekTo(long msec) throws IllegalStateException {
        this.mInternalMediaPlayer.seekTo((int) msec);
    }

    public long getCurrentPosition() {
        try {
            return (long) this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException var2) {
            LogMgr.e(TAG, var2.getMessage());
            return 0L;
        }
    }

    public long getDuration() {
        try {
            return (long) this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException var2) {
            LogMgr.e(TAG, var2.getMessage());
            return 0L;
        }
    }

    @RequiresApi(api = VERSION_CODES.CUPCAKE)
    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        this.releaseMediaDataSource();
        this.resetListeners();
        this.attachInternalListeners();
    }

    @RequiresApi(api = VERSION_CODES.CUPCAKE)
    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException var2) {
            LogMgr.e(TAG, var2.getMessage());
        }

        this.releaseMediaDataSource();
        this.resetListeners();
        this.attachInternalListeners();
    }

    public void setLooping(boolean looping) {
        this.mInternalMediaPlayer.setLooping(looping);
    }

    @RequiresApi(api = VERSION_CODES.CUPCAKE)
    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    public void setVolume(float leftVolume, float rightVolume) {
        this.mInternalMediaPlayer.setVolume(leftVolume, rightVolume);
    }

    @RequiresApi(api = VERSION_CODES.GINGERBREAD)
    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo module = new MediaInfo();
            module.mVideoDecoder = "android";
            module.mVideoDecoderImpl = "HW";
            module.mAudioDecoder = "android";
            module.mAudioDecoderImpl = "HW";
            sMediaInfo = module;
        }

        return sMediaInfo;
    }

    public void setLogEnabled(boolean enable) {
    }

    public boolean isPlayable() {
        return true;
    }

    public void setWakeMode(Context context, int mode) {
        this.mInternalMediaPlayer.setWakeMode(context, mode);
    }

    public void setAudioStreamType(int streamtype) {
        this.mInternalMediaPlayer.setAudioStreamType(streamtype);
    }

    public void setKeepInBackground(boolean keepInBackground) {
    }

    @TargetApi(VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = VERSION_CODES.CUPCAKE)
    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
    }

    @TargetApi(VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = VERSION_CODES.CUPCAKE)
    private class AndroidMediaPlayerListenerHolder implements android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.MediaPlayer.OnVideoSizeChangedListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnTimedTextListener {
        public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer mp) {
            this.mWeakMediaPlayer = new WeakReference(mp);
        }

        public boolean onInfo(MediaPlayer mp, int what, int extra) {
            AndroidMediaPlayer self = (AndroidMediaPlayer) this.mWeakMediaPlayer.get();
            return self != null && AndroidMediaPlayer.this.notifyOnInfo(what, extra);
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            AndroidMediaPlayer self = (AndroidMediaPlayer) this.mWeakMediaPlayer.get();
            return self != null && AndroidMediaPlayer.this.notifyOnError(what, extra);
        }

        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            AndroidMediaPlayer self = (AndroidMediaPlayer) this.mWeakMediaPlayer.get();
            if (self != null) {
                AndroidMediaPlayer.this.notifyOnVideoSizeChanged(width, height, 1, 1);
            }
        }

        public void onSeekComplete(MediaPlayer mp) {
            AndroidMediaPlayer self = (AndroidMediaPlayer) this.mWeakMediaPlayer.get();
            if (self != null) {
                AndroidMediaPlayer.this.notifyOnSeekComplete();
            }
        }

        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            AndroidMediaPlayer self = (AndroidMediaPlayer) this.mWeakMediaPlayer.get();
            if (self != null) {
                AndroidMediaPlayer.this.notifyOnBufferingUpdate(percent);
            }
        }

        public void onCompletion(MediaPlayer mp) {
            AndroidMediaPlayer self = (AndroidMediaPlayer) this.mWeakMediaPlayer.get();
            if (self != null) {
                AndroidMediaPlayer.this.notifyOnCompletion();
            }
        }

        public void onPrepared(MediaPlayer mp) {
            AndroidMediaPlayer self = (AndroidMediaPlayer) this.mWeakMediaPlayer.get();
            if (self != null) {
                AndroidMediaPlayer.this.notifyOnPrepared();
            }
        }

        @RequiresApi(api = VERSION_CODES.JELLY_BEAN)
        public void onTimedText(MediaPlayer mp, TimedText text) {
            AndroidMediaPlayer self = (AndroidMediaPlayer) this.mWeakMediaPlayer.get();
            if (self != null) {
                IjkTimedText ijkText = null;
                if (text != null) {
                    ijkText = new IjkTimedText(text.getBounds(), text.getText());
                }

                AndroidMediaPlayer.this.notifyOnTimedText(ijkText);
            }
        }
    }

    @TargetApi(23)
    private static class MediaDataSourceProxy extends MediaDataSource {
        private final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource mediaDataSource) {
            this.mMediaDataSource = mediaDataSource;
        }

        public int readAt(long position, byte[] buffer, int offset, int size) throws IOException {
            return this.mMediaDataSource.readAt(position, buffer, offset, size);
        }

        public long getSize() throws IOException {
            return this.mMediaDataSource.getSize();
        }

        public void close() throws IOException {
            this.mMediaDataSource.close();
        }
    }
}
