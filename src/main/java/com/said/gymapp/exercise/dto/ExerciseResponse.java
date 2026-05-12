package com.said.gymapp.exercise.dto;

import java.time.LocalDateTime;

import com.said.gymapp.exercise.Exercise;

public record ExerciseResponse(
        Long id,
        String name,
        LocalDateTime createdAt) {

    public static ExerciseResponse from(Exercise exercise) {
        return new ExerciseResponse(
                exercise.getId(),
                exercise.getName(),
                exercise.getCreatedAt());
    }
}
