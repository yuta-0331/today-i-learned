package fantasyAdventure;

public class FantasyAdventure {
    public static final String[] PLAYER_JOBS = { "Warrior", "Cleric", "Knight" };
    public static int partySize;
    public static int bossSize;


    //パーティのHPとスキルポイントを表示
    public static void printPlayerStatus(Adventurer[] args) {
        for (Adventurer arg : args) {
            System.out.println(arg.name + "\n HP: " + arg.hitPoint + " SP: " + arg.skillPoint);
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
        // ジョブの選択、名前の入力をして味方パーティの作成
        partySize =  3;
        Adventurer[] adventurePartyGroup = new Adventurer[partySize];
        int partyIndex = 0;
        do {
            System.out.println((partyIndex + 1) + "人目の名前を入力してください");
            String inputName = MyConsole.readLine();
            JobLoop:
            while (true) {
                try {
                    System.out.println((partyIndex + 1) + "人目のジョブを選択してください");
                    for (int i = 0; i < PLAYER_JOBS.length; i++) {
                        System.out.print((i + 1) + ":" + PLAYER_JOBS[i] + " ");
                    }
                    ;
                    int inputJobNum = Integer.parseInt(MyConsole.readLine());
                    if (inputJobNum > PLAYER_JOBS.length || inputJobNum < 0) {
                        throw new InvalidCommandException("ジョブを選んでください");
                    }
                    for (String jobKind : PLAYER_JOBS) {
                        if (jobKind.equals(PLAYER_JOBS[inputJobNum - 1])) {
                            adventurePartyGroup[partyIndex] = new Adventurer(inputName, new AdventurerJob(PLAYER_JOBS[inputJobNum - 1]));
                            partyIndex++;
                            break JobLoop;
                        }
                    }
                    throw new InvalidCommandException("ジョブが見つかりません");
                } catch (InvalidCommandException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.print(e.getMessage());
                }
            }
        } while (partyIndex != partySize);
        //ボスパーティの作成
        FinalBoss[] bossGroup = {
                new FinalBoss("魔王", new FinalBossJob("Devil")),
                new FinalBoss("魔導士A", new FinalBossJob("Sorcerer")),
                new FinalBoss("魔導士B", new FinalBossJob("Sorcerer")),
        };
        bossSize = 3;

        //味方の行動ターン
        printPlayerStatus(adventurePartyGroup);
        int[] commandArray;
        //生存しているパーティの配列を新たに作成
        Adventurer[] aliveAdventurers = new Adventurer[partySize];
        for (int i = 0; i < partySize; i++) {
            aliveAdventurers[i] = adventurePartyGroup[i];
        }
        //生存しているボスの配列を新たに作成
        FinalBoss[] aliveBosses = new FinalBoss[bossSize];
        for (int i = 0; i < bossSize; i++) {
            aliveBosses[i] = bossGroup[i];
        }
        for (Adventurer adventurer : aliveAdventurers) {
            commandArray = new int[partySize];
            String[] commands = createCommand(adventurer.job);
            System.out.println(adventurer.name + "のターン！");
            for (String command : commands) {
                System.out.print(command + " ");
            }
            //コマンドの入力
            int commandIndex = 0;
            while (true) {
                try {
                    int inputCommand = Integer.parseInt(MyConsole.readLine());
                    if (inputCommand < 0 || inputCommand > commands.length) {
                        throw new InvalidCommandException("無効な入力です");
                    }
                    commandArray[commandIndex] = inputCommand;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("数値で入力してください");
                } catch (InvalidCommandException e) {
                    System.out.println(e.getMessage());
                }
            }
            switch (commandArray[commandIndex++]) {
                case 1:
                    System.out.println("たたかう");
                    int damage = (int) ((Math.random() + 2) * adventurer.attackPower);
                    int targetIndex = (int) (Math.random() * bossSize);
                    bossGroup[targetIndex].hitPoint -= damage;
                    System.out.println(bossGroup[targetIndex].name + "に" + damage + "のダメージを与えた！");
                    break;
                case 2:
                    System.out.println(adventurer.skillName);
                    if (adventurer.skillName.equals("会心の一撃")) {
                        damage = (int) ((Math.random() + 2) * 3 * adventurer.attackPower);
                        targetIndex = (int) (Math.random() * bossSize);
                        aliveBosses[targetIndex].hitPoint -= damage;
                        adventurer.hitPoint -= damage/10;
                        System.out.println(aliveBosses[targetIndex].name + "に" + damage + "のダメージを与えた！");
                        System.out.println(adventurer.name + "は" + (damage / 10) + "の反動ダメージを受けた！");
                    } else if (adventurer.skillName.equals("回復魔法")) {
                        int heal = (int) ((Math.random() + 3) * adventurer.attackPower);
                        for (Adventurer chara : aliveAdventurers) {
                            chara.hitPoint += heal;
                        }
                        System.out.println("味方全員の体力が" + heal + "回復した！");
                    } else {

                    }
                    break;
                case 3:
                    System.out.println("防御");
                    break;
            }

        }
    }
}