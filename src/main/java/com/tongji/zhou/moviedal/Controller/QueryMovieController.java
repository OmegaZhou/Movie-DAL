package com.tongji.zhou.moviedal.Controller;

import com.tongji.zhou.moviedal.Entity.*;
import com.tongji.zhou.moviedal.Mapper.MovieMapper;
import com.tongji.zhou.moviedal.QueryEngine.QueryEngine;
import com.tongji.zhou.moviedal.QueryEntity.MovieProducts;
import com.tongji.zhou.moviedal.QueryEntity.PersonResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/byMovieName")
@RestController()
public class QueryMovieController {
    @PostMapping("/queryProducts/{db_type}")
    List<MovieProducts> queryProducts(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        List<Product> tmp=QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryProducts(movieFact.getName());
        Map<Integer,MovieProducts> productsMap=new HashMap<>();
        for(Product product:tmp){
            if(productsMap.get(product.getId())!=null){
                productsMap.get(product.getId()).getProducts().add(product);
            }else{
                MovieProducts movieProducts=new MovieProducts(product.getId());
                movieProducts.getProducts().add(product);
                productsMap.put(product.getId(),movieProducts);
            }
        }

        return new ArrayList<>(productsMap.values());
    }

    @PostMapping("/queryActors/{db_type}")
    List<PersonResult> queryActors(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryPersons(PersonType.ACTOR,movieFact.getName());
    }

    @PostMapping("/querySupportings/{db_type}")
    List<PersonResult> querySupportings(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryPersons(PersonType.SUPPORTING,movieFact.getName());
    }

    @PostMapping("/queryStarrings/{db_type}")
    List<PersonResult> queryStarrings(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryPersons(PersonType.STARRING,movieFact.getName());
    }

    @PostMapping("/queryDirectors/{db_type}")
    List<PersonResult> queryDirectors(@RequestBody MovieFact movieFact, @PathVariable String db_type){
        return QueryEngine.engines.get(db_type).createMapper(MovieMapper.class)
                .queryPersons(PersonType.DIRECTOR,movieFact.getName());
    }

}
