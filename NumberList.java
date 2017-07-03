package com.test.java;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class NumberList {
	
	private List<Integer> numList;
	
	public NumberList()
	{
		numList=new ArrayList<>();
		for(int i=0;i<10;i++)
		{
			numList.add(i);
		}
		
	}
	
	public void getNumberList()
	{
		
		 try
		 {
		 PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
		 for(int i=0;i<numList.size();i++)
		 {
			 out.println(numList.get(i));
		 }
		 }
		 catch(IndexOutOfBoundsException ibe)
		 {
			 ibe.printStackTrace();
		 }
		 catch(IOException ie)
		 {
			 ie.printStackTrace();
		 }

	}
	
	public static void main(String[] args)
	{
		NumberList numbers=new NumberList();
		numbers.getNumberList();
		
	}

}
