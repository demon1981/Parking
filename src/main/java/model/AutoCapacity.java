package model;

import javax.persistence.*;

@Entity
@Table(name = "AutoCapacity")
public class AutoCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Capacity;

    private double CostOfParking;

    public AutoCapacity(String capacity, double costOfParking) {
        Capacity = capacity;
        CostOfParking = costOfParking;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public double getCostOfParking() {
        return CostOfParking;
    }

    public void setCostOfParking(double costOfParking) {
        CostOfParking = costOfParking;
    }
}
