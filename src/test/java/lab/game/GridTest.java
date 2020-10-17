package lab.game;

import static lab.game.Cell.CellState.ALIVE;
import static lab.game.Cell.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GridTest {


    public static final Cell.CellState X = ALIVE;
    public static final Cell.CellState O = DEAD;

    @Test
    public void should_be_initiated_with_initial_state() {

        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
        Grid grid = new Grid(input);
        Cell.CellState[][] state = grid.getState();
        assertThat(state).isEqualTo(input);
    }

    private class Grid {
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
}
