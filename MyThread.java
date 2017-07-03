package com.test.java;

public class MyThread {
	

    private static class MessageLoop
        implements Runnable {
        public void run() {
            String languages[] = {
                "Telugu","Tamil","Kannada","Malayalam"
            };
            try {
                for (int i = 0;
                     i < languages.length;
                     i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    String threadName =
                            Thread.currentThread().getName();
                        System.out.format("%s: %s%n",
                                          threadName,
                                          languages[i]);
                }
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }

    public static void main(String args[])
        throws InterruptedException {

        // Delay, in milliseconds
      
        long patience = 1000 * 60 * 60;

        System.out.println("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

      
        while (t.isAlive()) {
        	System.out.println("Looping");
               t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                  && t.isAlive()) {
            	System.out.println("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
    }
}
