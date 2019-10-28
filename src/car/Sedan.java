package car;

import rental.RentDetails;

public class Sedan extends Car {

    public Sedan(String makeAndModel) {
        super(makeAndModel);
    }

    @Override
    public double calculateRentCost(RentDetails rentDetails) {
        double rentCost = 50.0;
        int daysRented = rentDetails.getDaysRented();
        int kilometersRented = rentDetails.getKilometersRented();

        rentCost += 100 * daysRented;

        if (kilometersRented > daysRented * 50) {
            rentCost += (kilometersRented - daysRented * 50) * 2;
        }

        if (rentDetails.isLate()) {
            rentCost += rentCost * 0.03;
        }

        return rentCost;
    }

    @Override
    public int calculateRewardPoints(int aggregatePoints, RentDetails rentDetails) {

        if (!rentDetails.isLate()) {
            aggregatePoints++;
        }

        return aggregatePoints;
    }
}
