package cz.geornamezi.bot.game.objects;

import cz.geornamezi.bot.game.Game;

public class Box {

    public Game game;
    public int x;
    public int y;

    public Box(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;

        game.gridString.grid = game.gridReplacer.replaceCharacter(game.gridString.grid, x, y, '(');
    }

    public void MoveUp(int boxNum) {

        char gameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x, y - 1);

        if (gameChar == '-') {
            if (boxNum == 1) {
                game.MoveBox1OnGrid("up");
                y--;
            } else if (boxNum == 2) {
                game.MoveBox2OnGrid("up");
                y--;
            }
        } else if (gameChar == ')') {
            game.GetDestinationByCoordination(x, y - 1).ChangeState();
            game.gridString.grid = game.gridReplacer.replaceCharacter(game.gridString.grid, x, y, '-');
        }
    }

    public void MoveDown(int boxNum) {

        char gameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x, y + 1);

        if (gameChar == '-') {
            if (boxNum == 1) {
                game.MoveBox1OnGrid("down");
                y++;
            } else if (boxNum == 2) {
                game.MoveBox2OnGrid("down");
                y++;
            }
        } else if (gameChar == ')') {
            game.GetDestinationByCoordination(x, y + 1).ChangeState();
            game.gridString.grid = game.gridReplacer.replaceCharacter(game.gridString.grid, x, y, '-');
        }
    }

    public void MoveLeft(int boxNum) {

        char gameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x - 1, y);

        if (gameChar == '-') {
            if (boxNum == 1) {
                game.MoveBox1OnGrid("left");
                x--;
            } else if (boxNum == 2) {
                game.MoveBox2OnGrid("left");
                x--;
            }
        } else if (gameChar == ')') {
            game.GetDestinationByCoordination(x - 1, y).ChangeState();
            game.gridString.grid = game.gridReplacer.replaceCharacter(game.gridString.grid, x, y, '-');
        }
    }

    public void MoveRight(int boxNum) {

        char gameChar = game.gridGetter.getChatAtPos(game.gridString.grid, x + 1, y);

        if (gameChar == '-') {
            if (boxNum == 1) {
                game.MoveBox1OnGrid("right");
                x++;
            } else if (boxNum == 2) {
                game.MoveBox2OnGrid("right");
                x++;
            }
        } else if (gameChar == ')') {
            game.GetDestinationByCoordination(x + 1, y).ChangeState();
            game.gridString.grid = game.gridReplacer.replaceCharacter(game.gridString.grid, x, y, '-');
        }
    }
}
