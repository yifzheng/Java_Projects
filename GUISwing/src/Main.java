import java.awt.*;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		/*
		JFrame frame = new JFrame(); // creates instance of frame/ GUI window to add components to
		frame.setTitle("JFrame Title"); // this sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application instead of hiding window
		frame.setResizable(false); // prevents frame from being resized
		frame.setSize(new Dimension(500,500)); // sets the x and y dimension of the frame
		frame.setLocationRelativeTo(null); // this centers the window to middle of screen
		ImageIcon icon = new ImageIcon("./pokeball.png"); // create an image icon
		frame.setIconImage(icon.getImage()); // change icon of frame
		frame.getContentPane().setBackground(new Color(0x123455)); // change color of background
		frame.setVisible(true); // make frame visible
		*/
		new MyFrame(); // creates instance of frame class
	}

}
