package lab.game;

import static lab.game.Cell.CellState.ALIVE;
import static lab.game.Cell.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
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

}
