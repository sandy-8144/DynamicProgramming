package com.oracle.dp;

public class TextDecoding {
/*
 * Approach is to take last char and last two chars
 *   count = 122(1) + 12(21). 
 *   take last two char only if <=26
 * 
 * 
 * 
 */
	
	// recursive approach is exponential
	public int decode(int [] input, int length)
	{
		if(length==0 || length==1)
			return 1;
		
		int count = 0;
		
		count = decode(input , length-1);
		
		if(input[length-2] <2 || (input[length-2] ==2 && input[length-1] <=6))
			count = count+decode(input,length-2);
		
		return count;
		
		
	}
	
	public int decodeViaDP(int [] input,int length) {
		
		int ways [] = new int[length+1];
		
		ways[0]=1;
		ways[1]=1;
		
		for(int i=2;i<=length;i++)
		{
			ways[i]=ways[i-1];
			
			if(input[i-2] <2 || (input[i-2] ==2 && input[i-1] <=6))
				ways[i]=ways[i]+ways[i-2];
			
			
			
		}
		
		return ways[length];
			
	}
	
	public static void main(String [] args) {
		
		TextDecoding tdc = new TextDecoding();
		
		int [] encoded =  {1,2,3,2,1};
		
		System.out.println("decoded{recursion}:"+tdc.decode(encoded, 5));
		System.out.println("decoded{dp}:"+tdc.decodeViaDP(encoded, 5));
		
	}
	
}
