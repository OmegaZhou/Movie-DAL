package com.tongji.zhou.moviedal.QueryEntity;

import java.util.List;

public class TableInformation {
    private String table_name;
    private List<String> fields;

    public List<String> getFields() {
        return fields;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }
}
