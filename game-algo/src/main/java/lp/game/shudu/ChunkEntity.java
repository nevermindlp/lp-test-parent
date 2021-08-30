package lp.game.shudu;

public class ChunkEntity {

    private int[][] row = new int[3][3]; // 3
    private int[][] column = new int[3][3]; //3

    public int[][] getRow() {
        return row;
    }

    public void setRow(int[][] row) {
        this.row = row;
    }

    public int[][] getColumn() {
        return column;
    }

    public void setColumn(int[][] column) {
        this.column = column;
    }

    public void setItem(int rowPos, int colPos, int value) {
        row[rowPos][colPos] = value;
        column[colPos][rowPos] = value;
    }

}
