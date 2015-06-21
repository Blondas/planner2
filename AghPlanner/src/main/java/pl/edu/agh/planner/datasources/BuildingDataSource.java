package pl.edu.agh.planner.datasources;

import pl.edu.agh.planner.dao.BuildingDao;
import pl.edu.agh.planner.domain.BuildingEntity;

public class BuildingDataSource {

    BuildingDao buildingDao = new BuildingDao();

    public BuildingEntity createBuilding(String name){
        BuildingEntity building = new BuildingEntity();
        building.setName(name);

        buildingDao.add(building);

        return building;
    }
}
