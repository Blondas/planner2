package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.LetterDesignationDao;
import pl.edu.agh.planner.domain.LetterDesignationEntity;

import java.util.List;

@Service("letterDesignationService")
public class LetterDesignationService implements ServiceInterface<LetterDesignationEntity, Long>{

    private LetterDesignationDao letterDesignationDao;

    @Autowired
    public void setLetterDesignationDao(LetterDesignationDao letterDesignationDao) {
        this.letterDesignationDao = letterDesignationDao;
    }


    @Override
    public void add(LetterDesignationEntity letterDesignationEntity) {
        letterDesignationDao.add(letterDesignationEntity);
    }

    @Override
    public void add(List<LetterDesignationEntity> letterDesignationEntities) {
        letterDesignationDao.add(letterDesignationEntities);
    }

    @Override
    public void update(LetterDesignationEntity letterDesignationEntity) {
        letterDesignationDao.update(letterDesignationEntity);
    }

    @Override
    public void delete(LetterDesignationEntity letterDesignationEntity) {
        letterDesignationDao.delete(letterDesignationEntity);
    }

    @Override
    public LetterDesignationEntity getById(Long id) {
        return letterDesignationDao.getById(id);
    }

    @Override
    public List<LetterDesignationEntity> getList() {
        return letterDesignationDao.getList();
    }

    @Override
    public LetterDesignationEntity saveOrUpdate(LetterDesignationEntity entity) {
        return letterDesignationDao.saveOrUpdate(entity);
    }
}
