package ex2Distance;

public class Point {

    // posegreguj punkty wg odleglosci od punktu 0.0 (na Slacku)

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculateDistance(double x, double y) {
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance;
    }

    @Override
    public String toString() {
        return "ex2Distance{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


