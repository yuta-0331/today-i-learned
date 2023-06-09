package fantasyAdventure;

class BossJob extends Job {
    BossJob(String args) {
        setJobName(args);
        switch (args) {
            case "Devil":
                setAttackPower(40);;
                setHitPoint(5000);
//                setSkillPoint(30);
                break;
            case "Sorcerer":
                setAttackPower(15);
                setHitPoint(3000);
//                setSkillPoint(50);
                break;
        }
    }
}
