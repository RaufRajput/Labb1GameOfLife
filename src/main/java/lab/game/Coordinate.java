package lab.game;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public List<Coordinate> getNeighbours(Grid grid) {
        List<Coordinate> neighbours = new ArrayList<>();
        Cell[][] cells = grid.getCells();
        int lastRowIndex = cells.length - 1;
        int lastColumnIndex = cells[0].length -1;
        int row = this.getRow();
        int col = this.getCol();
        for (int xOffset = -1; xOffset < 2; xOffset++) {
            for (int yOffset = -1; yOffset < 2; yOffset++) {
                int newRow = row + yOffset;
                int newCol = col + xOffset;
                if ((xOffset != 0 || yOffset != 0) && (newRow >-1 && newCol > -1) && (newRow <= lastRowIndex && newCol <=lastColumnIndex )) {
                    neighbours.add(new Coordinate(newRow, newCol));
                }
            }
        }

        return neighbours;

    }

    @Override
    public int hashCode() {
        int result;
        result = row / 11;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coordinate that = (Coordinate) obj;

        if (row != that.row) return false;
        return col == that.col;
    }
}
