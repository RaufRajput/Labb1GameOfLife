package lab.game;

import static lab.game.Cell.CellState.ALIVE;
import static lab.game.Cell.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CoordinateTest {
    public static final Cell.CellState X = ALIVE;
    public static final Cell.CellState O = DEAD;
    @Test
    public void should_be_able_to_get_neighbours_for_a_cell() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
        Grid grid = new Grid(input);
        List<Coordinate> expectedNeigbours = new ArrayList<>();
        expectedNeigbours.add(new Coordinate(0, 2));
        expectedNeigbours.add(new Coordinate(0, 3));
        expectedNeigbours.add(new Coordinate(0, 4));
        expectedNeigbours.add(new Coordinate(1, 2));
        expectedNeigbours.add(new Coordinate(1, 4));
        expectedNeigbours.add(new Coordinate(2, 2));
        expectedNeigbours.add(new Coordinate(2, 3));
        expectedNeigbours.add(new Coordinate(2, 4));
        List<Coordinate> actualNeighbours = new Coordinate(1, 3).getNeighbours(grid);
        assertThat(actualNeighbours).hasSameSizeAs(expectedNeigbours);
        assertThat(new Coordinate(0, 2)).isIn(expectedNeigbours);
        assertThat(new Coordinate(0, 2)).isIn(expectedNeigbours);
        assertThat(new Coordinate(0, 3)).isIn(expectedNeigbours);
        assertThat(new Coordinate(0, 4)).isIn(expectedNeigbours);
        assertThat(new Coordinate(1, 2)).isIn(expectedNeigbours);
        assertThat(new Coordinate(1, 4)).isIn(expectedNeigbours);
        assertThat(new Coordinate(2, 2)).isIn(expectedNeigbours);
        assertThat(new Coordinate(2, 3)).isIn(expectedNeigbours);
        assertThat(new Coordinate(2, 4)).isIn(expectedNeigbours);
    }

    @Test
    public void should_be_able_to_get_neighbours_for_first_cell() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
        Grid grid = new Grid(input);
        List<Coordinate> expectedNeigbours = new ArrayList<>();
        expectedNeigbours.add(new Coordinate(0, 1));
        expectedNeigbours.add(new Coordinate(1, 0));
        expectedNeigbours.add(new Coordinate(1, 1));

        List<Coordinate> actualNeighbours = new Coordinate(0, 0).getNeighbours(grid);
        assertThat(actualNeighbours).hasSameSizeAs(expectedNeigbours);
        assertThat(new Coordinate(0, 1)).isIn(expectedNeigbours);
        assertThat(new Coordinate(1, 0)).isIn(expectedNeigbours);
        assertThat(new Coordinate(1, 1)).isIn(expectedNeigbours);
    }

    @Test
    public void should_be_able_to_get_neighbours_for_last_cell() {
        Cell.CellState[][] input = new Cell.CellState[][]{
                {O, O, O, O, O, O, O, O},
                {O, O, O, O, X, O, O, O},
                {O, O, O, X, X, O, O, O},
                {O, O, O, O, O, O, O, O}
        };
        Grid grid = new Grid(input);
        List<Coordinate> expectedNeigbours = new ArrayList<>();
        expectedNeigbours.add(new Coordinate(2, 7));
        expectedNeigbours.add(new Coordinate(2, 6));
        expectedNeigbours.add(new Coordinate(3, 6));

        List<Coordinate> actualNeighbours = new Coordinate(3, 7).getNeighbours(grid);
        assertThat(actualNeighbours).hasSameSizeAs(expectedNeigbours);
        assertThat(new Coordinate(2, 7)).isIn(expectedNeigbours);
        assertThat(new Coordinate(2, 6)).isIn(expectedNeigbours);
        assertThat(new Coordinate(3, 6)).isIn(expectedNeigbours);
    }
}
