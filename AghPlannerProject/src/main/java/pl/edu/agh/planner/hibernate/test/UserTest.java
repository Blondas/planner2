package pl.edu.agh.planner.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.annotations.Test;
import pl.edu.agh.planner.hibernate.entity.User;
import pl.edu.agh.planner.hibernate.others.HibernateUtil;

public class UserTest {

    @Test
    public void testUser() {
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
        User user = new User();
        user.setLogin("firstUser");
        session.save(user);
//
        session.getTransaction().commit();
        session.close();
    }
}