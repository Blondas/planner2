package pl.edu.agh.planner.shared.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.shared.hibernate.dao.AvatarDao;
import pl.edu.agh.planner.shared.hibernate.entity.AvatarEntity;

import java.util.List;

@Service("avatarService")
public class AvatarService implements ServiceInterface<AvatarEntity, Integer> {

    private AvatarDao avatarDao;

    @Autowired
    public void setAvatarDao(AvatarDao avatarDao) {
        this.avatarDao = avatarDao;
    }

    @Override
    public void add(AvatarEntity avatarEntity) {
        avatarDao.add(avatarEntity);
    }

    @Override
    public void add(List<AvatarEntity> avatarEntities) {
        avatarDao.add(avatarEntities);
    }

    @Override
    public void update(AvatarEntity avatarEntity) {
        avatarDao.update(avatarEntity);
    }

    @Override
    public void delete(AvatarEntity avatarEntity) {
        avatarDao.delete(avatarEntity);
    }

    @Override
    public AvatarEntity getById(Integer id) {
        return avatarDao.getById(id);
    }

    @Override
    public List<AvatarEntity> getList() {
        return avatarDao.getList();
    }

}
