package com.confess.anonymous.entity;

import com.confess.anonymous.enums.Category;
import com.confess.anonymous.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "confession")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Confession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(length = 1000, nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private String identityHash;
    private LocalDateTime createdAt;

    private boolean flagged;

}
