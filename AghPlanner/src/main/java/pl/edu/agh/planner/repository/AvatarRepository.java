package pl.edu.agh.planner.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.planner.domain.AvatarEntity;

public interface AvatarRepository extends JpaRepository<AvatarEntity, Long> {
}
