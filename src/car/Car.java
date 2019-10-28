package car;

import rental.RentDetails;

import java.util.Objects;

abstract public class Car {

    private String makeAndModel;

    public Car(String makeAndModel) {
        this.makeAndModel = makeAndModel;
    }

    public abstract double calculateRentCost(RentDetails rentDetails);

    public abstract int calculateRewardPoints(int aggregatePoints, RentDetails rentDetails);

    public String getMakeAndModel() {
        return makeAndModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(makeAndModel, car.makeAndModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(makeAndModel);
    }
}
