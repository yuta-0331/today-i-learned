package reportCard_JDBC;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
    }

    public void executeFunction() {
        while (true) {
            view.displayMenu();
            int choiceNum = view.selectMenu();

            switch (choiceNum) {
                case 1:
                    view.displayList(model.getList());
                    break;
                case 2:
                    System.out.print("名前:");
                    String searchName = view.inputStr();
                    view.displayList(model.getSearchResults(searchName));
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }


    }

}
