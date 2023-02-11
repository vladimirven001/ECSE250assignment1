package assignment1;

public class Customer {

    private String name;

    private int balance;

    private Basket basket;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.basket = new Basket();
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public Basket getBasket() {
        return basket;
    }

    public int addFunds(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("The amount to be added is negative");
        }
        this.balance += amount;
        return this.balance;
    }

    public int addToBasket(Reservation r) {
        if ((r.reservationName()).equalsIgnoreCase(this.name)) {
            basket.add(r);
            return basket.getNumOfReservations();
        } else {
            throw new IllegalArgumentException("The name on this reservation does not match the name of the customer.");
        }
    }

    public int addToBasket(Hotel h, String type, int nights, boolean breakfast) {
        Reservation r;
        if (breakfast == true) {
            r = new BnBReservation(name, h, type, nights);
        } else {
            r = new HotelReservation(name, h, type, nights);
        }
        return this.addToBasket(r);
    }

    public int addToBasket(Airport a1, Airport a2) {
        Reservation r;
        try {
            r = new FlightReservation(name, a1, a2);
        } finally {
            return basket.getNumOfReservations();
        }
    }

    public boolean removeFromBasket(Reservation r) {
        return basket.remove(r);
    }

    public int checkOut() {
        int cost = basket.getTotalCost();
        if (cost > balance) {
            throw new IllegalStateException("Balance is not enough.");
        } else {
            balance -= cost;
            basket = new Basket();
            return balance;
        }

    }

}
