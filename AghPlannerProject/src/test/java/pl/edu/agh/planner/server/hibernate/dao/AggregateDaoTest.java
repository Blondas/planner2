package pl.edu.agh.planner.server.hibernate.dao;

import org.junit.Test;

public class AggregateDaoTest {

	@Test
	public void testGetById() throws Exception {
		AggregateDao aggregate = new AggregateDao();
		aggregate.getById(1);
	}

}