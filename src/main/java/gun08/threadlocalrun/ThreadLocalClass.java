package gun08.threadlocalrun;

import java.util.ArrayList;

public class ThreadLocalClass {

    // her thread için ayri bir değer tutar
    public static ThreadLocal<String> strings = new ThreadLocal<>();


    public static String string;

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                strings.set(Thread.currentThread().getName());
                string = "a";
                System.out.println(strings.get() + ", " + string);
            }
        };
        Thread t1 = new Thread("T1");
        Thread t2 = new Thread("T2");
        t1.start();
        t2.start();
    }
}
