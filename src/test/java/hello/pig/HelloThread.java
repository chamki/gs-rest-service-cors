package hello.pig;

public class HelloThread extends Thread{

	@Override
	public void run() {
		System.out.println("Hello from thread!");
	}
	
	public static void main(String[] args) {
		new HelloThread().start();
	}

	
}
