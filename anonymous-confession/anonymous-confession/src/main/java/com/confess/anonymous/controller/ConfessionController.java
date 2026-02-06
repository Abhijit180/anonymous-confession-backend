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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/confessions")
public class ConfessionController {

    private final ConfessionService service;

    public ConfessionController(ConfessionService service) {
        this.service = service;
    }

    // ✅ POST confession
    @PostMapping
    public ResponseEntity<String> submit(
            @RequestBody @Valid ConfessionRequestDTO dto,
            HttpServletRequest request) {

        service.submitConfession(dto, request);
        return new ResponseEntity<>("Confession submitted for review", HttpStatus.CREATED);
    }

    // ✅ GET ALL approved confessions
    @GetMapping
    public ResponseEntity<List<ConfessionResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllApprovedConfessions());
    }

    // ✅ GET approved confessions by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ConfessionResponseDTO>> getByCategory(
            @PathVariable Category category) {

        return ResponseEntity.ok(service.getApprovedConfessions(category));
    }
}
