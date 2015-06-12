package datasources;

import pl.edu.agh.planner.dao.UserDao;
import pl.edu.agh.planner.domain.UserEntity;

public class UserDataSource {

    private UserDao userDao = new UserDao();

    public UserEntity createUser(String login, String password){
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(login);
        userEntity.setPassword(password);

        userDao.add(userEntity);

        return userEntity;
    }
}
