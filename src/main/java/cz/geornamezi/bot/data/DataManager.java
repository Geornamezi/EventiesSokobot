package cz.geornamezi.bot.data;

import cz.geornamezi.bot.game.Game;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataManager {

    public static HashMap<User, Game> membersPlaying = new HashMap<>();

    public static List<User> membersUsingReactionMovement = new ArrayList<>();
}
