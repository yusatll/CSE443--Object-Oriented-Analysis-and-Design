package midterm_part3;

public class MacroOperations implements DatabaseOperations {
    DatabaseOperations[] operations;
    private int state;

    public MacroOperations(DatabaseOperations[] ops) {
        this.operations = ops;
        this.state = ops.length;
    }

    /**
     * don't have ID
     * @return 0
     */
    @Override
    public int getID() {
        return 0;
    }

    /**
     * Run operations' run methods if one is fail, undo previous operations.
     * @return 0
     */
    @Override
    public int runOperation() {

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].runOperation() != 1){
                System.out.println("One operation is failed. Undo all operations.");
                state = i;
                break;
            }
        }

        if (state != operations.length)
        {
            undoOperation();
        }
        return 0;
    }

    /**
     * undo all operations.
     */
    @Override
    public void undoOperation() {
        for (int i = state; i >= 0; i--) {
            operations[i].undoOperation();
        }
    }
}
