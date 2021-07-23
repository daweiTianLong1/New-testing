package com.java.thread;

/**
 *      一、能使得线程处于堵塞状态的方法有哪些：sleep(int mills) 会使得线程休眠 mills:毫秒数。
 *                                      join() 调用此方法时会使得线程进入堵塞状态。如：在主线程 A 中调用  b.join()会使得线程A进入堵塞状态
 *      二、线程的安全问题:线程本身是不存在安全问题的，但是当线程之间共享数据时，就会出现线程安全问题（读不会出现问题，但是写会出现问题）。
 *                      什么是线程安全？线程安全指的是多线程调用同一个对象的临界区的方法时，对象的属性值一定不会发生错误，这就是保证了线程安全。
 *
 */



public class MyThead {

    public static void main(String[] args) {

        Mythread mythread = new Mythread();
        Thread thread = new Thread(mythread);
        Thread thread1 = new Thread(mythread);
        Thread thread2 = new Thread(mythread);
        thread.setName("我是售票窗口1:");
        thread1.setName("我是售票窗口2:");
        thread2.setName("我是售票窗口3:");
        thread.start();
        thread1.start();
        thread2.start();

    }

}



class Mythread implements Runnable{

    public static int tickets = 1000;

    Object obj = new Object();


    @Override
    public void run() {

        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出的票的号数为：" + tickets);
                    tickets--;
                } else {
                    break;
                }

            }
        }
    }
}

