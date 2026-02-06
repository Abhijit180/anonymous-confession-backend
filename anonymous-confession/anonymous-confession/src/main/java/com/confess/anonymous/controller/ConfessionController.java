package com.confess.anonymous.controller;

import com.confess.anonymous.dto.ConfessionRequestDTO;
import com.confess.anonymous.dto.ConfessionResponseDTO;
import com.confess.anonymous.enums.Category;
import com.confess.anonymous.service.ConfessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/confessions")
public class ConfessionController {
    private final ConfessionService service;

    public ConfessionController(ConfessionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> submit(
            @RequestBody @Valid ConfessionRequestDTO dto,
            HttpServletRequest request) {

        service.submitConfession(dto, request);
        return new ResponseEntity<>("Confession submitted for review", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ConfessionResponseDTO>> get(
            @RequestParam Category category) {

        List<ConfessionResponseDTO> dtos =service.getApprovedConfessions(category);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
