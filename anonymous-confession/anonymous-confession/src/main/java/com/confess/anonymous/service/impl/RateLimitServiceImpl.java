package com.confess.anonymous.service.impl;

import com.confess.anonymous.service.RateLimitService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitServiceImpl implements RateLimitService {

    private final Map<String, Bucket> cache = new ConcurrentHashMap<>();
    @Override
    public void validateLimit(String identityHash) {
            Bucket bucket = cache.computeIfAbsent(identityHash, k ->
                    Bucket.builder()
                            .addLimit(Bandwidth.simple(5, Duration.ofHours(1)))
                            .build()
            );

            if (!bucket.tryConsume(1)) {
                throw new RuntimeException("Rate limit exceeded");
            }
    }
}

