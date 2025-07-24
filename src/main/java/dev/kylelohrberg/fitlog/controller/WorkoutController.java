package dev.kylelohrberg.fitlog.controller;

import dev.kylelohrberg.fitlog.entity.Workout;
import dev.kylelohrberg.fitlog.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout){
        Workout savedWorkout = workoutService.createWorkout(workout);
        return ResponseEntity.ok(savedWorkout);
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        return ResponseEntity.ok(workoutService.getAllWorkouts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id){
        Workout workout = workoutService.getWorkoutById(id);
        return (workout != null) ? ResponseEntity.ok(workout) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id){
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }
}
