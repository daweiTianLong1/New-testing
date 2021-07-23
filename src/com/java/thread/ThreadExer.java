package com.java.thread;

public class ThreadExer {

    public static void main(String[] args) {

        Customer customer = new Customer(new Bank(100));
        Thread thread1 = new Thread(customer);
        Thread thread2 = new Thread(customer);

        thread1.setName("这是线程1：");
        thread2.setName("这是线程2：");

        thread1.start();
        thread2.start();
    }

}

class Bank{

    private double Balance;

    public Bank(double Balance){
        this.Balance = Balance;
    }

    public synchronized void balance(double money) {

        if(money > 0){
            Balance += money;

//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + Balance);

        }

    }
}


class Customer implements Runnable{

    private Bank bank;

    public Customer(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {

        for (int i = 0;i < 30;i++){
            bank.balance(1000);
        }

    }
}