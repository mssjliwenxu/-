package jUnit;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class caculateTest {
	Caculate cal;
//	public caculateTest()
//	{
//		cal=new Caculate();
//	}
	@Before
	public void setUp() {
		 cal=new Caculate();
	}
	@Test
	public void testAdd() {
		
		assertEquals(5,cal.add(2, 3));
	}
	@Test
	public void testSub() {
		
		assertEquals(5,cal.sub(2, 3));
	}
	@Test(expected=ArithmeticException.class)
	public void testDivide() {
		
		assertEquals(5,cal.divide(2, 0));
	}
}
