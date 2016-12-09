// EGR320 Software Quality Assurence & Testing
// Name:  Anthony Gomez

import java.io.*;
public class Triangle
{
    public double sideA;
    public double sideB;
    public double sideC;

    //Constructor
    public Triangle(double a, double b, double c){
        sideA = a;
        sideB = b;
        sideC = c;
    }

    public boolean isEquilateral(){
        if((sideA==sideB) && (sideA==sideC) && (sideB==sideC)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isIsosceles(){
        if(((sideA == sideB) && (sideA != sideC)) ||
                ((sideA == sideC) && (sideA != sideB)) ||
                ((sideB == sideC) && (sideB != sideA))){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isScalene(){
        if((sideA != sideB) && (sideA != sideC) && (sideB != sideC)){
            return true;
        }
        else{
            return false;
        }
    }

}