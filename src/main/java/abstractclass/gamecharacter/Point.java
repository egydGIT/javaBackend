package abstractclass.gamecharacter;

public class Point {

    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
                                                // Pithagorasz t.:  c2 = a2 + b2  ->  c = (gyökjel) a2 + b2
    public long distance(Point otherPoint) {    // megkap egy pontot és visszatér a két pont távolságával
        return (long) Math.sqrt(                                        // négyzetgyök
                Math.pow((double)x - otherPoint.getX(), 2) +            // x tengelyen ismert pont - x tengelyen megadott pont
                                                                                // = kapott érték (itt 2)hatványa
                        Math.pow((double)y - otherPoint.getY(), 2)      // y tengelyen ugyanez
        );          // .sqrt:   returns the positive square root of a double value
    }               // .pow:    returns the value of the 1. argument, raised to the power of the 2. arg

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
