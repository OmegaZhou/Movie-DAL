package com.tongji.zhou.moviedal.Controller;

import com.tongji.zhou.moviedal.Entity.*;
import com.tongji.zhou.moviedal.Mapper.MovieMapper;
import com.tongji.zhou.moviedal.QueryEngine.QueryEngine;
import com.tongji.zhou.moviedal.QueryEntity.PersonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/byMovieName")
@RestController()
public class QueryMovieController {
    @PostMapping("/queryProducts/{db_type}")
    List<Product> queryProducts(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        var i= QueryEngine.engines.get(db_type).createMapper(MovieMapper.class).queryProducts(movieFact.getName());
        return i;
    }

    @PostMapping("/queryActors/{db_type}")
    PersonResult queryActors(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryPersons(PersonType.ACTOR,movieFact.getName());
    }

    @PostMapping("/querySupportings/{db_type}")
    PersonResult querySupportings(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryPersons(PersonType.SUPPORTING,movieFact.getName());
    }

    @PostMapping("/queryStarrings/{db_type}")
    PersonResult queryStarrings(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryPersons(PersonType.STARRING,movieFact.getName());
    }

    @PostMapping("/queryDirectors/{db_type}")
    PersonResult queryDirectors(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryPersons(PersonType.DIRECTOR,movieFact.getName());
    }

}
