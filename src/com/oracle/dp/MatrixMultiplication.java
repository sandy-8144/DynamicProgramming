package com.oracle.dp;

public class MatrixMultiplication {

	
	public int matrixMultiplicationCost(int matrix []) {
		
		int m [] [] = new int [matrix.length][matrix.length];
	//	int t [] [] = new int [matrix.length][matrix.length];
		
		for(int p=0; p <matrix.length-1;p++)
			for(int l=1; l<matrix.length-p;l++)
			{
				
				int j= l+p;
				int i=l;
				if(i==j) {
					m[i][j]=0;
					continue;
				}
				m[i][j] = 1000000;

				for(int k=i; k<j;k++)
				{
					int temp = m[i][k]+m[k+1][j]+matrix[i-1]*matrix[k]*matrix[j];
					if(temp < m[i][j])
						m[i][j]=temp;
					 //   t[i][j]=k;
					
					
				}
				
				
				
			}
		
		return m[1][matrix.length-1];
	}
	
	public static void main(String [] args) {
		int [] p = {1,2,3};
		
		MatrixMultiplication mc = new MatrixMultiplication();
		
		System.out.println("Matrix cost:"+mc.matrixMultiplicationCost(p));
		
		
	}
}
