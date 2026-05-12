package com.said.gymapp.set.dto;

import java.time.LocalDateTime;
import com.said.gymapp.set.WorkoutSet;

public record SetResponse(
        Long id,
        int reps,
        double weight,
        LocalDateTime createdAt) {

    public static SetResponse from(WorkoutSet set) {
        return new SetResponse(
                set.getId(),
                set.getReps(),
                set.getWeight(),
                set.getCreatedAt());
    }
}
