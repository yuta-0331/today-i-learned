package fantasyAdventure;

public class FantasyAdventure {
    // jobの種類, party・bossの残り人数をグローバルで定義
    private static final String[] PLAYER_JOBS = { "Warrior", "Cleric", "Knight" };
    private static int partySize;
    private static int bossSize;
    private static Adventurer[] aliveAdventurers;
    private static Boss[] aliveBosses;
    private static int inputCommand;
    private static boolean battleLoopFlag;

    public static String[] getPlayerJobs() {
        return PLAYER_JOBS;
    }

    // パーティの作成メソッド
    private static Adventurer[] createAdventureParty() {
        partySize =  3;
        Adventurer[] adventureParty = new Adventurer[partySize];
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
                    int inputJobNum;
                    try {
                        inputJobNum = Integer.parseInt(MyConsole.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    if (inputJobNum > PLAYER_JOBS.length || inputJobNum < 0) {
                        throw new InvalidCommandException("入力された番号は不正です");
                    }
                    for (String jobKind : PLAYER_JOBS) {
                        if (jobKind.equals(PLAYER_JOBS[inputJobNum - 1])) {
                            adventureParty[partyIndex] = new Adventurer(
                                    inputName, new AdventurerJob(PLAYER_JOBS[inputJobNum - 1])
                            );
                            partyIndex++;
                            break JobLoop;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (partyIndex != partySize);
        return adventureParty;
    }

    // ボスパーティの作成メソッド
    private static Boss[] createBossParty() {
        bossSize = 3;
        return new Boss[]{
                new Boss("魔王", new BossJob("Devil")),
                new Boss("魔導士A", new BossJob("Sorcerer")),
                new Boss("魔導士B", new BossJob("Sorcerer")),
        };
    }

    // 攻撃対象の選択
    private static int selectTarget(Boss[] bosses) {
        System.out.println("対象を選択してください");
        for (int i = 0; i < bosses.length; i++) {
            System.out.print(i + 1 + bosses[i].getName() + " ");
        }
        while (true) {
            int index;
            try {
                index = Integer.parseInt(MyConsole.readLine());
                if (index < 1 || index > bosses.length) {
                    throw new InvalidCommandException("不正な入力です");
                }
                return index - 1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // パーティのHPとスキルポイント残を表示
    private static void printPlayerStatus(Adventurer[] args) {
        for (Adventurer arg : args) {
            System.out.println(
                    arg.getName() + "\n HP: " + arg.getHitPoint() + "/" + arg.getMaxHitPoint() + " SP: " + arg.getSkillPoint()
            );
        }
    }
    // プレイヤーの行動を選択
    private static void selectAdventurersAction(Adventurer adventurer) {
        // コマンドの表示
        for (int i = 0; i < adventurer.getCommand().getCommands().length; i++) {
            System.out.print(i + 1 + ":" + adventurer.getCommand().getCommands()[i] + " ");
        }
        // コマンドの入力
        while (true) {
            try {
                inputCommand = Integer.parseInt(MyConsole.readLine());
                if (inputCommand < 1 || inputCommand > 3) {
                    throw new InvalidCommandException("無効な入力です");
                }
                if (adventurer.getSkillPoint() == 0 && inputCommand == 2) {
                    throw new InvalidCommandException("SPが足りない！");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("数値で入力してください");
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    // プレイヤーのターンの行動を実行
    private static void executeAdventurersTurn(Adventurer adventurer, int commandNumber, int turnCount) {
        // 防御の効果をリセット
        adventurer.setDamageMultiplier(1);
        //5ターンに1ずつSP回復
        if (adventurer.getHitPoint() != 0 && turnCount % 5 == 1 && turnCount > 1) {
            adventurer.increaseSkillPoint();
        }
        int index;
        switch (commandNumber) {
            case 1:
                index = selectTarget(aliveBosses);
                adventurer.attack(aliveBosses[index]);
                break;
            case 2:
                if (adventurer.getJobName().equals(PLAYER_JOBS[0])) {
                    index = selectTarget(aliveBosses);
                    adventurer.castSkill(aliveBosses[index]);
                } else if (adventurer.getJobName().equals(PLAYER_JOBS[1])) {
                    adventurer.castSkill(aliveAdventurers);
                } else if (adventurer.getJobName().equals((PLAYER_JOBS[2]))){
                    adventurer.castSkill(aliveBosses);
                }
                break;
            case 3:
                System.out.println("防御");
                adventurer.defense();
                break;
        }
    }

    // Bossのターンの行動を実行 *todo: ターン数によって行動を変える
    private static void executeBossesTurn(Boss boss, int turnCount) {
        int targetIndex = (int) (Math.random() * partySize);
        boss.demiseMagic(aliveAdventurers);;
    }

    // Adventurerの生存チェック
    public static void checkAliveAdventurers(Adventurer[] adventurers) {
        for (Adventurer adventurer : adventurers) {
            if (adventurer.getHitPoint() <= 0) {
                partySize--;
            }
        }
        aliveAdventurers = new Adventurer[partySize];
        int index = 0;
        for (Adventurer adventurer : adventurers) {
            if (adventurer.getHitPoint() > 0) {
                aliveAdventurers[index++] = adventurer;
            }
        }
        if (partySize == 0) {
            System.out.println("全滅しました");
            battleLoopFlag = false;
        }
    }
    public static void main(String[] args) {
        // ボスと味方のパーティを作成
        Adventurer[] adventurePartyGroup = createAdventureParty();
        Boss[] bossGroup = createBossParty();

        // 生存しているパーティの配列を新たに作成
        aliveAdventurers = new Adventurer[partySize];
        for (int i = 0; i < partySize; i++) {
            aliveAdventurers[i] = adventurePartyGroup[i];
        }
        // 生存しているボスの配列を新たに作成
        aliveBosses = new Boss[bossSize];
        for (int i = 0; i < bossSize; i++) {
            aliveBosses[i] = bossGroup[i];
        }

        int turnCount = 1;
        battleLoopFlag = true;
        while (battleLoopFlag) {
            printPlayerStatus(adventurePartyGroup);
            for (Adventurer adventurer : aliveAdventurers) {
                System.out.println(adventurer.getName() + "のターン！");

                selectAdventurersAction(adventurer);
                executeAdventurersTurn(adventurer,inputCommand, turnCount);
            }
            checkAliveAdventurers(adventurePartyGroup);
            printPlayerStatus(aliveAdventurers);
            for (Boss boss : aliveBosses) {
                System.out.println(boss.getName() + "のターン！");
                MyConsole.readLine();
                executeBossesTurn(boss, turnCount);
            }
            checkAliveAdventurers(aliveAdventurers);
            if (!battleLoopFlag) break;
            turnCount++;
        }
    }
}