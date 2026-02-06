package com.confess.anonymous.service;

import com.confess.anonymous.dto.ConfessionRequestDTO;
import com.confess.anonymous.dto.ConfessionResponseDTO;
import com.confess.anonymous.enums.Category;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface ConfessionService {

    void submitConfession(ConfessionRequestDTO dto, HttpServletRequest request);

    List<ConfessionResponseDTO> getApprovedConfessions(Category category);

}
