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
        System.out.println(targetAdventurer.getName() + "は" + damage + "のダメージを受けた！");
        targetAdventurer.decreaseHitPoint(damage);
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
            System.out.println(adventurer.getName() + "は" + damage + "のダメージを受けた！");
            adventurer.decreaseHitPoint(damage);
        }
    }
    // 回復魔法: 魔導士A, Bがランダムで使用
    void healMagic(Boss[] bosses) {
        System.out.println("回復魔法");
        Boss mostInjuredBoss = bosses[0]; // ダメージ量が大きいボス
        for (Boss boss : bosses) {
            if (boss.getMaxHitPoint() - boss.getHitPoint() > mostInjuredBoss.getMaxHitPoint() - mostInjuredBoss.getHitPoint()) {
                mostInjuredBoss = boss;
            }
        }
        if (mostInjuredBoss.getMaxHitPoint() == mostInjuredBoss.getHitPoint()) {
            System.out.println(mostInjuredBoss.getName() + "には効果がなかった！");
        } else {
            int heal = (int) ((Math.random() * 10 + 5) * getAttackPower());
            System.out.println(mostInjuredBoss.getName() + "は" + heal + "回復した");
            mostInjuredBoss.increaseHitPoint(heal);
        }
    }
}