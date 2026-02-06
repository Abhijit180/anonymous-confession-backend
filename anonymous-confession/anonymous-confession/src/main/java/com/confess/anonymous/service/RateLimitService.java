package com.confess.anonymous.service;

public interface RateLimitService {
    public void validateLimit(String identityHash);
}
