package com.tongji.zhou.moviedal.QueryEntity;

public class UserReviewInfo {
    private String id;
    private String name;
    private String mood;
    private Range range;

    public UserReviewInfo(){
        range=new Range();
        range.setMax_value(6);
        range.setMin_value(0);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Range getRange() {
        return range;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
