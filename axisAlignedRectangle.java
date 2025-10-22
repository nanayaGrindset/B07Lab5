package B07Lab5;

import java.lang.Math;

public class axisAlignedRectangle{

    // the Point variable keeps track of the top left corner of the rectangle
    Point p;
    double width, height;

    public axisAlignedRectangle() {
        p = new Point(0, 0);
        width = 0;
        height = 0;
    }

    public axisAlignedRectangle(double x, double y, double width, double height) throws Exception {

        if (width < 0) {
            throw new Exception("width cannot be negative");
        }

        if (height < 0) {
            throw new Exception("height cannot be negative");
        }

        p = new Point(x, y);

        this.width = width;
        this.height = height;
    }

    public Point topLeftCorner() {
        return new Point(p.x, p.y);
    }

    public Point topRightCorner() {
        return new Point(p.x + width, p.y);
    }

    public Point botLeftCorner() {
        return new Point(p.x, p.y + height);
    }

    public Point botRightCorner() {
        return new Point(p.x + width, p.y + height);
    }

    public Point midPoint() {
        return new Point(p.x + width / 2, p.y + height / 2);
    }

    public double diagLength() {
        return Math.hypot(width, height);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    public boolean isSquare() {
        return Math.abs(height - width) < 1e-9;
    }

}