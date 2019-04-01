package com.oracle.dp;

import java.util.Arrays;

public class Knapsack {

	
	public void knapsackTopDown( int [] weight , int [] value, int capacity  )
	{
		
		// Complexity. O(nc), without DP its 2^n
		
		int noOfItems = value.length;
		int [][] matrix = new int [noOfItems+1][capacity+1];
		for(int i = 1; i<noOfItems;i++)
			for(int j=1;j<=capacity;j++)
				//if(i==0 || j==0)
					matrix[i][j]=-1;
		
		int solution =  knapsackTopDown(weight, value , noOfItems-1 ,matrix,capacity);
		System.out.println("Max value:"+solution);
	}
	
	private int knapsackTopDown(int [] weight, int [] value , int n ,int [][] matrix, int capacity) {
		
		if(n==-1 || capacity==0)
			return 0;
		
		if(matrix[n][capacity]!=-1)
			return matrix[n][capacity];
		
		
		if(weight[n] > capacity)
			return knapsackTopDown(weight, value ,n-1 , matrix, capacity);
		else
		{
			int guess1 = knapsackTopDown(weight, value ,n-1 , matrix, capacity);
			int guess2= value[n]+knapsackTopDown(weight, value ,n-1 , matrix, capacity-weight[n]);
			int result =  Math.max(guess1,guess2);
			matrix[n][capacity]=result;
			return matrix[n][capacity];
			
		}		
		
	}
	
	
	
	public void knapsackBottomUp(int [] weight , int [] value, int capacity)
	{
		int n = weight.length;
		int [] [] matrix = new int[n+1][capacity+1];
		
		for(int i = 0; i <=n;i++)
			for(int j=0; j<=capacity;j++)
			{
				if(i==0 || j==0) {
					matrix[i][j]=0;
					continue;
				}
				
			// using i-1 as weight as first row and columns are zero. so ideally weight start from i=1 
		      if(weight[i-1] > j)
		    	  matrix[i][j]= matrix[i-1][j];
		      else {
		    	  
		    	  int guess1 = matrix[i-1][j];
		    	  int guess2 = value[i-1]+matrix[i-1][j-weight[i-1]];
		    	  matrix[i][j]= Math.max(guess1, guess2);
		    	  
		      }
		      
			}
		
		
	System.out.println("Max value:"+ matrix[n][capacity]);
	}
	
	// When items are repeated.
	public int unboundedKnapsack(int W, int n,  
            int[] val, int[] wt) { 

// dp[i] is going to store maximum value 
// with knapsack capacity i. 
			int dp[] = new int[W + 1]; 

// Fill dp[] using above recursive formula 
				for(int i = 0; i <= W; i++){ 
					for(int j = 0; j < n; j++){ 
						if(wt[j] <= i){ 
							dp[i] = Math.max(dp[i], dp[i - wt[j]] +  val[j]); 
						} 
					} 
				} 
				return dp[W]; 
	} 
	
	
	
	public static void main (String [] args) {
		
		// put leading zero.
		int [] weight = {2,1,3,4,1};
		int [] value = {1,4,5,8,9};
		
		int [] weight1 = {0,2,1,3,4,1};
		int [] value1 = {0,1,4,5,8,9};
		
		
		
		Knapsack kp = new Knapsack();
		kp.knapsackTopDown(weight, value, 7);
		kp.knapsackBottomUp(weight, value, 7);
	}
	
}
