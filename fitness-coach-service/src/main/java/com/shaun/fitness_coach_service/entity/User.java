package com.shaun.fitness_coach_service.entity;

import com.shaun.fitness_coach_service.enums.FitnessLevel;
import com.shaun.fitness_coach_service.enums.Sex;
import com.shaun.fitness_coach_service.enums.Weight;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    // Payment details
    @NotEmpty(message = "Account number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Account number must be 10 digits")
    private String cardNumber;

    // User
    private FitnessLevel fitnessLevel;
    private Weight weight;
    private Sex sex;

    // Injuries
    private boolean noInjuries;
    private boolean backpain;
    private boolean kneepain;

    // Equipment
    private boolean noEquipment;
    private boolean barbell;
    private boolean dumbell;
}
