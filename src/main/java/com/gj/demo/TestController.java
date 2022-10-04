package com.gj.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cache")
public class TestController {

    @Autowired
    RedisService redisService;

    @PostMapping("/create-cache")
    public boolean create(@RequestBody List<User> storeLocationDTOList) {
        System.out.println("saving data in cache");
        redisService.save(storeLocationDTOList);
        System.out.println("successfully saved in cache");
        return true;
    }

    @GetMapping("/findAll")
    public Map<String, List<User>> findAll() {
        System.out.println("retrieving data from cache");
        return redisService.findAll();
    }

    @GetMapping("/ping")
    public String  ping() {
        System.out.println("retrieving data from cache");
        return "Ping ok";
    }
}
