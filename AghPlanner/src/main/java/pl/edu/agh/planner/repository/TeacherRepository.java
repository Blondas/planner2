package pl.edu.agh.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.planner.domain.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
