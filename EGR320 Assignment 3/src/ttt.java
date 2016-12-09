import java.util.Scanner;

public class ttt
{
    public static void main(String args[])
    {
        // This will only display when the program is first run
        System.out.println("You, are about to witness the program of the century.\n"); //(Bug1 Comma)

        // This tracks the number of times each player has won.
        // Player 0 is the Cat
        // Player 1 is, well player 1                                                  //(Bug1 Comma)
        // Player 2 is player 2
        int[] numberOfWins = {0,0,0};

        // And this tells us whether or not to play again.
        boolean done = false;

        while (!done)
        {
            // This will display before each game
            System.out.println("COMMENCE TIC TAC TOE!!!!\n");

            // Play a game and remember who won (if anyone)
            int winner = playGame();

            // Update it
            numberOfWins[ winner ]++;

            // Display it
            displayWinnerStats( numberOfWins, winner );

            done = isDone();
        }

        // Finish
        System.out.println("\n\nThank you for playing!");                           //(Bug 2 \n)
    }

    public static int playGame()
    {
        String[][] b = {{" "," "," "},{" "," "," "},{" "," "," "}};
        Scanner kb = new Scanner(System.in);
        int r,c,i;
        System.out.println(" "+b[0][0]+" || "+b[0][1]+" || "+b[0][2]+" ");
        System.out.println("=============");
        System.out.println(" "+b[1][0]+" || "+b[1][1]+" || "+b[1][2]+" ");
        System.out.println("=============");
        System.out.println(" "+b[2][0]+" || "+b[2][1]+" || "+b[2][2]+" ");

        for(i=1,r=0,c=0;i<9;i++,r=0,c=0)
        {
            while(r<1||r>3||c<1||c>3)                                             //(Bug 3 check for int)
            {
                System.out.println("Enter the row(1-3) and column(1-3) you want: ");
                r = kb.nextInt();
                c = kb.nextInt();
            }
            if(i==1||i==3||i==5||i==7||i==9)                                      //(Bug 4 parenthesis on single if statement)
                b[r-1][c-1] = "X";
            else
                b[r-1][c-1] = "O";

            System.out.println(" "+b[0][0]+" || "+b[0][1]+" || "+b[0][2]+" ");
            System.out.println("=============");
            System.out.println(" "+b[1][0]+" || "+b[1][1]+" || "+b[1][2]+" ");
            System.out.println("=============");
            System.out.println(" "+b[2][0]+" || "+b[2][1]+" || "+b[2][2]+" ");
            if(i>=5)
                if((b[0][0]=="X" && ((b[0][0]==b[0][1]) && (b[0][1]==b[0][2]))) || (b[1][0]=="X" && ((b[1][0]==b[1][1]) && (b[1][1]==b[1][2])))
                        || (b[2][0]=="X" && ((b[2][0]==b[2][1]) && (b[2][1]==b[2][2]))) || (b[0][0]=="X" && ((b[0][0]==b[1][0]) && (b[1][0]==b[2][0])))
                        || (b[0][1]=="X" && ((b[0][1]==b[1][1]) && (b[1][1]==b[2][1]))) || (b[0][2]=="X" && ((b[0][2]==b[1][2]) && (b[1][2]==b[2][2])))
                        || ((((b[0][0]==b[1][1]) && (b[1][1]==b[2][2])) || ((b[2][0]==b[1][1]) && (b[1][1]==b[0][2]))) && b[1][1]=="X"))
                    return 1;
                else
                if((b[0][0]=="O" && ((b[0][0]==b[0][1]) && (b[0][1]==b[0][2]))) || (b[1][0]=="O" && ((b[1][0]==b[1][1]) && (b[1][1]==b[1][2])))
                        || (b[2][0]=="O" && ((b[2][0]==b[2][1]) && (b[2][1]==b[2][2]))) || (b[0][0]=="O" && ((b[0][0]==b[1][0]) && (b[1][0]==b[2][0])))
                        || (b[0][1]=="O" && ((b[0][1]==b[1][1]) && (b[1][1]==b[2][1]))) || (b[0][2]=="O" && ((b[0][2]==b[1][2]) && (b[1][2]==b[2][2])))
                        || ((((b[0][0]==b[1][1]) && (b[1][1]==b[2][2])) || ((b[2][0]==b[1][1]) && (b[1][1]==b[0][2]))) && b[1][1]=="O"))
                    return 2;
        }
        return 0;
    }

    public static void displayWinnerStats(int wins[], int winner)
    {
        if(winner==1)                                                    //(Bug 4 parenthesis on if statement)
            System.out.println("Player 1 Wins");
        else if(winner==2)
            System.out.println("Player 2 Wins");
        else
            System.out.println("Cats Game");
        System.out.println("The current scores are:");
        System.out.println("Player 1 has "+wins[1]+" wins");
        System.out.println("Player 2 has "+wins[2]+" wins");
        System.out.println("The Cat has "+wins[0]+" wins");
        System.out.println();
        System.out.println();
    }

    public static boolean isDone()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Do you want to keep playing?y/n: ");
        String k = kb.nextLine();
        if(k.charAt(0)=='y')                                       //(Bug 4 parenthesis on if statement)
            return false;
        else
            return true;
    }
}