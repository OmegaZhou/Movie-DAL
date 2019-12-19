package com.tongji.zhou.moviedal.Mapper;

import com.tongji.zhou.moviedal.QueryEntity.PersonResult;
import com.tongji.zhou.moviedal.Entity.PersonType;
import com.tongji.zhou.moviedal.Entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MovieMapper {
    @Select("select `price`,`asin`,`format` from product " +
            "join products_group on products_group.product_id=product.product_id " +
            "join movie on movie.products_group_id=products_group.product_group_id" +
            " where movie.name=#{name}")
    List<Product> queryProducts(@Param("name") String name);

    @Select("select names, count from  movie,${type.group}s_group " +
            "where movie.name=#{name} " +
            "and movie.${type.group}s_group_id=${type.group}s_group.${type.group}s_group_id limit 1")
    PersonResult queryPersons(@Param("type")PersonType type, @Param("name") String name);
}
