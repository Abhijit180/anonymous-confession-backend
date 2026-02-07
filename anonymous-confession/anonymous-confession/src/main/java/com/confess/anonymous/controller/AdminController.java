package com.confess.anonymous.controller;

import com.confess.anonymous.entity.Confession;
import com.confess.anonymous.enums.Status;
import com.confess.anonymous.repository.ConfessionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin/confessions")
public class AdminController {
    private final ConfessionRepository repository;

    public AdminController(ConfessionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<String> approve(@PathVariable Long id) {
        Confession confession = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Confession not found"));

        confession.setStatus(Status.APPROVED);
        repository.save(confession);
        return new ResponseEntity<>("Approved", HttpStatus.OK);
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<String> reject(@PathVariable Long id) {
        Confession c = repository.findById(id).orElseThrow();
        c.setStatus(Status.REJECTED);
        repository.save(c);
        return new ResponseEntity<>("Rejected", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllConfessionsForAdmin() {
        return ResponseEntity.ok(repository.findAll());
    }
}

