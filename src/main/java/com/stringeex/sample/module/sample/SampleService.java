package com.stringeex.sample.module.sample;

import org.springframework.stereotype.Service;

@Service
public interface SampleService {
    void generate(Long timestamp);
}
