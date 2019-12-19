package com.tongji.zhou.moviedal.SqlBuilder;
import com.tongji.zhou.moviedal.QueryEntity.Range;
import com.tongji.zhou.moviedal.QueryEntity.TableInformation;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;


public class CorporationSqlBuilder {
    public static String queryCorporation(Map<Object,Object> map){
        TableInformation table_info = (TableInformation) map.get("information");
        Range range = (Range) map.get("range");
        return new SQL(){{
            for(String field:table_info.getFields()){
                SELECT(field);
            }
            FROM(table_info.getTable_name());
            if(range.getMin_value()!=null){
                WHERE("count>="+range.getMin_value().toString());
            }
            if(range.getMax_value()!=null){
                WHERE("count<="+range.getMax_value().toString());
            }
            ORDER_BY("count DESC");
            if(range.getStart_from()!=null){
                OFFSET(range.getStart_from());
            }
            if(range.getLimitation()!=null){
                LIMIT(range.getLimitation());
            }
        }}.toString();
    }
}
