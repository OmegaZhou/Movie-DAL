package com.tongji.zhou.moviedal.QueryEntity;

public class Condition {
    private String col;
    private String val;

    public String getCol() {
        return col;
    }

    public String getVal() {
        return val;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public void setVal(String val) {
        this.val = val;
    }
    public Condition(String col,String val){
        this.col=col;
        this.val=val;
    }
}
