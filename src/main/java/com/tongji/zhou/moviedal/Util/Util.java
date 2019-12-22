package com.tongji.zhou.moviedal.Util;

import com.tongji.zhou.moviedal.QueryEntity.MovieResult;
import com.tongji.zhou.moviedal.QueryEntity.MovieResultImp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Util {
    public MovieResult combineMovies(List<? extends MovieResultImp> list){
        StringBuilder movies=new StringBuilder();
        Integer count=0;
        for(MovieResultImp movieResultImp:list){
            if(movies.length()==0){
                movies.append(movieResultImp.getMovies());
            }else {
                movies.append(movieResultImp.getMovies().substring(1));
            }
            count+=movieResultImp.getCount();
        }
        return new MovieResult(movies.toString(),count);
    }

}
