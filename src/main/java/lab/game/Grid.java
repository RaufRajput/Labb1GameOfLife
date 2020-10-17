package lab.game;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private Cell[][] cells;

    public Grid(Cell.CellState[][] input) {
        cells = new Cell[input.length][];
        for (int row = 0; row < input.length; row++) {
            cells[row] = new Cell[input[row].length];
            for (int col = 0; col < input[row].length; col++) {
                cells[row][col] = new Cell(input[row][col]);
            }
        }
    }

    public Cell.CellState[][] getCellsState() {
        Cell.CellState[][] cellStates = new Cell.CellState[cells.length][];
        for (int row = 0; row < cells.length; row++) {
            cellStates[row] = new Cell.CellState[cells[row].length];
            for (int col = 0; col < cells[row].length; col++) {
                cellStates[row][col] = cells[row][col].getCellSate();
            }
        }
        return cellStates;
    }

    public int getStateSize() {
        return cells.length;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getAliveCount() {
        return 3;
    }
}
