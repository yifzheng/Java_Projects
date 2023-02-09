import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class MyFrame extends JFrame{

	JLabel label;
	Border border = BorderFactory.createLineBorder(Color.green, 3);
	MyFrame() {
		// label
		label = new JLabel(); // create new label
		label.setText("Hello World! This is GUISwing practice"); // set text of label
		label.setForeground(Color.GRAY); // set color of label
		label.setFont(new Font("Roboto", Font.BOLD, 60));
		label.setBorder(border);
		this.setTitle("JFrame Title"); // this sets title of this
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application instead of hiding window
		this.setResizable(false); // prevents this from being resized
		//this.setSize(new Dimension(500,500)); // sets the x and y dimension of the this
		this.setLocationRelativeTo(null); // this centers the window to middle of screen
		//ImageIcon icon = new ImageIcon("/GUISwing/src/pokeball.png"); // create an image icon
		//this.setIconImage(icon.getImage()); // change icon of this
		this.getContentPane().setBackground(new Color(0x123455)); // change color of background
		this.setVisible(true); // make this visible
		this.add(label);
		this.pack(); // resize size of frame to accommodate the size of components
	}
	
}
