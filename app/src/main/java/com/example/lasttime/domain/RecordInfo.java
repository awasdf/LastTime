package com.example.lasttime.domain;

/**
 * Created by ggrcwxh on 2017/11/28.
 */

public class RecordInfo {
    private String record;
    private long lastTime;
    private String imageId;
    public RecordInfo(String record,long lastTime,String imageId){
        this.record=record;
        this.lastTime=lastTime;
        this.imageId=imageId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
    public String toString(){
        return String.format("离上一次: %s , %d天",record,lastTime);
    }
}
