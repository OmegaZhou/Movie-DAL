package com.tongji.zhou.moviedal.Controller;

import com.tongji.zhou.moviedal.Mapper.ReviewMapper;
import com.tongji.zhou.moviedal.QueryEngine.QueryEngine;
import com.tongji.zhou.moviedal.QueryEntity.Condition;
import com.tongji.zhou.moviedal.QueryEntity.UserReviewInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/byReview")
@RestController()
public class QueryReviewController {
    @PostMapping("/queryByMoodWithName/{db_type}")
    List<String> queryByMoodWithName(@PathVariable String db_type, @RequestBody UserReviewInfo info){
        return QueryEngine.engines.get(db_type).createMapper(ReviewMapper.class)
                .queryMovieByMood(new Condition("profileName",info.getName()),info.getMood());
    }

    @PostMapping("/queryByMoodWithId/{db_type}")
    List<String> queryByMoodWithId(@PathVariable String db_type, @RequestBody UserReviewInfo info){
        return QueryEngine.engines.get(db_type).createMapper(ReviewMapper.class)
                .queryMovieByMood(new Condition("userId",info.getId()),info.getMood());
    }

    @PostMapping("/queryByScoreWithName/{db_type}")
    List<String> queryByScoreWithName(@PathVariable String db_type, @RequestBody UserReviewInfo info){
        return QueryEngine.engines.get(db_type).createMapper(ReviewMapper.class)
                .queryMovieByScore(new Condition("profileName",info.getName()),info.getRange());
    }
    @PostMapping("/queryByScoreWithId/{db_type}")
    List<String> queryByScoreWithId(@PathVariable String db_type, @RequestBody UserReviewInfo info){
        return QueryEngine.engines.get(db_type).createMapper(ReviewMapper.class)
                .queryMovieByScore(new Condition("userId",info.getId()),info.getRange());
    }
}
