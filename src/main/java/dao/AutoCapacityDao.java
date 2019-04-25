
package dao;

import model.AutoCapacity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class AutoCapacityDao implements Dao{

    public AutoCapacity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AutoCapacity.class, id);
    }

    public void save(String name, double costOfParcing) {
        save(new AutoCapacity(name, costOfParcing));
    }

    public void save(AutoCapacity name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(name);
        tx1.commit();
        session.close();
    }

    public void update(AutoCapacity name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(name);
        tx1.commit();
        session.close();
    }

    public void delete(AutoCapacity name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(name);
        tx1.commit();
        session.close();
    }

    public List<String[]> findAll() {

        List<String[]> customerslListString = new ArrayList<String[]>();

        List<AutoCapacity> customerslList = (List<AutoCapacity>) HibernateSessionFactoryUtil.getSessionFactory()
                                .openSession().createQuery("From AutoCapacity").list();

        for (AutoCapacity autoCapacity :
                customerslList) {
            customerslListString.add(new String[]{autoCapacity.getCapacity(), Double.toString(autoCapacity.getCostOfParking())});
        }

        return customerslListString;
    }
}