package cz.geornamezi.bot.game.random;

import java.util.concurrent.ThreadLocalRandom;

public class RandomXYCoordination {

//    public static int[][] GetRandomXYCoordinates() {
//        int[][] coordinates = new int[4][4];
//
//        do {
//            coordinates[0][0] = ThreadLocalRandom.current().nextInt(3, 8);
//            coordinates[0][1] = ThreadLocalRandom.current().nextInt(3, 5);
//        } while (coordinates[0][0] == 3 && coordinates[0][1] == 3);
//
//        do {
//            coordinates[1][0] = ThreadLocalRandom.current().nextInt(3, 8);
//            coordinates[1][1] = ThreadLocalRandom.current().nextInt(3, 5);
//        } while ((coordinates[1][0] == coordinates[0][0] && coordinates[1][1] == coordinates[0][1]) || (coordinates[1][0] == 3 && coordinates[1][1] == 3));
//
//        do {
//            coordinates[2][0] = ThreadLocalRandom.current().nextInt(2, 9);
//            coordinates[2][1] = ThreadLocalRandom.current().nextInt(2, 6);
//        } while ((coordinates[2][0] == coordinates[0][0] && coordinates[2][1] == coordinates[0][1]) || (coordinates[2][0] == coordinates[1][0] && coordinates[2][1] == coordinates[1][1]));
//
//        do {
//            coordinates[3][0] = ThreadLocalRandom.current().nextInt(2, 9);
//            coordinates[3][1] = ThreadLocalRandom.current().nextInt(2, 6);
//        } while ((coordinates[3][0] == coordinates[0][0] && coordinates[3][1] == coordinates[0][1]) || (coordinates[3][0] == coordinates[1][0] && coordinates[3][1] == coordinates[1][1]) || (coordinates[3][0] == coordinates[2][0] && coordinates[3][1] == coordinates[2][1]));
//
//        return coordinates;
//    }

    public static int[][] GetRandomXYCoordinates() {
        int[][] coordinates = new int[4][2];

        do {
            coordinates[0][0] = ThreadLocalRandom.current().nextInt(3, 8);
            coordinates[0][1] = ThreadLocalRandom.current().nextInt(3, 5);
        } while (coordinates[0][0] == 3 && coordinates[0][1] == 3);

        do {
            coordinates[1][0] = ThreadLocalRandom.current().nextInt(3, 8);
            coordinates[1][1] = ThreadLocalRandom.current().nextInt(3, 5);
        } while ((coordinates[1][0] == coordinates[0][0] && coordinates[1][1] == coordinates[0][1]) || (coordinates[1][0] == 3 && coordinates[1][1] == 3));

        do {
            coordinates[2][0] = ThreadLocalRandom.current().nextInt(2, 9);
            coordinates[2][1] = ThreadLocalRandom.current().nextInt(2, 6);
        } while ((coordinates[2][0] == coordinates[0][0] && coordinates[2][1] == coordinates[0][1]) || (coordinates[2][0] == coordinates[1][0] && coordinates[2][1] == coordinates[1][1]) || (coordinates[2][0] == 3 && coordinates[2][1] == 3));

        do {
            coordinates[3][0] = ThreadLocalRandom.current().nextInt(2, 9);
            coordinates[3][1] = ThreadLocalRandom.current().nextInt(2, 6);
        } while ((coordinates[3][0] == coordinates[0][0] && coordinates[3][1] == coordinates[0][1]) || (coordinates[3][0] == coordinates[1][0] && coordinates[3][1] == coordinates[1][1]) || (coordinates[3][0] == coordinates[2][0] && coordinates[3][1] == coordinates[2][1]) || (coordinates[3][0] == 3 && coordinates[3][1] == 3));

        return coordinates;
    }
}
