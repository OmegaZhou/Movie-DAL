package com.tongji.zhou.moviedal.SqlBuilder;

import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class GenreSqlBuilder {
    public static String queryByGenre(Map<String, List<String>> map){
        return new SQL(){{
            List<String> genres=map.get("list");
            SELECT("name");
            FROM("movie,genre");
            WHERE("movie.genre_id=genre.genre_id");
            for(String genre:genres){
                WHERE(genre+"='Y'");
            }
        }}.toString();
    }
}
