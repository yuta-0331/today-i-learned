package fantasyAdventure;

class BossJob extends Job {
    BossJob(String args) {
        switch (args) {
            case "Devil":
                attackPower = 60;
                hitPoint = 10000;
                skillPoint = 30;
                break;
            case "Sorcerer":
                attackPower = 12;
                hitPoint = 5000;
                skillPoint = 50;
                break;
        }
    }
}
