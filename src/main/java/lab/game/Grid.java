package lab.game;

class Grid {
    private Cell[][] state;

    public Grid(Cell.CellState[][] input) {
        state = new Cell[input.length][];
        for (int row = 0; row < input.length; row++) {
            state[row] = new Cell[input[row].length];
            for (int col = 0; col < input[row].length; col++) {
                state[row][col] = new Cell(input[row][col]);
            }
        }
    }

    public Cell.CellState[][] getState() {
        Cell.CellState[][] cellStates = new Cell.CellState[state.length][];
        for (int row = 0; row < state.length; row++) {
            cellStates[row] = new Cell.CellState[state[row].length];
            for (int col = 0; col < state[row].length; col++) {
                cellStates[row][col] = state[row][col].getCellSate();
            }
        }
        return cellStates;
    }
}
