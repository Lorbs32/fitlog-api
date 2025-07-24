package dev.kylelohrberg.fitlog.repository;

import dev.kylelohrberg.fitlog.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
