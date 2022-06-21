package dev.realz.realzbot.listeners;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.contains("ping")) {
            event.getChannel().sendMessage("Pong!").queue();
        }

    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        String user = event.getUser().getAsMention();
        String message = "Welcome to the server, " + user + "!";
        event.getGuild().getSystemChannel().sendMessage(message).queue();
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        String user = event.getUser().getAsTag();
        String message = "Awh Goodbye, " + user + " :(";
        event.getGuild().getSystemChannel().sendMessage(message).queue();
    }
}
