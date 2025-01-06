package org.example.global.redis;

import lombok.RequiredArgsConstructor;
import org.example.common.service.RedisService;
import org.example.domain.student.exception.CodeNotExistsInRedisException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisAdapter implements RedisService {
    private final StringRedisTemplate redis;

    @Override
    public void setData(String key, String data, long duration) {
        ValueOperations<String, String> valueOperations = redis.opsForValue();
        Duration expireDuration = Duration.ofSeconds(duration);
        valueOperations.set(key, data, expireDuration);
    }

    @Override
    public boolean checkDataExists(String key) {
        return Boolean.TRUE.equals(redis.hasKey(key));
    }

    @Override
    public String getData(String key) {
        ValueOperations<String, String> valueOperations = redis.opsForValue();
        String data = valueOperations.get(key);

        if (data == null) {
            throw CodeNotExistsInRedisException.EXCEPTION;
        }
        
        return data;
    }

    @Override
    public void deleteData(String key) {
        redis.delete(key);
    }
}
