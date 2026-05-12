package com.said.gymapp.workoutexercise.dto;

import jakarta.validation.constraints.NotNull;

public record WorkoutExerciseRequest(
        @NotNull Long exerciseId,
        @NotNull Integer orderIndex,
        String notes) {
}
