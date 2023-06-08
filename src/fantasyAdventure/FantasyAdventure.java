package fantasyAdventure;

public class FantasyAdventure {
    private static final Party party = new Party();
    private static final BossGroup bossGroup = new BossGroup();

    public static Party getParty() {
        return party;
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
    private static int selectAdventurersAction(Adventurer adventurer) {
        // コマンドの表示
        for (int i = 0; i < adventurer.getCommand().getCommands().length; i++) {
            System.out.print(i + 1 + ":" + adventurer.getCommand().getCommands()[i] + " ");
        }
        // コマンドの入力
        int inputCommand;
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
        return inputCommand;
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
                index = selectTarget(bossGroup.getAliveBosses());
                adventurer.attack(bossGroup.getAliveBosses()[index]);
                break;
            case 2:
                if (adventurer.getJobName().equals(party.getPlayerJobs()[0])) {
                    index = selectTarget(bossGroup.getAliveBosses());
                    adventurer.castSkill(bossGroup.getAliveBosses()[index]);
                } else if (adventurer.getJobName().equals(party.getPlayerJobs()[1])) {
                    adventurer.castSkill(party.getAliveAdventurers());
                } else if (adventurer.getJobName().equals((party.getPlayerJobs()[2]))){
                    adventurer.castSkill(bossGroup.getAliveBosses());
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
        int targetIndex = (int) (Math.random() * party.getPartySize());
        boss.demiseMagic(party.getAliveAdventurers());;
    }


    public static void main(String[] args) {
        // プレイヤーのパーティを作成
        party.setAdventurerParty();
        party.setAliveAdventurers(party.getPartySize());
        Adventurer[] adventureParty = party.getAdventurers();

        // ボスグループの作成
        bossGroup.setBossGroup();
        bossGroup.setAliveBosses(bossGroup.getBossSize());
        //Boss[] bosses = bossGroup.getBossGroup();

        int turnCount = 1;
        boolean battleLoopFlag = true;
        while (battleLoopFlag) {
            printPlayerStatus(adventureParty);
            for (Adventurer adventurer : party.getAliveAdventurers()) {
                System.out.println(adventurer.getName() + "のターン！");

                int inputCommand = selectAdventurersAction(adventurer);
                executeAdventurersTurn(adventurer,inputCommand, turnCount);
                // 各キャラの行動後に生存チェックする
                party.checkAliveAdventurers(party);
                bossGroup.checkAliveBosses(bossGroup);
            }
            printPlayerStatus(party.getAliveAdventurers());
            for (Boss boss : bossGroup.getAliveBosses()) {
                System.out.println(boss.getName() + "のターン！");
                MyConsole.readLine();
                executeBossesTurn(boss, turnCount);
                // 各敵の行動後に生存チェックする
                party.checkAliveAdventurers(party);
                bossGroup.checkAliveBosses(bossGroup);
            }
            if (!battleLoopFlag) break;
            turnCount++;
        }
    }
}