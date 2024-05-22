package source;

import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
	Frame frame;
	TextField tf1;
	Button[] numberButtons = new Button[10];
	Button[] functionButtons = new Button[8];
	Button addButton, subButton, mulButton, divButton;
	Button decButton, equButton, delButton, clrButton;
	Panel panel;
Calculator(){
	
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
	}

}
