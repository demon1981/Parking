package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

    private long dateIn;
    private long dateOut;

    private String carNumber;

    private double amountOfParking ;

    public ParkingEvent() {   }

    public ParkingEvent(AutoModel autoModel, Customers customers, AutoCapacity autoCapacity) {
        this.autoModel = autoModel;
        this.customers = customers;
        this.autoCapacity = autoCapacity;
        this.dateIn = System.currentTimeMillis();
        this.amountOfParking = 0;
    }

    public String[] getFildsArray() {

        return new String[]{String.valueOf(this.id),
                            this.autoModel.getName(),
                            this.customers.getName(),

                            this.autoCapacity.getCapacity(),
                            new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(this.dateIn)),
                            this.dateOut == 0 ? "" : new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(this.dateOut)),
                            String.valueOf(this.amountOfParking)};
    }

    public void setDateOut() {
        this.dateOut = System.currentTimeMillis();
    }

    public void checkOutCar() {
        setDateOut();
        double autoCapacity = this.autoCapacity.getCostOfParking();

        int dayOfParking = (int)  Math.ceil(((this.dateOut - this.dateIn) / (24 * 60 * 60 * 1000)));

        this.amountOfParking = autoCapacity * dayOfParking;
    }


}
