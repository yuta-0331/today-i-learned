package fantasyAdventure;

class Adventurer extends Character {
    private final AdventurerCommand command;

    public AdventurerCommand getCommand() {
        return command;
    }
    Adventurer(String name, Job job) {
        this.setName(name);
        this.setJobName(job.getJobName());
        this.setHitPoint(job.getHitPoint());
        this.setMaxHitPoint(job.getHitPoint());
        this.setAttackPower(job.getAttackPower());
        this.setSkillPoint(job.getSkillPoint());
        this.setSkillName(job.getSkillName());
        this.setDamageMultiplier(1.0);
        command = new AdventurerCommand(job.getJobName());
    }

    // こうげき
    void attack(Boss targetBoss) {
        System.out.println(this.command.getCommands()[0]);
        int damage = (int) ((Math.random() + 2) * this.getAttackPower());
        targetBoss.decreaseHitPoint(damage);
        System.out.println(targetBoss.getName() + "に" + damage + "のダメージを与えた！");
    }

    // 防御
    void defense() {
        System.out.println(this.command.getCommands()[2]);
        setDamageMultiplier(0.1);
    }

    // Warriorのスキル
    void castSkill(Boss targetBoss) {
        System.out.println(this.getSkillName());

        int damage = (int) ((Math.random() + 2) * 3 * this.getAttackPower());
        targetBoss.decreaseHitPoint(damage);
        this.decreaseHitPoint(damage / 10);
        this.decreaseSkillPoint();
        System.out.println(targetBoss.getName() + "に" + damage + "のダメージを与えた！");
        System.out.println(this.getName() + "は" + (damage / 10) + "の反動ダメージを受けた！");
    }

    // Knightのスキル
    void castSkill(Boss[] allBosses) {
        System.out.println(this.getSkillName());

        int damage = (int) ((Math.random() + 2)  * this.getAttackPower());
        for (Boss boss : allBosses) {
            boss.decreaseHitPoint(damage);
        }
        this.decreaseSkillPoint();
        System.out.println("敵全体に" + damage + "のダメージ！");
    }

    // Clericのスキル
    void castSkill(Adventurer[] adventurers) {
        System.out.println(this.getSkillName());

        int heal = (int) ((Math.random() * 10 + 3) * this.getAttackPower());
        for (Adventurer adventurer : adventurers) {
            adventurer.increaseHitPoint(heal);
        }
        this.decreaseSkillPoint();
        System.out.println("味方全員の体力が" + heal + "回復した！");
    }
}
