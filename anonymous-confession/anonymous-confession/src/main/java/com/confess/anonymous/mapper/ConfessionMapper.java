package com.confess.anonymous.mapper;

import com.confess.anonymous.dto.ConfessionRequestDTO;
import com.confess.anonymous.dto.ConfessionResponseDTO;
import com.confess.anonymous.entity.Confession;
import com.confess.anonymous.enums.Status;

import java.time.LocalDateTime;

public class ConfessionMapper {
    public static Confession toEntity(ConfessionRequestDTO dto, String hash){
        Confession confession = new Confession();
        confession.setContent(dto.getContent());
        confession.setCategory(dto.getCategory());
        confession.setStatus(Status.PENDING);
        confession.setIdentityHash(hash);
        confession.setCreatedAt(LocalDateTime.now());
        return confession;
    }

    public static ConfessionResponseDTO toDTO(Confession confession){
        ConfessionResponseDTO dto = new ConfessionResponseDTO();
        dto.setContent(confession.getContent());
        dto.setCategory(confession.getCategory());
        dto.setPostedAt(confession.getCreatedAt());
        return dto;
    }
}
