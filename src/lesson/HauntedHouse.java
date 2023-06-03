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

    public static int humansIndex;
    public static int ghostsIndex;

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

        System.out.println("ゲームを開始します");
        MyConsole.readLine();
        humansIndex = 0;
        ghostsIndex = 0;
        while (true) {
            //怖さレベル、怖がりレベルを変数に格納する
            int humanPower = humans[humansIndex].scaredLevel;
            int ghostPower = ghosts[ghostsIndex].scaryLevel;
            System.out.println(humans[humansIndex].name + ": " + humanPower);
            System.out.println("敵: " + ghostPower);
            //サンジは女ゴーストに勝てない
            if (humans[humansIndex].name.equals("サンジ") && ghosts[ghostsIndex].sex.equals("女")) {
                System.out.println("サンジ『死んでも女は蹴らん・・・！』");
                System.out.println("サンジの負け");
                humansIndex++;
            } else {
                //1/3の確率でゴーストのスキルが発動（スキルポイントが余っていれば）
                if ((int) (Math.random() * 3) == 2 && ghosts[ghostsIndex].finishingMoveGauge != 0) {
                    ghostPower += (int) (Math.random() * 6 + 1);
                    System.out.println("ゴーストのスキルが発動！: " + ghostPower);
                    ghosts[ghostsIndex].scaryLevel -= 1;
                }
                //ゴーストのパワーがヒューマンより高ければスキル発動
                if (humanPower <= ghostPower && humans[humansIndex].finishingMoveGauge != 0) {
                    System.out.println("スキルを使います!");
                    MyConsole.readLine();
                    humanPower += (int) (Math.random() * 6 + 1);
                    System.out.println(humans[humansIndex].finishingMove + "が発動！: " + humanPower);
                    humans[humansIndex].finishingMoveGauge -= 1;
                }
                //バトル開始
                if (humanPower > ghostPower) {
                    System.out.println(humans[humansIndex].name + "の勝利");
                    humanPower -= ghostPower;
                    humans[humansIndex].scaredLevel = humanPower;
                    ghostsIndex++;
                } else if (humanPower == ghostPower) {
                    System.out.println("引き分け");
                    humansIndex++;
                    ghostsIndex++;
                } else {
                    System.out.println(ghosts[ghostsIndex].name + "の勝利");
                    ghostPower -= humanPower;
                    ghosts[ghostsIndex].scaryLevel = ghostPower;
                    humansIndex++;
                }
            }
            MyConsole.readLine();
            if (humansIndex == humans.length && ghostsIndex == ghosts.length) {
                System.out.println("引き分け");
                break;
            } else if (humansIndex == humans.length) {
                System.out.println("Ghostの勝利");
                break;
            } else if (ghostsIndex == ghosts.length){
                System.out.println("Humanの勝利");
                break;
            }
        }
    }
}