package fantasyAdventure;

public class BossGroup {
    private int bossSize;
    private Boss[] bossGroup;
    private Boss[] aliveBosses;

    // Bossの生存チェック
    public void checkAliveBosses(BossGroup bosses) {
        for (Boss boss : bosses.aliveBosses) {
            if (boss.getHitPoint() <= 0) {
                bosses.decreaseBossSize();
            }
        }
        bosses.aliveBosses = new Boss[bosses.getBossSize()];
        int index = 0;
        for (Boss boss : bosses.bossGroup) {
            if (boss.getHitPoint() > 0) {
                bosses.aliveBosses[index++] = boss;
            }
        }
        if (bosses.getBossSize() == 0) {
            System.out.println("魔王軍を倒した！");
//            battleLoopFlag = false;
        }
    }

    //Setter
    // Bossグループの作成
    public void setBossGroup() {
        bossGroup = new Boss[]{
                new Boss("魔王", new BossJob("Devil")),
                new Boss("魔導士A", new BossJob("Sorcerer")),
                new Boss("魔導士B", new BossJob("Sorcerer")),
        };
        bossSize = bossGroup.length;
    }
    // 生存しているボスの配列を新たに作成
    public void setAliveBosses(int bossSize) {
        aliveBosses = new Boss[bossSize];
        for (int i = 0; i < bossSize; i++) {
            aliveBosses[i] = bossGroup[i];
        }
    }
    public void decreaseBossSize() {
        bossSize--;
    }

    // Getter
    public int getBossSize() {
        return bossSize;
    }
    public Boss[] getBossGroup() {
        return bossGroup;
    }

    public Boss[] getAliveBosses() {
        return aliveBosses;
    }
}
