package org.example.common.service;

public interface RedisService {

    void setData(String key, String data, long duration);

    boolean checkDataExists(String key);

    String getData(String key);

    void deleteData(String key);
}
