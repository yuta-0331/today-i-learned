package fantasyAdventure;

class Boss extends Character {
    Boss(String name, Job job) {
        this.setName(name);
        this.setJobName(job.getJobName());
        this.setHitPoint(job.getHitPoint());
        this.setMaxHitPoint(job.getHitPoint());
        this.setAttackPower(job.getAttackPower());
        this.setSkillPoint(job.getSkillPoint());
        this.setSkillName(job.getSkillName());
    }

    // 通常攻撃
    void attack(Adventurer targetAdventurer) {
        System.out.println("たたかう");
        int damage = (int) ((Math.random() + 2) * this.getAttackPower());
        targetAdventurer.decreaseHitPoint(damage);
        System.out.println(targetAdventurer.getName() + "は" + damage + "のダメージを受けた！");
    }
    // 二回攻撃
    void doubleAttack(Adventurer targetAdventurer) {
        System.out.println("二回攻撃！");
        attack(targetAdventurer);
        attack(targetAdventurer);
    }
    // 時空魔法: 6ターンに一回使用
    void demiseMagic(Adventurer[] adventurers) {
        System.out.println("時空魔法メテオ");
        int damage;
        for (Adventurer adventurer : adventurers) {
            damage = (int) (adventurer.getDamageMultiplier() * 1500);
            adventurer.decreaseHitPoint(damage);
            System.out.println(adventurer.getName() + "は" + damage + "のダメージを受けた！");
        }
    }
    // 回復魔法: 魔導士A, Bがランダムで使用
    void healMagic(Boss[] bosses) {
        Boss minHpBoss = bosses[0];
        for (Boss boss : bosses) {
            if (boss.getHitPoint() < minHpBoss.getHitPoint()) {
                minHpBoss = boss;
            }
        }
        minHpBoss.increaseHitPoint((int) ((Math.random() * 10 + 5) * getAttackPower()));
    }
}