// Saeed Alshamsi
// CS 143
// HW #1: Sudoku #1 (Board Setup)
//
// This program will create a Sudoku board class that can read puzzle data from a file
// and display the board in a formatted way. It uses a 2D char array to store the board
// where digits represent filled cells and '.' represents empty cells.

import java.util.*;
import java.io.*;

public class SudokuBoard {
    private char[][] board;
    
    // PRE: filename is a valid path to a .sdk file with 9 rows of 9 characters each
    // POST: initializes the Sudoku board with data from the file
    public SudokuBoard(String filename) {
        board = new char[9][9];
        readBoardFromFile(filename);
    }
    
    // PRE: filename is a valid path to a .sdk file
    // POST: reads the file and populates the board array
    private void readBoardFromFile(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            int row = 0;
            
            while (fileScanner.hasNextLine() && row < 9) {
                String line = fileScanner.nextLine().trim();
                if (line.length() == 9) {
                    for (int col = 0; col < 9; col++) {
                        board[row][col] = line.charAt(col);
                    }
                    row++;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            // Initialize with empty board if file not found
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = '.';
                }
            }
        }
    }
    
    // PRE: none
    // POST: returns a formatted string representation of the Sudoku board
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Sudoku Board:\n");
        result.append("+-------+-------+-------+\n");
        
        for (int i = 0; i < 9; i++) {
            result.append("| ");
            for (int j = 0; j < 9; j++) {
                result.append(board[i][j]).append(" ");
                if ((j + 1) % 3 == 0) {
                    result.append("| ");
                }
            }
            result.append("\n");
            
            if ((i + 1) % 3 == 0 && i != 8) {
                result.append("+-------+-------+-------+\n");
            }
        }
        result.append("+-------+-------+-------+\n");
        
        return result.toString();
    }
}