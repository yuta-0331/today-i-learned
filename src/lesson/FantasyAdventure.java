package lesson;
class Character {
    String name;
    String job;
    int hitPoint;
    int attackPower;
    int skillPoint;
    Character(String name, Job job) {
        this.name = name;
        this.job = Job.jobName;
        this.hitPoint = hitPoint;
        this.attackPower = attackPower;
        this.skillPoint = skillPoint;
    }
}
class Job {
    String jobName;
    int hitPoint;
    int attackPower;
    int skillPoint;
}

class FinalBoss extends Character {

    FinalBoss(String name, String job, int hitPoint, int attackPower, int skillPoint) {
        super(name, job, hitPoint, attackPower, skillPoint);
    }
}

class Adventurer extends Character {
    Adventurer(String name, String job, int hitPoint, int attackPower, int skillPoint) {
        super(name, job, hitPoint, attackPower, skillPoint);
    }
}

class AdventurerJob extends Job {
    AdventurerJob(String args) throws invalidJobNameException {
        this.jobName = args;

        switch (this.jobName) {
            case "Warrior":
                this.attackPower = 50;
                this.hitPoint = 2000;
                this.skillPoint = 5;
                break;
            case "Cleric":
                this.attackPower = 12;
                this.hitPoint = 1200;
                this.skillPoint = 30;
                break;
            case "Knight":
                this.attackPower = 35;
                this.hitPoint = 2500;
                this.skillPoint = 12;
                break;
        }
    }
}
class invalidJobNameException extends Exception {
    invalidJobNameException(String msg) {
        super(msg);
    }
}
public class FantasyAdventure {
    public static void main(String[] args) {

    }
}
