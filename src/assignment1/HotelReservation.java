package assignment1;

public class HotelReservation extends Reservation {

    private Hotel h;

    private String type;

    private int nights;

    private int price;

    public HotelReservation(String name, Hotel h, String type, int nights) {

        super(name);

        this.h = h;
        this.type = type;
        this.nights = nights;

        try {
            this.price = h.reserveRoom(this.type);
        }
        catch(NullPointerException e) {
            throw new IllegalArgumentException("A room of such type is not available.");
        }

    }

    public int getNumOfNights() { return this.nights; }

    public int getCost() { return this.price * this.nights; }

    public boolean equals(Object o) {
        if(o instanceof HotelReservation && (((HotelReservation)o).reservationName()).equalsIgnoreCase(this.reservationName())
                && ((HotelReservation)o).h == this.h && (((HotelReservation)o).type).equalsIgnoreCase(this.type)
                && ((HotelReservation)o).nights == this.nights && ((HotelReservation)o).getCost() == this.getCost()) {
            return true;
        }
        return false;
    }


}
