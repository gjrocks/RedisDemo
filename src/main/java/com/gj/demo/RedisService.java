package com.gj.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RedisService {

    @Autowired
    TestDAO testDAO;

    public void save(List<User> storeLocationDTOList) {
        testDAO.save(storeLocationDTOList);
    }

    public Map<String, List<User>> findAll() {
        return testDAO.findAll();
    }
}
