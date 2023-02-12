package assignment1;

public class Hotel {

    private String name;

    private Room[] r;

    public Hotel(String name, Room[] r) {
        this.name = name;
        String type;
        Room rCopy[] = new Room[r.length];
        for (int i = 0; i < r.length; i++) {
            type = r[i].getType();
            rCopy[i] = new Room(type);
        }
        this.r = rCopy;
    }

    public int reserveRoom(String type) {
        Room r1 = Room.findAvailableRoom(r, type);
        if (r1 != null) {
            r1.changeAvailability();
            return r1.getPrice();
        } else {
            throw new IllegalArgumentException("No room of such type is available.");
        }
    }

    public boolean cancelRoom(String type) {
        for (int i = 0; i < r.length; i++) {
            if (Room.makeRoomAvailable(r, type)) {
                return true;
            }
        }
        return false;
    }
}
