package com.shaun.fitness_coach_service.service;

import com.shaun.fitness_coach_service.entity.Video;
import com.shaun.fitness_coach_service.exception.CustomerAlreadyExistsException;
import com.shaun.fitness_coach_service.exception.ResourceNotFoundException;
import com.shaun.fitness_coach_service.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {

    private VideoRepository videoRepository;

    public Video createVideo(Video video){

        Optional<Video> optionalVideo = videoRepository.getByName(video.getName());
        if(optionalVideo.isPresent()) {
            throw new CustomerAlreadyExistsException("Video already registered with given name "
                    + video.getName());
        }

        return videoRepository.save(video);
    }

    public Video updateVideo(Long videoId, Video video){

        Video _video = videoRepository.findById(videoId).orElseThrow(
                () -> new ResourceNotFoundException("Video not found with id: " + videoId)
        );

        _video.setName(video.getName());
        _video.setFitnessLevel(video.getFitnessLevel());
        _video.setWeight(video.getWeight());
        _video.setSex(video.getSex());
        _video.setWorkoutType(video.getWorkoutType());
        _video.setNoEquipment(video.isNoEquipment());
        _video.setBarbell(video.isBarbell());
        _video.setDumbell(video.isDumbell());
        _video.setNoInjuries(video.isNoInjuries());
        _video.setBackPain(video.isBackPain());
        _video.setKneepain(video.isKneepain());

        return videoRepository.save(_video);
    }
    public void deleteVideo(Long videoId){

        Video video = videoRepository.findById(videoId).orElseThrow(
                () -> new ResourceNotFoundException("Video not found with id: " + videoId)
        );

        videoRepository.deleteById(videoId);
    }

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }
}
