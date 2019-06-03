
package dao;

import model.AutoCapacity;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class AutoCapacityDao extends AbstractDao<AutoCapacity>{

    public AutoCapacity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AutoCapacity.class, id);
    }

    public void save(String name, double costOfParcing) {
        save(new AutoCapacity(name, costOfParcing));
    }


    public List<AutoCapacity> findAll() {
        return super.findAll(AutoCapacity.class);
    }

    public List<String[]> returnFieldsToView() {

        List<String[]> customersListString = new ArrayList<String[]>();
        List<AutoCapacity> customersList = findAll();

        for (AutoCapacity autoCapacity :
                customersList) {
            customersListString.add(new String[]{autoCapacity.getCapacity(), Double.toString(autoCapacity.getCostOfParking())});
        }

        return customersListString;
    }
}