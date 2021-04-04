package final_project;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class HESThread extends Thread {
    private Thread t;
    HESSystem hes;

//    public volatile boolean running;
    AtomicBoolean running;


    public HESThread(HESSystem h, AtomicBoolean running){
       this.hes = h;
       this.running = running;
    }

    /**
     * New thread start
     */
    public synchronized void start(){
        if (t == null){
            t = new Thread(this);
            t.start();
        }
        //System.out.println("hes thread start"+running);
    }

    /**
     * Individual ları hareket ettirir.
     */
    public synchronized void run(){
        while(true){
            while (!running.get()){
                try {
                    //System.out.println("HES thread wait:!!");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.hes.moveIndividuals();

            try {
                //System.out.println("1saniye HES thread wait:!!");
                this.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
