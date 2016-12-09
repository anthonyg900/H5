// Name:  Anthony Gomez
import java.io.*;
import java.util.Scanner;
public class UseTriangle
{
    public static void main (String[] args)throws IOException{

        // Declare stdin so data can be read from input.
        DataInputStream stdin = new DataInputStream (System.in);
        Scanner scan = new Scanner(System.in);
        String quit ="";

        do{
            // Ask user for 3 dimensions of triangle.
            System.out.println ("Enter side 1 length: ");
            int sideA = Integer.parseInt (stdin.readLine());

            System.out.println ("Enter side 2 length: ");
            int sideB = Integer.parseInt (stdin.readLine());

            System.out.println ("Enter side 3 length: ");
            int sideC = Integer.parseInt (stdin.readLine());

            // Now use these values to create a Triangle object.
            Triangle tri = new Triangle (sideA,sideB,sideC);

            // Determine what kind of triangle it is.
            System.out.println (" "+tri.isScalene());
            System.out.println (" "+tri.isIsosceles());
            System.out.println (""+tri.isEquilateral());
            // Ask user if they want to continue.
            System.out.println ("Do you want to make more triangles?(Y/N)");
            quit= scan.next();
        }
        while(!quit.equals("y"));
        System.exit(0);
    }
}