package pl.edu.agh.planner.hibernate.dao;

import org.junit.Test;

import static org.testng.Assert.*;

public class AggregateDaoTest {

	@Test
	public void testGetById() throws Exception {
		AggregateDao aggregate = new AggregateDao();
		aggregate.getById(1);
	}

}