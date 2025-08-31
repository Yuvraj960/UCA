import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Common Counter Class.
*/

public class CommonCounter {
  public int count;

  /**
   * Creating a Lock OBJ.
   * Used to put a lock on the resource.
   */
  public ReentrantLock lock;

  /**
   * Many more info.
   */

  public CommonCounter() {
    this.count = 0;
    this.lock = new ReentrantLock();
  }

  /**
   * This method increment the count by 1.
   * Here "synchronised" is used so the count can only be used by 1 thread.
   * Another method is by creating our own lock by using Reenterant Lock.
   *
   */
  public void increment() {
    while (!lock.tryLock()) {
      // this loop ensures that until we get a lock for this thread it keeps trying
    }
    this.count += 1;
    // since we updated
    // lock.unlock();
  }

  /**
   * Runnable class for the resource.
  */

  static class MyRunnable implements Runnable {
    // CommonCounter resource;
    AtomicInteger resource;
    int number;

    MyRunnable(AtomicInteger resource, int n) {
      this.resource = resource;
      this.number = n;
    }

    @Override
    public void run() {
      // Thread.sleep((new Random()).nextInt(3));
      for (int i = 0; i < number; i++) {
        resource.incrementAndGet();
      }
    }
  }

  /**
   * The main class for running the program.
  */

  public static void main(String[] args) throws InterruptedException {
    AtomicInteger resource = new AtomicInteger(0);
    Thread thread1 = new Thread(new MyRunnable(resource, 1000000));
    Thread thread2 = new Thread(new MyRunnable(resource, 1000000));

    thread1.start();
    thread2.start();
    thread1.join();  // when we want to join the thread in the main thread
    thread2.join();  // when we join, the main thread stops therefore there might be interrupt
    // hence we throw an InterruptedException
    System.out.println(resource.get());
    // here we are printing the val before the thread finished executing
  }
}
