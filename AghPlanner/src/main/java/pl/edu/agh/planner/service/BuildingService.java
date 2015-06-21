package pl.edu.agh.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.planner.dao.BuildingDao;
import pl.edu.agh.planner.domain.BuildingEntity;

import java.util.List;

@Service("buildingService")
public class BuildingService {


    private BuildingDao buildingDao;

    @Autowired
    public void setBuildingDao(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    public List<BuildingEntity> getList() {
        return buildingDao.getList();
    }
}
