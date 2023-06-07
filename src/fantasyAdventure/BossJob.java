package fantasyAdventure;

class BossJob extends Job {
    BossJob(String args) {
        switch (args) {
            case "Devil":
                setAttackPower(60);;
                setHitPoint(10000);
                setSkillPoint(30);
                break;
            case "Sorcerer":
                setAttackPower(12);
                setHitPoint(5000);
                setSkillPoint(50);
                break;
        }
    }
}
