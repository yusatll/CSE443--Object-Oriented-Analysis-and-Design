package hw2;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] data1 = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

        int[][] data2 = {{1,2,3,4,5},
                         {6,7,8,9,10},
                         {11,12,13,14,15},
                         {16,17,18,19,20},
                         {21,22,23,24,25}};

        Satellite satellite = new Satellite(data1);
        Iterator satellitedata = satellite.createIterator();

        while (satellitedata.hasNext()) {
            System.out.println(satellitedata.next());
        }


    }
}
