package jUnit;

import java.util.ArrayList;
import java.util.List;

public class Coin {

		private int[] coins;
		private int[] store;
		public  Coin(){
			coins=new int[]{50,20,5,1};
			store=new int[]{1,1,2,3};
		}
		public boolean findCoin(int number)
		{
			if(number==0)
			{
				return true;
			}
			if(number>83)
			{
				return false;
			}
			for(int i=0;i<store.length;i++)
			{
				if(store[i]!=0)
				{
					store[i]-=1;
					if(findCoin(number-coins[i]))
					{
						return true;
					}
					store[i]+=1;
				}
			}
			return false;
		}
		public static void main(String args[])
		{
			Coin test=new Coin();
			System.out.println(test.findCoin(31));
		}
}
