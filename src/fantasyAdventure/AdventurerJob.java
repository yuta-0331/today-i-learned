package fantasyAdventure;

class AdventurerJob extends Job {
    AdventurerJob(String args) {
        this.jobName = args;
        String[] jobs = FantasyAdventure.PLAYER_JOBS;
        if (this.jobName.equals(jobs[0])) {
            attackPower = 50;
            hitPoint = 2000;
            skillPoint = 5;
            skillName = "会心の一撃";
        } else if (this.jobName.equals(jobs[1])) {
            attackPower = 12;
            hitPoint = 1800;
            skillPoint = 30;
            skillName = "回復魔法";
        } else if (this.jobName.equals(jobs[2])) {
            attackPower = 35;
            hitPoint = 2500;
            skillPoint = 12;
            skillName = "華麗なる剣技";
        }
    }
}
