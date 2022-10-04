package com.gj.demo;



import java.util.List;
import java.util.Map;

public interface TestDAO {

    void save(List<User> storeLocationDTOList);

    Map<String, List<User>> findAll();
}
