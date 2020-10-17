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

    public List<Cordinate> getNeigbours(Cordinate inputCellCordinate, Grid grid) {
        int lastIndex = grid.getStateSize() - 1;
        List<Cordinate> neighbours = new ArrayList<>();
        int row = inputCellCordinate.getRow();
        int col = inputCellCordinate.getCol();
        for (int xOffset = -1; xOffset < 2; xOffset++) {
            for (int yOffset = -1; yOffset < 2; yOffset++) {
                if (xOffset != 0 || yOffset != 0) {
                    neighbours.add(new Cordinate(row + yOffset, col + xOffset));
                }
            }
        }

        return neighbours;

    }
}
