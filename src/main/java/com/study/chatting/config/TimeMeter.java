package com.study.chatting.config;

public class TimeMeter {
    private long startTime;
    private long endTime;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getDiff() {
        return (endTime - startTime)/1000;
    }
}
