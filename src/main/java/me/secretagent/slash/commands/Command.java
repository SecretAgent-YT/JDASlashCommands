package me.secretagent.slash.commands;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public interface Command {

    CommandData getData();

    void onCalled(CommandContext context);

}
