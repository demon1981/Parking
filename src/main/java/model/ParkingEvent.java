package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "ParkingEvent")
public class ParkingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "autoModel_id", referencedColumnName = "id")
    private AutoModel autoModel;
    @ManyToOne
    @JoinColumn(name = "customers_id", referencedColumnName = "id")
    private Customers customers;
    @ManyToOne
    @JoinColumn(name = "autoCapacity_id", referencedColumnName = "id")
    private AutoCapacity autoCapacity;

    //private Timestamp dateIn;
    private Date dateIn;
    private Date dateOut;

    private double amountOfParking;

    public ParkingEvent() {   }

    public ParkingEvent(AutoModel autoModel, Customers customers, AutoCapacity autoCapacity) {
        this.autoModel = autoModel;
//        this.customers = customers;
//        this.autoCapacity = autoCapacity;
//        this.dateIn = new Date();
    }

//    public void setDateOut(Date dateOut) {
//        this.dateOut = dateOut;
//
//
//    }


}
