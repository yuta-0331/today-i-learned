package lesson;
///////////////////////////////////////
//////////キャラ、ラスボスのクラス//////////
///////////////////////////////////////
class Character {
    String name;
    String job;
    int hitPoint;
    int attackPower;
    int skillPoint;

    Character(String name, Job job) {
        this.name = name;
        this.job = job.jobName;
        this.hitPoint = job.hitPoint;
        this.attackPower = job.attackPower;
        this.skillPoint = job.skillPoint;
    }
}

class FinalBoss extends Character {
    FinalBoss(String name, Job job) {
        super(name, job);
    }
}

class Adventurer extends Character {
    Adventurer(String name, Job job) {
        super(name, job);
    }
}
//////////////////////////
//////////Jobクラス//////////
//////////////////////////
class Job {
    String jobName;
    int hitPoint;
    int attackPower;
    int skillPoint;
}

class AdventurerJob extends Job {
    AdventurerJob(String args) {
        this.jobName = args;
        switch (this.jobName) {
            case "Warrior":
                this.attackPower = 50;
                this.hitPoint = 2000;
                this.skillPoint = 5;
                break;
            case "Cleric":
                this.attackPower = 12;
                this.hitPoint = 1800;
                this.skillPoint = 30;
                break;
            case "Knight":
                this.attackPower = 35;
                this.hitPoint = 2500;
                this.skillPoint = 12;
                break;
        }

    }
}

class FinalBossJob extends Job {
    FinalBossJob(String args) {
        switch (args) {
            case "Devil":
                this.attackPower = 60;
                this.hitPoint = 10000;
                this.skillPoint = 30;
                break;
            case "Sorcerer":
                this.attackPower = 12;
                this.hitPoint = 5000;
                this.skillPoint = 50;
                break;
        }
    }
}

///////////////////////////////
//////////無効な入力の例外//////////
///////////////////////////////
class InvalidCommandException extends Exception {
    InvalidCommandException(String msg) {
        super(msg);
    }
}

//メインクラス
public class FantasyAdventure {
    public static final String[] PLAYER_JOBS = { "Warrior", "Cleric", "Knight" };
    public static final int PARTY_SIZE = 3;

    //パーティのHPとスキルポイントを表示
    public static void printPlayerStatus(Adventurer[] args) {
        for (Adventurer arg : args) {
            System.out.println(arg.name + "\tHP: " + arg.hitPoint + " SP: " + arg.skillPoint);
        }
    }
    //コマンドの表示
    public static String[] createCommand(String args) {
        String[] commands = new String[3];
        switch (args) {
            case "Warrior":
                commands[0] = "1:たたかう";
                commands[1] = "2:会心の一撃";
                commands[2] = "3:ぼうぎょ";
                return commands;
            case "Cleric":
                commands[0] = "1:たたかう";
                commands[1] = "2:回復魔法";
                commands[2] = "3:ぼうぎょ";
                return commands;
            case "Knight":
                commands[0] = "1:たたかう";
                commands[1] = "2:華麗なる剣技";
                commands[2] = "3:ぼうぎょ";
                return commands;
            default:
                commands = null;
                return commands;
        }
    }
    public static void main(String[] args) {
        Adventurer[] adventurePartyGroup = new Adventurer[PARTY_SIZE];
        // ジョブの選択、名前の入力をしてパーティの作成
        int i = 0;
        do {
            System.out.println((i + 1) + "人目の名前を入力してください");
            String inputName = MyConsole.readLine();
            JobLoop:
            while (true) {
                try {
                    System.out.println((i + 1) + "人目のジョブを選択してください");
                    for (int j = 0; j < PLAYER_JOBS.length; j++) {
                        System.out.print((j + 1) + ":" + PLAYER_JOBS[j] + " ");
                    }
                    ;
                    int inputJobNum = Integer.parseInt(MyConsole.readLine());
                    if (inputJobNum > PLAYER_JOBS.length || inputJobNum < 0) {
                        throw new InvalidCommandException("ジョブを選んでください");
                    }
                    for (String jobKind : PLAYER_JOBS) {
                        if (jobKind.equals(PLAYER_JOBS[inputJobNum - 1])) {
                            adventurePartyGroup[i] = new Adventurer(inputName, new AdventurerJob(PLAYER_JOBS[inputJobNum - 1]));
                            i++;
                            break JobLoop;
                        }
                    }
                    throw new InvalidCommandException("ジョブが見つかりません");
                } catch (InvalidCommandException e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (i != PARTY_SIZE);
        //ボスの作成
        FinalBoss[] finalBossGroup = {
                new FinalBoss("魔王", new FinalBossJob("Devil")),
                new FinalBoss("魔導士A", new FinalBossJob("Sorcerer")),
                new FinalBoss("魔導士B", new FinalBossJob("Sorcerer")),
        };
        //味方の行動ターン
        printPlayerStatus(adventurePartyGroup);
        for (int j = 0; j < adventurePartyGroup.length; j++) {
            String[] commands = createCommand(adventurePartyGroup[j].job);
            System.out.print(commands[j] + " ");
            while (true) {
                try {
                    int inputCommand = Integer.parseInt(MyConsole.readLine());
                    if (inputCommand < 0 || inputCommand > commands.length) {
                        throw new InvalidCommandException("無効な入力です");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("数値で入力してください");
                } catch (InvalidCommandException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }
}