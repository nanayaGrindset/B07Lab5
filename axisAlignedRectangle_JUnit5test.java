package B07Lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class axisAlignedRectangle_JUnit5test {

	@Test
	void topLeftCorner_test() throws Exception 
	{
		axisAlignedRectangle r3=new axisAlignedRectangle();
		Point p3=new Point(0,0);
		assertEquals(r3.topLeftCorner(),  p3);
	}
	@Test
	void topRightCorner_test() throws Exception 
	{
		axisAlignedRectangle r1=new axisAlignedRectangle(1,2,4,5);
		Point p1=new Point(5,2);
		assertEquals(r1.topRightCorner(),  p1);

		}
	@Test
	void botLeftCorner_test() throws Exception 
	{
		axisAlignedRectangle r1=new axisAlignedRectangle(1,2,4,5);
		Point p1=new Point(1,7);
		assertEquals(r1.botLeftCorner(),  p1);

	}
	@Test
	void botRightCorner_test() throws Exception 
	{
		axisAlignedRectangle r1=new axisAlignedRectangle(1,2,4,5);
		Point p1=new Point(5,7);
		assertEquals(r1.botRightCorner(),  p1);

	}
	
	@Test
	void diagLength_test() throws Exception 
	{
		
		Point p2=new Point(3,19);
		axisAlignedRectangle r2=new axisAlignedRectangle(p2,4,3);
		assertEquals(r2.diagLength(), 5);

	}
	
	
		
}

