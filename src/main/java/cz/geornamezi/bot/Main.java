package cz.geornamezi.bot;

import cz.geornamezi.bot.commands.handlers.StartCommand;
import cz.geornamezi.bot.commands.registry.CommandsRegistry;
import cz.geornamezi.bot.events.GameHandler;
import cz.geornamezi.bot.events.GameReactionsHandler;
import cz.geornamezi.bot.events.GameSender;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class Main {

    private final Dotenv config;
    private final ShardManager shardManager;

    public Main() throws LoginException {
        config = Dotenv.configure().load();

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(config.get("TOKEN"));
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("svou hru."));
        shardManager = builder.build();

        shardManager.addEventListener(new GameSender());
        shardManager.addEventListener(new GameHandler());
        shardManager.addEventListener(new GameReactionsHandler());

        shardManager.addEventListener(new StartCommand());

        shardManager.addEventListener(new CommandsRegistry());
    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (LoginException e) {
            System.out.println("ERROR: Nepovedlo se pripojit, protoze token neni validni!");
        }
    }
}