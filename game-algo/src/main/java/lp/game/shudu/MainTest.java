package lp.game.shudu;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        int commonRepeat = 2;

        int rowMax = 8;
        int colMax = 8;

        int curRow = 0;
        int curCol = 0;

        int rowRepeat = 2;
        int colRepeat = 2;


        for (;;) {
            for (;;) {
                //                int temp = row[curRow][curCol];

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
    }

    public ChunkEntity getSingleChunk() {
        return new ChunkEntity();
    }

}
