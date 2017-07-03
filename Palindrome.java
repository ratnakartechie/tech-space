package com.test.java;

public class Palindrome {
	
	public boolean reverseString(String s1)
	{
		StringBuffer rev=new StringBuffer();
		int len=0;
		if(s1!=null)
		{
		len=s1.length();
		}
		for(int i=len-1;i>=0;i--)
		{
			rev.append(s1.charAt(i));
		}
		if(s1!=null && s1.equalsIgnoreCase(rev.toString()))
		{
			return true;
		}
		
	 return false;
	 }

	public static void main(String[] args) {
		String original="Able Was I Ere I saw Elba";
		Palindrome pal=new Palindrome();
		//Invoking a Method to Reverse String
		boolean isPalindrome=pal.reverseString(null);
		if(isPalindrome)
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not a Palindrome");
		}
		
	}

}
