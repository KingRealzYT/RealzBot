package dev.realz.realzbot;

import dev.realz.realzbot.listeners.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class RealzBot {

    private final Dotenv config;
    private final ShardManager shardManager;

    public RealzBot() throws LoginException {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Servers!"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        shardManager = builder.build();

        shardManager.addEventListener(new EventListener());
    }

    public Dotenv getConfig() {
        return config;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try {
            RealzBot bot = new RealzBot();
        } catch (LoginException e) {
            System.out.println("Invalid Token!");
        }

    }
}
