package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ParkingEvent")
public class ParkingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private AutoModel autoModel;
    @OneToOne
    private Customers customers;
    @OneToOne
    private AutoCapacity autoCapacity;

    private Date dateIn;
    private Date dateOut;

    private Double sum;

    public ParkingEvent() {  }

    public ParkingEvent(AutoModel autoModel, Customers customers, AutoCapacity autoCapacity) {
        this.autoModel = autoModel;
        this.customers = customers;
        this.autoCapacity = autoCapacity;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;


    }


}
