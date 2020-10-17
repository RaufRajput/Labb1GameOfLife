package lab.game;

import static lab.game.Cell.CellState.ALIVE;

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
        int count = 0;
        for (int row = 0; row < getStateSize(); row++) {
            for (int col = 0; col < cells[row].length; col++) {
                if (isCellAlive(cells[row][col])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isCellAlive(Cell cell) {
        return cell.getCellSate() == ALIVE;
    }

    public int getAliveCountOf(List<Coordinate> neighbours) {
        int count = 0;
        for (Coordinate coordinate : neighbours) {
            if (isCellAlive(cells[coordinate.getRow()][coordinate.getCol()])) {
                count++;
            }
        }
        return count;
    }

    public void getNextGeneration() {

    }
}