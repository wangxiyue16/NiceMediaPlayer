package com.ijkplayerlib.bean;

import android.graphics.Rect;

/**
 * description:
 * author: WDSG
 * date 2018/8/14
 */
public class IjkTimedText {
    private Rect mTextBounds = null;
    private String mTextChars = null;

    public IjkTimedText(Rect bounds, String text) {
        this.mTextBounds = bounds;
        this.mTextChars = text;
    }

    public Rect getBounds() {
        return this.mTextBounds;
    }

    public String getText() {
        return this.mTextChars;
    }
}
