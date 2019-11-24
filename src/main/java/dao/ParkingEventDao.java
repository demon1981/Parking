package dao;

import model.AutoCapacity;
import model.AutoModel;
import model.Customers;
import model.ParkingEvent;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class ParkingEventDao extends AbstractDao<ParkingEvent> {

//    public ParkingEvent findById(int id) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ParkingEvent.class, id);
//    }

    public void save(AutoModel autoModel, Customers customers, AutoCapacity autoCapacity, String autoNumber) {
        save(new ParkingEvent(autoModel, customers, autoCapacity, autoNumber));
    }

    public List<ParkingEvent> findAll() {
        return super.findAll(ParkingEvent.class);
    }

    public List<String[]> returnFieldsToView() {

        List<String[]> parkingEventListString = new ArrayList<String[]>();
        List<ParkingEvent> parkingEventList = super.findAll(ParkingEvent.class);

        for (ParkingEvent parkingEvent :
                parkingEventList) {
            parkingEventListString.add(parkingEvent.getFildsArray());
        }

        return parkingEventListString;
    }
}
