package lab.game;


public class Cell {
    private CellState cellSate;

    public Cell(CellState state) {
        cellSate = state;
    }

    public CellState getCellSate() {
        return cellSate;
    }

    public enum CellState {ALIVE, DEAD}
}
