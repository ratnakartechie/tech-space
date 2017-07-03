package com.test.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckArray {
	
 static String findNumber(int[] arr, int k)
 {
	 for(int i=0;i<arr.length;i++)
	 {
		 //Get value
		 if(k==arr[i])
		 {
			 return "YES";
		 }
	 }
	 
	 return "NO";
 }
 
 static int[] oddNumbers(int l, int r) {
	 
	List<Integer> values=new ArrayList<>();
     for(int i=l;i<r;i++)
     {
         //Get the number
         if(i%2>0)
         {
        	values.add(i);
         }
     }
     int[] arr = new int[values.size()];
     for(int i = 0; i < values.size(); i++) {
         arr[i] = values.get(i);
     }
     System.out.println(arr);
     return arr;

 }
 
 static int countPairs(int[] numbers, int k) {
	 int pairCount=0;
	 
	 int a,b;
	 int arrLen=numbers.length;
	 //Loop through array
	 for(int i=1;i<arrLen;i++)
	 {
			 //Get first element
		 a=numbers[i-1];
		 //Get second element
		 b=numbers[i];
		 System.out.println("Getting element "+i+","+a);
		 System.out.println("Getting element "+(i+1)+","+b);		 
		 //Check for Valid Pair
		 if(a<=b)
		 {
			 if(b-a==k)
			 {
				 System.out.println("Valid Pair");
				 pairCount++;
			 }
		 }
		 
	 }
	 
	 return pairCount;


 }
 static int numOfPlaylist(int N, int K, int L) {
	 
	 int playListNum=0;
	 int playOften=0;
	 
	//How often can a song be played
	 
	 if(N>=K)
	 {
		 playOften=N-K;
	 }
	 
	 System.out.println(playOften);
	 
	 //No of Possible repetitions of a song
	 int posTimes=N*playOften;
	 
	 System.out.println(posTimes);
	 
	 //Play List possible
	 playListNum=posTimes%L;
	 
	 System.out.println(playListNum);
	 
	 return playListNum;


 }
 
 static boolean checkParantheses(String s)
 {
	 //Get a Stack
	 Stack<Character> stack=new Stack<>();
	 
	 for(int i=0;i<s.length();i++)
	 {
		 
		 char ch=s.charAt(i);
		 //Check for opening braces
		 if(ch=='{' || ch=='(' || ch=='[')
		 {
			 //Add to Stack
			 stack.push(ch);
			 
		 }
		 
		 //Check for closing braces
		 if(ch=='}' || ch==')' || ch==']')
		 {
			System.out.println("Is Stack Empty"+stack.isEmpty());
			if(stack.isEmpty())
			{
				return true;
			}
			
			//Get the last character
			char last=stack.peek();
			System.out.println(last);
			if(ch=='}' && last=='{' || ch==')' && last=='(' || ch==']' && last==']')
			{
				//Pop out from stack
				stack.pop();
			}
			else
			{
				return false;
			}
			 
		 }
		 
		 
		 
	 }
	 return stack.isEmpty();
	 
 }
 
 public static void main(String[] args)
 {
	 int[] num={5,1,2,3,4,5,1};
	// String check=CheckArray.findNumber(num, 8);
	// System.out.println(check);
	 
	 //CheckArray.oddNumbers(5, 12);
	 
	//// int validPairs=CheckArray.countPairs(num, 1);
	// System.out.println(validPairs);
	 
	// CheckArray.numOfPlaylist(20,10,25);
	 
	 System.out.println(CheckArray.checkParantheses("{[Hello World}}"));
 }

}
