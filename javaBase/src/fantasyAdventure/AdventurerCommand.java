package fantasyAdventure;

class AdventurerCommand {
    private String[] commands = new String[3];

    public String[] getCommands() {
        return commands;
    }

    AdventurerCommand(String jobName) {
        Party party = new Party();
        commands[0] = "たたかう";
        commands[2] = "ぼうぎょ";
        if (jobName.equals(party.getPlayerJobs()[0])) {
            commands[1] = party.getPlayerSkill()[0];
        } else if (jobName.equals(party.getPlayerJobs()[1])) {
            commands[1] = party.getPlayerSkill()[1];
        } else if (jobName.equals(party.getPlayerJobs()[2])){
            commands[1] = party.getPlayerSkill()[2];
        } else {
            commands[1] = null;
        }
    }
}
