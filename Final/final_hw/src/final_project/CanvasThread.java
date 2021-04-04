package final_project;

import GUI.CanvasEkrani;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class CanvasThread extends Thread{

//    public volatile boolean running;
    private Thread thread;
    CanvasEkrani canvas;
    Semaphore semaphore;
    AtomicBoolean running;


    public CanvasThread(CanvasEkrani c, Semaphore s, AtomicBoolean running){
        this.canvas = c;
        this.semaphore = s;
        this.running = running;
    }

    public synchronized void start(){
        //System.out.println("Canvas th start"+running);
        if (thread == null){
            thread = new Thread(this);
            thread.start();
        }

    }

    public synchronized void updatecanvas(){
        //System.out.println("updatecanvas a geldi."+running);
        try {
            semaphore.acquire();
            //System.out.println("Canvas threadde repaint yap.");
            canvas.updateCanvas();
            canvas.repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }

    }

    /**
     * Repaint canvas
     */
    public synchronized void run(){
        while (true){
            while (!running.get()){
                try {
//                    System.out.println("Canvas th wait!");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            System.out.println("Canvas thr run");
            updatecanvas();
            try {
//                System.out.println("1saniye CANVAS thread wait:!!");
                this.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
