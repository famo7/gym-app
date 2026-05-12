package com.said.gymapp.workoutexercise.dto;

import java.util.List;
import com.said.gymapp.set.dto.SetResponse;
import com.said.gymapp.workoutexercise.WorkoutExercise;

public record WorkoutExerciseResponse(
        Long id,
        Long exerciseId,
        String exerciseName,
        Integer orderIndex,
        String notes,
        List<SetResponse> sets) {

    public static WorkoutExerciseResponse from(WorkoutExercise we) {
        return new WorkoutExerciseResponse(
                we.getId(),
                we.getExercise().getId(),
                we.getExercise().getName(),
                we.getOrderIndex(),
                we.getNotes(),
                we.getSets() != null
                        ? we.getSets().stream().map(SetResponse::from).toList()
                        : List.of());
    }
}
