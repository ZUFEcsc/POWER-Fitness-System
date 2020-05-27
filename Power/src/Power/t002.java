package Power;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class t002 {

	private JFrame frame;
	static t002 window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					window = new t002();
					window.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public t002() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
		
	}

}