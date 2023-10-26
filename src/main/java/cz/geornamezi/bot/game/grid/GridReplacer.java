package cz.geornamezi.bot.game.grid;

public class GridReplacer {

    public String replaceCharacter(String convertedGrid, int col, int row, char replacement) {
        int index = (row - 1) * 10 + (col - 1);

        StringBuilder modifiedString = new StringBuilder(convertedGrid);
        modifiedString.setCharAt(index, replacement);

        return modifiedString.toString();
    }
}
