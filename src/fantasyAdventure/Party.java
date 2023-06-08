package fantasyAdventure;

public class Party {
    private Adventurer[] adventurerParty;
    private Adventurer[] aliveAdventurers;
    private int partySize;
    private final String[] PLAYER_JOBS = { "戦士", "白魔道士", "騎士" };
    private final String[] PLAYER_SKILL = { "会心の一撃", "回復魔法", "華麗なる剣技" };


    // Adventurerの生存チェック
    public static void checkAliveAdventurers(Party party) {
        for (Adventurer adventurer : party.aliveAdventurers) {
            if (adventurer.getHitPoint() <= 0) {
                party.decreasePartySize();
            }
        }
        party.aliveAdventurers = new Adventurer[party.getPartySize()];
        int index = 0;
        for (Adventurer adventurer : party.adventurerParty) {
            if (adventurer.getHitPoint() > 0) {
                party.aliveAdventurers[index++] = adventurer;
            }
        }
        if (party.getPartySize() == 0) {
            System.out.println("全滅しました");
//            battleLoopFlag = false;
        }
    }
    // Setter
    // 戦闘パーティの作成
    public void setAdventurerParty() {
        partySize = 3;
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
        this.adventurerParty = adventureParty;
    }

    // 生存しているパーティの配列を新たに作成
    public void setAliveAdventurers(int partySize) {
        aliveAdventurers = new Adventurer[partySize];
        for (int i = 0; i < partySize; i++) {
            aliveAdventurers[i] = adventurerParty[i];
        }
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }
    public void decreasePartySize() {
        this.partySize--;
    }

    // Getter
    public Adventurer[] getAdventurers() {
        return adventurerParty;
    }

    public String[] getPlayerJobs() {
        return PLAYER_JOBS;
    }
    public String[] getPlayerSkill() {
        return PLAYER_SKILL;
    }

    public int getPartySize() {
        return partySize;
    }

    public Adventurer[] getAliveAdventurers() {
        return aliveAdventurers;
    }
}
