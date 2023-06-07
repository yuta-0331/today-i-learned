package fantasyAdventure;

//Jobクラス
class Job {
    private String jobName;
    private String skillName;
    private int hitPoint;
    private int attackPower;
    private int skillPoint;

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }
    public String getJobName() {
        return jobName;
    }
    public String getSkillName() {
        return skillName;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public int getSkillPoint() {
        return skillPoint;
    }
    public int getHitPoint() {
        return hitPoint;
    }
}
