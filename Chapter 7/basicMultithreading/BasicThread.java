package basicMultithreading;



public class BasicThread extends Thread{
    public String threadNo;
    public BasicThread(String i) {
        this.threadNo = i;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("running thread: "+ threadNo);
    }
}