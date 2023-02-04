package assignment1;

public class Airport {

    private int xCo;
    private int yCo;
    private int fees;

    public Airport(int xCo, int yCo, int fees) {
        this.xCo = xCo;
        this.yCo = yCo;
        this.fees = fees;
    }

    public int getFees() {
        return this.fees;
    }

    public static int getDistance(Airport a1, Airport a2) {
        int x1 = a1.xCo;
        int x2 = a2.xCo;
        int y1 = a1.yCo;
        int y2 = a2.yCo;
        int dist = (int)Math.ceil(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));

        return dist;
    }
}
