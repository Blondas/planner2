package pl.edu.agh.planner.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.agh.planner.shared.hibernate.dao.LetterDesignationDao;
import pl.edu.agh.planner.shared.hibernate.entity.LetterDesignationEntity;

import java.util.List;

@Controller("letterDesignationController")
public class LetterDesignationController implements ControllerInterface<LetterDesignationEntity, Integer> {

    private LetterDesignationDao letterDesignationDao;

    @Autowired
    public void setLetterDesignationDao(LetterDesignationDao letterDesignationDao) {
        this.letterDesignationDao = letterDesignationDao;
    }

    @Override
    public LetterDesignationEntity getById(Integer id) {
        return letterDesignationDao.getById(id);
    }

    @Override
    public List<LetterDesignationEntity> getList() {
        return letterDesignationDao.getList();
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
}
