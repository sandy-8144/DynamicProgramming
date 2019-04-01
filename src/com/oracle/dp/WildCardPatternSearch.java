package com.oracle.dp;

public class WildCardPatternSearch {

	/*
	 * if first char matched or '?' then recurse for isPatternMatch(string1+1, pattern+1).
	 * if pattern is '*' then there are two possibilities 
	 * 1. '*' denotes zero char. increase pattern length as patternLength+1 or (j-1) keeping string Length same 
	 * 2. '*' denotes multiple char. increase length of string+1 (i-1).keeping pattern length same.
	 * 
	 * 
	 */
	public boolean isPatternMatch(char [] input , char [] pattern, int inputLength , int patternLength) {
		
		if(input.length <=  inputLength && pattern.length <= patternLength)
			return true;
		// make sure chars are present after '*'
		if(pattern[patternLength]=='*' && patternLength+1 < pattern.length && input.length <=inputLength)
			return false;
		
		if( pattern[patternLength]== input[inputLength] || pattern[patternLength]=='?')
			return isPatternMatch(input,pattern, inputLength+1,patternLength+1);
		
		if(pattern[patternLength]=='*')
		{
			boolean t1 = isPatternMatch(input,pattern, inputLength+1,patternLength);
			boolean t2 = isPatternMatch(input,pattern, inputLength,patternLength+1);
			return t1||t2;
		}
		
		return false;
		
	}
	
	public boolean isPatternMatchDP(char string [] ,char pattern [] ) {
		
		
		boolean T[][] = new boolean [string.length+1][pattern.length+1];
		T[0][0]=true;
		
		for(int i =1 ; i< string.length+1;i++)
			for(int j=1;j<pattern.length+1;j++)
			{
				if(string[i-1]==pattern[j-1] || pattern[j-1]=='?')
					T[i][j]= T[i-1][j-1];
				else if(pattern[j-1]=='*')
					T[i][j]= T[i-1][j]||T[i][j-1];
				
				
			}
		
		return T[string.length][pattern.length];
		
		
	}

public static void main (String [] args) {
	
	String input = "geekds";
	String pattern = "g*k?s";
	
	WildCardPatternSearch wcs = new WildCardPatternSearch();
	boolean matched = wcs.isPatternMatch(input.toCharArray(), pattern.toCharArray(), 0, 0);
	System.out.println("is_matched:"+matched);
	
	System.out.println("is_matched(DP):"+wcs.isPatternMatchDP(input.toCharArray(), pattern.toCharArray()));
	
	
}

}
