package hello.pig;

public class SleepMessage implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		String[] importInfo = new String[] {"first","second","third", "four", "five"};
		for(String info : importInfo) {
			// pause sleep 4 second.
			Thread.sleep(4000);
			// print message
			System.out.println(info);
		}
	}

}
