
package dao;

import model.AutoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AutoModelDao {

    public AutoModel findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AutoModel.class, id);
    }

    public void save(String name) {
        save(new AutoModel(name));
    }

    public void save(AutoModel name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(name);
        tx1.commit();
        session.close();
    }

    public void update(AutoModel name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(name);
        tx1.commit();
        session.close();
    }

    public void delete(AutoModel name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(name);
        tx1.commit();
        session.close();
    }
//
//    public Auto findAutoById(int id) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
//    }
//
    public List<AutoModel> findAll() {
        List<AutoModel> autoModelList = (List<AutoModel>) HibernateSessionFactoryUtil.getSessionFactory()
                                .openSession().createQuery("From AutoModel").list();
        return autoModelList;
    }
}