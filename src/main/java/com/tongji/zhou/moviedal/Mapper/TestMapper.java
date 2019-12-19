package com.tongji.zhou.moviedal.Mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface TestMapper {
    @Select("select count(*) from actor_corpoation")
    Integer GetRelationCount();
}
