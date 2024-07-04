package basicMultithreading;



public class BasicThread extends Thread{  //This class extends Thread, meaning each instance of BasicThread represents a separate thread of execution.
    public String threadNo;
    public BasicThread(String i) {
        this.threadNo = i;
        System.out.println(i);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("running thread: "+ threadNo);
    }
}