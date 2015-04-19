package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.AuthorizationDao;
import pl.edu.agh.planner.shared.hibernate.entity.AuthorizationEntity;

import java.util.List;

@Controller("AuthorizationController")
public class AuthorizationController implements ControllerInterface<AuthorizationEntity, Integer>{

    private AuthorizationDao authorizationDao;

    @Autowired
    public void setAuthorizationDao(AuthorizationDao authorizationDao) {
        this.authorizationDao = authorizationDao;
    }

    @Override
    public void add(AuthorizationEntity authorizationEntity) {
        authorizationDao.add(authorizationEntity);
    }

    @Override
    public void add(List<AuthorizationEntity> authorizationEntities) {
        authorizationDao.add(authorizationEntities);
    }

    @Override
    public AuthorizationEntity getById(Integer id) {
        return authorizationDao.getById(id);
    }

    @Override
    public List<AuthorizationEntity> getList() {
        return authorizationDao.getList();
    }

    @Override
    public void update(AuthorizationEntity authorizationEntity) {
        authorizationDao.update(authorizationEntity);
    }

    @Override
    public void delete(AuthorizationEntity authorizationEntity) {
        authorizationDao.delete(authorizationEntity);
    }
}
