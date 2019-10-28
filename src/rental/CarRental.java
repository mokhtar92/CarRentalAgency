package rental;

import car.Car;

import java.util.Objects;

public class CarRental {

    private Car car;
    private RentDetails rentDetails;

    public CarRental(Car car, RentDetails rentDetails) {
        this.car = car;
        this.rentDetails = rentDetails;
    }

    public Car getCar() {
        return car;
    }

    public RentDetails getRentDetails() {
        return rentDetails;
    }

    public double calculateRentCost() {
        return car.calculateRentCost(rentDetails);
    }

    public int calculateRewardPoints(int aggregatePoints) {
        return car.calculateRewardPoints(aggregatePoints, rentDetails);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRental carRental = (CarRental) o;
        return Objects.equals(car, carRental.car) &&
                Objects.equals(rentDetails, carRental.rentDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, rentDetails);
    }
}
