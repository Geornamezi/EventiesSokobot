package cz.geornamezi.bot.commands.handlers;

import cz.geornamezi.bot.data.DataManager;
import cz.geornamezi.bot.game.Game;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class StartCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("start")) {
            Game game = new Game();

            DataManager.membersPlaying.put(event.getUser(), game);

            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle("Sokobot");
            eb.setDescription("Vítej u Sokobot! Zde máš tutoriál jak hrát!");
            eb.addField("Jak hrát", "~~~~\n:flushed: **je hráč.**\n\n:green_square: **je kostka, do které můžeš hráčem vrazit a pohneš jí.**\n\n:negative_squared_cross_mark: **je místo, na které musíš libovolnou kostku dotlačit.**", true);
            eb.addField("Začni hrát", "**Hrát můžeš pomocí WASD nebo pomocí reakcí.**\n**Pokud chceš hrát pomocí WASD, použij reakci 🟦.**\n**Pokud chceš hrát pomocí reakcí, použij reakci 🟪.**", true);

            event.reply("").queue();
            event.getChannel().sendMessageEmbeds(eb.build()).queue(message -> {
                message.addReaction(Emoji.fromUnicode("🟦")).queue();
                message.addReaction(Emoji.fromUnicode("🟪")).queue();
            });
        }
    }
}
