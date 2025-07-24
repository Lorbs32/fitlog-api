package dev.kylelohrberg.fitlog.controller;

import dev.kylelohrberg.fitlog.entity.Exercise;
import dev.kylelohrberg.fitlog.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise){
        Exercise savedExercise = exerciseService.createExercise(exercise);
        return ResponseEntity.ok(savedExercise);
    }

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises(){
        return ResponseEntity.ok(exerciseService.getAllExercises());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long id){
        Exercise exercise = exerciseService.getExerciseById(id);
        return (exercise != null) ? ResponseEntity.ok(exercise) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id){
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}
