package com.tongji.zhou.moviedal.QueryEntity;

import com.tongji.zhou.moviedal.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class MovieProducts {
    private List<Product> products;
    private Integer movie_id;

    public MovieProducts(Integer id){
        movie_id=id;
        products=new ArrayList<>();
    }
    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
