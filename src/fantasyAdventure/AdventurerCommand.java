package fantasyAdventure;

class AdventurerCommand {
    private String[] commands = new String[3];

    public String[] getCommands() {
        return commands;
    }

    AdventurerCommand(String jobName) {
        commands[0] = "たたかう";
        commands[2] = "ぼうぎょ";
        String[] jobs = FantasyAdventure.getPlayerJobs();
        if (jobName.equals(jobs[0])) {
            commands[1] = "会心の一撃";
        } else if (jobName.equals(jobs[1])) {
            commands[1] = "回復魔法";
        } else if (jobName.equals(jobs[2])){
            commands[1] = "華麗なる剣技";
        } else {
            commands[1] = null;
        }
    }
}
