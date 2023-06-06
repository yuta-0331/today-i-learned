package fantasyAdventure;

class AdventurerCommand {
    String[] command = new String[3];

    AdventurerCommand(String jobName) {
        command[0] = "たたかう";
        command[2] = "ぼうぎょ";
        String[] jobs = FantasyAdventure.PLAYER_JOBS;
        if (jobName.equals(jobs[0])) {
            command[1] = "会心の一撃";
        } else if (jobName.equals(jobs[1])) {
            command[1] = "回復魔法";
        } else if (jobName.equals(jobs[2])){
            command[1] = "華麗なる剣技";
        } else {
            command[1] = null;
        }
    }
}
