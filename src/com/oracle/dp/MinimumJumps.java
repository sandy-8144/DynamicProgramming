package com.oracle.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimumJumps {
/*
 * DP Approach:
 * 
 * Create a another array e.g. jump[] of same size as input array. One more array can be taken to track the element. 
 * This array will keep track minimum num of jump required to reach arr[i] from start, means from first element.
 * 
 * Start two for loops. to reach first element, zero jump is required. hence jump[0]=0;
 * start i from 1 to n-1 and j from 0 to i-1
 * check if i can be reached from j ( where j is 0 to i-1). i can be reached to j if j+arr[j] >=i.
 * each i will store minimum jump from start, i.e. from first element.
 * 
 * arr = {2,3,1,1,2,4,2,0,1,1} 
 * jump= {0,1,1,2,2,INF,INF,INF,INF,INF}
 * result={-
 * 
 * e.g. if i=5 ( j= 0 to 4. then i can't be reached from element indexed :0,1,2,3 as j+arr[j] >=i.
 * i can be reached from index 4. and mininum jump to reach index 4 is '2' hence min jumps needed to 
 * reach index 5 is 2+1='3'
 * 
 * Complexity : O(n^2). Space Complexity: O(n)
 *   
 */

	
public int minJump(int arr[]){
        
        int []jump = new int[arr.length];
        int []result = new int [arr.length];
        jump[0] = 0;
        
        // if first element is '0' then no elements are reachable.
        if (arr.length == 0 || arr[0] == 0) 
            return Integer.MAX_VALUE;
        
        
        for(int i=1; i < arr.length; i++){
        	jump[i] = Integer.MAX_VALUE-1;
            for(int j=0; j < i; j++){
                if(arr[j] + j >= i){
                    if(jump[i] > jump[j] + 1){
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
        
        for(int i = 0; i< arr.length;i++)
        	System.out.print(result[i]+",");
        
        LinkedList<Integer> element = new LinkedList<Integer>();
        element.add(arr.length-1);
        
        int index = result[arr.length-1];
        element.push(index);
        while (index > 0)
        {
        	index = result[index];
        	element.push(index);
        	
        }
        
        System.out.println("sequence..."+element);
        
        return jump[jump.length-1];
    }


public static void main (String [] args) {
	
	MinimumJumps jumps = new MinimumJumps();
	System.out.println();
	int [] arr = {2,3,1,1,2,4,2,0,1,1};
	System.out.println("Min jumps:"+jumps.minJump(arr));
}
	
}
