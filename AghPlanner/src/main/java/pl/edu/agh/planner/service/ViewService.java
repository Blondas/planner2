package pl.edu.agh.planner.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.ViewDao;
import pl.edu.agh.planner.domain.ViewEntity;

import java.util.List;

@Service("viewService")
public class ViewService implements ServiceInterface<ViewEntity, Long> {

    private ViewDao viewDao = new ViewDao();

    @Autowired
    public void setViewDao(ViewDao viewDao) { this.viewDao = viewDao; }

    @Override
    public void add(ViewEntity entity) {
        viewDao.add(entity);
    }

    @Override
    public void add(List<ViewEntity> object) { viewDao.add(object); }

    @Override
    public void update(ViewEntity entity) {
        viewDao.update(entity);
    }

    @Override
    public void delete(ViewEntity entity) {
        viewDao.delete(entity);
    }

    @Override
    public ViewEntity getById(Long id) {
        return viewDao.getById(id);
    }

    @Override
    public List<ViewEntity> getList() {
        return viewDao.getList();
    }

    @Override
    public ViewEntity saveOrUpdate(ViewEntity entity) {
        return viewDao.saveOrUpdate(entity);
    }
}