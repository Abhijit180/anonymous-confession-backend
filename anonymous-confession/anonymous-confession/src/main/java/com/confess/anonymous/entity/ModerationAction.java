package com.confess.anonymous.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "moderation_actions")
public class ModerationAction {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "confession_id", nullable = false)
    private Confession confession;

    private String action; // APPROVED / REJECTED / FLAGGED

    private String note;

    private LocalDateTime timestamp;
}
