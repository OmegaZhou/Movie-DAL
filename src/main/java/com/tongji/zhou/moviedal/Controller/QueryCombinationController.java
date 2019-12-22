package com.tongji.zhou.moviedal.Controller;

import com.tongji.zhou.moviedal.Mapper.CombinationMapper;
import com.tongji.zhou.moviedal.QueryEngine.QueryEngine;
import com.tongji.zhou.moviedal.QueryEntity.UserWithGenre;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/byCombination")
@RestController()
public class QueryCombinationController {
    @PostMapping("/queryWithGenreAndActor/{db_type}")
    List<String> queryWithGenreAndActor(@PathVariable String db_type, @RequestBody UserWithGenre user){
        return QueryEngine.engines.get(db_type).createMapper(CombinationMapper.class)
                .queryWithActorAndGenre(user.getGenre(),user.getName());
    }
}
