package com.said.gymapp.workout;

import java.util.List;
import java.time.LocalDateTime;
import com.said.gymapp.user.User;
import com.said.gymapp.workoutexercise.WorkoutExercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "workout")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<WorkoutExercise> workoutExercises;
}