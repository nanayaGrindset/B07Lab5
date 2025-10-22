package B07Lab5;

public class Circle {
    public Point a;
    public Point b;

    public Circle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getCenter() {
        return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
    }

    public double getRadius() {
        return a.distance(b) / 2;
    }

    public double area() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double perimeter() {
        return 2 * Math.PI * getRadius();
    }

    public boolean isPointOnCircle(Point p) {
        return Double.compare(getCenter().distance(p), getRadius()) == 0;
    }
}
