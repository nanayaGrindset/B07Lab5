package B07Lab5;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CircleTests {

    // TESTS FOR Circle

    // correct setting of point a
    @Test
    public void aTest() {
        Assert.assertEquals(new Point(10, 20.5), new Circle(new Point(10, 20.5),new Point(0, 0)).a);
    }

    // correct setting of point b
    @Test
    public void bTest() {
        assertEquals(new Point(0,0), new Circle(new Point(10, 20.5),new Point(0, 0)).b);
    }

    // radius != 0
    @Test
    public void radiusTest1() {
        assertEquals(5 * Math.sqrt(2) / 2, new Circle(new Point(0, 0),new Point(5, 5)).getRadius(), 0.001);
    }

    // radius == 0
    @Test
    public void radiusTest2() {
        assertEquals(0, new Circle(new Point(12, 12),new Point(12, 12)).getRadius(), 0.001);
    }

    // area != 0
    @Test
    public void areaTest1() {
        assertEquals(25 * Math.PI / 2, new Circle(new Point(0, 0),new Point(5, 5)).area(), 0.001);
    }

    // area == 0
    @Test
    public void areaTest2() {
        assertEquals(0, new Circle(new Point(3.2, 3.2),new Point(3.2, 3.2)).area(), 0.001);
    }

    // per != 0
    @Test
    public void perTest1() {
        assertEquals(12 * Math.sqrt(2) * Math.PI, new Circle(new Point(0, 0),new Point(12, 12)).perimeter(), 0.001);
    }

    // per == 0
    @Test
    public void perTest2() {
        assertEquals(0, new Circle(new Point(12, 12),new Point(12, 12)).perimeter(), 0.001);
    }

    // point on circle
    @Test
    public void onCircleTest1() {
        assertEquals(true, new Circle(new Point(0, 0),new Point(5, 5)).isPointOnCircle(new Point(0, 5)));
    }

    // point NOT on circle
    @Test
    public void onCircleTest2() {
        assertEquals(false, new Circle(new Point(0, 0),new Point(5, 5)).isPointOnCircle(new Point(5, 4)));
    }

}
