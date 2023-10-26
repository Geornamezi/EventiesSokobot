package cz.geornamezi.bot.game.grid;

import java.io.*;

public class GridConverter {

    public static String convertGrid(String grid) {
        StringBuilder convertedResult = new StringBuilder();
        String[] lines = grid.split("\n");

        for (String line : lines) {
            char[] charArray = line.replaceAll(" ", "").toCharArray();

            for (char c : charArray) {
                switch (c) {
                    case '+':
                        convertedResult.append(":blue_square:");
                        break;
                    case '-':
                        convertedResult.append(":orange_square:");
                        break;
                    case '*':
                        convertedResult.append(":flushed:");
                        break;
                    case '(':
                        convertedResult.append(":green_square:");
                        break;
                    case ')':
                        convertedResult.append(":negative_squared_cross_mark:");
                        break;
                    case '&':
                        convertedResult.append(":white_check_mark:");
                        break;
                    default:
                        break;
                }
            }

            convertedResult.append("\n");
        }

        return convertedResult.toString();
    }
}
