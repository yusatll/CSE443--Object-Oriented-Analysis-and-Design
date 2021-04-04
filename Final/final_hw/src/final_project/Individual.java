package final_project;

import java.util.Random;

public class Individual {
    private static short unique = 0;
    public  short ID = unique++;
    private int SocialDistance;     // D
    private int Speed;              // S
    private int Coef;               // C
    private float Mask;            // M
    private int [] X;
    private int [] Y;
    private long time;               // hastalıkla geçirdiği süre
    private boolean covid;
    private boolean visible;

    public Individual(){
        // range : (max-min+1) + min
        Random random = new Random();
        this.SocialDistance = random.nextInt(10);    // 0 - 9
        this.Speed = random.nextInt(499) + 1;
        this.Coef  = random.nextInt(4) + 1;
        boolean m = random.nextBoolean();
        if (m){
            this.Mask = (float) 0.2;
        }
        else {
            this.Mask = (float) 1.0;
        }
        int x = random.nextInt(995) + 3;
        int y = random.nextInt(595) + 3;
        this.X = new int[5];
        this.Y = new int[5];
        for (int i = 0; i < 5; i++) {
            this.X[i] = x - 2;
            this.Y[i] = y - 2;
            x++;
            y++;
        }

        if (ID == 1){
            this.covid = true;
            System.out.println("İlk Hasta oluşturdu. X: " + X[0] + " - " + Y[0] );
        }
        else{
            this.covid = false;
        }
        this.time = 0;
        this.visible = true;
//        System.out.println("İND oluşturuldu " + ID);
    }

    public boolean isVisible(){
        return this.visible;
    }

    public void setVisible(boolean b){
        this.visible = b;
    }

    public int getCoef() {
        return Coef;
    }

    public short getID() {
        return ID;
    }

    public long getTime(){
        return this.time;
    }

    public void setTime(long t){
        this.time = t;
    }

    public boolean isCovid(){
        return this.covid;
    }
    public void setCovid(boolean b){
        this.covid = b;
    }

    public int getSpeed() {
        return this.Speed;
    }
    public int[] getX(){
        return this.X;
    }
    public int[] getY(){
        return this.Y;
    }


    public float getMask() {
        return this.Mask;
    }

    public int getSocialDistance() {
        return SocialDistance;
    }
    public void setSocialDistance(int d){
        this.SocialDistance = d;
    }
    public void setSpeed(int s){
        this.Speed = s;
    }
    public void setCoef(int c){
        this.Coef = c;
    }

    public void setMask(boolean m){
        if (m){
            this.Mask = (float) 0.2;
        }
        else {
            this.Mask = (float) 1.0;
        }
    }
}
