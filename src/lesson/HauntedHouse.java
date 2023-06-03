package lesson;

class Ghost {
    public String name;
    public String sex;
    public String finishingMove;
    public int scaryLevel;
    public int finishingMoveGauge = 1;


    Ghost(String name, String finishingMove) {
        this.name = name;
        this.finishingMove = finishingMove;
        this.scaryLevel = (int) (Math.random() * 6 + 1);
        int sexNum = (int) (Math.random() * 2);
        if (sexNum == 0) {
            this.sex = "女";
        } else {
            this.sex = "男";
        }
    }
}

class Human {
    public String name;
    public String sex;
    public String finishingMove;
    public int scaredLevel;
    public int finishingMoveGauge = 1;

    Human(String name, String sex, String finishingMove, int scaredLevel) {
        this.name = name;
        this.sex = sex;
        this.finishingMove = finishingMove;
        this.scaredLevel = scaredLevel;

    }
}

public class HauntedHouse {

    public static void main(String[] args) {

        Human[] humans = {
                new Human("ナミ", "女", "クリマタクト", (int) (Math.random() * 10 + 1)),
                new Human("サンジ", "男", "ディアブルジャンプ", (int) (Math.random() * 5 + 6)),
                new Human("ゾロ", "男", "三千世界", (int) (Math.random() * 8 + 3)),
                new Human("ルフィ", "男", "Jetピストル", (int) (Math.random() * 6 + 5)),
        };

        Ghost[] ghosts = {
                new Ghost("ゴーストA", "あああ"),
                new Ghost("ゴーストB", "いいい"),
                new Ghost("ゴーストC", "ううう"),
                new Ghost("ゴーストD", "えええ"),
                new Ghost("ゴーストE", "おおお"),
        };

        int humansIndex = 0;
        int ghostsIndex = 0;
        System.out.println("ゲームを開始します");
        MyConsole.readLine();
        while (true) {
            int humanPower = humans[humansIndex].scaredLevel;
            int ghostPower = ghosts[ghostsIndex].scaryLevel;
            System.out.println("プレイヤー: " + humanPower);
            System.out.println("敵: " + ghostPower);
            if (humans[humansIndex].name.equals("サンジ") && ghosts[ghostsIndex].sex.equals("女")) {
                System.out.println("サンジ『死んでも女は蹴らん・・・！』");
                System.out.println("サンジの負け");
                humansIndex++;
            } else {
                if (humanPower < ghostPower && humans[humansIndex].finishingMoveGauge != 0) {
                    System.out.println("スキルを使いますか？ y/n");
                    String ans = MyConsole.readLine();
                }

            }

            if (humansIndex == humans.length || ghostsIndex == ghosts.length) {
                break;
            }
        }
    }
}