package com.oracle.dp;

public class MaxSumIS {

	public int maxSum(int [] arr) {
		
		
int length = arr.length;
		
		int [] temp = new int [length];
		
		for(int i=0;i<length;i++)
			temp[i]=arr[i];
		
		for(int i=1;i<length;i++)
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i])
					temp[i] = Math.max(temp[i], temp[j]+arr[i]);
				
				/*
				 * if(arr[j]<arr[i] && temp[i] < temp[j]+1)
					temp[i] = temp[j]+1;
				 * 
				 * 
				 */
				
				
				
			}
		
		// now get the max value from temp array.
		
		int max=temp[0];
		
		for(int i=1;i<length;i++)
			if(max < temp[i])
				max=temp[i];
		
		return max;
	}
	
	
	
public static void main (String [] args) {
		
		int [] input = {3,1,5,2,6,4,9};
		
		MaxSumIS l = new MaxSumIS();
		System.out.println("MaxLIS:"+l.maxSum(input));
	}
}
