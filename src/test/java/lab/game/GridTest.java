package lab.game;

import static lab.game.Cell.CellState.ALIVE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GridTest {

    @Test
    public void should_be_initiated_with_initial_state() {

        Cell.CellState[][] input = new Cell.CellState[][]{
                {ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE},
                {ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE},
                {ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE},
                {ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE}
        };
        Grid grid = new Grid(input);
        Cell[][] state = grid.getState();
        assertThat(state).isNotNull();
    }

    private class Grid {
        public Grid(Cell.CellState[][] input) {

        }

        public Cell[][] getState() {
            return null;
        }
    }
}
