package midterm_part4;

import java.util.ArrayList;

public class DCosineTransform extends DiscreteTransform {
    /**
     * set input file and output file names.
     * @param inputFile
     */
    DCosineTransform(String inputFile) {
        super(inputFile);
        outputFile = "./res/files/cosine.txt";
    }

    /**
     * Caltulate transform using Discrete Cosine Transform.
     */
    @Override
    void transformNumbers() {
        System.out.println("Transform in Cosine");
        int length = seq.size();
        out_seq = new ArrayList<ComplexNumber>(length);

        double f = Math.PI / length;
        for (int i = 0; i < length; i++) {
            double sum = 0.0;
            for (int j = 0; j < length; j++) {
                sum += seq.get(j).getReal() * Math.cos((j + 0.5) * i * f);
            }
            out_seq.add(i,new ComplexNumber(sum,0));
        }

    }
}
