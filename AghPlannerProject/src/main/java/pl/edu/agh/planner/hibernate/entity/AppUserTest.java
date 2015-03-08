package pl.edu.agh.planner.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.annotations.Test;

public class AppUserTest {

    @Test
    public void testApp() {
//        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml")
//                .buildSessionFactory();

//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        AppUser user = new AppUser("firstuser");
//        session.save(user);
//
//        session.getTransaction().commit();
//        session.close();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//
        AppUser user = new AppUser("firstuser");
        session.save(user);
//
        session.getTransaction().commit();
        session.close();
    }
}