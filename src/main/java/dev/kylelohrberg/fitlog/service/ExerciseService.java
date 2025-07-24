package dev.kylelohrberg.fitlog.service;

import dev.kylelohrberg.fitlog.entity.Exercise;
import dev.kylelohrberg.fitlog.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise createExercise(Exercise exercise){
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Long id){
        return exerciseRepository.findById(id).orElse(null);
    }

    public void deleteExercise(Long id){
        exerciseRepository.deleteById(id);
    }
}
