package me.secretagent.slash.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;

public class CommandContext {

    private final SlashCommandEvent event;

    public CommandContext(SlashCommandEvent event) {
        this.event = event;
    }

    public Guild getGuild() {
        return event.getGuild();
    }

    public MessageChannel getChannel() {
        return event.getChannel();
    }

    public Member getMember() {
        return event.getMember();
    }

    public OptionMapping getOption(String name) {
        return event.getOption(name);
    }

    public ReplyAction reply(String content, boolean hidden) {
       return event.reply(content).setEphemeral(hidden);
    }

    public ReplyAction reply(MessageEmbed embed, boolean hidden) {
        return event.replyEmbeds(embed).setEphemeral(hidden);
    }

}
