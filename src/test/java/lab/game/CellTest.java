package lab.game;

import static lab.game.Cell.CellState.ALIVE;
import static lab.game.Cell.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CellTest {

    @Test
    public void should_have_state_live_when_alive() {
        Cell cell = new Cell(ALIVE);
        assertThat(cell.getCellSate()).isEqualTo(ALIVE);
    }

    @Test
    public void should_have_dead_state_when_dead() {
        Cell cell = new Cell(DEAD);
        assertThat(cell.getCellSate()).isEqualTo(DEAD);
    }

    @Test
    //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    public void should_be_dead_when_live_cell_has_less_than_two_alive_neighbours() {
        Cell cell = new Cell(ALIVE);
        int numberOfAliveNeigbours = 1;
        cell.getCellNextStateHavingAliveNeighbours(numberOfAliveNeigbours);
        assertThat(cell.getCellSate()).isEqualTo(DEAD);
    }
}
