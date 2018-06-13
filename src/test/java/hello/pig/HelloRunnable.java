package hello.pig;

/**
 * Object implements Runnable is use general, because Runnable can subclass other class and object can implements more than one interface
 * @author root
 *
 */
public class HelloRunnable implements Runnable{

	public static void main(String[] args) {
		new Thread(new HelloRunnable()).start();

	}

	@Override
	public void run() {
		System.out.println("Hello from thread!");
		
	}

}
