package week1;

public class ThreadRunnableTest {
    public static void main(String[] args) throws InterruptedException{
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        MyThread thread2 = new MyThread();
        thread1.start();
        thread1.join();
        thread2.start();

    }
    
    
}
class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: "+i);
        }
    }
}
class MyRunnable implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable: "+i);
        }
    }
}

