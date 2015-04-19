package pl.edu.agh.planner.shared.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.shared.hibernate.dao.AuthorizationTypeDao;
import pl.edu.agh.planner.shared.hibernate.entity.AuthorizationTypeEntity;

import java.util.List;

@Service("authorizationTypeService")
public class AuthorizationTypeService implements ServiceInterface<AuthorizationTypeEntity, Integer> {

    private AuthorizationTypeDao authorizationTypeDao;

    @Autowired
    public void setAuthorizationTypeDao(AuthorizationTypeDao authorizationTypeDao) {
        this.authorizationTypeDao = authorizationTypeDao;
    }

    @Override
    public void add(AuthorizationTypeEntity authorizationTypeEntity) {
        authorizationTypeDao.add(authorizationTypeEntity);
    }

    @Override
    public void add(List<AuthorizationTypeEntity> authorizationTypeEntities) {
        authorizationTypeDao.add(authorizationTypeEntities);
    }

    @Override
    public void update(AuthorizationTypeEntity authorizationTypeEntity) {
        authorizationTypeDao.add(authorizationTypeEntity);
    }

    @Override
    public void delete(AuthorizationTypeEntity authorizationTypeEntity) {
        authorizationTypeDao.delete(authorizationTypeEntity);
    }

    @Override
    public AuthorizationTypeEntity getById(Integer id) {
        return authorizationTypeDao.getById(id);
    }

    @Override
    public List<AuthorizationTypeEntity> getList() {
        return authorizationTypeDao.getList();
    }
}
