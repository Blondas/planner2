package pl.edu.agh.planner.datasources;

import pl.edu.agh.planner.dao.AvatarDao;
import pl.edu.agh.planner.domain.AvatarEntity;

public class AvatarDataSource {

    private AvatarDao avatarDao = new AvatarDao();

    public AvatarEntity createAvatar(String name){
        AvatarEntity avatarEntity = new AvatarEntity();
        avatarEntity.setName(name);

        avatarDao.add(avatarEntity);

        return avatarEntity;
    }

}