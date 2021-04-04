package midterm_part4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DiscreteTransform {

    ArrayList<ComplexNumber> seq;
    ArrayList<ComplexNumber> out_seq;
    String inputFile;
    String outputFile;


    /**
     * set input file and create arraylist for inputs
     * @param inputFile
     */
    DiscreteTransform(String inputFile)
    {
        this.inputFile = "./res/files/" + inputFile;
        //System.out.println("abs class inp " + this.inputFile);
        seq = new ArrayList<ComplexNumber>();
    }

    /**
     * Will implement in DCT and DFT.
     */
    abstract void transformNumbers();

    /**
     * Calculate Transform Design
     */
    final void calculateTransform()
    {
        read_file();
        transformNumbers();
        write_file();
        hook();
    }

    /**
     * Read complex numbers from input file, split and register them.
     */
    final void read_file()
    {
        String line = "";
        System.out.println("Read File in Abstract Class: "+inputFile);
        File input = new File(inputFile);
        try {
            Scanner scan = new Scanner(input);
            line = scan.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println("Input: " + line);

        String [] splitted = line.split(" ");
        int k = 0;
        for (String s: splitted) {
            if (s.length() != 0)
            {
                String real = "0";
                String imaginary = "0";
                int l = s.length();

                int i=0;
                if (s.indexOf('+') != -1) {
                    i = s.indexOf('+');
                }
                else if(s.indexOf('-') != -1) {
                    i = s.indexOf('-');
                    if (i == 0)
                        i = s.indexOf('-',1);
                }

                if (i != 0) {
                    real = s.substring(0, i);
                }
                double r = Double.parseDouble(real);

                if (s.substring(l-1).equals("i")) {
                    imaginary = s.substring(i, l - 1);
                }

                double img = Double.parseDouble(imaginary);

                ComplexNumber c = new ComplexNumber(r,img);
                seq.add(k,c);
                k++;
            }
        }
    }

    /**
     * Write the result to output file.
     */
    final void write_file()
    {
        System.out.println("Write File in Abstract Class:" + outputFile);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (int i = 0; i < out_seq.size(); i++) {
                double r = out_seq.get(i).getReal();
                double img = out_seq.get(i).getImg();
                String s= "";
                if (img != 0){
                    s = r + "\t" + img + "i\n";
                }
                else {
                    s = r + "\n";
                }
                writer.write(s);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Made to free others.
     */
    void hook() { }

}
