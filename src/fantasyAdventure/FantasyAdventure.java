package fantasyAdventure;

public class FantasyAdventure {
    private static GameController gameController;

    public static GameController getGameController() {
        return gameController;
    }

    public static void main(String[] args) {
        gameController = new GameController();
        getGameController().executeBattle();

    }
}