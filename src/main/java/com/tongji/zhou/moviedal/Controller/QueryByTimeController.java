package com.tongji.zhou.moviedal.Controller;

import com.tongji.zhou.moviedal.Entity.Date;
import com.tongji.zhou.moviedal.QueryEntity.MovieResult;
import com.tongji.zhou.moviedal.Mapper.DateMapper;
import com.tongji.zhou.moviedal.QueryEngine.QueryEngine;
import com.tongji.zhou.moviedal.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/byTime")
@RestController()
public class QueryByTimeController {
    @Autowired
    private Util util;

    @PostMapping("queryByDate/{db_type}")
    public MovieResult queryByTime(@PathVariable String db_type, @RequestBody Date condition){
        List<Date> list=QueryEngine.engines.get(db_type).createMapper(DateMapper.class).queryMovieByDate(condition);
        return util.combineMovies(list);
    }

    @PostMapping("queryBySeason/{db_type}")
    public MovieResult queryBySeason(@PathVariable String db_type, @RequestBody Date condition){
        if(condition.getMonth()==null){
            return null;
        }
        List<Date> list=QueryEngine.engines.get(db_type).createMapper(DateMapper.class).queryMovieBySeason(condition);
        return util.combineMovies(list);
    }

}
