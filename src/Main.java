import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a n value(can't be 2,3 or greater than 8: ");
        int response;

        ChessBoard c = new ChessBoard(response);
    }

    public static int captureResponse(Scanner s)
    {
        try{
            response = Integer.parseInt(s.nextLine());
            if(response>8 || response == 2 || response == 3) throw new NumberFormatException();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Please enter a valid number");
            System.out.print("Please enter a n value: ");
        }
    }

}