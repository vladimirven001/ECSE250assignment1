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

    public String getType() { return type; }

    public int getPrice() { return cost; }

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
}
