package basicMultithreading;


public class ThreadingMain {
    public static void main(String[] args) {

        BasicThread t1 = new BasicThread("FIRST");
        BasicThread t2 = new BasicThread("SECOND");
        BasicThread t3 = new BasicThread("THIRD");
        BasicThread t4 = new BasicThread("FOURTH");
        BasicThread t5 = new BasicThread("FIFTH");
        BasicThread t6 = new BasicThread("SIXTH");
        BasicThread t7 = new BasicThread("SEVENTH");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}