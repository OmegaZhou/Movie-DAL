package com.tongji.zhou.moviedal.Controller;

import com.tongji.zhou.moviedal.QueryEntity.MovieResult;
import com.tongji.zhou.moviedal.Entity.Person;
import com.tongji.zhou.moviedal.Entity.PersonType;
import com.tongji.zhou.moviedal.Mapper.PersonMapper;
import com.tongji.zhou.moviedal.QueryEngine.QueryEngine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/byPerson")
@RestController()
public class QueryByPersonController {

    private MovieResult queryPerson(String db_type,Person person){
        return QueryEngine.engines.get(db_type).createMapper(PersonMapper.class).queryByPerson(person);
    }

    @PostMapping("/queryByActor/{db_type}")
    public MovieResult queryByActor(@PathVariable String db_type,@RequestBody Person person){
        person.setType(PersonType.ACTOR);
        return queryPerson(db_type,person);
    }

    @PostMapping("/queryByActorWithJoin/{db_type}")
    public List<String> queryByActorWithJoin(@PathVariable String db_type, @RequestBody Person person){
        person.setType(PersonType.ACTOR);
        return QueryEngine.engines.get(db_type).createMapper(PersonMapper.class).queryByPersonWithJoin(person);
    }

    @PostMapping("/queryBySupporting/{db_type}")
    public MovieResult queryBySupporting(@PathVariable String db_type,@RequestBody Person person){
        person.setType(PersonType.SUPPORTING);
        return queryPerson(db_type,person);
    }

    @PostMapping("/queryByStarring/{db_type}")
    MovieResult queryByStarring(@PathVariable String db_type,@RequestBody Person person){
        person.setType(PersonType.STARRING);
        return queryPerson(db_type,person);
    }

    @PostMapping("/queryByDirector/{db_type}")
    MovieResult queryByDirector(@PathVariable String db_type,@RequestBody Person person){
        person.setType(PersonType.DIRECTOR);
        return queryPerson(db_type,person);
    }
}
