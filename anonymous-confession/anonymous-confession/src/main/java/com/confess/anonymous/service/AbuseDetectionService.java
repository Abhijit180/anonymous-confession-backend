package com.confess.anonymous.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbuseDetectionService {
    private static final List<String> BLOCKED_WORDS =
            List.of("kill", "suicide", "abuse", "hate");

    public boolean isAbusive(String content) {
        String lower = content.toLowerCase();
        return BLOCKED_WORDS.stream().anyMatch(lower::contains);
    }
}
