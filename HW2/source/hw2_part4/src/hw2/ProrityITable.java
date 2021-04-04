package hw2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ProrityITable implements ITable{
    private Semaphore mutexWait = new Semaphore(1);
    private ArrayList<ArrayList<Object>> arrayLists;
    private int row;
    private int column;
    private int count;
    private int writerThreadSize;

    ProrityITable(int row, int column, int writerThreadSize){
        this.row = row;
        this.column = column;
        this.writerThreadSize = writerThreadSize;
        this.count = 0;
        arrayLists =  new ArrayList<ArrayList<Object>>(row);
        for (int i = 0; i < row; i++) {
            arrayLists.add(new ArrayList<>(column));
        }
    }

    /**
     * Set metodu toplam sayiya ulasirsa get metodu calisabilecek.
     * @param row int
     * @param column int
     * @return Object element
     */
    @Override
    public Object getElementAt(int row, int column) {
        //System.out.println("Get: "+ row);
        try {
            do {
                mutexWait.acquire();
                if (count < writerThreadSize){
                    mutexWait.release();
                }
                else{
                    break;
                }
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutexWait.release();
        return arrayLists.get(row).get(column);
    }

    /**
     * Setlerin sayisini tutuyoruz. Toplam sayiya ulasana kadar mutex i kilitliyoruz.
     * @param row int
     * @param column int
     * @param o Object
     */
    @Override
    public void setElementAt(int row, int column, Object o) {

        try {
            do {
                mutexWait.acquire();
                if (count < writerThreadSize){
                    break;
                }
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        if (arrayLists.get(row).isEmpty()) {
            arrayLists.get(row).add(column, o);
        }
        else{
            arrayLists.get(row).set(column,o);
        }
        System.out.println("Row: " + row + " Column: " + column +
                " SET: "+ o);
        mutexWait.release();
    }

    /**
     * return row
     * @return int row
     */
    @Override
    public int getNumberOfRows() {
        return this.row;
    }

    /**
     * return column
     * @return int column
     */
    @Override
    public int getNumberOfColumns() {
        return this.column;
    }
}
