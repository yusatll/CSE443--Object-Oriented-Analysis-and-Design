package final_project;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Hospital {
    private int capacity;
    private int hastane_counter;
    private int zombi_counter;

    Individual[] hastanedeki_hastalar;
    Individual[] zombi_hastalar;

    private int oluler;
    private final float Z;


    public Hospital(int c){
        this.capacity = c / 100;
        this.hastanedeki_hastalar = new Individual[this.capacity];

        this.zombi_hastalar = new Individual[c];

        this.hastane_counter = 0;
        this.zombi_counter = 0;
        this.oluler = 0;

        Random r = new Random();
        this.Z = (float) (0.1 + (0.9 - 0.1) * r.nextFloat());

    }

    /**
     * set capacit
     * @param c cap
     */
    public void setCapacity(int c){
        this.capacity = c / 100;
    }

    /**
     * Check individual and if capacity enough take it in.
     * @param ind take hospital
     */
    public void hastaneye_al(Individual ind){

        if (this.hastane_counter < this.capacity){

            hastanedeki_hastalar[this.hastane_counter] = ind;
            ind.setVisible(false);
            this.hastane_counter++;
        }
        else{
            zombi_hastalar[this.zombi_counter] = ind;
            this.zombi_counter++;
        }

        ind.setTime(System.currentTimeMillis()/1000);

    }

    /**
     * hastanedekileri geri gönder. 10sn süresi dolduysa. iyileştir.
     */
    public void hastane_update(){
        long now = System.currentTimeMillis()/1000;
        int c = hastane_counter;
        for (int i = 0; i < c; i++) {
            if (hastanedeki_hastalar[i] != null) {
                if (now - hastanedeki_hastalar[i].getTime() >= 10) {
                    // hastanede 10den fazla süre geçirmişse iyileştir geri gönder.
                    //System.out.println("Hasta iyileşti. " +hastanedeki_hastalar[i].getID());
                    hastanedeki_hastalar[i].setVisible(true);
                    hastanedeki_hastalar[i].setCovid(false);
                    hastanedeki_hastalar[i] = null;
                    hastanedeki_hastalar[i].setTime(now);
                    hastane_counter--;
                }
            }
        }
        // hasta olmuş ama hastaneye girememişler
        float olum_suresi = 100 * (1 - this.Z);
        for (int i = 0; i < zombi_counter; i++) {
            // 100*(1-Z) süreden fazladır hastalarsa ölürler.
            if (zombi_hastalar[i] != null) {
                if (olum_suresi < (now - zombi_hastalar[i].getTime())) {
                    // zombie ÖLÜR
//                System.out.println("Öldü " + zombi_hastalar[i].getID() );
                    zombi_hastalar[i].setVisible(false);
                    zombi_hastalar[i].setCovid(true);
                    zombi_hastalar[i] = null;
                    oluler++;
                } else {
                    // ölmezlerse hastaneye al.
                    hastaneye_al(zombi_hastalar[i]);
                }
            }
        }

    }

    /**
     * hastanede yatanlar
     * @return hastanedekiler
     */
    public int gethastanedekiler(){
        return this.hastane_counter;
    }

    /**
     * hastanedekiler ve etrafta dolaşanlar.
     * @return hastanedekiler ve dışardaki hastalar.
     */
    public int toplam_hasta(){
        return zombi_counter + hastane_counter;
    }

    /**
     * Ölenler.
     * @return ölenler
     */
    public int olu_sayisi(){
        return this.oluler;
    }



}
