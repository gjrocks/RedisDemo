package com.gj.demo;


import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TestDAOImpl implements TestDAO {
    private RedisTemplate<String, List<User>> redisTemplate;
    private HashOperations hashOperations;

    public TestDAOImpl(RedisTemplate<String, List<User>> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(List<User> storeLocationDTOList) {
        hashOperations.put("jdf-revolving-finance-api-elasticache-cluster-devl", "1", storeLocationDTOList);
    }

    @Override
    public Map<String, List<User>> findAll() {
        return hashOperations.entries("jdf-revolving-finance-api-elasticache-cluster-devl");
    }
}
