package com.test;

public class Main {
    public static void main(String[] args) {
//        System.err.println(new Thread().getState());

        Thread th = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
//                    Thread.sleep(100);
                    System.err.println(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        th.start();

        System.err.println(th.getState());
    }

    public synchronized void m () {

    }
}
