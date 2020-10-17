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
        if (isReproductionPossible(numberOfAliveNeigbours) || !isCellHasOverPopulatedORUnderPopulatedNeighbourHood(numberOfAliveNeigbours)) {
            cellSate = ALIVE;
        } else {
            cellSate = DEAD;
        }
    }

    private boolean isReproductionPossible(int numberOfAliveNeigbours) {
        return cellSate == DEAD && numberOfAliveNeigbours == 3;
    }

    private boolean isCellHasOverPopulatedORUnderPopulatedNeighbourHood(int numberOfAliveNeigbours) {
        return numberOfAliveNeigbours != 2 && numberOfAliveNeigbours != 3;
    }

    public enum CellState {ALIVE, DEAD}
}
