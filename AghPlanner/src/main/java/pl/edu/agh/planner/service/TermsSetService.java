package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.TermsSetDao;
import pl.edu.agh.planner.domain.TermsSetEntity;

import java.util.List;

@Service("termsSetService")
public class TermsSetService implements ServiceInterface<TermsSetEntity, Long> {

    private TermsSetDao termsSetDao;

    @Autowired
    public void setTermsSetDao(TermsSetDao termsSetDao) {
        this.termsSetDao = termsSetDao;
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

    @Override
    public TermsSetEntity getById(Long id) {
        return termsSetDao.getById(id);
    }

    @Override
    public List<TermsSetEntity> getList() {
        return termsSetDao.getList();
    }

    @Override
    public TermsSetEntity saveOrUpdate(TermsSetEntity entity) {
        return termsSetDao.saveOrUpdate(entity);
    }
}
