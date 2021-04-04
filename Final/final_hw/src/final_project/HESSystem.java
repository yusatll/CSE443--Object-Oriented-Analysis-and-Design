package final_project;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class HESSystem implements Mediator{

    Semaphore semaphore;

    HastaneThread hastaneThread;
    Hospital hastane;

    private Individual[] individuals;
    private short[][] zombieland;

    private int population_sayisi;
    private final float R;

    AtomicBoolean run;


    public HESSystem(Semaphore s, AtomicBoolean running){
        //giris = new Giris_Ekrani();
        this.run = running;
        this.semaphore = s;
        zombieland = new short[1000][600];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 600; j++) {
                this.zombieland[i][j] = 0;
            }
        }
        Random random;
        random = new Random();
        R = (float) (0.5 + (1.0 - 0.5) * random.nextFloat());
    }

    /**
     * Populasyon sayısını al. Ve 2D individual ve kontrol arraylarını oluştur.
     * @param p populasyon sayısı
     */
    @Override
    public synchronized void setPopulation_sayisi(int p){
//        System.out.println("hataları otomatik oluştur.");
        this.population_sayisi = p;
        this.individuals = new Individual[p];
        this.hastane = new Hospital(p);
        this.hastane.setCapacity(p);
        this.hastaneThread = new HastaneThread(this.hastane,this.semaphore,this.run);
        designZombieland(p,true);
    }

    /**
     * hastaları kullanıcı girerse o ekrandakileri al.
     * @param ind girilen hastalar
     */
    @Override
    public synchronized void setIndividuals(Individual[] ind){
//        System.out.println("Hastaları dışardan aldık." + ind.length);
        this.individuals = ind;
        this.population_sayisi = ind.length;
        this.hastane = new Hospital(ind.length);
        this.hastane.setCapacity(ind.length);
        this.hastaneThread = new HastaneThread(this.hastane,this.semaphore,this.run);

        designZombieland(ind.length,false);
    }

    /**
     * Design our 2d short array.
     * @param len length
     * @param b individual control
     */
    private synchronized void designZombieland(int len,boolean b){
//        System.out.println("desing zombie " + b);
        for (int i = 0; i < len; i++) {
            if (b){
                this.individuals[i] = new Individual();
            }
            int[] x = individuals[i].getX();
            int[] y = individuals[i].getY();
            for (int j = x[0]; j < 5; j++) {
                for (int k = y[0]; k < 5; k++) {
                    this.zombieland[j][k] = individuals[i].getID();
                }
            }
        }
    }

    /**
     * individual ları hareket ettir.
     * çakışmaları kontrol et.
     * hastane kontrolü yap. 25 sn için
     */
    @Override
    public synchronized void moveIndividuals(){
        try {
            semaphore.acquire();
            // hepsini hareket ettir.
            for (Individual ind:this.individuals ) {
                move(ind);
            }
            // çakışma var mı kontrol et.
            checkCollesion();
            // covidleri kontrol et. 25 sn den uzun kalan varsa hastaneye gönder.
            hastaneye_gonder();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }

    /**
     * Covid olmuş ve süresi 25den fazla olanları hastanye gönder.
     */
    @Override
    public void hastaneye_gonder(){
        long now = System.currentTimeMillis()/1000;

        for (Individual ind: individuals) {
            if (ind.isCovid() && (now - ind.getTime()) >= 25){
                hastane.hastaneye_al(ind);
            }
        }
    }

    /**
     * bir individual ı hareket ettir.
     * @param ind
     */
    private synchronized void move(Individual ind){
        Random random = new Random();
        int []x = ind.getX();
        int []y = ind.getY();
        int s = ind.getSpeed();
        int yon = random.nextInt(4);

        updateInd(ind,false);
        switch (yon){
            case 0:
                // saga gidebiliyom mu
                if(x[4] + s < 1000){
                    for (int j = 0; j < 5; j++) {
                        x[j] += s;
                    }
                    break;
                }
                else yon = 1;
            case 1: // sola
                if (x[0] - s > 0){
                    for (int j = 0; j < 5; j++) {
                        x[j] -= s;
                    }
                    break;
                }
            case 2: // yukari
                if(y[0] - s > 0){
                    for (int j = 0; j < 5; j++) {
                        y[j] -= s;
                    }
                    break;
                }
            case 3: // asagi
                if(y[4] + s < 600){
                    for (int j = 0; j < 5; j++) {
                        y[j] += s;
                    }
                    break;
                }
                else yon = 0;
        }
        updateInd(ind,true);
    }


    /**
     * boolean arryi udate et. eski yeri sil. yeni yere al.
     * @param ind individual
     * @param add_remove ekle veya sil
     */
    private synchronized void updateInd(Individual ind, boolean add_remove){
        int x = ind.getX()[0];
        int y = ind.getY()[0];
        //System.out.println("Update " +x+ " " + y);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (add_remove){
                    this.zombieland[x+i][y+j] = ind.getID();
                }
                else{
                    this.zombieland[x+i][y+j] = 0;
                }
            }
        }
    }

    /**
     * Individuals
     * @return ind array
     */
    public Individual[] getIndividuals(){
        return individuals;
    }


    /**
     * individual lar arasında Covid olanlar başkalarıyla kesiştimi ona bak.
     * kesiştilerse hasta olacaklarmı hesapla.
     *
     */
    @Override
    public synchronized void checkCollesion() {

        for (int i = 0; i < this.population_sayisi; i++) {
            if (individuals[i].isCovid() && individuals[i].isVisible()){
//                System.out.println("Covid " + individuals[i].getID() + " etrafına bak." );
                // covidlinin etrafında kimse var mı? ID sini bul.
                short s = checkme(individuals[i]);
//                System.out.println("Etrafındaki : " + s);
                if (s != -1){
                    Individual ind = individuals[s];
                    // R * (1+C/10) * M_1 * M_2 * (1-D/10)
                    int C = Math.max(ind.getCoef(), individuals[i].getCoef());
                    int D = Math.min(ind.getSocialDistance(), individuals[i].getSocialDistance());
                    float check = R * (1 + C / 10) * ind.getMask() * individuals[i].getMask() * (1 - D / 10);
                    // P = min check, 1
                    float P = Math.min(check,1);
//                    System.out.println("Covid bulaştıdı mı: " + P + " - " + ind.ID);
                    if (P > 0.25){
                        ind.setCovid(true);
                        ind.setTime(System.currentTimeMillis()/1000);
                    }
                }
            }
        }
    }

    /**
     * ID ye göre individual bul
     * @param id ID
     * @return individual
     */
    private Individual getInd(short id){
        for (Individual ind: individuals) {
//            System.out.println(id + " ==== " + ind.getID());
            if (id == ind.getID()){
                return ind;
            }
        }
        return null;
    }

    /**
     * Individual etrafındaki individualları bul
     * @param i1 bunun etrafındakileri
     * @return bulunan individual
     */
    private synchronized short checkme(Individual i1){
        short ret = -1;
        int x = i1.getX()[0];
        int y = i1.getY()[0];
        // sol üst
        if (x > 1 && x < 995 && y > 1 && y < 595) {
            if (this.zombieland[x - 1][y - 1] != 0) {
                ret = this.zombieland[x - 1][y - 1];
            }
            // orta üst
            else if (this.zombieland[x + 2][y - 1] != 0) {
                ret = this.zombieland[x + 2][y - 1];
            }
            // sağ üst
            else if (this.zombieland[x + 5][y - 1] != 0) {
                ret = this.zombieland[x + 5][y - 1];
            }
            // orta sol
            else if (this.zombieland[x - 1][y + 2] != 0) {
                ret = this.zombieland[x - 1][y + 2];
            }
            // orta sağ
            else if (this.zombieland[x + 5][y + 2] != 0) {
                ret = this.zombieland[x + 5][y + 2];
            }
            // sol alt
            else if (this.zombieland[x - 1][y + 5] != 0) {
                ret = this.zombieland[x - 1][y + 5];
            }
            // orta alt
            else if (this.zombieland[x + 2][y + 5] != 0) {
                ret = this.zombieland[x + 2][y + 5];
            }
            // sağ alt
            else if (this.zombieland[x + 5][y + 5] != 0) {
                ret = this.zombieland[x + 5][y + 5];
            }
        }
        return ret;
    }


    /**
     * hastanedeki hasta sayısı
     * @return hastanedeki hasta sayısı
     */
    public synchronized int hastanedeki_hastalar(){
        return hastane.gethastanedekiler();
    }

    /**
     * Öluler
     * @return oluler
     */
    public synchronized int getOluler(){
        return this.hastane.olu_sayisi();
    }

    /**
     * toplam hasta
     * @return hastalar
     */
    public synchronized int gettoplam_hasta(){
        int count=0;
        for (Individual ind: individuals) {
            if (ind.isCovid()) count++;
        }
        return count;
//        return this.hastane.toplam_hasta();
    }



}
