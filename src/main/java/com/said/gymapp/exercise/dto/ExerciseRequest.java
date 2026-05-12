package com.said.gymapp.exercise.dto;

import jakarta.validation.constraints.NotBlank;

public record ExerciseRequest(
        @NotBlank String name) {
}
