package com.cndevxm.concurrent.lock.sync.scenarios;

import lombok.SneakyThrows;

import java.util.*;

/**
 * 使用synchronized实现生产这消费者模型
 * 1、本质上是通过wait()与notify()来实现，定时唤醒生产端与消费端
 * 2、因为竞争的是互斥锁，所以只能有一个生产者和消费者
 */
public class ProducerAndConsumer {

    private static Queue<Integer> repository = new ArrayDeque<>();
    private static Object lock = new Object();

    @SneakyThrows
    public static void main(String[] args) {

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }


    /**
     * 生产者
     */
    private static class Producer implements Runnable {

        @SneakyThrows
        @Override
        public void run() {

            for (; ; ) {
                // 获取锁
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        // 进行生产
                        repository.add(i);
                        System.out.println("生产者-正在生产第" + i + "件商品");
                    }
                    // 生产完成
                    // 唤醒消费线程
                    lock.notify();
                    // wait生产线程并让出锁
                    lock.wait();
                }
            }
        }
    }

    
    /**
     * 消费者
     */
    private static class Consumer implements Runnable {

        @SneakyThrows
        @Override
        public void run() {

            for (; ; ) {
                // 获取锁
                synchronized (lock) {
                    for (; ; ) {
                        Integer poll = repository.poll();
                        if (null == poll) {
                            break;
                        }
                        System.out.println("消费者-正在消费第" + poll + "件商品");
                    }
                    // 消费完成
                    // 唤醒生产线程
                    lock.notify();
                    // wait消费线程并让出锁
                    lock.wait();
                }
            }
        }
    }
}
