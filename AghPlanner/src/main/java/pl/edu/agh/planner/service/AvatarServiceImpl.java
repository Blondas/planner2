package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.repository.AvatarRepository;

import java.util.List;

@Service
public class AvatarServiceImpl implements AvatarService{

    private AvatarRepository avatarRepository;

    @Autowired
    public void setAvatarRepository(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    @Override
    public AvatarEntity getOne(Long id) {
        return avatarRepository.getOne(id);
    }

    @Override
    public List<AvatarEntity> findAll() {
        return avatarRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        avatarRepository.delete(id);
    }

    @Override
    public AvatarEntity saveOrUpdate(AvatarEntity teacherEntity) {
        return avatarRepository.save(teacherEntity);
    }
}
