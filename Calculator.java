import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
		
	JFrame frame;
	JTextField textfield;
	//Creating an array for our numbered buttons
	JButton[] numberButtons = new JButton[10];
	//Creating an array for our function buttons
	JButton[] functionButtons = new JButton[9];
	//Initializing our function buttons
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	//Initializing our panel
	JPanel panel;
	
	Font myFont = new Font("Arial", Font.BOLD, 25);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	
	
	Calculator() {
		//Creating our window for the calculator
		frame = new JFrame("Calculator");
		//Creating a close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Setting the size of the frame
		frame.setSize(430, 560);
		
		frame.setLayout(null);
		
		//Creating our text field
		textfield = new JTextField();
		//Setting the boundaries of the text field
		textfield.setBounds(50, 25, 300, 50);
		//Setting the font
		textfield.setFont(myFont);
		//Disables typing into the output window
		textfield.setEditable(false);
		//Adding the text field to the frame
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");

		
		//Storing our function buttons within the array
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		for (int i = 0; i < 9; i++) {
			//Iterating through our array of buttons
			functionButtons[i].addActionListener(this);
			//Setting the font of the buttons
			functionButtons[i].setFont(myFont);
			//Eliminates the outline around the button
			functionButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			//Iterating through our array of buttons
			numberButtons[i].addActionListener(this);
			//Setting the font of the buttons
			numberButtons[i].setFont(myFont);
			//Eliminates the outline around the button
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		//Adding our buttons to display within our panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);



		//Adding the panel, buttons, and text field to our window
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		//Ensuring the frame is visible
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//Iterating through our number button array to obtain a value
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		//Checking what function button was clicked
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}

		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			//Tracking user input and applying the proper functionality
			switch(operator) {
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
			}
			textfield.setText(String.valueOf(result));
			//Carrying over result if more calculations are needed
			num1 = result;
		}
		//Clear button functionality
		if (e.getSource() == clrButton) {

			textfield.setText("");
		}
		//Delete button functionality
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			
			for (int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		//Negative button functionality
		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
	}
	

}
