package Problem5;

public class Question {

	//Notice the perfect use of locks and semaphores. One thing to notice is locks doesn't work here! (which is why
	// foobad will crash the program)
	public static void main(String[] args) {
		Foo foo = new Foo();
		
		MyThread thread1 = new MyThread(foo, "first");
		MyThread thread2 = new MyThread(foo, "second");
		MyThread thread3 = new MyThread(foo, "third");
		
		thread3.start();
		thread2.start();
		thread1.start();
	}
}
