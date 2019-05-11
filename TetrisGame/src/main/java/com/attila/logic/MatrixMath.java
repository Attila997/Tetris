package com.attila.logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixMath {

    /**
     * A Board mátrixának és a shape mátrixának a metszéspontját számolja ki, annak érdekében hogy
     * tudja mikor nem mehet már lejjebb a shape
     * @param matrix a tábla mártixa
     * @param shape forma
     * @param x
     * @param y
     * @return igazat ha még még mehet tovább a forma, hamisat ha megkell álljon
     */
    public static boolean intersect(final int[][] matrix, final int[][] shape,int x, int y){
        for (int i = 0; i < shape.length; i++){
            for (int j = 0; j < shape[i].length; j++) {
                int targetX = x + i;
                int targetY = y + j;
                if (shape[j][i] != 0 && (outOfBorder(matrix, targetX, targetY) || matrix[targetY][targetX] != 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * AZt vizsgálja hogy a cél koordináta ahova a forma mozogni fog belül van-e
     * a tábla szélén
     * @param matrix
     * @param targetX
     * @param targetY
     * @return igazat ha igen, hamisat ha nem
     */
    private static boolean outOfBorder(int[][] matrix,int targetX, int targetY){
        boolean value = true;
        if (targetX >= 0 && targetY < matrix.length && targetX < matrix[targetY].length){
            value = false;
        }
        return value;
    }

    public static int[][] copy(int[][] matrix){
        int [][] myInt = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++)
        {
            int[] aMatrix = matrix[i];
            int   aLength = aMatrix.length;
            myInt[i] = new int[aLength];
            System.arraycopy(aMatrix, 0, myInt[i], 0, aLength);
        }
        return myInt;
    }

    public static int[][] push(int[][] shape, int[][] filledField, int x, int y){
        int[][] copy = copy(filledField);
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                int targetX = x + i;
                int targetY = y + j;
                if (shape[j][i] != 0) {
                    copy[targetY][targetX] = shape[j][i];
                }
            }
        }
        return copy;
    }

    /**
     * Megnézi hogy valamely sor törlendő-e
     * @return visszad a törölt sorok számát, az uj Tábla mátrixát
     */
    public static LineClear checkRemove(final int[][] board){
        int[][] currentBoard = new int[board.length][board[0].length];
        Deque<int[]> newRows = new ArrayDeque<>();
        List<Integer> clearedRows = new ArrayList<>();

        for (int i = 0; i < board.length; i++){
            int[] currentRow = new int[board[i].length];
            boolean rowToClear = true;
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 0){
                    rowToClear = false;
                }
                currentRow[j] = board[i][j];
            }
            if (rowToClear){
                clearedRows.add(i);
            } else {
                newRows.add(currentRow);
            }
        }
        //AZ ures helyre berakja a felette lévőket
        for (int i = board.length - 1; i >= 0; i--) {
            int[] row = newRows.pollLast();
            if (row != null) {
                currentBoard[i] = row;
            } else {
                break;
            }
        }
        int score = 50 * clearedRows.size() * clearedRows.size();
        return new LineClear(clearedRows.size(),currentBoard,score);
    }

    public static List<int[][]> copyToList(List<int[][]> list){
        return list.stream().map(MatrixMath::copy).collect(Collectors.toList());
    }
}
