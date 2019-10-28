package rental;

import java.util.Objects;

public class RentDetails {

    private int kilometersRented;
    private int daysRented;
    private boolean isLate;

    public RentDetails(int kilometersRented, int daysRented, boolean isLate) {
        this.kilometersRented = kilometersRented;
        this.daysRented = daysRented;
        this.isLate = isLate;
    }

    public int getKilometersRented() {
        return kilometersRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public boolean isLate() {
        return isLate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentDetails that = (RentDetails) o;
        return kilometersRented == that.kilometersRented &&
                daysRented == that.daysRented &&
                isLate == that.isLate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kilometersRented, daysRented, isLate);
    }
}
