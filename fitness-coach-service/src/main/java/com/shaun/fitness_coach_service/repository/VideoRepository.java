package com.shaun.fitness_coach_service.repository;

import com.shaun.fitness_coach_service.entity.Video;
import com.shaun.fitness_coach_service.enums.FitnessLevel;
import com.shaun.fitness_coach_service.enums.Sex;
import com.shaun.fitness_coach_service.enums.Weight;
import com.shaun.fitness_coach_service.enums.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Query("SELECT v FROM Video v " +
            "WHERE v.noEquipment = :noEquipment " +
            "AND v.barbell = :barbell " +
            "AND v.dumbell = :dumbell " +
            "AND v.noInjuries = :noInjuries " +
            "AND v.backPain = :backPain " +
            "AND v.kneepain = :kneepain " +
            "AND v.fitnessLevel = :fitnessLevel " +
            "AND v.sex = :sex " +
            "AND v.weight = :weight " +
            "AND v.workoutType = :workoutType")
    Set<Video> findByUserParams(@Param("noEquipment") boolean noEquipment,
                                        @Param("barbell") boolean barbell,
                                        @Param("dumbell") boolean dumbell,
                                        @Param("noInjuries") boolean noInjuries,
                                        @Param("backPain") boolean backPain,
                                        @Param("kneepain") boolean kneepain,
                                        @Param("fitnessLevel") FitnessLevel fitnessLevel,
                                        @Param("sex") Sex sex,
                                        @Param("weight") Weight weight,
                                        @Param("workoutType") WorkoutType workoutType
    );
}
