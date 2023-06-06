package fantasyAdventure;

class Boss extends Character {
    Boss(String name, Job job) {
        this.name = name;
        this.job = job.jobName;
        hitPoint = job.hitPoint;
        maxHitPoint = job.hitPoint;
        attackPower = job.attackPower;
        skillPoint = job.skillPoint;
        skillName = job.skillName;
    }
}
