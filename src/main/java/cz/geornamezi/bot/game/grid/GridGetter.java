package cz.geornamezi.bot.game.grid;

public class GridGetter {

    public char getChatAtPos(String convertedGrid, int col, int row) {
        int index = (row - 1) * 10 + (col - 1);

        return convertedGrid.charAt(index);
    }


}
