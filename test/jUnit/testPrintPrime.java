package jUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class testPrintPrime {
	PrintPrimes test;
	@Before
	public void setUp() {
		 test=new PrintPrimes();
	}
	@Test
	public void testAdd() {
		int [] a= {2};
		assertTrue(Arrays.equals(a,test.printPrimes(3)));
	}
}
