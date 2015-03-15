package pl.edu.agh.planner.hibernate.dao;

import junit.framework.TestCase;
import org.testng.annotations.Test;

public class AggregateDaoTest extends TestCase {

    @Test
    public void testGetById() throws Exception {
        AggregateDao aggregate = new AggregateDao();
        aggregate.getById(1);
    }
}