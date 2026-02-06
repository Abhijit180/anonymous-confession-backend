package com.confess.anonymous.service.impl;

import com.confess.anonymous.dto.ConfessionRequestDTO;
import com.confess.anonymous.dto.ConfessionResponseDTO;
import com.confess.anonymous.entity.Confession;
import com.confess.anonymous.enums.Category;
import com.confess.anonymous.enums.Status;
import com.confess.anonymous.mapper.ConfessionMapper;
import com.confess.anonymous.repository.ConfessionRepository;
import com.confess.anonymous.security.IdentityHashUtil;
import com.confess.anonymous.service.ConfessionService;
import com.confess.anonymous.service.RateLimitService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfessionServiceImpl implements ConfessionService {

    private final ConfessionRepository repository;
    private final RateLimitService rateLimitService;

    public ConfessionServiceImpl(ConfessionRepository repository, RateLimitService rateLimitService) {
        this.repository = repository;
        this.rateLimitService = rateLimitService;
    }

    @Override
    public void submitConfession(ConfessionRequestDTO dto, HttpServletRequest request) {
        String hash = IdentityHashUtil.generate(request);
        rateLimitService.validateLimit(hash);

        Confession confession =
                ConfessionMapper.toEntity(dto, hash);
        confession.setContent(dto.getContent());
        confession.setCategory(dto.getCategory());
        confession.setStatus(Status.PENDING);

        repository.save(confession);
    }

    @Override
    public List<ConfessionResponseDTO> getAllApprovedConfessions() {
        return repository.findByStatus(Status.APPROVED)
                .stream()
                .map(ConfessionMapper::toDTO)
                .toList();
    }

    @Override
    public List<ConfessionResponseDTO> getApprovedConfessions(Category category) {
        return repository.findByStatusAndCategory(Status.APPROVED, category)
                .stream()
                .map(ConfessionMapper::toDTO)
                .toList();
    }


}

