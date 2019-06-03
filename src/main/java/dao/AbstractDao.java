package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public abstract class AbstractDao <T> implements Dao{

    public T findById(Class<T> genericType, int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(genericType, id);
    }

    public void save(T value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(value);
        tx1.commit();
        session.close();
    }

    public void update(T value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(value);
        tx1.commit();
        session.close();
    }

    public void delete(T value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(value);
        tx1.commit();
        session.close();
    }

    public List<T> findAll(Class<T> clazz) {

       List<T> objectList = (List<T>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From " + clazz.getSimpleName()).list();

        return objectList;
    }


}
