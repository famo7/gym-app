package com.said.gymapp.workoutexercise;

import java.util.List;
import com.said.gymapp.exercise.Exercise;
import com.said.gymapp.set.WorkoutSet;
import com.said.gymapp.workout.Workout;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workout_exercises")
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Exercise exercise;

    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<WorkoutSet> sets;

    private int orderIndex;
    private String notes;
}