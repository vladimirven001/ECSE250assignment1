package assignment1;

public class Basket {

    private Reservation[] r;

    public Basket() {
        this.r = new Reservation[0];
    }

    public Reservation[] getProducts() {
        Reservation[] shallowCopy = new Reservation[r.length];
        System.arraycopy(r, 0, shallowCopy, 0, r.length);
        return shallowCopy;
    }

    public int add(Reservation r) {
        int length;
        length = this.r.length;
        Reservation[] newArr = new Reservation[length + 1];
        for (int i = 0; i < length; i++) {
            newArr[i] = this.r[i];
        }
        newArr[length] = r;
        this.r = newArr;
        return (length + 1);
    }

    public boolean remove(Reservation r) {
        int index = -1;
        int length = this.r.length;
        for (int i = 0; i < length; i++) {
            if (index == -1 && this.r[i].equals(r)) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        Reservation[] newArr = new Reservation[length - 1];

        for (int i = 0; i < length; i++) {
            if (i < index) {
                newArr[i] = this.r[i];
            } else if (i > index) {
                newArr[i - 1] = this.r[i];
            }
        }
        this.r = newArr;
        return true;
    }

    public void clear() {
        Reservation[] newArr = new Reservation[0];
        this.r = newArr;
    }

    public int getNumOfReservations() {
        return this.r.length;
    }

    public int getTotalCost() {
        int cost = 0;
        for (int i = 0; i < this.r.length; i++) {
            cost += this.r[i].getCost();
        }
        return cost;
    }
}
