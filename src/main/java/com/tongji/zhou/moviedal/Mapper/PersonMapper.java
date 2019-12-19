package com.tongji.zhou.moviedal.Mapper;

import com.tongji.zhou.moviedal.QueryEntity.MovieResult;
import com.tongji.zhou.moviedal.Entity.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {
    @Select("select ${group}_movies as movies, ${group}_count as count from ${role} where name=#{name}")
    MovieResult queryByPerson(Person person);

    @Select("select movie.name from ${role}, ${group}s_group, movie where ${role}.name=#{name} and " +
            "${role}.${role}_id=${group}s_group.${group}_id " +
            "and movie.${group}s_group_id=${group}s_group.${group}s_group_id")
    List<String> queryByPersonWithJoin(Person person);
}
