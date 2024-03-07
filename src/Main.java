import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int response = captureResponse(s);
        ChessBoard c = new ChessBoard(response);
        ArrayList<String[][]> solved = c.solveQueens();
        printSolutions(solved);
        System.out.println("Solutions: " + solved.size());
    }

    public static int captureResponse(Scanner s)
    {
        System.out.print("Please enter a n value(can't be 2,3 or greater than 8): ");
        int response;
        try{
            response = Integer.parseInt(s.nextLine());
            if(response>8 || response == 2 || response == 3) throw new NumberFormatException();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Did not enter a valid n value!\n");
            response = captureResponse(s);
        }
        return response;
    }

    public static void printSolutions(ArrayList<String[][]> solutions)
    {
        for(int i = 0; i < solutions.size(); i++)
        {
            String[][] solution = solutions.get(i);
            for(String[] row : solution)
            {
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
        }
    }


}