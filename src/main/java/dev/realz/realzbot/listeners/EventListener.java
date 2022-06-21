package dev.realz.realzbot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;

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
        EmbedBuilder eb = new EmbedBuilder();
        String user = event.getUser().getAsTag();
        String message = "Welcome to the server, " + user + "!";
        eb.setTitle(message);
        eb.setTimestamp(Instant.now());
        eb.setColor(0xd01212);
        event.getGuild().getSystemChannel().sendMessageEmbeds(eb.build()).queue();
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        String user = event.getUser().getAsTag();
        String message = "Awh Goodbye, " + user + " :(";
        eb.setTitle(message);
        eb.setTimestamp(Instant.now());
        eb.setColor(0xd01212);
        event.getGuild().getSystemChannel().sendMessageEmbeds(eb.build()).queue();
    }
}
