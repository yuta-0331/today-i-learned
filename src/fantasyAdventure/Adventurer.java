package fantasyAdventure;

class Adventurer extends Character {
    AdventurerCommand command;

    Adventurer(String name, Job job) {
        this.name = name;
        this.job = job.jobName;
        hitPoint = job.hitPoint;
        maxHitPoint = job.hitPoint;
        attackPower = job.attackPower;
        skillPoint = job.skillPoint;
        skillName = job.skillName;
        command = new AdventurerCommand(job.jobName);
    }

    // こうげき
    void attack(Boss targetBoss) {
        System.out.println("たたかう");
        int damage = (int) ((Math.random() + 2) * this.attackPower);
        targetBoss.hitPoint -= damage;
        System.out.println(targetBoss.name + "に" + damage + "のダメージを与えた！");
    }

    // スキル使用（*ジョブが増えた時の為にcastSkill内で
    // if (this.job.equals(FantasyAdventure.PLAYER_JOBS[0]))）を
    // 使用しているが現状は不要
    // Warriorのスキル
    void castSkill(Boss targetBoss) {
        if (this.job.equals(FantasyAdventure.PLAYER_JOBS[0])) {
            System.out.println(this.skillName);

            int damage = (int) ((Math.random() + 2) * 3 * this.attackPower);
            targetBoss.hitPoint -= damage;
            this.hitPoint -= damage / 10;
            this.skillPoint--;
            System.out.println(targetBoss.name + "に" + damage + "のダメージを与えた！");
            System.out.println(this.name + "は" + (damage / 10) + "の反動ダメージを受けた！");
        }
    }

    // Knightのスキル
    void castSkill(Boss[] allBosses) {
        if (this.job.equals(FantasyAdventure.PLAYER_JOBS[2])) {
            System.out.println(this.skillName);

            int damage = (int) ((Math.random() + 2)  * this.attackPower);
            for (Boss boss : allBosses) {
                boss.hitPoint -= damage;
            }
            this.skillPoint--;
            System.out.println("敵全体に" + damage + "のダメージ！");
        }
    }

    // Clericのスキル
    void castSkill(Adventurer[] party) {
        if (this.job.equals(FantasyAdventure.PLAYER_JOBS[1])) {
            System.out.println(this.skillName);

            int heal = (int) ((Math.random() * 10 + 3) * this.attackPower);
            for (Adventurer chara : party) {
                chara.hitPoint += heal;
                if (chara.hitPoint > chara.maxHitPoint) {
                    chara.hitPoint = chara.maxHitPoint;
                }
            }
            this.skillPoint--;
            System.out.println("味方全員の体力が" + heal + "回復した！");
        }
    }
}
