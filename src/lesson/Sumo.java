package lesson;

class SumoPlayer {
    public String name;
    public String signatureMove;
    public String signatureLine;

    public SumoPlayer(String name, String signatureMove, String signatureLine) {
        this.name = name;
        this.signatureMove = signatureMove;
        this.signatureLine = signatureLine;
    }

    //1/3の確率で得意技発動
    public boolean performSignatureMove() {
        return (int) (Math.random() * 3) == 0;
    }
}
class Enemy extends SumoPlayer {
    public Enemy(String name, String signatureMove, String signatureLine) {
        super(name, signatureMove, signatureLine);
    }
}

class Teammate extends SumoPlayer {

    public Teammate(String name, String signatureMove, String signatureLine) {
        super(name, signatureMove, signatureLine);
    }
}
public class Sumo {
    public static int playerIndex;
    public static int enemyIndex;
    public static void main(String[] args) {

        Teammate[] players = {
                new Teammate("サンジ", "寄り倒し", "くそお世話になりました！"),
                new Teammate("ゾロ", "寄り切り", "二度と負けねえから！"),
                new Teammate("ルフィ", "押し出し", "相撲王におれはなる！"),
        };

        Enemy[] enemies = {
                new Enemy("オーガー", "突き落とし", "これもまた巡り合わせ"),
                new Enemy("バージェス", "上手投げ", "ウィーハッハ！"),
                new Enemy("ティーチ", "浴びせ倒し", "人の夢は終わらねえ！"),
        };

        String msg;
        playerIndex = 0;
        enemyIndex = 0;
        do {
            System.out.println(players[playerIndex].name + " vs " + enemies[enemyIndex].name);
            System.out.println("のこった、のこった、のこった");
            while (true) {
                MyConsole.readLine();
                if (players[playerIndex].performSignatureMove() && enemies[enemyIndex].performSignatureMove()) {
                    System.out.println("互いの得意技がぶつかり合う・・・！");
                } else if (players[playerIndex].performSignatureMove()) {
                    System.out.println(players[playerIndex].signatureLine);
                    msg = players[playerIndex].name + "が" + players[playerIndex].signatureMove + "で勝ちました";
                    enemyIndex++;
                    break;
                } else if (enemies[enemyIndex].performSignatureMove()) {
                    System.out.println(enemies[enemyIndex].signatureLine);
                    msg = enemies[enemyIndex].name + "が" + enemies[enemyIndex].signatureMove + "で勝ちました";
                    playerIndex++;
                    break;
                } else {
                    System.out.println("互いに一歩も引かない・・・！");
                }
            }
            System.out.println(msg);

        } while (playerIndex != players.length && enemyIndex != enemies.length);

        String victoryOrDefeat;
        if (playerIndex == players.length) {
            victoryOrDefeat = "プレイヤーの負け";
        } else {
            victoryOrDefeat = "プレイヤーの勝利";
        }
        System.out.println(victoryOrDefeat);
    }
}
