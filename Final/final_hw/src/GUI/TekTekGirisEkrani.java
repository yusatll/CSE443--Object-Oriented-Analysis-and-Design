package GUI;

import final_project.Individual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TekTekGirisEkrani extends JFrame implements ActionListener {


    private JLabel askuser;
    private JLabel speed_text;
    private JLabel sd_text;
    private JLabel coef_text;
    private JLabel mask_text;

    private JTextField speed_inp;
    private JTextField sd_inp;
    private JTextField coef_inp;
    private JTextField mask_inp;

    private JButton giris;
    private JButton cont;

    ArrayList<Individual> individuals;


    public TekTekGirisEkrani() {
        individuals = new ArrayList();
        setTitle("Final Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new GridLayout(6, 2));

        askuser = new JLabel("Enter Individual Features: ");
        JLabel temp = new JLabel("");
        speed_text = new JLabel("Speed [1,500]:");
        sd_text = new JLabel("Social Distance [0,9]:");
        coef_text = new JLabel("Coefficient [1,5]:");
        mask_text = new JLabel("Mask [0-1]: ");


        speed_inp = new JTextField(5);
        sd_inp = new JTextField();
        coef_inp = new JTextField(1);
        mask_inp = new JTextField(1);

        giris = new JButton("Enter");
        cont = new JButton("Finish");
        giris.addActionListener(this);
        cont.addActionListener(this);

        add(askuser, 0);
        add(temp,1);
        add(speed_text, 2);
        add(speed_inp, 3);
        add(sd_text, 4);
        add(sd_inp, 5);
        add(coef_text, 6);
        add(coef_inp, 7);
        add(mask_text, 8);
        add(mask_inp, 9);
        add(giris,10);
        add(cont,11);

        setVisible(true);

    }


    /**
     * button bekleme
     * @param e button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Individual ind = new Individual();
        ind.setSocialDistance(Integer.parseInt(sd_inp.getText()));
        ind.setSpeed(Integer.parseInt(speed_inp.getText()));
        ind.setCoef(Integer.parseInt(coef_inp.getText()));
        ind.setMask(Integer.parseInt(mask_inp.getText()) == 1);
        individuals.add(ind);
        String str = e.getActionCommand();
        if (str.equals("Finish")) {
            dispose();
            Individual[] inds = new Individual[individuals.size()];
            new CovidSimulation(individuals.size(), individuals.toArray(inds));
        }
        else if (str.equals("Enter")){
//            System.out.println("len "+individuals.size());
            // update textfields
            speed_inp.setText("");
            sd_inp.setText("");
            coef_inp.setText("");
            mask_inp.setText("");
        }

    }
}
