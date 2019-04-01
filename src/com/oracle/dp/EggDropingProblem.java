package com.oracle.dp;
/*
 *  Formula:
 *  
 *  if n is number of floors and e is number of eggs then
 * 
 * 1. lets say if we drop egg from xth floor and it doesn't break then we have to 
 * explore n-x floor with same number of eggs.
 * 2. if egg breaks at xth floor then we have to explore 0 to x-1 floor with e-1 eggs
 * 
 * f(n,e) = min  1<=x<n-1 {  max(f(n-x,e), f(x-1,e-1))+1}
 * 
 * base cases: 
 *   f(1,e) =1 ( one floor with e eggs)
 *   f(n,1) = n ( n floor with 1 egg)
 * 
 *   complexcity O(n2*e)
 * 
 * 
 */
public class EggDropingProblem {

	
	public int eggDroppingBottomUpDP(int n, int e) {
        final int results[][] = new int[n + 1][e + 1];
        for (int i = 0; i < n + 1; i++) {
            results[i][1] = i;
        }
        for (int i = 0; i < e + 1; i++) {
            results[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < e + 1; j++) {
                results[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x < i; x++) {
                     int r1 = results[x - 1][j - 1];
                    int r2  = results[i - x][j];
                    int temp = Math.max(r1, r2) + 1;
                    if (temp < results[i][j]) {
                        results[i][j] = temp;
                    }
                }
            }
        }
        
        return results[n][e];
    }
	
	
	public static void main(String [] args) {
		
		
		EggDropingProblem egd = new EggDropingProblem();
		
		System.out.println(egd.eggDroppingBottomUpDP(100, 2));
	}
}
