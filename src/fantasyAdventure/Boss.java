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

    void attack(Adventurer targetAdventurer) {
        System.out.println("たたかう");
        int damage = (int) ((Math.random() + 2) * this.getAttackPower());
        targetAdventurer.decreaseHitPoint(damage);
        System.out.println(targetAdventurer.getName() + "に" + damage + "のダメージを与えた！");
    }
}
