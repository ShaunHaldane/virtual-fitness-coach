package com.shaun.fitness_coach_service.controller;

import com.shaun.fitness_coach_service.entity.Video;
import com.shaun.fitness_coach_service.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Validated
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/video")
    public ResponseEntity<Video> createVideo(@Valid @RequestBody Video video){
        Video savedVideo = adminService.createVideo(video);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }

    @PutMapping("/video/{id}")
    public ResponseEntity<Video> updateVideo(@Valid @PathVariable("id") long id, @RequestBody Video video){
        Video updatedVideo = adminService.updateVideo(id, video);
        return new ResponseEntity<>(updatedVideo, HttpStatus.CREATED);
    }

    @DeleteMapping("/video/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable long id) {
        adminService.deleteVideo(id);
        return new ResponseEntity<>("Video " +id+ "Deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("video")
    public ResponseEntity<List<Video>> getAllVideos() {
        return new ResponseEntity<>(adminService.getAllVideos(), HttpStatus.OK);
    }
}
