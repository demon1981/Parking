
package dao;

import model.Customers;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomersDao extends AbstractDao<Customers>{

    public Customers findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customers.class, id);
    }

    public void save(String name) {
        super.save(new Customers(name));
    }

    public List<Customers> findAll() {
        return super.findAll(Customers.class);
    }

    public List<String[]> returnFieldsToView() {

        List<String[]> customersListString = new ArrayList<String[]>();
        List<Customers> customersList = findAll();

        for (Customers customers :
                customersList) {
            customersListString.add(new String[]{ String.valueOf(customers.getId()), customers.getName()});
        }
        return customersListString;
    }
}