package week1;

public class SyncTest {
    public static void main(String[] args)throws InterruptedException {
        SharedData data = new SharedData();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                data.increment();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 1000; i++){
                data.increment();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(data.data);

            

    }
    
}
class SharedData{
    public int data = 0;
    //동기화
    synchronized public void increment(){
        data++;
    }
}
