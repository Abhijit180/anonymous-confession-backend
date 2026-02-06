package com.confess.anonymous.repository;

import com.confess.anonymous.entity.Confession;
import com.confess.anonymous.enums.Category;
import com.confess.anonymous.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConfessionRepository extends JpaRepository<Confession, Long> {
    List<Confession> findByStatusAndCategory(Status status, Category category);
}
