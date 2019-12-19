package com.tongji.zhou.moviedal.Controller;

import com.tongji.zhou.moviedal.Mapper.GenreMapper;
import com.tongji.zhou.moviedal.QueryEngine.QueryEngine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/byGenre")
@RestController()
public class QueryGenreController {
    @PostMapping("/getGenres/{db_type}")
    List<String> getGenres(@PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(GenreMapper.class).queryGenreNames();
    }

    @PostMapping("/queryMoviesByGenres/{db_type}")
    List<String> queryMoviesByGenres(@PathVariable String db_type, @RequestBody List<String> genres){
        return QueryEngine.engines.get(db_type).createMapper(GenreMapper.class).queryByGenre(genres);
    }
}
