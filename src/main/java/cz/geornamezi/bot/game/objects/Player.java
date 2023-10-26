package cz.geornamezi.bot.game.objects;

import cz.geornamezi.bot.game.Game;

public class Player {

    public Game game;
    public int x;
    public int y;

    public Player(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;

        game.gridString.grid = game.gridReplacer.replaceCharacter(game.gridString.grid, x, y, '*');
    }

    public void MoveUp() {

        char gameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x, y - 1);
        char boxGameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x, y - 2);

        if (gameChar == '-') {
            game.MovePlayerOnGrid("up");
            y--;
        } else if (gameChar == '(') {

            if (boxGameChar == '+') return;

            if (x == game.box1.x && y - 1 == game.box1.y) {
                game.box1.MoveUp(1);
            } else {
                game.box2.MoveUp(2);
            }
            game.MovePlayerOnGrid("up");
            y--;
        }
    }

    public void MoveDown() {

        char gameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x, y + 1);
        char boxGameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x, y + 2);

        if (gameChar == '-') {
            game.MovePlayerOnGrid("down");
            y++;
        } else if (gameChar == '(') {

            if (boxGameChar == '+') return;

            if (x == game.box1.x && y + 1 == game.box1.y) {
                game.box1.MoveDown(1);
            } else {
                game.box2.MoveDown(2);
            }

            game.MovePlayerOnGrid("down");
            y++;
        }
    }

    public void MoveLeft() {

        char gameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x - 1, y);
        char boxGameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x - 2, y);

        if (gameChar == '-') {
            game.MovePlayerOnGrid("left");
            x--;
        } else if (gameChar == '(') {

            if (boxGameChar == '+') return;

            if (x - 1 == game.box1.x && y == game.box1.y) {
                game.box1.MoveLeft(1);
            } else {
                game.box2.MoveLeft(2);
            }

            game.MovePlayerOnGrid("left");
            x--;
        }
    }

    public void MoveRight() {

        char gameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x + 1, y);
        char boxGameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x + 2, y);

        if (gameChar == '-') {
            game.MovePlayerOnGrid("right");
            x++;
        } else if (gameChar == '(') {

            if (boxGameChar == '+') return;

            if (x + 1 == game.box1.x && y == game.box1.y) {
                game.box1.MoveRight(1);
            } else {
                game.box2.MoveRight(2);
            }

            game.MovePlayerOnGrid("right");
            x++;
        }
    }
}
