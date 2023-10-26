package cz.geornamezi.bot.events;

import cz.geornamezi.bot.data.DataManager;
import cz.geornamezi.bot.game.Game;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class GameHandler extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (!DataManager.membersPlaying.containsKey(event.getAuthor())) return;
        if (!DataManager.membersPlaying.get(event.getAuthor()).Won()) return;

        switch (event.getMessage().getContentRaw()) {
            case "pokracovat":
                DataManager.membersPlaying.remove(event.getAuthor());
                Game game = new Game();

                DataManager.membersPlaying.put(event.getAuthor(), game);

                EmbedBuilder eb = new EmbedBuilder();

                eb.setTitle("Sokobot");
                eb.setColor(Color.CYAN);
                eb.setDescription(game.ReturnGrid());
                eb.setFooter("Napiš do chatu w, a, s, d na pohyb nebo napiš r na restartování levelu.");

                event.getChannel().sendMessageEmbeds(eb.build()).queue(message -> {
                    if (DataManager.membersUsingReactionMovement.contains(event.getAuthor())) {
                        message.addReaction(Emoji.fromUnicode("➡")).queue();
                        message.addReaction(Emoji.fromUnicode("⬅")).queue();
                        message.addReaction(Emoji.fromUnicode("⬆")).queue();
                        message.addReaction(Emoji.fromUnicode("⬇")).queue();
                        message.addReaction(Emoji.fromUnicode("🔄")).queue();
                    }
                });
                break;
            case "ukoncit":
                DataManager.membersPlaying.remove(event.getAuthor());
                break;
        }
    }
}
