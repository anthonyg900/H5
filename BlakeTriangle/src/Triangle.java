/**
 * Created by blakegordon on 9/12/16.
 */
public class Triangle {
    //Sides of the triangle
    private double sideA;
    private double sideB;
    private double sideC;

    //Triangle Constructor
    public Triangle(double a, double b, double c) {
        sideA = a;
        sideB = b;
        sideC = c;
    }

    //Will return true if the triangle is Equilateral
    public boolean isEquilateral() {
        //All three sides must be equal
        if (sideA == sideB && sideB == sideC) {
            return true;
        }
        return false;
    }

    //Will return true if the triangle is Isosceles
    public boolean isIsosceles() {
        //Two sides must be equal
        if (sideA == sideB || sideB == sideC || sideA == sideC) {
            return true;
        }
        return false;
    }

    //Returns true if a, b, and c are NOT able to be a triangle
    public static boolean NotATriangle(double a, double b, double c) {
        boolean ABGreaterC = (a + b) > c;
        boolean ACGreaterB = (a + c) > b;
        boolean BCGreaterA = (b + c) > a;
        if (ABGreaterC && ACGreaterB && BCGreaterA) {
            return false;
        }
        return true;
    }
}