package final_project;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class HastaneThread extends Thread {

    private Thread th;
    Hospital hastane;
    private AtomicBoolean running;
    private Semaphore semaphore;

    HastaneThread(Hospital h, Semaphore s, AtomicBoolean r){
        this.hastane = h;
        this.semaphore = s;
        this.running =r;
    }

    public void start(){
        if (th == null){
            th = new Thread();
            th.start();
        }
    }

    /**
     * update hastane class.
     */
    public void run(){
        while(true){
            while (!running.get()){
                try {
                    //System.out.println("HES thread wait:!!");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            hastane.hastane_update();

            try {
                //System.out.println("1saniye HES thread wait:!!");
                this.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
