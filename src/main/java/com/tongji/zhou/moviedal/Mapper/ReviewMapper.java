package com.tongji.zhou.moviedal.Mapper;

import com.tongji.zhou.moviedal.QueryEntity.Range;
import com.tongji.zhou.moviedal.QueryEntity.Condition;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReviewMapper {
    @Select("select distinct movie.name from movie,products_group,product " +
            "where product.asin in " +
            "(select distinct asin as review_asin from review where ${condition.col}=#{condition.val} and mood=#{mood}) " +
            "and movie.products_group_id=products_group.product_group_id " +
            "and products_group.product_id=product.product_id")
    List<String> queryMovieByMood(@Param("condition") Condition condition,@Param("mood") String mood);

    @Select("select distinct movie.name from movie,products_group,product " +
            "where product.asin in " +
            "(select distinct asin as review_asin from review where ${condition.col}=#{condition.val} " +
            "and score>=#{range.min_value} and score<=#{range.max_value}) " +
            "and movie.products_group_id=products_group.product_group_id " +
            "and products_group.product_id=product.product_id")
    List<String> queryMovieByScore(@Param("condition") Condition condition,@Param("range") Range range);
}
