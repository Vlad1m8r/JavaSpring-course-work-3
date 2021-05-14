package david.carprokat.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String carVIN;

    @Column
    private String carNumber;

    @Column
    private String carModel;

    @Column
    private String carMake;

    @Column
    private String cost;

    @Column
    private String type;

    @Column
    private String carColor;

    @Column
    private String carModelYear;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Car() {
    }


    public Car(String carVIN, String carNumber, String carModel, String carMake, String cost, String type, String carColor, String carModelYear) {
        this.carVIN = carVIN;
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.carMake = carMake;
        this.cost = cost;
        this.type = type;
        this.carColor = carColor;
        this.carModelYear = carModelYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarVIN() {
        return carVIN;
    }

    public void setCarVIN(String carVin) {
        this.carVIN = carVin;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(String carModelYear) {
        this.carModelYear = carModelYear;
    }
}
