package midterm_part4;

public class ComplexNumber {
    private double real;
    private double img;

    public ComplexNumber(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public String toString()
    {
        String s = this.real + this.img + "i";
        return s;
    }
}
