package hw2;

import java.util.ArrayList;

public class ThreadITable implements ITable {
    private ArrayList<ArrayList<Object>> arrayLists;
    private int row;
    private int column;

    ThreadITable(int row, int column){
        this.row = row;
        this.column = column;

        arrayLists =  new ArrayList<ArrayList<Object>>(row);
        for (int i = 0; i < row; i++) {
            arrayLists.add(new ArrayList<>(column));
        }
    }

    /**
     * Senkron Get metodu
     * @param row int row
     * @param column int column
     * @return Object element
     */
    @Override
    public synchronized Object getElementAt(int row, int column) {
        return arrayLists.get(row).get(column);
    }

    /**
     * Set o object.
     * @param row int row
     * @param column int column
     * @param o object
     */
    @Override
    public synchronized void setElementAt(int row, int column, Object o) {
        if (arrayLists.get(row).isEmpty()) {
            arrayLists.get(row).add(column, o);
        }
        else{
            arrayLists.get(row).set(column,o);
        }
        System.out.println("Row: " + row + " Column: " + column +
                " SET: "+ o);
    }

    /**
     * return row
     * @return row
     */
    @Override
    public synchronized int getNumberOfRows() {
        return this.row;
    }

    /**
     * return column
     * @return column
     */
    @Override
    public synchronized int getNumberOfColumns() {
        return this.column;
    }
}
