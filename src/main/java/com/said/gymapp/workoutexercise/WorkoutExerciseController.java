package com.said.gymapp.workoutexercise;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.said.gymapp.workoutexercise.dto.WorkoutExerciseRequest;
import com.said.gymapp.workoutexercise.dto.WorkoutExerciseResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/workouts/{workoutId}/exercises")
public class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;

    public WorkoutExerciseController(WorkoutExerciseService workoutExerciseService) {
        this.workoutExerciseService = workoutExerciseService;
    }

    @GetMapping("")
    public List<WorkoutExerciseResponse> getExercises(@PathVariable Long workoutId) {
        return workoutExerciseService.getExercises(workoutId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public WorkoutExerciseResponse addExercise(
            @PathVariable Long workoutId,
            @Valid @RequestBody WorkoutExerciseRequest request) {
        return workoutExerciseService.addExercise(workoutId, request);
    }

    @DeleteMapping("/{weId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeExercise(
            @PathVariable Long workoutId,
            @PathVariable Long weId) {
        workoutExerciseService.removeExercise(workoutId, weId);
    }
}
