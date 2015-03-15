package pl.edu.agh.planner.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.agh.planner.hibernate.utils.HibernateUtil;

public abstract class GenericQuery {
    private Transaction transaction = null;
    protected Session session;


    public final void beginTransaction(){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
        }catch (RuntimeException e) {
            rollback(e);
        }
    }

    public final void endTransaction(){
        try {
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            rollback(e);
        } finally {
            session.flush();
            session.close();
            transaction=null;
            session=null;
        }

    }

    private void rollback(RuntimeException e){
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }

    public Session getSession()
    {
        return session;}
}
