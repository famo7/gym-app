package com.said.gymapp.exercise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.said.gymapp.exercise.dto.ExerciseRequest;
import com.said.gymapp.exercise.dto.ExerciseResponse;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<ExerciseResponse> findAll() {
        return exerciseRepository.findAll().stream()
                .map(ExerciseResponse::from)
                .toList();
    }

    public ExerciseResponse findById(Long id) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
        return ExerciseResponse.from(exercise);
    }

    public ExerciseResponse create(ExerciseRequest request) {
        Exercise exercise = new Exercise();
        exercise.setName(request.name());
        return ExerciseResponse.from(exerciseRepository.save(exercise));
    }

    public ExerciseResponse update(Long id, ExerciseRequest request) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
        exercise.setName(request.name());
        return ExerciseResponse.from(exerciseRepository.save(exercise));
    }

    public void delete(Long id) {
        if (!exerciseRepository.existsById(id)) {
            throw new RuntimeException("Exercise not found");
        }
        exerciseRepository.deleteById(id);
    }
}
