package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.AuthorizationDao;
import pl.edu.agh.planner.domain.AuthorizationEntity;

import java.util.List;

@Service("authorizationService")
public class AuthorizationService implements ServiceInterface<AuthorizationEntity, Long> {

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
    public void update(AuthorizationEntity authorizationEntity) {
        authorizationDao.update(authorizationEntity);
    }

    @Override
    public void delete(AuthorizationEntity authorizationEntity) {
        authorizationDao.delete(authorizationEntity);
    }

    @Override
    public AuthorizationEntity getById(Long id) {
        return authorizationDao.getById(id);
    }

    @Override
    public List<AuthorizationEntity> getList() {
        return authorizationDao.getList();
    }

    @Override
    public AuthorizationEntity saveOrUpdate(AuthorizationEntity entity) {
        return authorizationDao.saveOrUpdate(entity);
    }
}
