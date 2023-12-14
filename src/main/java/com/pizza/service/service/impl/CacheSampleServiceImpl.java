package com.pizza.service.service.impl;

import com.pizza.service.service.CacheSampleService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheSampleServiceImpl implements CacheSampleService {
    long counter = 0;
    @Override
    @Cacheable("number")
    public Long sample(Long number) {
        return number + counter++;
    }

    @Override
    public Long sampleNoCached(Long number) {
        return number + counter++;
    }
}
