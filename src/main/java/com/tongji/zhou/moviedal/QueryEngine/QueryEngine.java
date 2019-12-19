package com.tongji.zhou.moviedal.QueryEngine;

import com.tongji.zhou.ErrorHandler;
import com.tongji.zhou.moviedal.Mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class QueryEngine {
    public static final Map<String,QueryEngine> engines;
    private SqlSessionFactory sqlSessionFactory=null;
    static {
        engines=new HashMap<>();
        engines.put("mysql",new QueryEngine(DB_TYPE.MYSQL));
        engines.put("hive",new QueryEngine(DB_TYPE.HIVE));
        engines.put("impala",new QueryEngine(DB_TYPE.IMPALA));
    }
    public enum DB_TYPE{
        MYSQL("mysql"), HIVE("hive"), IMPALA("impala");
        private final String db_name;
        DB_TYPE(String driver_name){
            this.db_name=driver_name;
        }
        public String getDatabaseName(){
            return db_name;
        }

    };


    private QueryEngine(DB_TYPE type){
        try{
            String resource= "config/config.xml";
            InputStream inputStream= Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,type.getDatabaseName());
        }catch (Exception e){
            ErrorHandler.error(e);
        }
    }

    public <T> T createMapper(Class<T> mapper){

        return sqlSessionFactory.openSession().getMapper(mapper);
    }
}
