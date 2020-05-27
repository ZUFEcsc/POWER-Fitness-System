package Power;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class Home extends JFrame {
	static Home frame;
	Login LoginFrame;
	JPanel MainPanel;
	SportFrame Sport;
	Food Food;
	PrdFrame Prd;
	ShopFrame Shop;
	VipFrame Vip;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Home();
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
	public Home() {		
		setTitle("POWER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 560);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		
		JLabel label_3 = new JLabel("POWER");
		label_3.setBounds(0, 0, 100, 50);
		label_3.setFont(new Font("French Script MT", Font.PLAIN, 20));
		MainPanel.add(label_3);
		ImageIcon img1 = new ImageIcon(Login.class.getResource("1.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img1.setImage(img1.getImage().getScaledInstance(img1.getIconWidth(),
				                    		 		   	img1.getIconHeight(), 
				                    		 		   	Image.SCALE_DEFAULT)); 
		ImageIcon img2 = new ImageIcon(Login.class.getResource("2.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img2.setImage(img2.getImage().getScaledInstance(img2.getIconWidth(),
														img2.getIconHeight(), 
														Image.SCALE_DEFAULT)); 
		ImageIcon img3 = new ImageIcon(Login.class.getResource("3.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img3.setImage(img3.getImage().getScaledInstance(img3.getIconWidth(),
														img3.getIconHeight(), 
														Image.SCALE_DEFAULT)); 
		
		JButton btn_sport = new JButton("");
		btn_sport.setBounds(76, 47, 180, 180);
		
		btn_sport.setIcon(img1);
		btn_sport.setContentAreaFilled(false);//对JButton透明的设置
		btn_sport.setBorderPainted(false);
		MainPanel.add(btn_sport);
		
		JButton btn_food = new JButton("");
		
		btn_food.setBounds(349, 47, 180, 180);
		btn_food.setIcon(img2);
		btn_food.setContentAreaFilled(false);
		btn_food.setBorderPainted(false);
		MainPanel.add(btn_food);
		
		JButton btn_vip = new JButton("");
		
		btn_vip.setBounds(622, 47, 180, 180);
		btn_vip.setIcon(img3);
		btn_vip.setContentAreaFilled(false);
		btn_vip.setBorderPainted(false);
		MainPanel.add(btn_vip);
		
		JLabel lbl_sport = new JLabel("\u4F53\u80B2\u8BAD\u7EC3\u7BA1\u7406");
		lbl_sport.setBounds(104, 235, 144, 29);
		lbl_sport.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(lbl_sport);
		
		JLabel lbl_foot = new JLabel("\u5065\u5EB7\u996E\u98DF\u7BA1\u7406");
		lbl_foot.setBounds(374, 235, 138, 29);
		lbl_foot.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(lbl_foot);
		ImageIcon img4 = new ImageIcon(Login.class.getResource("4.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img4.setImage(img4.getImage().getScaledInstance(img4.getIconWidth(),
														img4.getIconHeight(), 
														Image.SCALE_DEFAULT)); 
		ImageIcon img5 = new ImageIcon(Login.class.getResource("5.png")) ;//背景图案
		//icon=ImageScale.getImage(icon, lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight());
		img5.setImage(img5.getImage().getScaledInstance(img5.getIconWidth(),
														img5.getIconHeight(), 
														Image.SCALE_DEFAULT)); 
		
		JLabel lbl_vip = new JLabel("VIP\u5145\u503C/\u7EED\u8D39\u7BA1\u7406");
		lbl_vip.setBounds(632, 235, 166, 29);
		lbl_vip.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(lbl_vip);
		
		JButton btn_prd = new JButton("");
		
		btn_prd.setBounds(211, 285, 180, 180);
		btn_prd.setIcon(img4);
		btn_prd.setContentAreaFilled(false);
		btn_prd.setBorderPainted(false);
		MainPanel.add(btn_prd);
		
		JButton btn_buy = new JButton("");
		
		btn_buy.setBounds(496, 285, 180, 180);
		btn_buy.setIcon(img5);
		btn_buy.setContentAreaFilled(false);
		btn_buy.setBorderPainted(false);
		MainPanel.add(btn_buy);
		
		JLabel lbl_prd = new JLabel("\u52A8\u6001\u7BA1\u7406");
		lbl_prd.setBounds(246, 475, 100, 19);
		lbl_prd.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(lbl_prd);
		
		JLabel lbl_buy = new JLabel("\u5546\u57CE\u7BA1\u7406");
		lbl_buy.setBounds(551, 475, 94, 19);
		lbl_buy.setFont(new Font("宋体", Font.PLAIN, 20));
		MainPanel.add(lbl_buy);
		
		JButton button_Unload = new JButton("退出登录");
		button_Unload.setIcon(new ImageIcon(Home.class.getResource("/Power/exitProject.png")));
		button_Unload.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		button_Unload.setContentAreaFilled(false);
		button_Unload.setBorderPainted(false);
		button_Unload.setMargin(new Insets(0, 0, 0, 0));
		button_Unload.setForeground(Color.GRAY);
		button_Unload.setFont(new Font("黑体", Font.PLAIN, 22));
		button_Unload.setBounds(726, 444, 166, 50);
		MainPanel.add(button_Unload);
		
		//运动管理界面
		btn_sport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sport = new SportFrame();
				dispose();
				try {
					Sport.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		//饮食管理界面
		btn_food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Food = new Food();
				try {
					Food.FoodFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//VIP管理页面
		btn_vip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vip = new VipFrame();
				dispose();
				try {
					Vip.VipFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//动态管理界面
		btn_prd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Prd = new PrdFrame();
				try {
					Prd.PrdFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//商城管理页面
		btn_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Shop = new ShopFrame();
				try {
					Shop.ShopFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//退出登录
		button_Unload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login LoginFrame = new Login();
//				mainLayout ml=new mainLayout();//为跳转的界面
//				contentPane.setVisible(false);//销毁当前界面
				dispose();
//				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				try {
					LoginFrame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

}
