package GUI;

import final_project.HESSystem;
import final_project.Individual;

import java.awt.*;

public class CanvasEkrani extends Canvas {

    private Graphics2D g;
    private HESSystem hes;

    public CanvasEkrani(HESSystem hesSystem){
        this.hes = hesSystem;
        setSize(1000,600);
    }

    @Override
    public synchronized void paint(Graphics g){
        //super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Individual[] individuals = this.hes.getIndividuals();
        for (int i = 0; i < individuals.length ; i++) {
            if (individuals[i].isVisible()) {
                g2.setColor(Color.BLUE);
                int[] x = individuals[i].getX();
                int[] y = individuals[i].getY();

                if (individuals[i].isCovid()) {
                    g2.setColor(Color.red);
//                    System.out.println(individuals[i].ID +" Hasta Kırmızı çiz X0 " + x[0] + " y0 " + y[0]);
                }
                g2.fillRect(x[0], y[0], 5, 5);
            }
        }
    }

    /**
     * updata canvas. repaint()
     */
    public void updateCanvas(){
        repaint();
    }

}
