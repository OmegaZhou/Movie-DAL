package com.tongji.zhou.moviedal.QueryEntity;

import com.tongji.zhou.moviedal.QueryEntity.MovieResultImp;

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
        return movies;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }
}
