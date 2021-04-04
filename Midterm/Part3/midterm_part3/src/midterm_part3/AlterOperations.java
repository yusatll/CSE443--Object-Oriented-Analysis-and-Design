package midterm_part3;

import java.util.Random;

public class AlterOperations implements DatabaseOperations {
    private int id;

    AlterOperations(int id)
    {
        this.id = id;
    }

    /**
     * return unique ID
     * @return id
     */
    @Override
    public int getID() {
        return id;
    }

    /**
     * Run operation and generate a random integer for success or not.
     * @return success or not.
     */
    @Override
    public int runOperation() {
        Random r = new Random();
        System.out.println("ALTER " + id + " run.");
        return r.nextInt(2);
    }

    /**
     * Undo operation.
     */
    @Override
    public void undoOperation() {
        System.out.println("ALTER " + id + " undo.");
    }
}
