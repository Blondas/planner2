package pl.edu.agh.planner.dao;

import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.BuildingEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("buildingDao")
public class BuildingDao extends GenericQuery {

    public List<BuildingEntity> getList() {
        beginTransaction();
        List<BuildingEntity> list = session.createCriteria(BuildingEntity.class).list();
        endTransaction();
        return list;
    }

    public void add(BuildingEntity building) {
        beginTransaction();
        getSession().save(building);
        endTransaction();
    }

}
