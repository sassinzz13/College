package source;

import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame {
    
	//idk why theres no error with static need to check the docs
    public static double num1 = 0;
    public static double num2 = 0;
    public static char operator;

    public static void main(String[] args) {
        // Frame implementations
        Frame f = new Frame();

        // Textfields
        TextField tf1 = new TextField(10);
        tf1.setEditable(false);

        // Buttons
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button bPlus = new Button("+");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button bMinus = new Button("-");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button bMultiply = new Button("*");
        Button bModulo = new Button("%");
        Button bZero = new Button("0");
        Button bDot = new Button(".");
        Button bDivide = new Button("/");
        Button bEqual = new Button("=");

        // Panel
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        // Implementations
        p1.setLayout(new GridLayout(4, 4));
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(bPlus);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(bMinus);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p1.add(bMultiply);
        p1.add(bModulo);
        p1.add(bZero);
        p1.add(bDot);
        p1.add(bEqual);
        p2.add(tf1);

        // WindowEvent
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Add components to the frame
        f.add(tf1, BorderLayout.NORTH);
        f.add(p1, BorderLayout.CENTER);
        
        f.setVisible(true);
        f.setSize(400, 400);

        // Logic
        //So after realizing na kaya ko naman palang gawing ganto nalang instead of like
        /*
         b1.addActionListener(ActionEvent() {
         	something like this i can just do it like that
         });
         */
        b1.addActionListener(e -> tf1.setText(tf1.getText() + '1'));
        b2.addActionListener(e -> tf1.setText(tf1.getText() + '2'));
        b3.addActionListener(e -> tf1.setText(tf1.getText() + '3'));
        b4.addActionListener(e -> tf1.setText(tf1.getText() + '4'));
        b5.addActionListener(e -> tf1.setText(tf1.getText() + '5'));
        b6.addActionListener(e -> tf1.setText(tf1.getText() + '6'));
        b7.addActionListener(e -> tf1.setText(tf1.getText() + '7'));
        b8.addActionListener(e -> tf1.setText(tf1.getText() + '8'));
        b9.addActionListener(e -> tf1.setText(tf1.getText() + '9'));
        bZero.addActionListener(e -> tf1.setText(tf1.getText() + '0'));
        bDot.addActionListener(e -> tf1.setText(tf1.getText() + '.'));

        bPlus.addActionListener(e -> handleOperator(tf1, '+'));
        bMinus.addActionListener(e -> handleOperator(tf1, '-'));
        bMultiply.addActionListener(e -> handleOperator(tf1, '*'));
        bDivide.addActionListener(e -> handleOperator(tf1, '/'));
        bModulo.addActionListener(e -> handleOperator(tf1, '%'));

        bEqual.addActionListener(e -> calculateResult(tf1));
    }

    // Clear the text field for the next number
    private static void handleOperator(TextField tf1, char op) {
        num1 = Double.parseDouble(tf1.getText());
        operator = op;
        tf1.setText(""); 
    }

    //Result
    //king ina ganto lang pala yan
    private static void calculateResult(TextField tf1) {
        num2 = Double.parseDouble(tf1.getText());
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '%':
                result = num1 % num2;
                break;
        }
        tf1.setText(String.valueOf(result));
    }
}
