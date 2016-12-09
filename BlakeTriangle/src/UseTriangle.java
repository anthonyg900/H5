import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Created by blakegordon on 9/14/16.
 */
public class UseTriangle {
    private JPanel panelMain;
    private JTextField sideAIn;
    private JTextField sideBIn;
    private JTextField sideCIn;
    private JButton checkTriangleButton;
    private JLabel titleLabel;

    public UseTriangle() {
        //Set the title label. HTML is used to make the label multiline
        titleLabel.setText("<html><center><b>Welcome to Triangle Tester! Please input three sides</b><br>" +
                "We will tell you if the three sides make an equilateral, isosceles, or scalene triangle<br>" +
                "Please be sure that all three sides are numbers <br>" +
                "and are not longer than 16 characters</center></html>");

        //Listener for the check triangle button
        checkTriangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sideA;
                double sideB;
                double sideC;

                //Ensure that all the inputs are valid
                //If they are then set them to the sides, if not then error message will be presented
                if ((validSideInput(sideAIn.getText())) && (validSideInput(sideBIn.getText()))
                        && (validSideInput(sideCIn.getText()))) {
                    sideA = Double.parseDouble(sideAIn.getText());
                    sideB = Double.parseDouble(sideBIn.getText());
                    sideC = Double.parseDouble(sideCIn.getText());
                } else {
                    return;
                }

                //Check if three sides are a triangle, if not show error message
                if (Triangle.NotATriangle(sideA, sideB, sideC)) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "The three sides do not equal a triangle. Please input again",
                            "Not A Triangle", JOptionPane.DEFAULT_OPTION);
                } else {
                    Triangle userTriangle = new Triangle(sideA, sideB, sideC);

                    if (userTriangle.isEquilateral()) {
                        //The triangle is equilateral
                        //A message will display the triangle type and if they want to test again
                        //If they choose No then the program will quit
                        if (JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),
                                "This is an equilateral triangle. Thank you for using our program!" +
                                        "\nWould you like to test again?",
                                "Equilateral Triangle", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                            System.exit(0);
                        }
                    } else if (userTriangle.isIsosceles()) {
                        //The triangle is isosceles
                        //A message will display the triangle type and if they want to test again
                        //If they choose No then the program will quit
                        if (JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),
                                "This is an isosceles triangle. Thank you for using our program!" +
                                        "\nWould you like to test again?",
                                "Isosceles Triangle", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                            System.exit(0);
                        }
                    } else {
                        //The triangle must be scalene
                        //A message will display the triangle type and if they want to test again
                        //If they choose No then the program will quit
                        if (JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),
                                "This is a scalene triangle. Thank you for using our program!" +
                                        "\nWould you like to test again?",
                                "Scalene Triangle", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                            System.exit(0);
                        }
                    }
                }

                //Reset the text input boxes
                sideAIn.setText("");
                sideBIn.setText("");
                sideCIn.setText("");
            }
        });
    }

    //Setup the frame
    public static void main(String[] args) {
        JFrame frame = new JFrame("NewGUI");
        frame.setContentPane(new UseTriangle().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setTitle("Triangle Tester");
        frame.setResizable(false);

        //Retrieved from a previous project of mine to set the frame size and location on screen
        frame.setSize(700, 250);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        frame.setVisible(true);
    }

    //Presents a message and set false if the input is not positive, non zero, longer than 17, or not a number
    private boolean validSideInput(String userInput) {
        //Regex, a digit is required and followed by a decimal and digit is optional
        if ((userInput.matches("\\d+(\\.\\d+)?") || userInput.matches("\\.\\d+")) &&
                userInput.length() < 17){
            if (!(Double.parseDouble(userInput) == 0)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                "Please be sure that the input is a positive, non-zero number" +
                        "\nand the input is not longer than 16 characters including the decimal point",
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}