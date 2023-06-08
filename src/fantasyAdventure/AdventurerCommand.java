package fantasyAdventure;

class AdventurerCommand {
    private String[] commands = new String[3];

    public String[] getCommands() {
        return commands;
    }

    AdventurerCommand(String jobName) {
        commands[0] = "たたかう";
        commands[2] = "ぼうぎょ";
        if (jobName.equals(FantasyAdventure.getParty().getPlayerJobs()[0])) {
            commands[1] = FantasyAdventure.getParty().getPlayerSkill()[0];
        } else if (jobName.equals(FantasyAdventure.getParty().getPlayerJobs()[1])) {
            commands[1] = FantasyAdventure.getParty().getPlayerSkill()[1];
        } else if (jobName.equals(FantasyAdventure.getParty().getPlayerJobs()[2])){
            commands[1] = FantasyAdventure.getParty().getPlayerSkill()[2];
        } else {
            commands[1] = null;
        }
    }
}
