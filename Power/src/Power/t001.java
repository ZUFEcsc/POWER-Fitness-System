package Power;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class t001 {

	private JFrame frame;
	static t001 window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					window = new t001();
					window.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public t001() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				window.frame.setVisible(false);
				t002 t2 = new t002();
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
	}

}