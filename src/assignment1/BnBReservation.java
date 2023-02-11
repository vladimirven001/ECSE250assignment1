package assignment1;

public class BnBReservation extends HotelReservation {

    public BnBReservation(String name,Hotel h, String type, int nights) {
        super(name, h, type, nights);
    }

    public int getCost() {
        return (super.getCost() + this.getNumOfNights() * 1000);
    }


}
