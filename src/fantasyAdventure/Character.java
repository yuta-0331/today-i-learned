package fantasyAdventure;

class Character {
    private String name;
    private String jobName;
    private String skillName;
    private int hitPoint;
    private int maxHitPoint;
    private int attackPower;
    private int skillPoint;
    private double damageMultiplier; // ダメージ倍率 *todo: 敵のデバフ用のダメージ倍率も作成

    // Setter
    public void setName(String name) {
        this.name = name;
    }
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
    public void setMaxHitPoint(int maxHitPoint) {
        this.maxHitPoint = maxHitPoint;
    }
    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }
    public void increaseSkillPoint() {
        skillPoint++;
    }
    public void decreaseSkillPoint() {
        skillPoint--;
    }
    public void increaseHitPoint(int heal) {
        if (hitPoint + heal > maxHitPoint) {
            hitPoint = maxHitPoint;
        } else {
            hitPoint += heal;
        }
    }
    public void decreaseHitPoint(int damage) {
        hitPoint -= damage;
    }

    //Getter
    public String getName() {
        return name;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public int getHitPoint() {
        return hitPoint;
    }
    public int getMaxHitPoint() {
        return maxHitPoint;
    }
    public int getSkillPoint() {
        return skillPoint;
    }
    public String getJobName() {
        return jobName;
    }
    public String getSkillName() {
        return skillName;
    }
    public double getDamageMultiplier() {
        return damageMultiplier;
    }
}
