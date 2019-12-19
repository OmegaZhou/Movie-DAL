package com.tongji.zhou.moviedal.Mapper;

import com.tongji.zhou.moviedal.Entity.Corporation;
import com.tongji.zhou.moviedal.QueryEntity.Range;
import com.tongji.zhou.moviedal.QueryEntity.TableInformation;
import com.tongji.zhou.moviedal.SqlBuilder.CorporationSqlBuilder;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface CorporationMapper {
    @SelectProvider(value = CorporationSqlBuilder.class, method = "queryCorporation")
    List<Corporation> queryByCorporation(TableInformation information, Range range);
}
