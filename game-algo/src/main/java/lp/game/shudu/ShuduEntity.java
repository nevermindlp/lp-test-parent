package lp.game.shudu;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 9*9 数独
 */
public class ShuduEntity {

    private int[][] row = new int[9][9];
    private int[][] column = new int[9][9];
    private ChunkEntity[][] chunks = new ChunkEntity[3][3]; // 3 * 3
    private List<ChunkEntity> flatChunks = Lists.newArrayList();

    public void setRow(Integer rowNum, Integer colNum, Integer value) {
        row[rowNum][colNum] = value;
    }

    public void setColumn(Integer colNum, Integer rowNum, Integer value) {
        column[colNum][rowNum] = value;
    }

    public void createChunk() throws InterruptedException {

        int commonRepeat = 2;

        int rowMax = 8;
        int colMax = 8;

        int curRow = 0;
        int curCol = 0;

        int rowRepeat = 2;
        int colRepeat = 2;

        ChunkEntity ce = new ChunkEntity();
        for (;;) {
            for (;;) {
                //                int temp = row[curRow][curCol];
                ce.setItem(Math.abs(rowRepeat - commonRepeat), Math.abs(colRepeat - commonRepeat), row[curRow][curCol]);
                System.out.println("curRow : " + curRow
                        + " curCol : " + curCol
                        + " colRepeat : " + colRepeat
                        + " rowRepeat : " + rowRepeat);
                Thread.sleep(10);
                curCol++;
                if (colRepeat == 0) {
                    colRepeat = 2;
                    if (!(curRow == 2 || curRow == 5 || curRow == 8)) {
                        curCol = curCol - commonRepeat - 1;
                    }
                    if (curCol == 9) {
                        curCol = 8;
                    }
                    break;
                }
                colRepeat--;
            }
            curRow++;
            if (rowRepeat == 0) {
                flatChunks.add(ce);
                ce = getSingleChunk();
                rowRepeat = 2;
                if (curCol == colMax && curRow - 1 == rowMax) {
                    break;
                }
                if (curCol == colMax) {
                    curCol = 0;
                } else {
                    curRow = curRow - commonRepeat - 1;
                }
            } else {
                rowRepeat--;
            }
        }
        System.out.println(flatChunks);
    }

    private ChunkEntity getSingleChunk() {
        return new ChunkEntity();
    }

    public void setItem(int r, int c, int v) {
        row[r][c] = v;
        column[c][r] = v;
    }

    public void print() {
        for (int[] r : row) {
            for (int v : r) {
                System.out.print(" " + v);
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ShuduEntity s = new ShuduEntity();

        s.setItem(0, 5, 7);
        s.setItem(3, 6, 2);
        s.setItem(5, 2, 1);
        s.setItem(6, 3, 4);

        s.createChunk();
        s.print();
    }



}
