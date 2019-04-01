package com.oracle.dp;

public class LIS {

	/*
	 * Approach is to take a temp array of same size. 
	 * initialize the array with '1' as each element in LIS for it self.
	 * 
	 * 
	 * 
	 * 
	 */
	public int lis(int [] arr) {
		// O(n^2)
		int length = arr.length;
		
		int [] temp = new int [length];
		
		for(int i=0;i<length;i++)
			temp[i]=1;
		
		for(int i=1;i<length;i++)
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i])
					temp[i] = Math.max(temp[i], temp[j]+1);
				
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
		
		LIS l = new LIS();
		System.out.println("LIS:"+l.lis(input));
	}
	
}
