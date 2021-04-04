package midterm_part3;

import java.util.Random;

public class UpdateOperations implements DatabaseOperations {
    private int id;

    /**
     * Constructor takes an ID
     * @param id unique
     */
    UpdateOperations(int id)
    {
        this.id = id;
    }

    /**
     * get the ID
     * @return ID
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
        System.out.println("UPDATE " + id + " run.");
        return r.nextInt(2);
    }

    /**
     * Undo operation.
     */
    @Override
    public void undoOperation() {
        System.out.println("UPDATE " + id + " undo.");
    }
}
