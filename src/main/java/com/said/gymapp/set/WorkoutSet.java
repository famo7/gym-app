package com.said.gymapp.set;

import java.time.LocalDateTime;
import com.said.gymapp.workoutexercise.WorkoutExercise;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workout_sets")
public class WorkoutSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int reps;
    private double weight;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "workout_exercise_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkoutExercise workoutExercise;
}