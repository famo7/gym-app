package com.said.gymapp.workout;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.said.gymapp.workout.dto.WorkoutRequest;
import com.said.gymapp.workout.dto.WorkoutResponse;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("")
    public List<WorkoutResponse> getWorkouts() {
        return workoutService.findAll();
    }

    @GetMapping("/{id}")
    public WorkoutResponse getWorkout(@PathVariable Long id) {
        return workoutService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public WorkoutResponse createWorkout(@Valid @RequestBody WorkoutRequest request) {
        return workoutService.create(request);
    }

    @PutMapping("/{id}")
    public WorkoutResponse updateWorkout(@PathVariable Long id, @Valid @RequestBody WorkoutRequest request) {
        return workoutService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.delete(id);
    }

}
