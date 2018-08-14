package com.ijkplayerlib.unknown;

import android.os.Bundle;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/**
 * description:
 * author: WDSG
 * date 2018/8/14
 */
public class IjkMediaMeta {
    public static final String IJKM_KEY_FORMAT = "format";
    public static final String IJKM_KEY_DURATION_US = "duration_us";
    public static final String IJKM_KEY_START_US = "start_us";
    public static final String IJKM_KEY_BITRATE = "bitrate";
    public static final String IJKM_KEY_VIDEO_STREAM = "video";
    public static final String IJKM_KEY_AUDIO_STREAM = "audio";
    public static final String IJKM_KEY_TIMEDTEXT_STREAM = "timedtext";
    public static final String IJKM_KEY_TYPE = "type";
    public static final String IJKM_VAL_TYPE__VIDEO = "video";
    public static final String IJKM_VAL_TYPE__AUDIO = "audio";
    public static final String IJKM_VAL_TYPE__TIMEDTEXT = "timedtext";
    public static final String IJKM_VAL_TYPE__UNKNOWN = "unknown";
    public static final String IJKM_KEY_LANGUAGE = "language";
    public static final String IJKM_KEY_CODEC_NAME = "codec_name";
    public static final String IJKM_KEY_CODEC_PROFILE = "codec_profile";
    public static final String IJKM_KEY_CODEC_LEVEL = "codec_level";
    public static final String IJKM_KEY_CODEC_LONG_NAME = "codec_long_name";
    public static final String IJKM_KEY_CODEC_PIXEL_FORMAT = "codec_pixel_format";
    public static final String IJKM_KEY_CODEC_PROFILE_ID = "codec_profile_id";
    public static final String IJKM_KEY_WIDTH = "width";
    public static final String IJKM_KEY_HEIGHT = "height";
    public static final String IJKM_KEY_FPS_NUM = "fps_num";
    public static final String IJKM_KEY_FPS_DEN = "fps_den";
    public static final String IJKM_KEY_TBR_NUM = "tbr_num";
    public static final String IJKM_KEY_TBR_DEN = "tbr_den";
    public static final String IJKM_KEY_SAR_NUM = "sar_num";
    public static final String IJKM_KEY_SAR_DEN = "sar_den";
    public static final String IJKM_KEY_SAMPLE_RATE = "sample_rate";
    public static final String IJKM_KEY_CHANNEL_LAYOUT = "channel_layout";
    public static final String IJKM_KEY_STREAMS = "streams";
    public static final long AV_CH_FRONT_LEFT = 1L;
    public static final long AV_CH_FRONT_RIGHT = 2L;
    public static final long AV_CH_FRONT_CENTER = 4L;
    public static final long AV_CH_LOW_FREQUENCY = 8L;
    public static final long AV_CH_BACK_LEFT = 16L;
    public static final long AV_CH_BACK_RIGHT = 32L;
    public static final long AV_CH_FRONT_LEFT_OF_CENTER = 64L;
    public static final long AV_CH_FRONT_RIGHT_OF_CENTER = 128L;
    public static final long AV_CH_BACK_CENTER = 256L;
    public static final long AV_CH_SIDE_LEFT = 512L;
    public static final long AV_CH_SIDE_RIGHT = 1024L;
    public static final long AV_CH_TOP_CENTER = 2048L;
    public static final long AV_CH_TOP_FRONT_LEFT = 4096L;
    public static final long AV_CH_TOP_FRONT_CENTER = 8192L;
    public static final long AV_CH_TOP_FRONT_RIGHT = 16384L;
    public static final long AV_CH_TOP_BACK_LEFT = 32768L;
    public static final long AV_CH_TOP_BACK_CENTER = 65536L;
    public static final long AV_CH_TOP_BACK_RIGHT = 131072L;
    public static final long AV_CH_STEREO_LEFT = 536870912L;
    public static final long AV_CH_STEREO_RIGHT = 1073741824L;
    public static final long AV_CH_WIDE_LEFT = 2147483648L;
    public static final long AV_CH_WIDE_RIGHT = 4294967296L;
    public static final long AV_CH_SURROUND_DIRECT_LEFT = 8589934592L;
    public static final long AV_CH_SURROUND_DIRECT_RIGHT = 17179869184L;
    public static final long AV_CH_LOW_FREQUENCY_2 = 34359738368L;
    public static final long AV_CH_LAYOUT_MONO = 4L;
    public static final long AV_CH_LAYOUT_STEREO = 3L;
    public static final long AV_CH_LAYOUT_2POINT1 = 11L;
    public static final long AV_CH_LAYOUT_2_1 = 259L;
    public static final long AV_CH_LAYOUT_SURROUND = 7L;
    public static final long AV_CH_LAYOUT_3POINT1 = 15L;
    public static final long AV_CH_LAYOUT_4POINT0 = 263L;
    public static final long AV_CH_LAYOUT_4POINT1 = 271L;
    public static final long AV_CH_LAYOUT_2_2 = 1539L;
    public static final long AV_CH_LAYOUT_QUAD = 51L;
    public static final long AV_CH_LAYOUT_5POINT0 = 1543L;
    public static final long AV_CH_LAYOUT_5POINT1 = 1551L;
    public static final long AV_CH_LAYOUT_5POINT0_BACK = 55L;
    public static final long AV_CH_LAYOUT_5POINT1_BACK = 63L;
    public static final long AV_CH_LAYOUT_6POINT0 = 1799L;
    public static final long AV_CH_LAYOUT_6POINT0_FRONT = 1731L;
    public static final long AV_CH_LAYOUT_HEXAGONAL = 311L;
    public static final long AV_CH_LAYOUT_6POINT1 = 1807L;
    public static final long AV_CH_LAYOUT_6POINT1_BACK = 319L;
    public static final long AV_CH_LAYOUT_6POINT1_FRONT = 1739L;
    public static final long AV_CH_LAYOUT_7POINT0 = 1591L;
    public static final long AV_CH_LAYOUT_7POINT0_FRONT = 1735L;
    public static final long AV_CH_LAYOUT_7POINT1 = 1599L;
    public static final long AV_CH_LAYOUT_7POINT1_WIDE = 1743L;
    public static final long AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255L;
    public static final long AV_CH_LAYOUT_OCTAGONAL = 1847L;
    public static final long AV_CH_LAYOUT_STEREO_DOWNMIX = 1610612736L;
    public static final int FF_PROFILE_H264_CONSTRAINED = 512;
    public static final int FF_PROFILE_H264_INTRA = 2048;
    public static final int FF_PROFILE_H264_BASELINE = 66;
    public static final int FF_PROFILE_H264_CONSTRAINED_BASELINE = 578;
    public static final int FF_PROFILE_H264_MAIN = 77;
    public static final int FF_PROFILE_H264_EXTENDED = 88;
    public static final int FF_PROFILE_H264_HIGH = 100;
    public static final int FF_PROFILE_H264_HIGH_10 = 110;
    public static final int FF_PROFILE_H264_HIGH_10_INTRA = 2158;
    public static final int FF_PROFILE_H264_HIGH_422 = 122;
    public static final int FF_PROFILE_H264_HIGH_422_INTRA = 2170;
    public static final int FF_PROFILE_H264_HIGH_444 = 144;
    public static final int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
    public static final int FF_PROFILE_H264_HIGH_444_INTRA = 2292;
    public static final int FF_PROFILE_H264_CAVLC_444 = 44;
    public Bundle mMediaMeta;
    public String mFormat;
    public long mDurationUS;
    public long mStartUS;
    public long mBitrate;
    public final ArrayList<IjkStreamMeta> mStreams = new ArrayList();
    public IjkMediaMeta.IjkStreamMeta mVideoStream;
    public IjkMediaMeta.IjkStreamMeta mAudioStream;

    public IjkMediaMeta() {
    }

    public String getString(String key) {
        return this.mMediaMeta.getString(key);
    }

    public int getInt(String key) {
        return this.getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        String value = this.getString(key);
        if (TextUtils.isEmpty(value)) {
            return defaultValue;
        } else {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException var5) {
                return defaultValue;
            }
        }
    }

    public long getLong(String key) {
        return this.getLong(key, 0L);
    }

    public long getLong(String key, long defaultValue) {
        String value = this.getString(key);
        if (TextUtils.isEmpty(value)) {
            return defaultValue;
        } else {
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException var6) {
                return defaultValue;
            }
        }
    }

    public ArrayList<Bundle> getParcelableArrayList(String key) {
        return this.mMediaMeta.getParcelableArrayList(key);
    }

    public String getDurationInline() {
        long duration = this.mDurationUS + 5000L;
        long secs = duration / 1000000L;
        long mins = secs / 60L;
        secs %= 60L;
        long hours = mins / 60L;
        mins %= 60L;
        return String.format(Locale.US, "%02d:%02d:%02d", hours, mins, secs);
    }

    public static IjkMediaMeta parse(Bundle mediaMeta) {
        if (mediaMeta == null) {
            return null;
        } else {
            IjkMediaMeta meta = new IjkMediaMeta();
            meta.mMediaMeta = mediaMeta;
            meta.mFormat = meta.getString("format");
            meta.mDurationUS = meta.getLong("duration_us");
            meta.mStartUS = meta.getLong("start_us");
            meta.mBitrate = meta.getLong("bitrate");
            int videoStreamIndex = meta.getInt("video", -1);
            int audioStreamIndex = meta.getInt("audio", -1);
            int subtitleStreamIndex = meta.getInt("timedtext", -1);
            ArrayList<Bundle> streams = meta.getParcelableArrayList("streams");
            if (streams == null) {
                return meta;
            } else {
                int index = -1;
                Iterator var7 = streams.iterator();

                while(var7.hasNext()) {
                    Bundle streamBundle = (Bundle)var7.next();
                    ++index;
                    if (streamBundle != null) {
                        IjkMediaMeta.IjkStreamMeta streamMeta = new IjkMediaMeta.IjkStreamMeta(index);
                        streamMeta.mMeta = streamBundle;
                        streamMeta.mType = streamMeta.getString("type");
                        streamMeta.mLanguage = streamMeta.getString("language");
                        if (!TextUtils.isEmpty(streamMeta.mType)) {
                            streamMeta.mCodecName = streamMeta.getString("codec_name");
                            streamMeta.mCodecProfile = streamMeta.getString("codec_profile");
                            streamMeta.mCodecLongName = streamMeta.getString("codec_long_name");
                            streamMeta.mBitrate = (long)streamMeta.getInt("bitrate");
                            if (streamMeta.mType.equalsIgnoreCase("video")) {
                                streamMeta.mWidth = streamMeta.getInt("width");
                                streamMeta.mHeight = streamMeta.getInt("height");
                                streamMeta.mFpsNum = streamMeta.getInt("fps_num");
                                streamMeta.mFpsDen = streamMeta.getInt("fps_den");
                                streamMeta.mTbrNum = streamMeta.getInt("tbr_num");
                                streamMeta.mTbrDen = streamMeta.getInt("tbr_den");
                                streamMeta.mSarNum = streamMeta.getInt("sar_num");
                                streamMeta.mSarDen = streamMeta.getInt("sar_den");
                                if (videoStreamIndex == index) {
                                    meta.mVideoStream = streamMeta;
                                }
                            } else if (streamMeta.mType.equalsIgnoreCase("audio")) {
                                streamMeta.mSampleRate = streamMeta.getInt("sample_rate");
                                streamMeta.mChannelLayout = streamMeta.getLong("channel_layout");
                                if (audioStreamIndex == index) {
                                    meta.mAudioStream = streamMeta;
                                }
                            }

                            meta.mStreams.add(streamMeta);
                        }
                    }
                }

                return meta;
            }
        }
    }

    public static class IjkStreamMeta {
        public Bundle mMeta;
        public final int mIndex;
        public String mType;
        public String mLanguage;
        public String mCodecName;
        public String mCodecProfile;
        public String mCodecLongName;
        public long mBitrate;
        public int mWidth;
        public int mHeight;
        public int mFpsNum;
        public int mFpsDen;
        public int mTbrNum;
        public int mTbrDen;
        public int mSarNum;
        public int mSarDen;
        public int mSampleRate;
        public long mChannelLayout;

        public IjkStreamMeta(int index) {
            this.mIndex = index;
        }

        public String getString(String key) {
            return this.mMeta.getString(key);
        }

        public int getInt(String key) {
            return this.getInt(key, 0);
        }

        public int getInt(String key, int defaultValue) {
            String value = this.getString(key);
            if (TextUtils.isEmpty(value)) {
                return defaultValue;
            } else {
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException var5) {
                    return defaultValue;
                }
            }
        }

        public long getLong(String key) {
            return this.getLong(key, 0L);
        }

        public long getLong(String key, long defaultValue) {
            String value = this.getString(key);
            if (TextUtils.isEmpty(value)) {
                return defaultValue;
            } else {
                try {
                    return Long.parseLong(value);
                } catch (NumberFormatException var6) {
                    return defaultValue;
                }
            }
        }

        public String getCodecLongNameInline() {
            if (!TextUtils.isEmpty(this.mCodecLongName)) {
                return this.mCodecLongName;
            } else {
                return !TextUtils.isEmpty(this.mCodecName) ? this.mCodecName : "N/A";
            }
        }

        public String getCodecShortNameInline() {
            return !TextUtils.isEmpty(this.mCodecName) ? this.mCodecName : "N/A";
        }

        public String getResolutionInline() {
            if (this.mWidth > 0 && this.mHeight > 0) {
                return this.mSarNum > 0 && this.mSarDen > 0 ? String.format(Locale.US, "%d x %d [SAR %d:%d]", this.mWidth, this.mHeight, this.mSarNum, this.mSarDen) : String.format(Locale.US, "%d x %d", this.mWidth, this.mHeight);
            } else {
                return "N/A";
            }
        }

        public String getFpsInline() {
            return this.mFpsNum > 0 && this.mFpsDen > 0 ? String.valueOf((float)this.mFpsNum / (float)this.mFpsDen) : "N/A";
        }

        public String getBitrateInline() {
            if (this.mBitrate <= 0L) {
                return "N/A";
            } else {
                return this.mBitrate < 1000L ? String.format(Locale.US, "%d bit/s", this.mBitrate) : String.format(Locale.US, "%d kb/s", this.mBitrate / 1000L);
            }
        }

        public String getSampleRateInline() {
            return this.mSampleRate <= 0 ? "N/A" : String.format(Locale.US, "%d Hz", this.mSampleRate);
        }

        public String getChannelLayoutInline() {
            if (this.mChannelLayout <= 0L) {
                return "N/A";
            } else if (this.mChannelLayout == 4L) {
                return "mono";
            } else {
                return this.mChannelLayout == 3L ? "stereo" : String.format(Locale.US, "%x", this.mChannelLayout);
            }
        }
    }
}
