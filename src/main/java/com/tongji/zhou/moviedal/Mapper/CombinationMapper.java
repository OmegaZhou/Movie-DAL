package com.tongji.zhou.moviedal.Mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CombinationMapper {
    @Select("select movie.name from genre join movie on genre.genre_id=movie.genre_id join " +
            "actors_group on movie.actors_group_id=actors_group.actors_group_id join " +
            "actor on actors_group.actor_id=actor.actor_id " +
            "where ${genre}='Y' and actor.name=#{name}")
    List<String> queryWithActorAndGenre(@Param("genre") String genre,@Param("name") String name);
}
