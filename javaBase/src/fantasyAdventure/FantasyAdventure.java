package fantasyAdventure;

public class FantasyAdventure {
    public static void main(String[] args) {
        System.out.println(
                "*味方3人対魔王軍（三体）のターン制バトルゲームです"
                + "\n*初めに3人の名前とJobを選択してパーティを作成します"
                + "\n*「たたかう」「ぼうぎょ」または、各Job毎の固有のコマンドを選択して戦闘を進めます"
                + "\n*魔王軍を倒して、姫を救い出しましょう！"
        );
        new GameController().executeBattle();
    }
}