package B07Lab5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testRectangle2 {
	@Test
    void testDefaultConstructorX() {
        axisAlignedRectangle rect = new axisAlignedRectangle();
        assertEquals(0, rect.p.x);
    }
	
	@Test
    void testDefaultConstructorY() {
        axisAlignedRectangle rect = new axisAlignedRectangle();
        assertEquals(0, rect.p.y);
    }
	
	@Test
    void testDefaultConstructorWidth() {
        axisAlignedRectangle rect = new axisAlignedRectangle();
        assertEquals(0, rect.width);
    }
	
	@Test
    void testDefaultConstructorHeight() {
        axisAlignedRectangle rect = new axisAlignedRectangle();
        assertEquals(0, rect.height);
    }
	//
	@Test
    void testPointConstructorX() throws Exception{
		Point topLeft = new Point(1.0, 2.0);
        axisAlignedRectangle rect = new axisAlignedRectangle(topLeft, 3.0, 4.0);
        assertEquals(1.0, rect.p.x);
    }
	@Test
    void testPointConstructorY() throws Exception{
		Point topLeft = new Point(1.0, 2.0);
        axisAlignedRectangle rect = new axisAlignedRectangle(topLeft, 3.0, 4.0);
        assertEquals(2.0, rect.p.y);
    }
	@Test
    void testPointConstructorWidth() throws Exception{
		Point topLeft = new Point(1.0, 2.0);
        axisAlignedRectangle rect = new axisAlignedRectangle(topLeft, 3.0, 4.0);
        assertEquals(3.0, rect.width);
    }
	@Test
    void testPointConstructorHeight() throws Exception{
		Point topLeft = new Point(1.0, 2.0);
        axisAlignedRectangle rect = new axisAlignedRectangle(topLeft, 3.0, 4.0);
        assertEquals(4.0, rect.height);
    }
	//
	@Test
    void testCoordinatesConstructorX() throws Exception{
        axisAlignedRectangle rect = new axisAlignedRectangle(1.1, 1.2, 2.1, 2.2);
        assertEquals(1.1, rect.p.x);
    }
	@Test
    void testCoordinatesConstructorY() throws Exception{
        axisAlignedRectangle rect = new axisAlignedRectangle(1.1, 1.2, 2.1, 2.2);
        assertEquals(1.2, rect.p.y);
    }
	@Test
    void testCoordinatesConstructorWidth() throws Exception{
        axisAlignedRectangle rect = new axisAlignedRectangle(1.1, 1.2, 2.1, 2.2);
        assertEquals(2.1, rect.width);
    }
	@Test
    void testCoordinatesConstructorHeight() throws Exception{
        axisAlignedRectangle rect = new axisAlignedRectangle(1.1, 1.2, 2.1, 2.2);
        assertEquals(2.2, rect.height);
    }
	//
	@Test
    void testConstructorNegativeWidthThrowsException() {
        Point p = new Point(-1.0, 0.0);
        Exception e = assertThrows(Exception.class, () -> {
            new axisAlignedRectangle(p, -1.0, 1.0);
        });
        assertEquals("width cannot be negative", e.getMessage());
    }
	@Test
    void testConstructorNegativeHeightThrowsException() {
        Point p = new Point(-1.0, 0.0);
        Exception e = assertThrows(Exception.class, () -> {
            new axisAlignedRectangle(p, 1.0, -1.0);
        });
        assertEquals("height cannot be negative", e.getMessage());
    }
	@Test
    void testConstructorWithNegativeWidth() {
        Exception e = assertThrows(Exception.class, () -> {
            new axisAlignedRectangle(5.0, 6.0, -7.0, 8.0);
        });
        assertEquals("width cannot be negative", e.getMessage());
    }
	@Test
    void testConstructorWithNegativeHeight() {
        Exception e = assertThrows(Exception.class, () -> {
            new axisAlignedRectangle(5.0, 6.0, 7.0, -8.0);
        });
        assertEquals("height cannot be negative", e.getMessage());
    }
	@Test
    void testMidPointX() throws Exception {
        axisAlignedRectangle rect = new axisAlignedRectangle(0.0, 0.0, 6.0, 9.0);
        Point mid = rect.midPoint();
        assertEquals(3.0, mid.x);
    }
	@Test
    void testMidPointY() throws Exception {
        axisAlignedRectangle rect = new axisAlignedRectangle(0.0, 0.0, 6.0, 9.0);
        Point mid = rect.midPoint();
        assertEquals(4.5, mid.y);
    }
	@Test
	void testdiagLength()throws Exception {
        axisAlignedRectangle rect = new axisAlignedRectangle(0.0, 0.0, 3.0, 4.0);
        assertEquals(5.0, rect.diagLength());
    }
	@Test
	void testGetArea()throws Exception {
        axisAlignedRectangle rect = new axisAlignedRectangle(1.0, -1.0, 3.0, 4.0);
        assertEquals(12.0, rect.getArea());
    }
	@Test
	void testGetPerimeter()throws Exception {
        axisAlignedRectangle rect = new axisAlignedRectangle(1.0, -1.0, 3.0, 5.0);
        assertEquals(16.0, rect.getPerimeter());
    }
	@Test
	void testIsSquare()throws Exception {
        axisAlignedRectangle rect = new axisAlignedRectangle(1.0, -1.0, 3.0, 3.0);
        assertTrue(rect.isSquare());
    }
	@Test
	void testIsNotSquare()throws Exception {
        axisAlignedRectangle rect = new axisAlignedRectangle(1.0, -1.0, 3.0, 7.0);
        assertFalse(rect.isSquare());
    }
}
