package com.shaun.fitness_coach_service.dto;

import lombok.Data;

@Data
public class VideoDTO {

    private Long id;
    private String name;
    private int fitnessLevel;
    private String weight;
    private char sex;
    // Workout Type(Strength, Flexibility, Cardio, Plyo)
    private String workoutType;
    // Injuries
    private boolean noInjuries;
    private boolean backPain;
    private boolean kneepain;
    // Equipment
    private boolean noEquipment;
    private boolean barbell;
    private boolean dumbell;
    private boolean barbellAndDumbell;

    public VideoDTO(Long id, String name) {
    }
}
