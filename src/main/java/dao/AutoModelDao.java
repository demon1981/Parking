
package dao;

import model.AutoModel;
import model.Customers;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class AutoModelDao implements Dao{

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
//    public List<AutoModel> findAll() {
//        List<AutoModel> autoModelList = (List<AutoModel>) HibernateSessionFactoryUtil.getSessionFactory()
//                                .openSession().createQuery("From AutoModel").list();
//        return autoModelList;
//    }

    public List<String[]> findAll() {

        List<String[]> autoModelListString = new ArrayList<String[]>();

        List<AutoModel> autoModelList = (List<AutoModel>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From AutoModel").list();

        for (AutoModel autoModel :
                autoModelList) {
            autoModelListString.add(new String[]{autoModel.getName()});
        }

        return autoModelListString;
    }

}