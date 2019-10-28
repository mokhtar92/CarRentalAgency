package customer;

import format.PlainTextFormat;
import format.StatementFormat;
import rental.CarRental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<CarRental> carRentalList;

    public Customer(String name) {
        this.name = name;
        this.carRentalList = new ArrayList<>();
    }

    public Customer(String name, List<CarRental> carRentalList) {
        this.name = name;
        this.carRentalList = carRentalList;
    }

    public void addCarRental(CarRental carRental) {
        carRentalList.add(carRental);
    }

    public String statement(StatementFormat format) {
        return format.printStatement(this);
    }

    public String statement() {
        return statement(PlainTextFormat.getInstance());
    }

    public String getName() {
        return name;
    }

    public List<CarRental> getCarRentalList() {
        return carRentalList;
    }
}