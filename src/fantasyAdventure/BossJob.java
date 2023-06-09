package fantasyAdventure;

class BossJob extends Job {
    BossJob(String args) {
        switch (args) {
            case "Devil":
                setAttackPower(60);;
                setHitPoint(10);
                setSkillPoint(30);
                break;
            case "Sorcerer":
                setAttackPower(12);
                setHitPoint(50);
                setSkillPoint(50);
                break;
        }
    }
}
