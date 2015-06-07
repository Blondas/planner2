package datasources;

import pl.edu.agh.planner.dao.DepartmentDao;
import pl.edu.agh.planner.domain.DepartmentEntity;

public class DepartmentDataSource {

    private DepartmentDao departmentDao = new DepartmentDao();

    public DepartmentEntity createDepartmentEntity(String name){
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName(name);

        departmentDao.add(departmentEntity);

        return departmentEntity;
    }
}
