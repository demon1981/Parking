
package dao;

import model.Customers;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomersDao implements Dao{

    public Customers findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customers.class, id);
    }

    public void save(String name) {
        save(new Customers(name));
    }

    public void save(Customers name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(name);
        tx1.commit();
        session.close();
    }

    public void update(Customers name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(name);
        tx1.commit();
        session.close();
    }

    public void delete(Customers name) {
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
    public List<String[]> findAll() {

        List<String[]> customerslListString = new ArrayList<String[]>();

        List<Customers> customerslList = (List<Customers>) HibernateSessionFactoryUtil.getSessionFactory()
                                .openSession().createQuery("From Customers").list();

        for (Customers customers :
                customerslList) {
            customerslListString.add(new String[]{customers.getName()});
        }

        return customerslListString;
    }
}