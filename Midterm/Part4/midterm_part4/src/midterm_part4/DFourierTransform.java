package midterm_part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFourierTransform extends DiscreteTransform {
    private long exe_time;

    /**
     * set the input file and output file.
     * @param inputFile
     */
    DFourierTransform(String inputFile) {
        super(inputFile);
        //System.out.println("furies clas");
        outputFile = "./res/files/fourier.txt";
    }

    /**
     * calculate the transform using Discrete Fourier Transform.
     */
    @Override
    void transformNumbers() {

        int length = seq.size();
        System.out.println("Transform in Fourier.");
        out_seq = new ArrayList<ComplexNumber>(length);

        long start = System.nanoTime();
        for (int i = 0; i < length; i++) {
            double sum_real = 0.0;
            double sum_imgj = 0.0;
            for (int j = 0; j < length; j++) {
                double degree = 2 * Math.PI * j * i / length;
                sum_real += ( seq.get(j).getReal() * Math.cos(degree)) + (seq.get(j).getImg() * Math.sin(degree));
                sum_imgj += (-seq.get(j).getReal() * Math.sin(degree)) + (seq.get(j).getImg() * Math.cos(degree));
            }
            out_seq.add(i,new ComplexNumber(sum_real,sum_imgj));
        }
        exe_time = System.nanoTime() - start;
    }

    /**
     * Ask to user for write the execution time.
     */
    void hook() {
        String answer = askUser();
        if (answer.toLowerCase().startsWith("y")) {
            System.out.println("Time of Execution: "+ exe_time);
        }
    }

    /**
     * Get user input
     * @return user answer
     */
    private String askUser()
    {
        System.out.println("Do you want to know time of execution for DFT?");
        String answer = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
