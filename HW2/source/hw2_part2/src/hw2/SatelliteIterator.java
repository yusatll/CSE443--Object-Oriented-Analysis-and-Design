package hw2;

import java.util.Iterator;

public class SatelliteIterator implements Iterator {
    private int column_min, column_max, column ;
    private int row_min, row_max, row;
    private int last_element;
    private int [][] data;
    private int col_or_row; // 1 için row, 0 için column

    public SatelliteIterator(int [][] d)
    {
        this.data = d;
        this.row = 0;
        this.row_min = 0;
        this.row_max = data.length - 1;
        this.column = 0;
        this.column_min = 0;
        this.column_max = data.length - 1;
        this.last_element = 0;
        this.col_or_row = 1;
    }


    /**
     * Saat yonunde olacak sekilde sonraki elemani kontrol ediyoruz.
     * @return Sonraki eleman var mi
     */
    @Override
    public boolean hasNext() {

        if (row_min == row_max && column_max == column_min) {
            if (last_element == 0) {
                column = column_max;
                row = row_max;
                last_element = 1;
                return true;
            }
            return false;
        }

        // Row da hareket ediyorsa.
        if (col_or_row == 1)
        {
            // row da sağa doğru git
            if (row == row_min)
            {
                if (column < column_max){
                    return true;
                }
                else if (column == column_max){
                    col_or_row = 0;
                    row_min++;
                    return true;
                }
            }
            // row da sola doğru git
            else if (row == row_max)
            {
                if (column_min < column){
                    return true;
                }
                else if (column_min == column){
                    col_or_row = 0;
                    row_max--;
                    return true;
                }
            }
        }
        // column da hareket et.
        else if (col_or_row == 0)
        {
            // columnda aşağı doğru hareket
            if (column == column_max)
            {
                if (row < row_max){
                    return true;
                }
                else if (row == row_max)
                {
                    col_or_row = 1;
                    column_max--;
                    return true;
                }
            }
            // column da yukarı doğru hareket
            else if (column == column_min)
            {
                if (row_min < row){
                    return true;
                }
                else if (row_min == row)
                {
                    column_min++;
                    col_or_row = 1;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Suan ki elemanı donduruyoruz. Ve konumumuzu degistiriyoruz.
     * @return suan ki eleman
     */
    @Override
    public Object next() {
        int r = data[row][column];
//        System.out.printf("Row %d, rowmin: %d, rowmax: %d " ,row, row_min, row_max);
//        System.out.printf("Column %d, Colmin: %d, Colmax: %d" ,column, column_min, column_max);

        if (last_element == 1){
            return r;
        }

        // rowda hareket et.
        if (col_or_row == 1)
        {
            if (row_max == row_min) {
                row = row_max;
            }
            else if (row == row_min) {
                column++;
            }
            else if (row == row_max) {
                column--;
            }
        }
        // columnda hareket et.
        else if (col_or_row == 0)
        {
            if (column_max == column_min){
                column = column_max;
            }
            else if (column == column_max) {
                row++;
            }
            else if (column == column_min) {
                row--;
            }
        }

        return r;
    }
}
