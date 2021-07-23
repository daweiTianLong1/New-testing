package com.java.thread;

/**
 *
 *   一·、多线程创建的方式一：1.通过继承Thread类
 *                       2.重写Thread类中的run()方法
 *                       3.创建子类的对象
 *                       4.通过对象调用start()方法。注：直接通过对象调用调用run()方法不算多线程
 *   二、创建多线程的方式二：1.通过实现Runnable接口
 *                      2.在实现类中重写run()方法
 *                      3.创建实现类的对象
 *                      4.创建Thread类的对象，将实现类的对象作为参数传入
 *                      5.通过Thread类的对象实现start()方法
 *   三、Thread的静态方法currentThread()获取当前线程的状态
 *
 */
public class MyFThread {

    public static void main(String[] args) {

        //方式一创建线程
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("我是线程1");
        myThread1.start();

        //方式二创建线程
        MyThreadr2 myThreadr2 = new MyThreadr2();
        Thread thread1 = new Thread(myThreadr2);
        thread1.setName("我是线程2");
        thread1.start();
    }
}



class MyThread1 extends Thread{

    @Override
    public void run() {

        for(int i = 0;i <= 100;i++){

            if(i % 2 == 0){
                System.out.println(getName() + ":" + i +"是偶数");
            }

        }
    }
}

class MyThreadr2 implements Runnable{

    @Override
    public void run() {

        for(int i = 0;i <= 100;i++){

            if(i % 2 != 0){

                System.out.println(Thread.currentThread().getName() + ":" + i + "是奇数");

            }

        }


    }
}




