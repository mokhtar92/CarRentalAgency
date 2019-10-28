public class Main {

    public static void main(String[] args) {
        Vehicle blueHonda = new Vehicle("Blue Honda 2008", Vehicle.SEDAN);
        Vehicle greyJeep = new Vehicle("Grey Jeep 2013", Vehicle.FOURxFOUR);
        Vehicle RedSunny = new Vehicle("Red Sunny 2014", Vehicle.SEDAN);
        Vehicle BlueBMW = new Vehicle("Blue X3 2017", Vehicle.SUV);

        Rental hondaRental = new Rental(blueHonda, 431, 4, false);
        Rental jeepRental = new Rental(greyJeep, 744, 4, false);
        Rental sunnnyRental = new Rental(RedSunny, 591, 3, true);
        Rental x3Rental = new Rental(BlueBMW, 240, 5, false);

        Customer uber = new Customer("Uber");
        Customer hitlon = new Customer("Hilton");

        uber.addRental(hondaRental);
        uber.addRental(jeepRental);
        uber.addRental(sunnnyRental);

        hitlon.addRental(x3Rental);

        System.out.println(uber.statement());
    }
}
