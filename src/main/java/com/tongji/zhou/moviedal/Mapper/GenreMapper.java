package com.tongji.zhou.moviedal.Mapper;

import com.tongji.zhou.moviedal.SqlBuilder.GenreSqlBuilder;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface GenreMapper {
    @Select("select * from genre_names")
    List<String> queryGenreNames();

    @SelectProvider(value = GenreSqlBuilder.class,method = "queryByGenre")
    List<String> queryByGenre(List<String> genres);
}
