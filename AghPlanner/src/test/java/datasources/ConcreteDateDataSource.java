package datasources;

import pl.edu.agh.planner.dao.ConcreteDateDao;
import pl.edu.agh.planner.domain.ConcreteDateEntity;

import java.util.Date;
import java.util.Random;

public class ConcreteDateDataSource {

    private ConcreteDateDao concreteDateDao = new ConcreteDateDao();

    public ConcreteDateEntity createConcreteDate(Date date){
        ConcreteDateEntity concreteDateEntity = new ConcreteDateEntity();
        concreteDateEntity.setRealDate(date);

        concreteDateDao.add(concreteDateEntity);

        return concreteDateEntity;
    }
}
