package com.tongji.zhou.moviedal.QueryEntity;

public class Range {
    private Integer start_from;
    private Integer limitation;
    private Integer min_value;
    private Integer max_value;

    public Integer getLimitation() {
        return limitation;
    }

    public Integer getMax_value() {
        return max_value;
    }

    public Integer getMin_value() {
        return min_value;
    }

    public Integer getStart_from() {
        return start_from;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public void setMax_value(Integer max_value) {
        this.max_value = max_value;
    }

    public void setMin_value(Integer min_value) {
        this.min_value = min_value;
    }

    public void setStart_from(Integer start_from) {
        this.start_from = start_from;
    }
}
