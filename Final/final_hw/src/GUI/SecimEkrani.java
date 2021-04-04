package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SecimEkrani extends JFrame implements ActionListener {

    private final JLabel askuser_1;
    private final JLabel askuser_2;
    private final JTextField takeinput;
    private final JButton giris;


    public SecimEkrani(){

        setTitle("Final Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        setLayout(new GridLayout(4,1));

        askuser_1 = new JLabel("If you want to enter individuals please enter 1.");
        askuser_2 = new JLabel("If you want to add individuals automatically please enter 2.");
        takeinput = new JTextField(5);
        giris = new JButton("Enter");

        giris.addActionListener(this);

        add(askuser_1,0);
        add(askuser_2,1);
        add(takeinput,2);
        add(giris,3);
        setVisible(true);
    }


    /**
     * button bekleme
     * @param e button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Integer.parseInt(takeinput.getText()) == 2){
            dispose();
            new Giris_Ekrani();
        }
        else if(Integer.parseInt(takeinput.getText()) == 1){
            dispose();
            new TekTekGirisEkrani();
        }

    }
}
