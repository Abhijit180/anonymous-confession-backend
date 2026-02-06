package com.confess.anonymous.dto;

import com.confess.anonymous.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfessionResponseDTO {

    private String content;
    private Category category;
    private LocalDateTime postedAt;
}
