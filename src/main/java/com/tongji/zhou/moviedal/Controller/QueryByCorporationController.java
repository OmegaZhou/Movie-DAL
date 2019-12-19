package com.tongji.zhou.moviedal.Controller;

import com.cloudera.impala.jdbc42.internal.com.cloudera.altus.shaded.com.google.common.collect.Lists;
import com.tongji.zhou.moviedal.Entity.Corporation;
import com.tongji.zhou.moviedal.Entity.PersonType;
import com.tongji.zhou.moviedal.QueryEntity.Range;
import com.tongji.zhou.moviedal.QueryEntity.TableInformation;
import com.tongji.zhou.moviedal.Mapper.CorporationMapper;
import com.tongji.zhou.moviedal.QueryEngine.QueryEngine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/byCorporation")
@RestController()
public class QueryByCorporationController {
    private List<Corporation> setRole(List<Corporation> corporations, PersonType type1,PersonType type2){
        for(Corporation corporation:corporations){
            corporation.getP1().setType(type1);
            corporation.getP2().setType(type2);
        }
        return corporations;
    }

    @PostMapping("/byActors/{db_type}")
    public List<Corporation> queryBetweenActor(@PathVariable String db_type, @RequestBody Range range){
        TableInformation tableInformation=new TableInformation();
        tableInformation.setTable_name("actor_corporation");
        tableInformation.setFields(
                Lists.newArrayList("actor_name1 as name1","actor_name2 as name2","count","movies"));
        return setRole(QueryEngine.engines.get(db_type).createMapper(CorporationMapper.class)
                .queryByCorporation(tableInformation,range),PersonType.ACTOR,PersonType.ACTOR);
    }

    @PostMapping("/byActorAndDirector/{db_type}")
    public List<Corporation> byActorAndDirector(@PathVariable String db_type, @RequestBody Range range){
        TableInformation tableInformation=new TableInformation();
        tableInformation.setTable_name("director_actor_corporation");
        tableInformation.setFields(
                Lists.newArrayList("actor_name as name1","director_name as name2","count","movies"));
        return setRole(QueryEngine.engines.get(db_type).createMapper(CorporationMapper.class)
                .queryByCorporation(tableInformation,range),PersonType.ACTOR,PersonType.DIRECTOR);
    }
}
