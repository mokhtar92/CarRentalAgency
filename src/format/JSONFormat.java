package format;

import customer.Customer;
import rental.CarRental;

import java.util.List;

public class JSONFormat implements StatementFormat {

    private static JSONFormat instance;

    private JSONFormat() {
    }

    public static JSONFormat getInstance() {
        if (instance == null) {
            synchronized (JSONFormat.class) {
                if (instance == null) {
                    instance = new JSONFormat();
                }
            }
        }

        return instance;
    }

    @Override
    public String printStatement(Customer customer) {
        double totalCost = 0;
        int rewardPoints = 0;

        List<CarRental> carRentalList = customer.getCarRentalList();
        int lastIndex = carRentalList.size() - 1;

        StringBuilder costBuilder = new StringBuilder();

        for (CarRental carRental : carRentalList) {

            double costPerCar = carRental.calculateRentCost();

            costBuilder.append("\n\t\t{")
                    .append("\n\t\t\t\"car_make\": \"")
                    .append(carRental.getCar().getMakeAndModel())
                    .append("\",")
                    .append("\n\t\t\t\"rent_cost\": ")
                    .append(costPerCar)
                    .append("\n\t\t}");

            if (carRental != carRentalList.get(lastIndex)) costBuilder.append(",");

            rewardPoints = carRental.calculateRewardPoints(rewardPoints);
            totalCost += costPerCar;
        }


        StringBuilder result = new StringBuilder();

        result.append("{")
                .append("\n\t")
                .append("\"customer_name\": \"")
                .append(customer.getName())
                .append("\",")
                .append("\n\t")
                .append("\"reward_points\": ")
                .append(rewardPoints)
                .append(",")
                .append("\n\t")
                .append("\"total_rent_cost\": ")
                .append(totalCost)
                .append(",")
                .append("\n\t")
                .append("\"currency\": \"")
                .append("LE")
                .append("\",")
                .append("\n\t")
                .append("\"rent_details\": [")
                .append(costBuilder)
                .append("\n\t]")
                .append("\n}");

        return result.toString();
    }
}
