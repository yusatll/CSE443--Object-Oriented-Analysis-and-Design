package GUI;

import final_project.HESSystem;
import final_project.Individual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Giris_Ekrani extends JFrame implements ActionListener {

    JLabel popi_sayisi_girin_text;
    JTextField populasyon_sayisi_tf;
    JButton popu_giris;


    public Giris_Ekrani(){
        setTitle("Final Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setLayout(new GridLayout(3,1));

        popi_sayisi_girin_text = new JLabel("Enter Population Number: ");
        populasyon_sayisi_tf = new JTextField(5);
        popu_giris = new JButton("Enter");

        popu_giris.addActionListener(this);

        add(popi_sayisi_girin_text,0);
        add(populasyon_sayisi_tf,1);
        add(popu_giris,2);
        setVisible(true);
    }

    /**
     * Button bekleme
     * @param e button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Enter")){
            int populasyon_sayisi = Integer.parseInt(populasyon_sayisi_tf.getText());
//        this.individuals = new Individual[populasyon_sayisi];
//        for (int i = 0; i < populasyon_sayisi; i++) {
//            this.individuals[i] = new Individual();
//        }
//            System.out.println("Popi sayısı. " + populasyon_sayisi);
            //setVisible(false);
            //removeAll();
            //size = populasyon_sayisi;
            remove(popi_sayisi_girin_text);
            remove(populasyon_sayisi_tf);
            remove(popu_giris);
            dispose();
            //this.hesSystem.setPopulation_sayisi(populasyon_sayisi);
            new CovidSimulation(populasyon_sayisi, null);
        }


    }


}
