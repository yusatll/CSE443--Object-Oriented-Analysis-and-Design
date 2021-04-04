package midterm_part3;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SelectOperation s1 = new SelectOperation(1);
        SelectOperation s2 = new SelectOperation(2);
        SelectOperation s3 = new SelectOperation(3);

        AlterOperations a1 = new AlterOperations(1);
        AlterOperations a2 = new AlterOperations(2);
        AlterOperations a3 = new AlterOperations(3);

        UpdateOperations u1 = new UpdateOperations(1);
        UpdateOperations u2 = new UpdateOperations(2);
        UpdateOperations u3 = new UpdateOperations(3);


        DatabaseOperations[] fail_operations = {s1, a1, a2, u1, s2, u2, s3, a3, u3};
        MacroOperations mac = new MacroOperations(fail_operations);

        mac.runOperation();
        System.out.println();
        //mac.undoOperation();

        DatabaseOperations[] completed_ops = {s1, s2, a1, s3, a2, s3};
        mac = new MacroOperations(completed_ops);
        mac.runOperation();


    }
}
