package cz.geornamezi.bot.game;

import cz.geornamezi.bot.game.grid.GridGetter;
import cz.geornamezi.bot.game.grid.GridConverter;
import cz.geornamezi.bot.game.grid.GridString;
import cz.geornamezi.bot.game.grid.GridReplacer;
import cz.geornamezi.bot.game.objects.Box;
import cz.geornamezi.bot.game.objects.Destination;
import cz.geornamezi.bot.game.objects.Player;
import cz.geornamezi.bot.game.random.RandomXYCoordination;

public class Game {

    public Player player;
    public Box box1;
    public Box box2;
    public Destination destination1;
    public Destination destination2;
    public GridString gridString;
    public GridReplacer gridReplacer;
    public GridGetter gridGetter;
    public int level;
    public boolean complete;
    public boolean isUsingReactions;

    int[][] randomCoordinates = RandomXYCoordination.GetRandomXYCoordinates();

    public Game() {
        gridReplacer = new GridReplacer();
        gridString = new GridString();
        gridGetter = new GridGetter();

        player = new Player(this, 3, 3);

        // -0 je X, -1 je Y
        // 00, 01, 10, 11 je pro boxy
        // 20, 21, 30, 31 je pro destinace

        box1 = new Box(this, randomCoordinates[0][0], randomCoordinates[0][1]);
        box2 = new Box(this, randomCoordinates[1][0], randomCoordinates[1][1]);
        destination1 = new Destination(this, randomCoordinates[2][0], randomCoordinates[2][1]);
        destination2 = new Destination(this, randomCoordinates[3][0], randomCoordinates[3][1]);
        gridString.gridForReseting = gridString.grid;
    }

    public String ReturnGrid() {
        return GridConverter.convertGrid(gridString.grid);
    }

    public void MovePlayerOnGrid(String move) {
        switch (move) {
            case "up":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, player.x, player.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, player.x, player.y - 1, '*');
                break;
            case "down":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, player.x, player.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, player.x, player.y + 1, '*');
                break;
            case "left":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, player.x, player.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, player.x - 1, player.y, '*');
                break;
            case "right":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, player.x, player.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, player.x + 1, player.y, '*');
                break;
        }
    }

    public void MoveBox1OnGrid(String move) {
        switch (move) {
            case "up":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box1.x, box1.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box1.x, box1.y - 1, '(');
                break;
            case "down":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box1.x, box1.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box1.x, box1.y + 1, '(');
                break;
            case "left":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box1.x, box1.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box1.x - 1, box1.y, '(');
                break;
            case "right":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box1.x, box1.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box1.x + 1, box1.y, '(');
                break;
        }
    }

    public void MoveBox2OnGrid(String move) {
        switch (move) {
            case "up":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box2.x, box2.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box2.x, box2.y - 1, '(');
                break;
            case "down":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box2.x, box2.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box2.x, box2.y + 1, '(');
                break;
            case "left":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box2.x, box2.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box2.x - 1, box2.y, '(');
                break;
            case "right":
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box2.x, box2.y, '-');
                gridString.grid = gridReplacer.replaceCharacter(gridString.grid, box2.x + 1, box2.y, '(');
                break;
        }
    }

    public boolean Won() {
        return destination1.completed && destination2.completed;
    }

    public Destination GetDestinationByCoordination(int x, int y) {
        if (x == randomCoordinates[2][0] && y == randomCoordinates[2][1]) {
            return destination1;
        }

        return destination2;
    }

    public void Reset() {

        player.x = 3;
        player.y = 3;
        box1.x = randomCoordinates[0][0];
        box1.y = randomCoordinates[0][1];
        box2.x = randomCoordinates[1][0];
        box2.y = randomCoordinates[1][1];
        destination1.x = randomCoordinates[2][0];
        destination1.y = randomCoordinates[2][1];
        destination2.x = randomCoordinates[3][0];
        destination2.y = randomCoordinates[3][1];

        gridString.grid = gridString.gridForReseting;
    }

    public void setUsingReactions(boolean usingReactions) {
        isUsingReactions = usingReactions;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getLevel() {
        return level;
    }

    public boolean isComplete() {
        return complete;
    }
}
