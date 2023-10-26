package cz.geornamezi.bot.events;

import cz.geornamezi.bot.data.DataManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class GameSender extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        boolean moved = false;

        if (event.getAuthor().isBot()) return;
        if (!DataManager.membersPlaying.containsKey(event.getAuthor())) return;

        switch (event.getMessage().getContentRaw()) {
            case "w", "W":
                DataManager.membersPlaying.get(event.getAuthor()).player.MoveUp();
                moved = true;
                break;
            case "s", "S":
                DataManager.membersPlaying.get(event.getAuthor()).player.MoveDown();
                moved = true;
                break;
            case "a", "A":
                DataManager.membersPlaying.get(event.getAuthor()).player.MoveLeft();
                moved = true;
                break;
            case "d", "D":
                DataManager.membersPlaying.get(event.getAuthor()).player.MoveRight();
                moved = true;
                break;
            case "r", "R":
                DataManager.membersPlaying.get(event.getAuthor()).Reset();
                moved = true;
                break;
        }

        if (!moved) return;

        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Sokobot");
        eb.setDescription(DataManager.membersPlaying.get(event.getAuthor()).ReturnGrid());
        eb.setColor(Color.CYAN);
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

        if (!DataManager.membersPlaying.get(event.getAuthor()).Won()) return;

        event.getChannel().sendMessage("Vyhrál si! Pokud chceš pokračovat, napiš `pokracovat`. Pokud chceš ukončit hru, napiš `ukoncit`.").queue();
    }
}
