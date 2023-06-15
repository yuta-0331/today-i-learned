package studentManagement;

public class Exec {

    public static void main(String[] args) {
        FunctionController fc = new FunctionController();
        fc.executeFunction();
        fc.getScan().close();
    }
}
