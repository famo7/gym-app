package com.said.gymapp.workout.dto;

import jakarta.validation.constraints.NotBlank;

public record WorkoutRequest(
        @NotBlank String name) {

}
