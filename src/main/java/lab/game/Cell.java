package lab.game;


import static lab.game.Cell.CellState.ALIVE;
import static lab.game.Cell.CellState.DEAD;

public class Cell {
    private CellState cellSate;

    public Cell(CellState state) {
        cellSate = state;
    }

    public CellState getCellSate() {
        return cellSate;
    }

    public void getCellNextStateHavingAliveNeighbours(int numberOfAliveNeigbours) {
        if (numberOfAliveNeigbours >= 2) {
            cellSate = ALIVE;
        } else {
            cellSate = DEAD;
        }
    }

    public enum CellState {ALIVE, DEAD}
}
