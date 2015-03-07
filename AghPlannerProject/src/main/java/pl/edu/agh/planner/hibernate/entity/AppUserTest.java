package pl.edu.agh.planner.hibernate.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

public class AppUserTest {

    @Test
    public void testApp() {
        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml")
                .buildSessionFactory();

//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        AppUser user = new AppUser("firstuser");
//        session.save(user);
//
//        session.getTransaction().commit();
//        session.close();

//        Session session = (Session) HibernateUtil.getSessionFactory();
//        session.beginTransaction();
//
//        AppUser user = new AppUser("firstuser");
//        session.save(user);
//
//        session.getTransaction().commit();
//        session.close();
    }
}