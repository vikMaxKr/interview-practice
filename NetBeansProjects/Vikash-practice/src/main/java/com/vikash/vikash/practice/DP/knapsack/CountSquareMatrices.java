package com.vikash.vikash.practice.DP.knapsack;

import java.util.Arrays;

/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 */
public class CountSquareMatrices {

    public int countSquares(int[][] matrix) {
        int lastRow = matrix.length - 1;
        int lastCol = matrix[0].length - 1;
        int result = 0;

        int[][] memory = new int[lastRow + 1][lastCol + 1];
        for (int[] row : memory) {
            Arrays.fill(row, -1); // Initialize memory with -1 to mark uncomputed cells
        }

        // Loop through every cell and apply the recursive function if it contains 1
        for (int row = 0; row <= lastRow; row++) {
            for (int col = 0; col <= lastCol; col++) {
                if (matrix[row][col] == 1) {
                    result += solve(row, col, matrix, lastRow, lastCol, memory);
                }
            }
        }

        return result;
    }

    int solve(int row, int col, int[][] matrix, int lastRow, int lastCol, int[][] memory) {
        if (row > lastRow || col > lastCol) return 0; // Out of bounds
        if (matrix[row][col] == 0) return 0;           // No square possible if cell is 0
        if (memory[row][col] != -1) return memory[row][col]; // Use memoized result

        // Recursive calls to check right, diagonal, and down neighbors
        int right = solve(row, col + 1, matrix, lastRow, lastCol, memory);
        int diagonal = solve(row + 1, col + 1, matrix, lastRow, lastCol, memory);
        int down = solve(row + 1, col, matrix, lastRow, lastCol, memory);

        // Calculate square size for the current cell and store it
        memory[row][col] = 1 + Math.min(right, Math.min(diagonal, down));
        return memory[row][col];
    }
}
