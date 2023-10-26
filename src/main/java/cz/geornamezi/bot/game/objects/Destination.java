package cz.geornamezi.bot.game.objects;

import cz.geornamezi.bot.game.Game;

public class Destination {

    public Game game;
    public int x;
    public int y;
    public boolean completed;

    public Destination(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;

        game.gridString.grid = game.gridReplacer.replaceCharacter(game.gridString.grid, this.x, this.y, ')');
    }

    public void ChangeState() {
        game.gridString.grid = game.gridReplacer.replaceCharacter(game.gridString.grid, x, y, '&');
        setCompleted(true);
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
