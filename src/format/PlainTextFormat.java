package format;

import customer.Customer;
import rental.CarRental;

import java.util.List;

public class PlainTextFormat implements StatementFormat {

    private static PlainTextFormat instance;

    private PlainTextFormat() {
    }

    public static PlainTextFormat getInstance() {
        if (instance == null) {
            synchronized (PlainTextFormat.class) {
                if (instance == null) {
                    instance = new PlainTextFormat();
                }
            }
        }

        return instance;
    }

    @Override
    public String printStatement(Customer customer) {

        double totalCost = 0;
        int rewardPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for:" + customer.getName() + "\n");

        List<CarRental> carRentalList = customer.getCarRentalList();

        for (CarRental carRental : carRentalList) {

            double costPerCar = carRental.calculateRentCost();

            result.append("\t\"")
                    .append(carRental.getCar().getMakeAndModel())
                    .append("\"\tLE ")
                    .append(String.valueOf(costPerCar))
                    .append("\n");

            rewardPoints = carRental.calculateRewardPoints(rewardPoints);
            totalCost += costPerCar;
        }

        result.append("Amount owed is LE ")
                .append(String.valueOf(totalCost))
                .append("\n");

        result.append("You earned: ")
                .append(String.valueOf(rewardPoints))
                .append(" new Reward Points\n\n");

        return result.toString();
    }
}
