package lab.game;

public class Cell {
    public CellState cellSate;

    public Cell(CellState state) {
        cellSate = state;
    }

    public enum CellState {ALIVE, DEAD}

}
