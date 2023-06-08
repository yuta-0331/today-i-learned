package fantasyAdventure;

class AdventurerJob extends Job {
    AdventurerJob(String jobName) {
        setJobName(jobName);;
        String[] jobs = FantasyAdventure.getParty().getPlayerJobs();
        if (this.getJobName().equals(jobs[0])) {
            setAttackPower(50);
            setHitPoint(2000);
            setSkillPoint(5);
            setSkillName(FantasyAdventure.getParty().getPlayerSkill()[0]);
        } else if (this.getJobName().equals(jobs[1])) {
            setAttackPower(12);
            setHitPoint(1800);
            setSkillPoint(30);
            setSkillName(FantasyAdventure.getParty().getPlayerSkill()[1]);
        } else if (this.getJobName().equals(jobs[2])) {
            setAttackPower(35);
            setHitPoint(2500);
            setSkillPoint(12);
            setSkillName(FantasyAdventure.getParty().getPlayerSkill()[2]);
        }
    }
}
