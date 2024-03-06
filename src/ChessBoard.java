import java.util.ArrayList;
import java.util.Arrays;
public class ChessBoard {
    private String[][] board;
    final private int n;
    public ChessBoard(int n)
    {
        this.n = n;
        createBoard();
        printBoard();
    }
    public void createBoard()
    {
        board = new String[n][n];
        for(int i = 0; i < board.length; i++)
        {
            for(int a = 0; a < board[i].length; a++)
            {
                board[i][a]="-";
            }
        }
    }
    public void printBoard()
    {
        for(String[] row : board)
        {
            System.out.println(Arrays.toString(row));
        }
    }

}
