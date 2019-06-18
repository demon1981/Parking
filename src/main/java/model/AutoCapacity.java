package model;

import javax.persistence.*;

@Entity
@Table(name = "AutoCapacity")
public class AutoCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String capacity;
    private double costOfParking;

    public AutoCapacity(){}
    
    public AutoCapacity(String capacity, double costOfParking) {
        this.capacity = capacity;
        this.costOfParking = costOfParking;
    }

    public int getId() { return id; }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public double getCostOfParking() {
        return costOfParking;
    }

    public void setCostOfParking(double costOfParking) {
        this.costOfParking = costOfParking;
    }
}
