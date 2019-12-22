package com.tongji.zhou.moviedal.QueryEntity;

import com.tongji.zhou.moviedal.QueryEntity.MovieResultImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieResult implements MovieResultImp {
    private String movies;
    private Integer count;
    public MovieResult(String movies,Integer count){
        this.movies=movies;
        this.count=count;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public String getMovies() {

        return null;
    }

    public List<String> getMovieList(){
        String[] movie_list= movies.split("\\|");
        List<String> re=new ArrayList<>();
        for(String i:movie_list){
            if(!i.equals("")){
                re.add(i);
            }
        }
        return re;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }
}
