package hello.pig;

public class SimpleThread {
	
	
	public static void main(String[] args) {
		// Delay, in milliseconds before we interrupt MessageLoop thread (defult an hour). 
		long patience = 1000 * 60 * 60;
		
		// if command argument present, give patinece in second
		if(args.length > 0) {
			try {
			patience = (Long.parseLong(args[0])) * 1000;
			} catch(NumberFormatException e) {
				System.err.println("Argument must be an integer");
				System.exit(-1);
			}
		}
		
		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		
		threadMessage("Waiting for MessageLoop thread to finish.");
		//Loop until MessageLoop thread exit
		while(t.isAlive()) {
			threadMessage("still Waiing...");
			try {
				//wait maximum 1 second for MessageLoop thread to finish
				t.join(1000);
				if(System.currentTimeMillis() - startTime > patience && t.isAlive()) {
					threadMessage("Tired waiting...");
					t.interrupt();
					//shouldn't be long now, wait indefinitely
					t.join();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		threadMessage("finally!");
	}

	/**
	 * deploy message, preceded by the name of current thread
	 * @param message
	 */
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}
	
	private static class MessageLoop implements Runnable {

		@Override
		public void run() {
			String importInfo[] = {"Mares eat oats",
	                "Does eat oats",
	                "Little lambs eat ivy",
	                "A kid will eat ivy too"};
			
			for(String info : importInfo) {
				try {
					//Pause 4 second
					Thread.sleep(4000);
					//Print a message
					System.out.println(info);
				} catch (InterruptedException e) {
					e.printStackTrace();
					threadMessage("I wasn't done!");
				}
			}
		}
		
	}
	
}
