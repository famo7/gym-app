package com.said.gymapp;

import com.said.gymapp.exercise.Exercise;
import com.said.gymapp.exercise.ExerciseRepository;
import com.said.gymapp.user.User;
import com.said.gymapp.user.UserRepository;
import com.said.gymapp.workout.Workout;
import com.said.gymapp.workout.WorkoutRepository;
import com.said.gymapp.workoutexercise.WorkoutExercise;
import com.said.gymapp.workoutexercise.WorkoutExerciseRepository;
import com.said.gymapp.set.WorkoutSet;
import com.said.gymapp.set.WorkoutSetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutSetRepository workoutSetRepository;

    public DataLoader(UserRepository userRepository, WorkoutRepository workoutRepository,
            ExerciseRepository exerciseRepository, WorkoutExerciseRepository workoutExerciseRepository,
            WorkoutSetRepository workoutSetRepository) {
        this.userRepository = userRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
        this.workoutExerciseRepository = workoutExerciseRepository;
        this.workoutSetRepository = workoutSetRepository;
    }

    @Override
    public void run(String... args) {

        if (userRepository.count() > 0)
            return;

        // Users
        User user = new User();
        user.setName("Said");
        user.setEmail("said@gym.com");
        user.setPassword("password123");
        userRepository.save(user);

        // Exercises
        Exercise benchPress = new Exercise();
        benchPress.setName("Bench Press");
        exerciseRepository.save(benchPress);

        Exercise squat = new Exercise();
        squat.setName("Squat");
        exerciseRepository.save(squat);

        Exercise deadlift = new Exercise();
        deadlift.setName("Deadlift");
        exerciseRepository.save(deadlift);

        // Workout
        Workout workout = new Workout();
        workout.setName("Push Day");
        workout.setUser(user);
        workoutRepository.save(workout);

        // WorkoutExercises
        WorkoutExercise we1 = new WorkoutExercise();
        we1.setWorkout(workout);
        we1.setExercise(benchPress);
        we1.setOrderIndex(1);
        we1.setNotes("Warm up first");
        workoutExerciseRepository.save(we1);

        WorkoutExercise we2 = new WorkoutExercise();
        we2.setWorkout(workout);
        we2.setExercise(squat);
        we2.setOrderIndex(2);
        workoutExerciseRepository.save(we2);

        // Sets
        WorkoutSet set1 = new WorkoutSet();
        set1.setWorkoutExercise(we1);
        set1.setReps(10);
        set1.setWeight(80.0);
        workoutSetRepository.save(set1);

        WorkoutSet set2 = new WorkoutSet();
        set2.setWorkoutExercise(we1);
        set2.setReps(8);
        set2.setWeight(85.0);
        workoutSetRepository.save(set2);

        System.out.println("Test data loaded.");
    }
}
