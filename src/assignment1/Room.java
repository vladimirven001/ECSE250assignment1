package assignment1;

public class Room {

    private String type;
    private int cost;
    private boolean available;


    public Room(String type) {

        switch (type) {
            case "double":
                this.cost = 9000;
                break;
            case "queen":
                this.cost = 11000;
                break;
            case "king":
                this.cost = 15000;
                break;
            default:
                throw new IllegalArgumentException("No room of such type can be created.");
        }

        
        this.type = type;

        this.available = true;
    }

    public Room(Room r){
        this.type = r.type;
        this.cost = r.cost;
        this.available = r.available;
    }

    public String getType() { return this.type; }

    public int getPrice() { return this.cost; }

    public boolean getAvailability() { return this.available; }

    public void changeAvailability() { this.available = !this.available; }

    public static Room findAvailableRoom(Room[] r, String type) {
        for (int i = 0; i < r.length; i++) {
            if (r[i].type == type && r[i].available == true) {
                return r[i];
            }
        }
        return null;
    }

    public static boolean makeRoomAvailable(Room[] r, String type) {
        for (int i = 0; i < r.length; i++) {
            if (r[i].type == type && r[i].available == false) {
                r[i].available = true;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Room double1 = new Room("double");
        Room queen1 = new Room("queen");
        Room king1 = new Room("king");
    
        //Should throw IllegalArgumentException
        try {
            Room twin = new Room("twin");
        } catch (Exception e){
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
        System.out.println((double1.type.equals(double2.type)) && (double1.cost == double2.cost) && (double1.available == double2.available));
    
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
