package com.tongji.zhou.moviedal.Mapper;

import com.tongji.zhou.moviedal.Entity.Date;
import com.tongji.zhou.moviedal.SqlBuilder.DateSqlBuilder;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface DateMapper {
    @SelectProvider(value = DateSqlBuilder.class,method = "queryMovieByDate")
    List<Date> queryMovieByDate(Date date);
    @SelectProvider(value = DateSqlBuilder.class,method = "queryMovieBySeason")
    List<Date> queryMovieBySeason(Date date);
}
