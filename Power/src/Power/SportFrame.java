package Power;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SportFrame extends JFrame {

	Home MainPanel;
	SportPanel SportPanel;
	
	String sq;
	Connection conn;
	Statement st;
	ResultSet rs;
	final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SCT";
	final String userName="sa";
	final String userPwd="123";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SportFrame frame = new SportFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SportFrame() {
		setTitle("POWER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 560);
		SportPanel = new SportPanel();
		SportPanel.button_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			MainPanel = new Home();
			dispose();
			try {
				MainPanel.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	});
		setContentPane(SportPanel);
	}

}
