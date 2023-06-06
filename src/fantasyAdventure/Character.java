package fantasyAdventure;

class Character {
    String name;
    String job;
    String skillName;
    int hitPoint;
    int attackPower;
    int skillPoint;

    Character(String name, Job job) {
        this.name = name;
        this.job = job.jobName;
        hitPoint = job.hitPoint;
        attackPower = job.attackPower;
        skillPoint = job.skillPoint;
        skillName = job.skillName;
    }
}
