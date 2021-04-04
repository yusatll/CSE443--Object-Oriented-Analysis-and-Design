package midterm_part4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Enter file name: ");
        Scanner sc = new Scanner(System.in);
        String inputFile = sc.nextLine();

        DFourierTransform fourier = new DFourierTransform(inputFile);
        fourier.calculateTransform();

        DCosineTransform cosine = new DCosineTransform(inputFile);
        cosine.calculateTransform();
    }
}
