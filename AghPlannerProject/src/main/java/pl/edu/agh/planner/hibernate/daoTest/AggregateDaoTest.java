package pl.edu.agh.planner.hibernate.daoTest;

import junit.framework.TestCase;
import org.testng.annotations.Test;
import pl.edu.agh.planner.hibernate.dao.AggregateDao;

public class AggregateDaoTest extends TestCase {

    @Test
    public void testGetById() throws Exception {
        AggregateDao aggregate = new AggregateDao();
        aggregate.getById(1);
    }
}