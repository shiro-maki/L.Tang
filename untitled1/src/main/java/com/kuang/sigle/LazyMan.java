package com.kuang.sigle;

public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    private static LazyMan lazyMan;
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan=new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(LazyMan::getInstance).start();
        }
    }
}
