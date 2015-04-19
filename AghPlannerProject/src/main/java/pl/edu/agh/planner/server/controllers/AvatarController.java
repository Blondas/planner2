package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.AvatarDao;
import pl.edu.agh.planner.shared.hibernate.entity.AvatarEntity;

import java.util.List;

@Controller("AvatarController")
public class AvatarController implements ControllerInterface<AvatarEntity, Integer> {

    private AvatarDao avatarDao;

    @Autowired
    public void setAvatarDao(AvatarDao avatarDao) {
        this.avatarDao = avatarDao;
    }

    @Override
    public AvatarEntity getById(Integer id) {
        return avatarDao.getById(id);
    }

    @Override
    public List<AvatarEntity> getList() {
        return avatarDao.getList();
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
}
