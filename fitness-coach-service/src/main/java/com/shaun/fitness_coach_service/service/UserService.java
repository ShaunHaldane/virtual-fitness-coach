package com.shaun.fitness_coach_service.service;

import com.shaun.fitness_coach_service.entity.User;
import com.shaun.fitness_coach_service.entity.Video;
import com.shaun.fitness_coach_service.enums.WorkoutType;
import com.shaun.fitness_coach_service.exception.ResourceAlreadyExistsException;
import com.shaun.fitness_coach_service.exception.ResourceNotFoundException;
import com.shaun.fitness_coach_service.repository.UserRepository;
import com.shaun.fitness_coach_service.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private VideoRepository videoRepository;

    public User createUser(User user){

        Optional<User> optionalCustomer = userRepository.getByEmail(user.getEmail());
        if(optionalCustomer.isPresent()) {
            throw new ResourceAlreadyExistsException("User already registered with given email "
                    + user.getEmail());
        }

        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user){

        User _user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + userId)
        );

        _user.setName(user.getName());
        _user.setFitnessLevel(user.getFitnessLevel());
        _user.setWeight(user.getWeight());
        _user.setSex(user.getSex());
        _user.setNoEquipment(user.isNoEquipment());
        _user.setBarbell(user.isBarbell());
        _user.setDumbell(user.isDumbell());
        _user.setNoInjuries(user.isNoInjuries());
        _user.setBackPain(user.isBackPain());
        _user.setKneepain(user.isKneepain());

        return userRepository.save(_user);
    }

    public void deleteUser(Long userId){

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + userId)
        );

        userRepository.deleteById(userId);
    }

    public Set<Video> getRecomendedVideos(Long userId){

        //ToDo: Convert return value to VideoDTO

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + userId)
        );

        Set<Video> recomededVideos = new HashSet<>();

        Set<Video> strengthVideos = videoRepository.findByUserParams(
                user.isNoEquipment(),
                user.isBarbell(),
                user.isDumbell(),
                user.isNoInjuries(),
                user.isBackPain(),
                user.isKneepain(),
                user.getFitnessLevel(),
                user.getSex(),
                user.getWeight(),
                WorkoutType.STRENGTH
        );

        Set<Video> cardioVideos = videoRepository.findByUserParams(
                user.isNoEquipment(),
                user.isBarbell(),
                user.isDumbell(),
                user.isNoInjuries(),
                user.isBackPain(),
                user.isKneepain(),
                user.getFitnessLevel(),
                user.getSex(),
                user.getWeight(),
                WorkoutType.CARDIO
        );

        Set<Video> flexibilityVideos = videoRepository.findByUserParams(
                user.isNoEquipment(),
                user.isBarbell(),
                user.isDumbell(),
                user.isNoInjuries(),
                user.isBackPain(),
                user.isKneepain(),
                user.getFitnessLevel(),
                user.getSex(),
                user.getWeight(),
                WorkoutType.FLEX
        );

        strengthVideos.stream().forEach(video -> {
            recomededVideos.add(video);
        });

        cardioVideos.stream().forEach(video -> {
            recomededVideos.add(video);
        });

        flexibilityVideos.stream().forEach(video -> {
            recomededVideos.add(video);
        });

        return recomededVideos;
    }
}
