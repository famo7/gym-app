package com.said.gymapp.workout.dto;

import java.time.LocalDateTime;

import com.said.gymapp.workout.Workout;

public record WorkoutResponse(
        Long id,
        String name,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        LocalDateTime createdAt) {

    public static WorkoutResponse from(Workout workout) {
        return new WorkoutResponse(
                workout.getId(),
                workout.getName(),
                workout.getStartedAt(),
                workout.getEndedAt(),
                workout.getCreatedAt());
    }

}
