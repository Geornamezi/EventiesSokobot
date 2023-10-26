package cz.geornamezi.bot.game.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GridString {

    public String grid = """
            +++++++++
            +-------+
            +-------+
            +-------+
            +-------+
            +++++++++
            """;
    public String gridForReseting;

//    public void loadGrid(int level) throws IOException {
//        StringBuilder convertedResult = new StringBuilder();
//        ClassLoader classLoader = GridConverter.class.getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("levels/level" + level + ".txt");
//
//        if (inputStream == null) {
//            throw new IllegalArgumentException("idiot");
//        }
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//
//        while ((line = br.readLine()) != null) {
//            convertedResult.append(line.replaceAll(" ", "")).append("\n");
//        }
//
//        br.close();
//
//        grid = convertedResult.toString();
//    }
}
