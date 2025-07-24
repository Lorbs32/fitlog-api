package dev.kylelohrberg.fitlog.service;

import dev.kylelohrberg.fitlog.entity.Exercise;
import dev.kylelohrberg.fitlog.entity.Workout;
import dev.kylelohrberg.fitlog.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    public Workout createWorkout(Workout workout){
        if (workout.getExercises() != null){
            for (Exercise e : workout.getExercises()){
                e.setWorkout(workout);
            }
        }
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    public Workout getWorkoutById(Long id){
        return workoutRepository.findById(id).orElse(null);
    }

    public void deleteWorkout(Long id){
        workoutRepository.deleteById(id);
    }
}
