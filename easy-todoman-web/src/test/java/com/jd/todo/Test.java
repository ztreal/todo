package com.jd.todo;

import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-11-5
 * Time: 下午6:13
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    class Producer implements Runnable {
       private final BlockingQueue queue;
       Producer(BlockingQueue q) { queue = q; }
       public void run() {
         try {
           while(true) { queue.put(produce()); }
         } catch (InterruptedException ex) { }
       }
       Object produce() { return null; }
     }

     class Consumer implements Runnable {
       private final BlockingQueue queue;
       Consumer(BlockingQueue q) { queue = q; }
       public void run() {
         try {
           while(true) { consume(queue.take()); }
         } catch (InterruptedException ex) { }
       }
       void consume(Object x) {   }
     }

     class Setup {
       void main() {
//         BlockingQueue q = new SomeQueueImplementation();
//         Producer p = new Producer(q);
//         Consumer c1 = new Consumer(q);
//         Consumer c2 = new Consumer(q);
//         new Thread(p).start();
//         new Thread(c1).start();
//         new Thread(c2).start();
       }
     }

}
