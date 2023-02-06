import javax.swing.JFrame;

public class GameFrame extends JFrame{

	// constructor for the class
	GameFrame(){
		this.add(new GamePanel());
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack(); // pack all components snugly added to the JFrame
		this.setVisible(true);
		this.setLocationRelativeTo(null); // center window to center of screen
	}
}
