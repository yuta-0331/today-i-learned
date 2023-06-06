package fantasyAdventure;

class AdventurerJob extends Job {
    AdventurerJob(String args) {
        this.jobName = args;
        switch (this.jobName) {
            case "Warrior":
                attackPower = 50;
                hitPoint = 2000;
                skillPoint = 5;
                skillName = "会心の一撃";
                break;
            case "Cleric":
                attackPower = 12;
                hitPoint = 1800;
                skillPoint = 30;
                skillName = "回復魔法";
                break;
            case "Knight":
                attackPower = 35;
                hitPoint = 2500;
                skillPoint = 12;
                skillName = "華麗なる剣技";
                break;
        }

    }
}
