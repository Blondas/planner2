package datasources;

import pl.edu.agh.planner.dao.LetterDesignationDao;
import pl.edu.agh.planner.domain.LetterDesignationEntity;

public class LetterDesignationDataSource {

    private LetterDesignationDao letterDesignationDao = new LetterDesignationDao();

    public LetterDesignationEntity createLetterDesignation(String name){
        LetterDesignationEntity letterDesignationEntity = new LetterDesignationEntity();
        letterDesignationEntity.setName(name);

        letterDesignationDao.add(letterDesignationEntity);

        return letterDesignationEntity;
    }

}
