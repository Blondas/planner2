package datasources;

import pl.edu.agh.planner.dao.AvatarDao;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.domain.TeacherEntity;

/**
 * Created by krystian on 06.06.15.
 */
public class AvatarDataSource {

    private AvatarDao avatarDao = new AvatarDao();

    public AvatarEntity createAvatar(String name){
        AvatarEntity avatarEntity = new AvatarEntity();
        avatarEntity.setName(name);

        avatarDao.add(avatarEntity);

        return avatarEntity;
    }

}