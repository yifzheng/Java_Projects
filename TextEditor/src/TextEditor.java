import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor extends JFrame implements ActionListener{
	
	JTextArea textArea;
	JScrollPane scrollPane;
	JLabel fontLabel;
	JSpinner fontSizeSpinner;
	JButton fontColorButton;
	JComboBox<?> fontBox;
	
	/* Menu Bar */
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
	
	TextEditor() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close program
		this.setTitle("Yif's Text Editor"); // title of window
		this.setSize(500, 500); // size of window
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null); // center window on screen
		/* creating and defining the text area */
		textArea = new JTextArea(); // initialize the text area variable
		textArea.setLineWrap(true); // wrap overflow text
		textArea.setWrapStyleWord(true); // wrap around spaces instead of characters
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		/* creating and defining the scroll pane*/
		scrollPane = new JScrollPane(textArea);// add the JTextArea onto the scrollPane
		scrollPane.setPreferredSize(new Dimension(475, 475)); // dimension of the scrollPane
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		/* font label*/
		fontLabel = new JLabel("Font Size: ");
		/* font size spinner*/
		fontSizeSpinner = new JSpinner(); // Initialize the JSpinner object
		fontSizeSpinner.setPreferredSize(new Dimension(50, 25)); // set preferred dimension of object on window
		fontSizeSpinner.setValue(20); // set default value
		fontSizeSpinner.addChangeListener(new ChangeListener() { // add a change listener that changes font size when value is changed

			@Override
			public void stateChanged(ChangeEvent e) {
			
				textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int)fontSizeSpinner.getValue()));
				
			}
			
		});
		/* font color button*/
		fontColorButton = new JButton("Color");
		fontColorButton.addActionListener(this);
		/* font box */
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontBox = new JComboBox(fonts);
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Times New Roman");
		/*<------------------------------------Menu Bar----------------------------------------->*/
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		/* Adding action listeners to menu items */
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(exitItem);
		menuBar.add(menu);
		/*<------------------------------------Menu Bar----------------------------------------->*/
		/* Adding components onto the window */
		this.setJMenuBar(menuBar); // adding menu bar to window
		this.add(fontLabel); // add label onto window
		this.add(fontSizeSpinner); // add font size spinner onto window
		this.add(fontColorButton); // add button onto window
		this.add(fontBox); // add font options onto window
		this.add(scrollPane); // add scroll pane to the frame 
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fontColorButton) {
			Color color = JColorChooser.showDialog(null, "Choose a color", Color.black);
			
			textArea.setForeground(color); // update the color
		}
		if (e.getSource() == fontBox) {
			textArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize())); // update the font
		}
		if (e.getSource() == openItem) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(".")); // set default save location to current project directory
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
			fileChooser.setFileFilter(filter); // add filter to file chooser
			
			int response = fileChooser.showOpenDialog(null);
			if (response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;
				try {
					fileIn = new Scanner(file);
					if (file.isFile()) { // check if file is actually a file
						while (fileIn.hasNextLine()) {
							String line = fileIn.nextLine() + "\n";
							textArea.append(line); // add read line onto text area
						}
					}
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				finally {
					fileIn.close();
				}
			}
		}
		if (e.getSource() == saveItem) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(".")); // set default save location to current project directory
			int response = fileChooser.showSaveDialog(null);
			if (response == JFileChooser.APPROVE_OPTION) {
				File newFile;
				PrintWriter fileOut = null;
				newFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					fileOut = new PrintWriter(newFile);
					fileOut.println(textArea.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				finally {
					fileOut.close();
				}
				
			}
		}
		if (e.getSource() == exitItem) {
			System.exit(0);
		}
	}

}
