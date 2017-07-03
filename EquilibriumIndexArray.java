package com.test.java;

public class EquilibriumIndexArray {
	
	public int solution(int[] A) {
        int index=0;
       int sum=0;
        //Check for sum of next elements
        for(int i=0;i<A.length;i++)
        {
        	sum=getArraySum(A,i);
        	System.out.println("Checking for index "+i);
        	if(A[i]==sum)
        	{
        		index=A[i];
        	}
        }
        System.out.println(sum);
        	
        return index;
    }
	
	private int getArraySum(int []A, int index)
	{
		int sum=0;
		for(int i=index;i<(A.length-index);i++)
		{
			sum=A[i]+sum;
		}
		System.out.println(sum+","+index);
		return sum;
	}
	
	public static void main(String[] args)
	{
		int[] num={-1,8,5,4,1,3};
		EquilibriumIndexArray eia=new EquilibriumIndexArray();
		int eqi=eia.solution(num);
		System.out.println(eqi);
		
	}

}
