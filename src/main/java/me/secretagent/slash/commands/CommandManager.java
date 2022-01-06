package me.secretagent.slash.commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class CommandManager extends ListenerAdapter {

    private final ArrayList<Command> commands = new ArrayList<>();
    private final JDA jda;

    public CommandManager(JDA jda) {
        this.jda = jda;
        jda.addEventListener(this);
    }

    public ArrayList<Command> getCommands() {
        return (ArrayList<Command>) commands.clone();
    }

    public void registerCommand(Command command) {
        getCommands().add(command);
        for (Guild guild : jda.getGuilds()) {
            guild.upsertCommand(command.getData()).queue();
        }
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        for (Command command : commands) {
            if (command.getData().getName().equals(event.getName())) {
                command.onCalled(new CommandContext(event));
                return;
            }
        }
    }

}
