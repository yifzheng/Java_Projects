import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10]; // 0-9
	JButton[] functionButtons = new JButton[9]; // +,=,-,*,.,/,clear,delete
	JButton addBtn, subBtn, mulBtn, divBtn;
	JButton decBtn, equBtn, delBtn, clrBtn, negBtn;
	JPanel panel;
	
	Font font = new Font("Ink Tree", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0; // used for calculations
	char operator; // hold the operation
	// constructor
	Calculator() {
		// setting up windows
		frame = new JFrame("Yif's Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(420, 550));
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		//<--------------------------TextField------------>
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50); // re-size of text field
		textField.setFont(font);
		textField.setEditable(false);
		//<--------------------------TextField------------>
		//<--------------------------Function Buttons------------>
		// instantiating buttons and pushing to function buttons array
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("*");
		divBtn = new JButton("/");
		decBtn = new JButton(".");
		equBtn = new JButton("=");
		delBtn = new JButton("del");
		clrBtn = new JButton("clr");
		negBtn = new JButton("(-)");
		functionButtons[0] = addBtn;
		functionButtons[1] = subBtn;
		functionButtons[2] = mulBtn;
		functionButtons[3] = divBtn;
		functionButtons[4] = decBtn;
		functionButtons[5] = equBtn;
		functionButtons[6] = delBtn;
		functionButtons[7] = clrBtn;
		functionButtons[8] = negBtn;
		
		for (JButton btn: functionButtons) {
			btn.addActionListener(this); // each button adds an action listener
			btn.setFont(font); // add font to button
			btn.setFocusable(false); // remove outline of button when clicked
		}
		//<--------------------------Function Buttons------------>
		//<--------------------------Number Buttons------------>
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i)); // add button with index
			numberButtons[i].addActionListener(this); // each button adds an action listener
			numberButtons[i].setFont(font); // add font to button
			numberButtons[i].setFocusable(false); // remove outline of button when clicked
		}
		//<--------------------------Number Buttons------------>
		negBtn.setBounds(50, 430, 95, 50);
		delBtn.setBounds(152,  430, 95, 50);
		clrBtn.setBounds(252, 430, 95, 50);
		//<--------- JPanel---------------------->
		// declaring and defining JPanel
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		// add buttons to panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addBtn);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subBtn);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulBtn);
		panel.add(decBtn);
		panel.add(numberButtons[0]);
		panel.add(equBtn);
		panel.add(divBtn);
		//<--------- JPanel---------------------->
		// add component to frame
		frame.add(panel);
		frame.add(textField);
		frame.add(negBtn);
		frame.add(delBtn);
		frame.add(clrBtn);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator(); // declare and instantiate instance of Calculator object
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decBtn) {
			textField.setText(textField.getText().concat("."));
		}
		if (e.getSource() == addBtn) {
			num1 = Double.parseDouble(textField.getText()); // Retrieve text value before operator
			operator = '+'; // operator is now +
			textField.setText(""); // clear text field
		}
		if (e.getSource() == subBtn) {
			num1 = Double.parseDouble(textField.getText()); // Retrieve text value before operator
			operator = '-'; // operator is now +
			textField.setText(""); // clear text field
		}
		if (e.getSource() == divBtn) {
			num1 = Double.parseDouble(textField.getText()); // Retrieve text value before operator
			operator = '/'; // operator is now +
			textField.setText(""); // clear text field
		}
		if (e.getSource() == mulBtn) {
			num1 = Double.parseDouble(textField.getText()); // Retrieve text value before operator
			operator = '*'; // operator is now +
			textField.setText(""); // clear text field
		}
		if (e.getSource() == equBtn) {
			num2 = Double.parseDouble(textField.getText()); // get value of text field
			
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
			textField.setText(String.valueOf(result)); // set textfield value of result from calculation
			num1 = result; // in case of additional operation
		}
		if (e.getSource() == clrBtn) {
			textField.setText(""); // clear text field
		}
		if (e.getSource() == delBtn) {
			String str = textField.getText();
			textField.setText("");
			for (int i = 0; i < str.length() - 1; i++) {
				textField.setText(textField.getText() + str.charAt(i));
			}
		}
		if (e.getSource() == negBtn) {
			double temp = Double.parseDouble(textField.getText());
			temp *= -1; // make number negative
			textField.setText(String.valueOf(temp));
		}
	}

}
