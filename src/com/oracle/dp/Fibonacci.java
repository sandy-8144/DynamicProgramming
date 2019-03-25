package com.oracle.dp;

public class Fibonacci {

	//private static int [] memory = 
	public void fibTopDown(int n) {
		
		int [] memory = new int[n+1];
		
		for(int i=0;i<=n;i++)
			memory[i]=-1;
		
		int output = fibTopDown(n , memory);
		
		System.out.println("Fib of {"+n+"} is:"+output);
		
		
	}
	
	private int fibTopDown( int n , int [] memory)
	{
		if(memory[n]!=-1){
			
			return memory[n];
		}
		
			if(n<=1)
				memory[n]=n;
			else 
				memory[n] = fibTopDown( n-1 , memory) +fibTopDown( n-2 , memory);
		return memory[n];
		
	}
	
	
	public static void main(String [] args) {
		
		Fibonacci fib = new Fibonacci();
		fib.fibTopDown(6);
		
	}
}
