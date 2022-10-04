package com.gj.demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    Map<Integer, User> db=new HashMap<>();


    @Cacheable(value = "jdf-revolving-finance-api-elasticache-cluster-devl",key="#id")
    public User findUserById(Integer id) {
        logger.debug("Getting user from DB for Id:" + id);
        return db.get(id);
    }

    @PostConstruct
    public void init(){
        db.put(1,new User(1,"Ganesh"));
        db.put(2,new User(2,"anesh"));
        db.put(3,new User(3,"nesh"));
        db.put(4,new User(4,"esh"));
        db.put(5,new User(5,"sh"));
    }

    public  Map<Integer, User> getAll() {
        return db;
    }
}
