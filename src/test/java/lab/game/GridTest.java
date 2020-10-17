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
        Cell.CellState[][] state = grid.getCellsState();
        assertThat(state).isEqualTo(input);
    }

    @Test
    public void should_be_able_determine_number_of_alive_cells() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
        Grid grid = new Grid(input);
        int expectedNumberOfAliveCells = 3;
        int actualAliveCells = grid.getAliveCount();
        assertThat(actualAliveCells).isEqualTo(expectedNumberOfAliveCells);
    }

    @Test
    public void should_be_able_to_count_number_of_alive_neighbours_for_a_cell() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, X, O, X, O, O, O},
                {O, O, X, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
        Grid grid = new Grid(input);
        //neighbours for (1,3)
        List<Coordinate> neighbours = new ArrayList<>();
        neighbours.add(new Coordinate(0, 2));
        neighbours.add(new Coordinate(0, 3));
        neighbours.add(new Coordinate(0, 4));
        neighbours.add(new Coordinate(1, 2));
        neighbours.add(new Coordinate(1, 4));
        neighbours.add(new Coordinate(2, 2));
        neighbours.add(new Coordinate(2, 3));
        neighbours.add(new Coordinate(2, 4));

        int expectedNumberOfAliveNeigbours = 5;

        int aliveCountOf = grid.getAliveCountOf(neighbours);
        assertThat(aliveCountOf).isEqualTo(expectedNumberOfAliveNeigbours);
    }

    @Test
    public void should_be_able_to_get_next_generation() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
        Grid grid = new Grid(input);

        Cell.CellState[][] expectedGeneration = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };

        Grid nextGeneration = grid.getNextGeneration();
        assertThat(nextGeneration.getCellsState()).isEqualTo(expectedGeneration);
    }
}
