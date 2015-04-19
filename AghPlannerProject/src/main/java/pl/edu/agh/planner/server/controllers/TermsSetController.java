package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.TermsSetDao;
import pl.edu.agh.planner.shared.hibernate.entity.TermsSetEntity;

import java.util.List;

@Controller
public class TermsSetController implements ControllerInterface<TermsSetEntity, Integer>{

    private TermsSetDao termsSetDao;

    @Autowired
    public void setTermsSetDao(TermsSetDao termsSetDao) {
        this.termsSetDao = termsSetDao;
    }

    @Override
    public TermsSetEntity getById(Integer id) {
        return termsSetDao.getById(id);
    }

    @Override
    public List<TermsSetEntity> getList() {
        return termsSetDao.getList();
    }

    @Override
    public void add(TermsSetEntity termsSetEntity) {
        termsSetDao.add(termsSetEntity);
    }

    @Override
    public void add(List<TermsSetEntity> termsSetEntities) {
        termsSetDao.add(termsSetEntities);
    }

    @Override
    public void update(TermsSetEntity termsSetEntity) {
        termsSetDao.update(termsSetEntity);
    }

    @Override
    public void delete(TermsSetEntity termsSetEntity) {
        termsSetDao.delete(termsSetEntity);
    }
}
