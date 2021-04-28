import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Consumer implements Runnable {

	BlockingQueue<Integer> con;
	int taken = -1;

	public Consumer(BlockingQueue<Integer> con) {
		this.con = con;
	}

	@Override
	public void run() {
		while (taken != 10) {
			try {
				taken = con.take();
				System.out.println("Consumed By consumer : " + taken);
			} catch (InterruptedException e) {
			}
		}

	}

}

class Producer implements Runnable {

	BlockingQueue<Integer> pro;

	public Producer(BlockingQueue<Integer> pro) {
		this.pro = pro;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				pro.put(i);
				System.out.println("Produced By producer : " + i);
			} catch (InterruptedException e) {

			}
		}

	}

}

public class ConsumerAndProducer {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(consumer);
		executorService.submit(consumer);

		executorService.shutdown();
	}
}
