package com.tongji.zhou.moviedal.SqlBuilder;

import com.tongji.zhou.moviedal.Entity.Date;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class DateSqlBuilder {
    public static String queryMovieByDate(Date date_condition){
        return new SQL(){{
            SELECT("count,movies");
            FROM("date");
            if(date_condition.getYear()!=null){
                WHERE("year=#{year}");
            }
            if(date_condition.getMonth()!=null){
                WHERE("month=#{month}");
            }
            if(date_condition.getDay()!=null){
                WHERE("day=#{day}");
            }
            if(date_condition.getWeekday()!=null){
                WHERE("weekday=#{weekday}");
            }
        }}.toString();
    }

    public static String queryMovieBySeason(Date season_condition){
        return new SQL(){
            {
                SELECT("count,movies");
                FROM("date");
                if(season_condition.getYear()!=null){
                    WHERE("year=#{year}");
                }
                if(season_condition.getMonth()!=null){
                    Integer month=(season_condition.getMonth()-1)/3*3;
                    WHERE("month>"+month.toString());
                    month+=4;
                    WHERE("month<"+month.toString());
                }
            }
        }.toString();
    }
}
