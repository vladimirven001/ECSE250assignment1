import assignment1.Airport;
import assignment1.Room;

import static assignment1.Airport.getDistance;

public class Main {
    public static void main(String[] args) {

        //Ask why Room is red

        Room double1 = new Room("double");
        Room queen1 = new Room("queen");
        Room king1 = new Room("king");

        //Should throw IllegalArgumentException
        try {
            Room twin = new Room("twin");
        } catch (Exception e) {
            System.out.println("Invalid room type caught: " + e);
        }

        //Check if fields were properly written to
        System.out.println(double1.getPrice() + "," + double1.getType() + "," + double1.available);
        System.out.println(queen1.getPrice() + "," + queen1.getType() + "," + queen1.available);
        System.out.println(king1.getPrice() + "," + king1.getType() + "," + king1.available);

        //Check changeAvailability
        double1.changeAvailability();
        System.out.println(double1.available);

        //Check copy constructor
        Room double2 = new Room(double1);
        System.out.println((double1.roomType.equals(double2.roomType)) && (double1.roomPrice == double2.roomPrice) && (double1.available == double2.available));

        //Create array of rooms to test final two methods
        //No doubles are available, queen and king are
        Room[] rooms = {double1, queen1, king1, double2};
        System.out.println("Searching for rooms of type double:" + findAvailableRoom(rooms, "double")); //null
        System.out.println("Searching for rooms of type queen:" + findAvailableRoom(rooms, "queen")); //not null
        System.out.println("Searching for rooms of type king:" + findAvailableRoom(rooms, "king")); //not null

        //Make double available, and then recheck for availability
        System.out.println(makeRoomAvailable(rooms, "double"));
        System.out.println("Searching for rooms of type double:" + findAvailableRoom(rooms, "double"));
        //Try to make a queen available (you can't)
        System.out.println(makeRoomAvailable(rooms, "queen"));
    }
}