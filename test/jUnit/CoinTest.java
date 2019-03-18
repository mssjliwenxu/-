package jUnit;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;
import org.junit.*;
@RunWith(Parameterized.class)
public class CoinTest {
	private Coin test;
	private boolean expected;
	private int input;
	public CoinTest(boolean expected,int input){
		 this.input=input;
		 this.expected=expected;
	}
	@Before
	public void setUp() {
		 test=new Coin();
	}
	@Parameters
	public static Collection<Object[]> getData()
	{
		return Arrays.asList(new Object[][] {
			{true,32},
			{true,33},
			{false,34},
			{false,35},
			{false,37},
			{true,12},
			{true,13},
			{false,14},
			{false,15},
			{true,55},
			{true,56},
			{false,59},
		});
	}
	@Test
	public void testCoin() {
		assertEquals(this.expected,test.findCoin(this.input));
	}
}
