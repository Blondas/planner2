package datasources;

import pl.edu.agh.planner.dao.AggregateDao;
import pl.edu.agh.planner.domain.AggregateEntity;
import pl.edu.agh.planner.domain.AvatarEntity;
import pl.edu.agh.planner.domain.ProgrammeUnitEntity;
import pl.edu.agh.planner.domain.StudentGroupEntity;

public class AggregateDataSource {

    private AggregateDao aggregateDao = new AggregateDao();

    public AggregateEntity createAggregate(AvatarEntity avatarEntity, ProgrammeUnitEntity programmeUnitEntity, StudentGroupEntity studentGroupEntity){
        AggregateEntity aggregateEntity = new AggregateEntity();
        aggregateEntity.setAvatar(avatarEntity);
        aggregateEntity.setProgrammeUnit(programmeUnitEntity);
        aggregateEntity.setStudentGroup(studentGroupEntity);

        aggregateDao.add(aggregateEntity);

        return aggregateEntity;
    }
}
