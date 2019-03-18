package jUnit;

public class Caculate {
	public static void main(String[] args) {
		int [] x= {2,3,5};
		System.out.println(findLast(x,2));
	}
	
	public int add(int a,int b)
	{
		return a+b;
	}
	public int sub(int a,int b)
	{
		return a-b;
	}
	public int divide(int a, int b)
	{
		return a/b;
	}
	public int multiple(int a, int b)
	{
		return a*b;
	}
	public static  int findLast (int[] x, int y) {
		//Effects: If x==null throwNullPointerException
		// else return the index of the last element // in x that equals y.
		// If no such element exists, return -1
		for (int i=x.length-1; i > 0; i--)
		{
		if (x[i] == y) {
		return i; }
		}
		return -1;
		}
}
