package cz.geornamezi.bot.events;

import cz.geornamezi.bot.data.DataManager;
import cz.geornamezi.bot.game.Game;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.xml.crypto.Data;
import java.awt.*;

public class GameReactionsHandler extends ListenerAdapter {

    @Override
    public void onGenericMessageReaction(@NotNull GenericMessageReactionEvent event) {
        if (event.getUser().isBot()) return;

        switch (event.getReaction().getEmoji().getFormatted()) {

            // pri startu jsou prvni dve, potom zbytek pri hre

            case "🟦":
                DataManager.membersPlaying.put(event.getUser(), new Game());
                EmbedBuilder eb = new EmbedBuilder();

                eb.setTitle("Sokobot");
                eb.setDescription(DataManager.membersPlaying.get(event.getUser()).ReturnGrid());
                eb.setColor(Color.CYAN);
                eb.setFooter("Napiš do chatu w, a, s, d na pohyb nebo napiš r na restartování levelu.");

                event.getChannel().sendMessageEmbeds(eb.build()).queue();
                break;
            case "🟪":
                DataManager.membersPlaying.put(event.getUser(), new Game());
                DataManager.membersUsingReactionMovement.add(event.getUser());

                EmbedBuilder eb1 = new EmbedBuilder();

                eb1.setTitle("Sokobot");
                eb1.setDescription(DataManager.membersPlaying.get(event.getUser()).ReturnGrid());
                eb1.setColor(Color.CYAN);
                eb1.setFooter("Napiš do chatu w, a, s, d na pohyb nebo napiš r na restartování levelu.");

                event.getChannel().sendMessageEmbeds(eb1.build()).queue(message -> {
                    message.addReaction(Emoji.fromUnicode("➡")).queue();
                    message.addReaction(Emoji.fromUnicode("⬅")).queue();
                    message.addReaction(Emoji.fromUnicode("⬆")).queue();
                    message.addReaction(Emoji.fromUnicode("⬇")).queue();
                    message.addReaction(Emoji.fromUnicode("🔄")).queue();
                });
                break;

            case "➡":
                DataManager.membersPlaying.get(event.getUser()).player.MoveRight();
                break;
            case "⬅":
                DataManager.membersPlaying.get(event.getUser()).player.MoveLeft();;
                break;
            case "⬆":
                DataManager.membersPlaying.get(event.getUser()).player.MoveUp();
                break;
            case "⬇":
                DataManager.membersPlaying.get(event.getUser()).player.MoveDown();
                break;
            case "🔄":
                DataManager.membersPlaying.get(event.getUser()).Reset();
                break;
        }

        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Sokobot");
        eb.setDescription(DataManager.membersPlaying.get(event.getUser()).ReturnGrid());
        eb.setColor(Color.CYAN);
        eb.setFooter("Napiš do chatu w, a, s, d na pohyb nebo napiš r na restartování levelu.");

        event.getChannel().sendMessageEmbeds(eb.build()).queue(message -> {
            if (DataManager.membersUsingReactionMovement.contains(event.getUser())) {
                message.addReaction(Emoji.fromUnicode("➡")).queue();
                message.addReaction(Emoji.fromUnicode("⬅")).queue();
                message.addReaction(Emoji.fromUnicode("⬆")).queue();
                message.addReaction(Emoji.fromUnicode("⬇")).queue();
                message.addReaction(Emoji.fromUnicode("🔄")).queue();
            }
        });
    }
}
