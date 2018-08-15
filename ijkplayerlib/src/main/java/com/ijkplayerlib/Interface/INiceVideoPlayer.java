package com.ijkplayerlib.Interface;

import java.util.Map;

/**
 * description: 播放器方法
 * author: WDSG
 * date 2018/8/14
 */
public interface INiceVideoPlayer {

    /**
     * 设置视频Url，以及headers
     *
     * @param url     视频地址，可以是本地，也可以是网络视频
     * @param headers 请求header.
     */
    void setUp(String url, Map<String, String> headers);

    /**
     * 开始播放
     */
    void start();

    /**
     * 从指定的位置开始播放
     *
     * @param position 当前播放的位置，毫秒
     */
    void start(long position);

    /**
     * 重新播放，播放器被暂停、播放错误、播放完成后，需要调用此方法重新播放
     */
    void restart();

    /**
     * 暂停播放
     */
    void pause();

    /**
     * seek到制定的位置继续播放
     *
     * @param pos 播放位置
     */
    void seekTo(long pos);

    /**
     * 设置音量
     *
     * @param volume 音量值
     */
    void setVolume(int volume);

    /**
     * 开始播放时，是否从上一次的位置继续播放
     *
     * @param continueFromLastPosition true 接着上次的位置继续播放，false从头开始播放
     */
    void continueFromLastPosition(boolean continueFromLastPosition);

    //*************** 以下9个方法是播放器在当前的播放状态 ******************//

    /**
     * 播放未开始
     *
     * @return
     */
    boolean isIdle();

    /**
     * 播放准备中
     *
     * @return
     */
    boolean isPreparing();

    /**
     * 播放准备就绪
     *
     * @return
     */
    boolean isPrepared();

    /**
     * 正在缓冲(播放器正在播放时，缓冲区数据不足，进行缓冲，缓冲区数据足够后恢复播放)
     *
     * @return
     */
    boolean isBufferingPlaying();

    /**
     * 正在缓冲(播放器正在播放时，缓冲区数据不足，进行缓冲，此时暂停播放器，继续缓冲，缓冲区数据足够后恢复暂停
     *
     * @return
     */
    boolean isBufferingPaused();

    /**
     * 正在播放
     *
     * @return
     */
    boolean isPlaying();

    /**
     * 暂停播放
     *
     * @return
     */
    boolean isPaused();

    /**
     * 播放错误
     *
     * @return
     */
    boolean isError();

    /**
     * 播放完成
     *
     * @return
     */
    boolean isCompleted();

    //*********************************//

    //*************** 以下7个方法是播放器模式相关 ******************//

    /**
     * 获取当前是否是全屏模式
     *
     * @return
     */
    boolean isFullScreen();

    /**
     * 获取当前是否是小窗口模式
     *
     * @return
     */
    boolean isTinyWindow();

    /**
     * 获取当前是否是默认模式
     *
     * @return
     */
    boolean isNormal();

    /**
     * 打开全屏模式（要先给NiceVideoPlayer设置NiceVideoPlayerController才能在外部调用此方法）
     */
    void enterFullScreen();

    /**
     * 退出全屏模式（要先给NiceVideoPlayer设置NiceVideoPlayerController才能在外部调用此方法）
     *
     * @return true 退出
     */
    boolean exitFullScreen();

    /**
     * 打开小窗口模式（要先给NiceVideoPlayer设置NiceVideoPlayerController才能在外部调用此方法）
     */
    void enterTinyWindow();

    /**
     * 退出小窗口模式（要先给NiceVideoPlayer设置NiceVideoPlayerController才能在外部调用此方法）
     *
     * @return true 退出小窗口
     */
    boolean exitTinyWindow();

    /**
     * 设置播放器执行release()方法时是否退出全屏以及小窗口模式
     */
    void setIsCanExitFullScreenAndTinyWindow(boolean isCanExitFullScreenAndTinyWindow);

    /**
     * 获取播放器执行release()方法时是否退出全屏以及小窗口模式
     *
     * @return true 播放器执行release()方法时退出全屏以及小窗口模式
     */
    boolean isCanExitFullScreenAndTinyWindow();

    //*********************************//

    /**
     * 获取最大音量
     *
     * @return 最大音量值
     */
    int getMaxVolume();

    /**
     * 获取当前音量
     *
     * @return 当前音量值
     */
    int getVolume();

    /**
     * 获取办法给总时长，毫秒
     *
     * @return 视频总时长ms
     */
    long getDuration();

    /**
     * 获取当前播放的位置，毫秒
     *
     * @return 当前播放位置，ms
     */
    long getCurrentPosition();

    /**
     * 获取视频缓冲百分比
     *
     * @return 缓冲白百分比
     */
    int getBufferPercentage();

    /**
     * 此处只释放播放器（如果要释放播放器并恢复控制器状态需要调用{@link #release()}方法）
     * 不管是全屏、小窗口还是Normal状态下控制器的UI都不恢复初始状态
     * 这样以便在当前播放器状态下可以方便的切换不同的清晰度的视频地址
     */
    void releasePlayer();

    /**
     * 释放INiceVideoPlayer，释放后，内部的播放器被释放掉，同时如果在全屏、小窗口模式下都会退出
     * 并且控制器的UI也应该恢复到最初始的状态.
     */
    void release();

    /**
     * 设置是否可以手势调节音量大小以及亮度，ture表示可以调节
     */
    void setOnTouch(boolean isOnTouch);

    /**
     * 是否可以手势调节音量大小以及亮度，ture标识可以调节
     */
    boolean isOnTouch();
}
