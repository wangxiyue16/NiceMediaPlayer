package com.ijkplayerlib.Interface;

import java.io.IOException;

/**
 * description:
 * author: WDSG
 * date 2018/8/14
 */
public interface IMediaDataSource {
    int readAt(long var1, byte[] var3, int var4, int var5) throws IOException;

    long getSize() throws IOException;

    void close() throws IOException;
}
