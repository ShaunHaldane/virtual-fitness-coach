package com.shaun.fitness_coach_service.controller;

import com.shaun.fitness_coach_service.entity.User;
import com.shaun.fitness_coach_service.entity.Video;
import com.shaun.fitness_coach_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    private ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User " +id+ "Deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/videos")
    private ResponseEntity<Set<Video>> getRecomendedVideos(@PathVariable("id") Long id){
        Set<Video> recomendedVideos = userService.getRecomendedVideos(id);
        return new ResponseEntity<>(recomendedVideos, HttpStatus.OK);
    }
}
