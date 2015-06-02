package pl.edu.agh.planner.service;

import pl.edu.agh.planner.domain.AvatarEntity;

import java.util.List;

public interface AvatarService {

    AvatarEntity getOne(Long id);

    List<AvatarEntity> findAll();

    void delete(Long id);

    AvatarEntity saveOrUpdate(AvatarEntity teacherEntity);

}
