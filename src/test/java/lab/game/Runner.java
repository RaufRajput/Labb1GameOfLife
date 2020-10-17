package lab.game;

import static lab.game.Cell.CellState.ALIVE;
import static lab.game.Cell.CellState.DEAD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {
    public static final Cell.CellState X = ALIVE;
    public static final Cell.CellState O = DEAD;

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Cell.CellState[][] input = new Cell.CellState[][]{
                {X, O, O, O, O, O, X, X},
                {O, X, O, O, X, O, X, O},
                {O, O, O, X, X, O, X, O},
                {O, X, O, O, O, O, X, O}
        };
        Grid grid = new Grid(input);
        stringBuilder.append("---------------------").append("GENERATION[0]").append("---------------------").append("\n").append(grid);
        ;
        for (int i = 1; i < 5; i++) {
            grid = grid.getNextGeneration();
            stringBuilder.append("---------------------").append("GENERATION[").append(i).append("]").append("---------------------").append("\n").append(grid);
        }
        Files.write(Paths.get("output.txt"), stringBuilder.toString().getBytes());
    }
}

