package fantasyAdventure;

class GameController {
    private final Party party;
    private final BossGroup bossGroup;
    private boolean gameLoopFlag;

    GameController() {
        party = new Party();
        bossGroup = new BossGroup();
        gameLoopFlag = true;
    }

    // 攻撃対象の選択
    private int selectTarget(Boss[] bosses) {
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
    void printPlayerStatus(Adventurer[] args) {
        for (Adventurer arg : args) {
            System.out.println(
                    arg.getName() + "\n HP: " + arg.getHitPoint() + "/" + arg.getMaxHitPoint() + " SP: " + arg.getSkillPoint()
            );
        }
    }
    // プレイヤーの行動を選択
    int selectAdventurersAction(Adventurer adventurer) {
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
    void executeAdventurersTurn(Adventurer adventurer, int commandNumber, int turnCount) {
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
                adventurer.defense();
                break;
        }
    }

    // Bossのターンの行動を実行 *todo: ターン数によって行動を変える
    void executeBossesTurn(Boss boss, int turnCount) {
        if (boss.getJobName().equals("Devil")) {
            if (turnCount % 5 == 0) {
                System.out.println("魔王に邪悪なエネルギーが集まっていく・・・！");
            } else if (turnCount % 5 == 1 && turnCount > 1) {
                boss.demiseMagic(party.getAliveAdventurers());
            } else {
                int tmp = (int) (Math.random() * 3);
                int targetIndex = (int) (Math.random() * party.getPartySize());
                if (tmp == 0) {
                    boss.doubleAttack(party.getAliveAdventurers()[targetIndex]);
                } else {
                    boss.attack(party.getAliveAdventurers()[targetIndex]);
                }
            }
        } else {
            int tmp = (int) (Math.random() * 5);
            int targetIndex = (int) (Math.random() * party.getPartySize());
            if (tmp < 2) {
                boss.attack(party.getAliveAdventurers()[targetIndex]);
            } else if (tmp < 4) {
                boss.doubleAttack(party.getAliveAdventurers()[targetIndex]);
            } else {
                boss.healMagic(bossGroup.getAliveBosses());
            }
        }
    }

    //バトルループ実行メソッド
    void executeBattle() {
        Party party = getParty();
        BossGroup bossGroup = getBossGroup();
        // プレイヤーのパーティを作成
        party.setAdventurerParty();
        party.setAliveAdventurers(party.getPartySize());
        Adventurer[] adventurerParty = party.getAdventurers();

        // ボスグループの作成
        bossGroup.setBossGroup();
        bossGroup.setAliveBosses(bossGroup.getBossSize());
        // バトル開始
        int turnCount = 1;
        BattleLoop: while (isGameLoopFlag()) {
            printPlayerStatus(adventurerParty);
            for (Adventurer adventurer : party.getAliveAdventurers()) {
                System.out.println(adventurer.getName() + "のターン！");

                int inputCommand = selectAdventurersAction(adventurer);
                executeAdventurersTurn(adventurer,inputCommand, turnCount);
                // 各キャラの行動後に生存チェックする
                party.checkAliveAdventurers(party);
                bossGroup.checkAliveBosses(bossGroup);
                if (!isGameLoopFlag()) {
                    break BattleLoop;
                }
            }
            printPlayerStatus(party.getAliveAdventurers());
            for (Boss boss : bossGroup.getAliveBosses()) {
                System.out.println(boss.getName() + "のターン！");
                MyConsole.readLine();
                executeBossesTurn(boss, turnCount);
                // 各敵の行動後に生存チェックする
                party.checkAliveAdventurers(party);
                bossGroup.checkAliveBosses(bossGroup);
                if (!isGameLoopFlag()) {
                    break BattleLoop;
                }
            }
            MyConsole.readLine();
            turnCount++;
        }
        if (party.getAliveAdventurers().length == 0) {
            System.out.println("hint: おすすめの編成は戦士2　白魔道士1です。危険を感じたら防御しましょう！");
        } else {
            System.out.println("無事、姫を救い出しました！");
        }
    }


    public void setGameLoopFlag(boolean gameLoopFlag) {
        this.gameLoopFlag = gameLoopFlag;
    }

    public boolean isGameLoopFlag() {
        return gameLoopFlag;
    }

    public Party getParty() {
        return party;
    }

    public BossGroup getBossGroup() {
        return bossGroup;
    }
}
