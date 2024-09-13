package com.shaun.fitness_coach_service.entity;

import com.shaun.fitness_coach_service.enums.FitnessLevel;
import com.shaun.fitness_coach_service.enums.Sex;
import com.shaun.fitness_coach_service.enums.Weight;
import com.shaun.fitness_coach_service.enums.WorkoutType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the video name should be between 5 and 30")
    private String name;
    private FitnessLevel fitnessLevel;
    private Weight weight;
    private Sex sex;

    // Workout Type(Strength, Flexibility, Cardio, Plyo)
    private WorkoutType workoutType;

    // Injuries
    private boolean noInjuries;
    private boolean backPain;
    private boolean kneepain;

    // Equipment
    private boolean noEquipment;
    private boolean barbell;
    private boolean dumbell;
}
