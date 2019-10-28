import car.Car;
import car.FourByFour;
import car.SUV;
import car.Sedan;
import customer.Customer;
import format.JSONFormat;
import rental.CarRental;
import rental.RentDetails;

public class Main {

    public static void main(String[] args) {
        Car blueHonda = new Sedan("Blue Honda 2008");
        Car greyJeep = new FourByFour("Grey Jeep 2013");
        Car RedSunny = new Sedan("Red Sunny 2014");
        Car BlueBMW = new SUV("Blue X3 2017");

        RentDetails hondaDetails = new RentDetails(431, 4, false);
        CarRental hondaRental = new CarRental(blueHonda, hondaDetails);

        RentDetails jeepDetails = new RentDetails(744, 4, false);
        CarRental jeepRental = new CarRental(greyJeep, jeepDetails);

        RentDetails sunnyDetails = new RentDetails(591, 3, true);
        CarRental sunnyRental = new CarRental(RedSunny, sunnyDetails);

        RentDetails x3Details = new RentDetails(240, 5, false);
        CarRental x3Rental = new CarRental(BlueBMW, x3Details);

        Customer uber = new Customer("Uber");
        Customer hilton = new Customer("Hilton");

        uber.addCarRental(hondaRental);
        uber.addCarRental(jeepRental);
        uber.addCarRental(sunnyRental);

        hilton.addCarRental(x3Rental);

        System.out.println(uber.statement());

        System.out.println(uber.statement(JSONFormat.getInstance()));
    }
}
