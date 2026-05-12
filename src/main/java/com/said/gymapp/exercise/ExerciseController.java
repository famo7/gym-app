package com.said.gymapp.exercise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.said.gymapp.exercise.dto.ExerciseRequest;
import com.said.gymapp.exercise.dto.ExerciseResponse;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("")
    public List<ExerciseResponse> getExercises() {
        return exerciseService.findAll();
    }

    @GetMapping("/{id}")
    public ExerciseResponse getExercise(@PathVariable Long id) {
        return exerciseService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciseResponse createExercise(@Valid @RequestBody ExerciseRequest request) {
        return exerciseService.create(request);
    }

    @PutMapping("/{id}")
    public ExerciseResponse updateExercise(@PathVariable Long id, @Valid @RequestBody ExerciseRequest request) {
        return exerciseService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.delete(id);
    }
}
