package com.confess.anonymous.dto;

import com.confess.anonymous.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfessionRequestDTO {

    @NotBlank
    @Size(max = 1000)
    private String content;

    @NotNull
    private Category category;
}
