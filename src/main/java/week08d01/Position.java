package week08d01;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int increaseX() {
        return x++;
    }

    public int increaseY() {
        return y++;
    }

    public int decreaseX() {
        return x--;
    }

    public int decreaseY() {
        return y--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Position " +
                "x= " + x +
                ", y= " + y;
    }
}
