package lab.game;

import static lab.game.Cell.CellState.ALIVE;
import static lab.game.Cell.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void should_be_able_to_get_neighbours_for_a_cell() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
        Grid grid = new Grid(input);
        List<Integer[][]> expectedNeigbours = new ArrayList<>();
        expectedNeigbours.add(new Integer[0][2]);
        expectedNeigbours.add(new Integer[0][3]);
        expectedNeigbours.add(new Integer[0][4]);
        expectedNeigbours.add(new Integer[1][2]);
        expectedNeigbours.add(new Integer[1][4]);
        expectedNeigbours.add(new Integer[2][2]);
        expectedNeigbours.add(new Integer[2][3]);
        expectedNeigbours.add(new Integer[2][4]);
        List<Integer[][]> actualNeighbours = grid.getNeighboursFor(new Integer[1][3], grid);
        assertThat(actualNeighbours).isEqualTo(expectedNeigbours);
    }
}
