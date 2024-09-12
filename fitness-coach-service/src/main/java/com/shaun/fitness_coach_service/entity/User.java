package com.shaun.fitness_coach_service.entity;

import com.shaun.fitness_coach_service.enums.FitnessLevel;
import com.shaun.fitness_coach_service.enums.Sex;
import com.shaun.fitness_coach_service.enums.Weight;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Payment details
    private String cardNumber;

    // User
    private FitnessLevel fitnessLevel;
    private Weight weight;
    private Sex sex;

    // Injuries
    private boolean noInjuries;
    private boolean backPain;
    private boolean kneepain;

    // Equipment
    private boolean noEquipment;
    private boolean barbell;
    private boolean dumbell;
}
