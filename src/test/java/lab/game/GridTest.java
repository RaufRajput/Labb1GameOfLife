package lab.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GridTest {

    @Test
    public void should_be_initiated_with_initial_state() {
        Grid grid = new Grid();
        Cell[][] state = grid.getState();
        assertThat(state).isNull();

    }

    private class Grid {
        public Cell[][] getState() {
            return null;
        }
    }
}
