package lab.game;

public class Cordinate {
    private int row;
    private int col;

    public Cordinate(int row, int col) {
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

        Cordinate that = (Cordinate) obj;

        if (row != that.row) return false;
        return col == that.col;
    }
}
