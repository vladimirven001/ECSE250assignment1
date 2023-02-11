package assignment1;

public class Room {

    private String type;
    private int cost;
    private boolean available;


    public Room(String type) {
        if (type.equalsIgnoreCase("double")) {
            this.cost = 9000;
        } else if(type.equalsIgnoreCase("queen")) {
            this.cost = 11000;
        } else if (type.equalsIgnoreCase("king")) {
            this.cost = 15000;
        } else {
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

    public boolean getAvailability() { return available; }

    public void changeAvailability() { available = !available; }

    public static Room findAvailableRoom(Room[] r, String type) {
        for (int i = 0; i < r.length; i++) {
            if (r[i] != null && r[i].type.equalsIgnoreCase(type) && r[i].available == true) {
                return r[i];
            }
        }
        return null;
    }

    public static boolean makeRoomAvailable(Room[] r, String type) {
        for (int i = 0; i < r.length; i++) {
            if (r[i] != null && r[i].type.equalsIgnoreCase(type) && r[i].available == false) {
                r[i].available = true;
                return true;
            }
        }
        return false;
    }
}
