package com.said.gymapp.workout;

import java.util.List;

import org.springframework.stereotype.Service;

import com.said.gymapp.workout.dto.WorkoutRequest;
import com.said.gymapp.workout.dto.WorkoutResponse;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<WorkoutResponse> findAll() {
        return workoutRepository.findAll().stream()
                .map(WorkoutResponse::from)
                .toList();
    }

    public WorkoutResponse findById(Long id) {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        return WorkoutResponse.from(workout);
    }

    public WorkoutResponse create(WorkoutRequest request) {
        Workout workout = new Workout();
        workout.setName(request.name());
        return WorkoutResponse.from(workoutRepository.save(workout));
    }

    public WorkoutResponse update(Long id, WorkoutRequest request) {
        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        workout.setName(request.name());
        return WorkoutResponse.from(workoutRepository.save(workout));
    }

    public void delete(Long id) {
        if (!workoutRepository.existsById(id)) {
            throw new RuntimeException("Workout not found");
        }
        workoutRepository.deleteById(id);
    }
}
