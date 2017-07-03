package com.test.java;

import java.util.HashMap;
import java.util.Map;

/*
 * Algorithm to find the pairs making K complementary in O(n) complexity
 * 
 */
public class ComplementaryPairs {

	public static void main(String[] args) {
		ComplementaryPairs kcompairs=new ComplementaryPairs();
		int[] values=new int[]{1,4,-4,5,3,-5,6,10,-1};
		Integer[][] compNumbers=kcompairs.getComplementaryPairs(7, values);
		for(Integer[] compNumber : compNumbers)
		{
			 System.out.println(" Pairs are "+compNumber[0] + " and " + compNumber[1]);
		}

	}
	
	/*
	 * An algorithm to find pair from given array that would sum up given K
	 * Implementing this in 0)(n). First it would create a temporary collection of pairs 
	 * value,(sum-value)
	 * @param KSum
	 * @param numList
	 * @return
	 */
	public Integer[][] getComplementaryPairs(int KSum, int[] numList)
	{
		//Store numList in int[][] array
		Integer[][] compPairs=new Integer[numList.length][2];
		//Populate array with complementary numbers
		Map<Integer, Integer> numPairs=new HashMap<Integer, Integer>();
		
		for(int num : numList)
		{
			numPairs.put(num,KSum-num);
		}
		System.out.println("Pairs Map "+numPairs);
		
		
		//Filter out pairs not having corresponding complementary number
		int index=0;
		for(int num : numList)
		{
			int compNumber=KSum-num;
			//Check if this key exists in pairs
			if(numPairs.containsKey(compNumber))
			{
				compPairs[index][0]=num;
				compPairs[index][1]=compNumber;
				index++;
			}
			
		}
		
		//Now get the final Array
		Integer[][] finalComplementaryNumbers=new Integer[index][2];
		//Using O(n) complexity
		int indx=0;
		for(Integer[] pair:compPairs)
		{
			if(pair[0]!=null)
			{
			finalComplementaryNumbers[indx][0]=pair[0];
			finalComplementaryNumbers[indx][1]=pair[1];
			}
			indx++;
		}
		return finalComplementaryNumbers;
		
	}

}
