import java.util.ArrayList;
import java.util.Arrays;
public class ChessBoard {
    private String[][] board;
    final private int n;
    private ArrayList<String[][]> combinations;
    public ChessBoard(int n)
    {
        this.n = n;
        createBoard();
        combinations = new ArrayList<>();
    }
    public void createBoard()
    {
        board = new String[n][n];
        for(String[] rows : board)
        {
            Arrays.fill(rows,"-");
        }
    }
    public void printBoard()
    {
        for(String[] row : board)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public ArrayList<String[][]> solveQueens()
    {
        solveQueensCompute(0,n);
        combinations = checkSolutions();
        return combinations;
    }
    private boolean isValid(int row, int column)
    {
        int rowCheck = row;
        int columnCheck = column;
        //System.out.println(board[row].length + "------");
        //System.out.println(board.length);
        //System.out.println(row);
        //System.out.println(column);
        for(int i = 0; i < board.length; i++)
        {
            if(board[i][column].equals("Q")) return false;
        }
        for(int i = 0; i < board[row].length; i++)
        {
            if(board[row][i].equals("Q")) return false;
        }
        while(rowCheck>=0 && columnCheck>=0)
        {
            if(board[rowCheck][columnCheck].equals("Q")) return false;
            rowCheck--; columnCheck--;
        }
        rowCheck = row;
        columnCheck = column;
        while(rowCheck>=0 && columnCheck<board[0].length)
        {
            if(board[rowCheck][columnCheck].equals("Q")) return false;
            rowCheck--; columnCheck++;
        }
        rowCheck = row;
        columnCheck = column;
        while(rowCheck<board.length && columnCheck<board[0].length)
        {
            if(board[rowCheck][columnCheck].equals("Q")) return false;
            rowCheck++; columnCheck++;
        }
        rowCheck = row;
        columnCheck = column;
        while(rowCheck<board.length && columnCheck>=0)
        {
            if(board[rowCheck][columnCheck].equals("Q")) return false;
            rowCheck++; columnCheck--;
        }
        return true;
    }

     /* starts at board[0][0] place queen at coord, mark it as "Q"
        and go recurse the function with the next column and start from row 0 until a tile which "Q" can be placed
        this repeats until a queen is placed on the last column (adds the board) or if no
        possible tile is found in which case the function will simply stop the for iteration and end, backtracking
        to the previous column and reset the coord which the queen was at to "-" before increasing the row until
        another possible tile is found. This function will completely come to a stop once all tiles of the first column
        or board[i][0] and its resulting combinations are tested **/

    private void solveQueensCompute(int column, int queens)
    {
        //System.out.println(row);
        //System.out.println(column);
        //System.out.println(queens);
        if(queens == 0 || column == board.length) {
            addBoard();
            return;
        }
        for(int i = 0; i < board.length; i++)
        {
            if(isValid(i,column))
            {
                board[i][column] = "Q";
                solveQueensCompute(column+1,queens-1);
                board[i][column] = "-";
            }
        }
    }

    private void addBoard()
    {
        String[][] tempBoard = new String[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int a = 0; a < n; a++)
            {
                tempBoard[i][a] = board[i][a];
            }
        }
        combinations.add(tempBoard);
        //createBoard();
    }
    private boolean enoughQueens(String[][] solution)
    {
        int count = 0;
        for(String[] row : solution)
        {
            for(String coord : row)
            {
                if(coord.equals("Q")) count++;
            }
        }
        if(count == n) return true;
        return false;
    }

    private ArrayList<String[][]> checkSolutions()
    {
        ArrayList<String[][]> newSolutions = new ArrayList<>();
        for(String[][] solution : combinations)
        {
            if(enoughQueens(solution)) newSolutions.add(solution);
        }
        return newSolutions;
    }



}
