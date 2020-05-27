package Power;

import java.awt.EventQueue;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PrdFrame {
	Home MainPanel;
	static PrdFrame window;
	private JTextField textField;
	JFrame PrdFrame;
	
	JLabel label_NowUser;
	
	String sq;
	Connection conn;
	Statement st;
	ResultSet rs;
	final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=POW";
	final String userName="sa";
	final String userPwd="123";
	String sqlStr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrdFrame window = new PrdFrame();
					window.PrdFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrdFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PrdFrame = new JFrame();
		PrdFrame.getContentPane().setFocusCycleRoot(true);
		PrdFrame.setTitle("POWER");
		PrdFrame.setBounds(100, 100, 930, 560);
		PrdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PrdFrame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("POWER");
		label.setFont(new Font("French Script MT", Font.PLAIN, 20));
		label.setBounds(0, 0, 64, 22);
		PrdFrame.getContentPane().add(label);
		ImageIcon ico_fbdt = new ImageIcon(Login.class.getResource("fbdt.png")) ;//����ͼ��
		ico_fbdt.setImage(ico_fbdt.getImage().getScaledInstance(ico_fbdt.getIconWidth(),
																  ico_fbdt.getIconHeight(), 
																  Image.SCALE_DEFAULT));
		
		JButton button_ckft = new JButton("\u67E5\u770B\u52A8\u6001");
		
		button_ckft.setFocusPainted(false);
		button_ckft.setIcon(new ImageIcon(PrdFrame.class.getResource("/Power/ckdt.png")));
		button_ckft.setFont(new Font("��Բ", Font.PLAIN, 16));
		button_ckft.setFocusTraversalKeysEnabled(false);
		button_ckft.setDefaultCapable(false);
		button_ckft.setContentAreaFilled(false);
		button_ckft.setBorderPainted(false);
		button_ckft.setBackground(SystemColor.info);
		button_ckft.setBounds(47, 307, 222, 119);
		PrdFrame.getContentPane().add(button_ckft);
		
		JButton button_fbdt = new JButton("\u53D1\u5E03\u52A8\u6001");
		
		button_fbdt.setFocusPainted(false);
		button_fbdt.setIcon(new ImageIcon(PrdFrame.class.getResource("/Power/fbdt.png")));
		button_fbdt.setActionCommand("\u53D1\u5E03\u52A8\u6001");
		button_fbdt.setFont(new Font("��Բ", Font.PLAIN, 16));
		button_fbdt.setFocusTraversalKeysEnabled(false);
		button_fbdt.setDefaultCapable(false);
		button_fbdt.setContentAreaFilled(false);
		button_fbdt.setBorderPainted(false);
		button_fbdt.setBackground(SystemColor.info);
		button_fbdt.setBounds(47, 93, 222, 119);
		PrdFrame.getContentPane().add(button_fbdt);
		
		JLabel label_NowUser = new JLabel("\u5F53\u524D\u64CD\u4F5C\u7528\u6237\uFF1Acsnb");
		label_NowUser.setForeground(Color.GRAY);
		label_NowUser.setFont(new Font("����", Font.PLAIN, 12));
		label_NowUser.setBounds(782, 10, 111, 15);
		PrdFrame.getContentPane().add(label_NowUser);
		
		JPanel panel_fbdt = new JPanel();
		panel_fbdt.setBounds(275, 35, 618, 410);
		PrdFrame.getContentPane().add(panel_fbdt);
		panel_fbdt.setLayout(null);
		
		JButton button = new JButton("\u786E\u8BA4\u53D1\u5E03");
		
		button.setFont(new Font("����", Font.PLAIN, 16));
		button.setBounds(440, 344, 168, 44);
		panel_fbdt.add(button);
		
		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u52A8\u6001\u5185\u5BB9\uFF1A");
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("��Բ", Font.PLAIN, 16));
		label_4.setBounds(0, 61, 128, 15);
		panel_fbdt.add(label_4);
		
		textField = new JTextField();
		textField.setAlignmentY(Component.TOP_ALIGNMENT);
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField.setMargin(new Insets(10, 10, 2, 2));
		textField.setFont(new Font("����", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(0, 79, 618, 202);
		panel_fbdt.add(textField);
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		
		String xtsh=df.format(new Date()).toString();
//		System.out.println(xtsh.substring(8,11));
		JLabel label_5 = new JLabel("\u7CFB\u7EDF\u65E5\u671F\uFF1A "+xtsh);
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("��Բ", Font.PLAIN, 16));
		label_5.setBounds(363, 290, 255, 24);
		panel_fbdt.add(label_5);
		
		JButton btnpower = new JButton("\u6309\u6700\u65B0\u65F6\u95F4\u5F00\u59CB\u770B");
		btnpower.setBounds(440, 344, 168, 44);
		panel_fbdt.add(btnpower);
		btnpower.setFont(new Font("����", Font.PLAIN, 16));
		
		JPanel panel_ckdt = new JPanel();
		panel_ckdt.setLayout(null);
		panel_ckdt.setBounds(275, 35, 618, 410);
		PrdFrame.getContentPane().add(panel_ckdt);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(0, 44, 618, 276);
		panel_ckdt.add(textAreaResult);
		
		JScrollPane scrollPaneReturn = new JScrollPane(textAreaResult);
		scrollPaneReturn.setBounds(0, 44, 618, 276);
		panel_ckdt.add(scrollPaneReturn);
		
		JLabel lblPower = new JLabel("Power\u5708\u52A8\u6001\uFF1A");
		lblPower.setForeground(Color.DARK_GRAY);
		lblPower.setFont(new Font("��Բ", Font.PLAIN, 16));
		lblPower.setBounds(0, 25, 151, 15);
		panel_ckdt.add(lblPower);
		
		JButton button_Return = new JButton("\u8FD4 \u56DE");
		button_Return.setIcon(new ImageIcon(PrdFrame.class.getResource("/Power/return.png")));
		button_Return.setForeground(Color.GRAY);
		button_Return.setFont(new Font("����", Font.PLAIN, 22));
		button_Return.setContentAreaFilled(false);
		button_Return.setBorderPainted(false);
		button_Return.setBounds(724, 455, 169, 56);
		PrdFrame.getContentPane().add(button_Return);
		
		//������ҳ��
		button_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrdFrame.dispose();
				MainPanel = new Home();
				try {
					MainPanel.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		//panel�л�
		button_ckft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_fbdt.setVisible(false);
				panel_ckdt.setVisible(true);
				textAreaResult.setText("");
				//select * From prend Order by ptime desc
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					sqlStr="select * From prend Order by ptime desc";
					st=conn.createStatement();
					rs=st.executeQuery(sqlStr);
					String result = "";
					while(rs.next()) {
						result = "��̬��ţ�"+rs.getString("pno")+"\t��̬�����ߣ�"+rs.getString("uno")+"\n��̬����ʱ�䣺"
										+rs.getString("ptime")+"\n��̬���ݣ�"+rs.getString("ptext")
										+"\n-------------------------------------------------------------------";
						textAreaResult.setText(textAreaResult.getText()+result+"\n");						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��"+e1.getMessage());
				}
			}
		});
		
		//panel�л�
		button_fbdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_fbdt.setVisible(true);
				panel_ckdt.setVisible(false);
			}
		});
		
		//������̬��ť
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dtStr = textField.getText();
				String pno = "p1"+xtsh.substring(8,11);
//				System.out.println(pno);
//				insert into prend values('p020','u017','2020-05-07','ΪʲôҪ��ѧУ�ˣ���������');
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn=DriverManager.getConnection(dbURL,userName,userPwd);
					
					sqlStr="insert into prend values('"+pno+"','u017','"+xtsh+"','"+dtStr+"')";
					st=conn.createStatement();
					st.execute(sqlStr);
					JOptionPane.showMessageDialog(null, "������̬�ɹ���","������̬�ɹ�~",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��"+e1.getMessage());
				}
			}
		});
		
		panel_fbdt.setVisible(true);
		panel_ckdt.setVisible(false);
		
	}
}
