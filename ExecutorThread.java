package com.test.java;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ExecutorThread implements Runnable {
	
	private final String name;
	
	public ExecutorThread(String name)
	{
		this.name=name;
		
    }
	
	@Override
	public void run() {
		System.out.println("Start");
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException ie)
		{}
		
	}

	public static void main(String[] args) {
		Random random=new Random(); // To generat Random numbers
		
		//Create executor of thread pool size 5
		ExecutorService executor=Executors.newFixedThreadPool(5);
		
		//Print names
		int wait=600;
		for(int i=0;i<10;i++)
		{
			String name="Hello "+i;
			int time=random.nextInt(500);
			wait+=time;
			Runnable runner=new ExecutorThread(name);
			executor.execute(runner);
			
		}
		try
		{
			Thread.sleep(wait);
			executor.shutdown();
			executor.awaitTermination(wait,TimeUnit.MILLISECONDS);
			
		}
		catch(InterruptedException ie)
		{}
		System.exit(0);
	

	}


	

}
