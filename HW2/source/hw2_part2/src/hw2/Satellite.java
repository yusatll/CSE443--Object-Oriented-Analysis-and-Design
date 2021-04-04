package hw2;

import java.util.Iterator;

public class Satellite implements IteratorInterface{

    private int[][] data;

    /**
     * Veriyi mainden al
     * @param d data
     */
    public Satellite(int [][] d) {
        this.data = d;
    }

    /**
     * Iteratörü oluştur.
     * @return SatelliteIterator
     */
    @Override
    public Iterator createIterator() {
        return new SatelliteIterator(data);
    }
}
