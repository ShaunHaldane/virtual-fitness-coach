package com.shaun.fitness_coach_service.repository;

import com.shaun.fitness_coach_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(long id);
}
