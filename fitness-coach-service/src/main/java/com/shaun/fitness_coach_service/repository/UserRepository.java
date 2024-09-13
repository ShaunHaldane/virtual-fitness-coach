package com.shaun.fitness_coach_service.repository;

import com.shaun.fitness_coach_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByEmail(String email);
    User getById(long id);
}
