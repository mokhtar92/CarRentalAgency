package car;

import rental.RentDetails;

public class FourByFour extends Car {

    public FourByFour(String makeAndModel) {
        super(makeAndModel);
    }

    @Override
    public double calculateRentCost(RentDetails rentDetails) {
        double rentCost = 50.0;
        int daysRented = rentDetails.getDaysRented();

        rentCost += 200 * daysRented;

        if (rentDetails.getKilometersRented() >= 200 && daysRented > 10) {
            rentCost -= rentCost * 0.05;
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
            aggregatePoints *= 2;
        }

        return aggregatePoints;
    }
}
