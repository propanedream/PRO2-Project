package opgaveFindMax;

import java.util.Random;

public class TestFindMax {

    private static final int rowindex = 4;
    private static final int colindex = 200000000;

    private static int[][] board = new int[rowindex][colindex];

    public static void main(String[] args) {
        fillBoard();
//		 printBoard();
        System.out.println("thread");
        long l1 = System.nanoTime();
        try {
            System.out.println("Max: " + findMaxThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l2 = System.nanoTime();
        System.out.println("K�retiden var " + (l2 - l1) / 1000000 + " millisekunder");

        System.out.println("no thread");
         l1 = System.nanoTime();
        System.out.println("Max: " + findMax());
         l2 = System.nanoTime();
        System.out.println("K�retiden var " + (l2 - l1) / 1000000 + " millisekunder");
    }

    public static int findMax() {
        //TODO
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rowindex; i++) {
            for (int j = 0; j < colindex; j++) {
                if (max < board[i][j]) {
                    max = board[i][j];
                }
            }
        }
        return max;
    }

    public static int findMaxThread() throws InterruptedException {
        //TODO
        int max = -1;
        TraadKlassen[] tk = new TraadKlassen[rowindex];

        for (int i = 0; i < board.length; i++) {
            tk[i] = new TraadKlassen(board[i]);
            tk[i].start();
        }
        for (int i = 0; i < board.length ; i++) {
            tk[i].join();
            max = Math.max(max,tk[i].getMax());
        }
        return max;
    }

    public static void fillBoard() {
        Random rand = new Random();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = rand.nextInt(200000000) + 1;
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
