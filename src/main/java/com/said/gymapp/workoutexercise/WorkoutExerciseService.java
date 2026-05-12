package com.said.gymapp.workoutexercise;

import java.util.List;
import org.springframework.stereotype.Service;
import com.said.gymapp.exercise.Exercise;
import com.said.gymapp.exercise.ExerciseRepository;
import com.said.gymapp.workout.Workout;
import com.said.gymapp.workout.WorkoutRepository;
import com.said.gymapp.workoutexercise.dto.WorkoutExerciseRequest;
import com.said.gymapp.workoutexercise.dto.WorkoutExerciseResponse;

@Service
public class WorkoutExerciseService {

    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;

    public WorkoutExerciseService(
            WorkoutExerciseRepository workoutExerciseRepository,
            WorkoutRepository workoutRepository,
            ExerciseRepository exerciseRepository) {
        this.workoutExerciseRepository = workoutExerciseRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public List<WorkoutExerciseResponse> getExercises(Long workoutId) {
        workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        return workoutExerciseRepository.findByWorkoutId(workoutId).stream()
                .map(WorkoutExerciseResponse::from)
                .toList();
    }

    public WorkoutExerciseResponse addExercise(Long workoutId, WorkoutExerciseRequest request) {
        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
        Exercise exercise = exerciseRepository.findById(request.exerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        WorkoutExercise we = new WorkoutExercise();
        we.setWorkout(workout);
        we.setExercise(exercise);
        we.setOrderIndex(request.orderIndex());
        we.setNotes(request.notes());

        return WorkoutExerciseResponse.from(workoutExerciseRepository.save(we));
    }

    public void removeExercise(Long workoutId, Long weId) {
        WorkoutExercise we = workoutExerciseRepository.findById(weId)
                .orElseThrow(() -> new RuntimeException("WorkoutExercise not found"));

        if (!we.getWorkout().getId().equals(workoutId)) {
            throw new RuntimeException("WorkoutExercise does not belong to this workout");
        }

        workoutExerciseRepository.deleteById(weId);
    }
}
