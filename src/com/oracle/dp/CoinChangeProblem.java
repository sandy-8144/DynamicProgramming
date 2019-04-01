package com.oracle.dp;

public class CoinChangeProblem {

	private static int amount=12;
	private static int [] coins = {1,2,5};
	/*
	 * This is same like unbounded knapsack problem
	 * 
	 * Complexity O(amount*#coins)
	 * 
	 */
	public int coinChange(int [] coins, int amount) {
		
		int combination [] = new int[amount+1];
		combination[0]=1;
		
		
		for(int i=1; i<=amount;i++)
			 for(int coin:coins)
				if(i >= coin)
					combination[i]=combination[i]+combination[i-coin];
		
		return combination[amount];
		
		
	}
	
	
	public int coinChangeRecursion(int amount)
	{
		if(amount==0)
			return 1;
		if(amount<0)
			return 0;
		int combination=0;
		for(int i=0;i<coins.length;i++)
		{
			combination = combination+coinChangeRecursion(amount-coins[i]);
		}
		
		return combination;
		
		
	}
	
	
	public static void main(String [] args)
	{
		CoinChangeProblem ccp = new CoinChangeProblem();
		System.out.println("ccp(DP):"+ccp.coinChange(coins, amount));
		System.out.println("ccp(recursion):"+ccp.coinChangeRecursion(amount));
		
	}
}
