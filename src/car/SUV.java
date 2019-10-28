package car;

import rental.RentDetails;

public class SUV extends Car {

    public SUV(String makeAndModel) {
        super(makeAndModel);
    }

    @Override
    public double calculateRentCost(RentDetails rentDetails) {
        double rentCost = 50.0;
        int daysRented = rentDetails.getDaysRented();
        int kilometersRented = rentDetails.getKilometersRented();

        rentCost += 150 * daysRented;

        if (kilometersRented > daysRented * 70) {
            rentCost += (kilometersRented - daysRented * 70) * 2;
        }

        if (kilometersRented >= 200) {
            rentCost -= rentCost * 0.05;
        }

        if (rentDetails.isLate()) {
            rentCost += rentCost * 0.03;
        }

        return rentCost;
    }

    @Override
    public int calculateRewardPoints(int aggregatePoints, RentDetails rentDetails) {

        int daysRented = rentDetails.getDaysRented();

        if (!rentDetails.isLate()) {
            aggregatePoints++;

            if (daysRented > 5) {
                aggregatePoints += (daysRented - 5);
            }
        }

        return aggregatePoints;
    }
}
