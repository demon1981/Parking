package dao;

import model.AutoCapacity;
import model.AutoModel;
import model.Customers;
import model.ParkingEvent;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class ParkingEventDao extends AbstractDao<ParkingEvent> {

    public ParkingEvent findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ParkingEvent.class, id);
    }

    public void save(AutoModel autoModel, Customers customers, AutoCapacity autoCapacity) {
        save(new ParkingEvent(autoModel, customers, autoCapacity));
    }

    public List<ParkingEvent> findAll() {
        return super.findAll(ParkingEvent.class);
    }

    public List<String[]> returnFieldsToView() {

        List<String[]> parkingEventListString = new ArrayList<String[]>();
        /*List<ParkingEvent> parkingEventList = (List<ParkingEvent>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From ParkingEvent").list();*/
        List<ParkingEvent> parkingEventList = super.findAll(ParkingEvent.class);

        for (ParkingEvent parkingEvent :
                parkingEventList) {
            parkingEventListString.add(new String[]{parkingEvent.toString()});
        }

        return parkingEventListString;
    }
}
