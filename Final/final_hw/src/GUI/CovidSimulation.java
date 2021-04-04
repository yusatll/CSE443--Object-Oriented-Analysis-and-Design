package GUI;

import final_project.CanvasThread;
import final_project.HESSystem;
import final_project.HESThread;
import final_project.Individual;

import javax.swing.*;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class CovidSimulation extends JFrame implements ActionListener {

    HESSystem hes;
    final Semaphore semaphore;
    //public volatile boolean running;
    AtomicBoolean running;
    HESThread ht;
    CanvasThread ct;
    Thread table;

    long time;
    long temp_time;

    CanvasEkrani canvas;
    JButton start;
    JButton pause;
    JButton cont;
    JLabel total_hasta;
    JLabel total_saglikli;
    JLabel people_hosp;
    JLabel dead_people;

    private int hasta;
    private int saglikli;
    private int hastanede;
    private int olmus;


    public CovidSimulation(int popi, Individual[] ind){
        this.running = new AtomicBoolean();
        this.running.set(true);
        this.semaphore = new Semaphore(1);
        this.hes = new HESSystem(this.semaphore,this.running);
        if (ind == null) {
            this.hes.setPopulation_sayisi(popi);
        }
        else{
            hes.setIndividuals(ind);
        }

        saglikli = popi;
        hasta = 1;
        olmus = 0;
        hastanede = 0;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,1000);
        setLayout(new GridBagLayout());



        start = new JButton("Start");
        pause = new JButton("Pause");
        cont = new JButton("Continue");

        start.addActionListener(this);
        pause.addActionListener(this);
        cont.addActionListener(this);

        total_hasta = new JLabel("Total Infected: " + hasta);
        total_saglikli = new JLabel("Total Healthy: " + saglikli);
        people_hosp = new JLabel("People in the Hospital: " + hastanede);
        dead_people = new JLabel("Dead People: " + olmus);



        this.canvas = new CanvasEkrani(this.hes);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridheight = 8;
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;


        ekle(1,0,start);
        ekle(1,1,pause);
        ekle(1,2,cont);
        ekle(1,3,total_hasta);
        ekle(1,4,total_saglikli);
        ekle(1,5,people_hosp);
        ekle(1,6,dead_people);

        add(canvas,gbc);
        setVisible(true);
    }

    /**
     * Layout a component ekleme
     * @param x gridx
     * @param y gridy
     * @param c Component
     */
    private void ekle(int x,int y, Component c){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = x;
        gbc.gridy = y;
        this.add(c,gbc);
    }

    /**
     * Button bekleme
     * @param e button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Start")){
            // new hesthread
            if(this.hes.getIndividuals()[1].isCovid()){
                this.hes.getIndividuals()[1].setTime(System.currentTimeMillis()/1000);
            }

            this.running.set(true);
            ht = new HESThread(this.hes,this.running);
            ht.start();
            // canvas repaint
            ct = new CanvasThread(this.canvas,this.semaphore,this.running);
            ct.start();
            time = 0;
            temp_time = System.currentTimeMillis()/1000;
            table = new Thread(()->table_update());
            table.start();
        }
        else if(str.equals("Pause")){
            // hesthread stop wait()
            this.running.set(false);
        }
        else if(str.equals("Continue")){
            // hesthread notify
            this.running.set(true);
            synchronized (ht) {
                ht.notify();
            }
            synchronized (ct){
                ct.notify();
            }
            synchronized (table){
                table.notify();
            }
        }
    }


    /**
     * Update numbers.
     */
    private void table_update() {
        while(true){
            while (!running.get()){
                synchronized (table){
                    try {
                        table.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            hastanede = hes.hastanedeki_hastalar();
            hasta = hes.gettoplam_hasta();
            saglikli = hes.getIndividuals().length - hasta;
            olmus = hes.getOluler();

            total_hasta.setText("Total Infected: " + hasta);
            total_saglikli.setText("Total Healthy: " + saglikli);
            people_hosp.setText("People in the Hospital: " + hastanede);
            dead_people.setText("Dead People: " + olmus);

            synchronized (table){
                try {
                    table.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
