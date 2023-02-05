package assignment1;

public class Hotel {

    private String name;

    private Room[] r;

    public Hotel(String name, Room[] r) {
        this.name = name;

        Room rCopy[] = new Room[r.length];

        for (int i = 0; i < r.length; i++) {
            rCopy[i] = r[i];
        }

        this.r = rCopy;
    }

    public int reserveRoom(String type) {
        Room r1 = Room.findAvailableRoom(r, type);
        r1.changeAvailability();
        return r1.getPrice();
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
