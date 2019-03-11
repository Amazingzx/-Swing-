package com.sel.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Mysql.Conn;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.SystemColor;

public class Rigest extends JFrame {

	private JPanel contentPane;
	private JTextField rig_name_text;
	private JTextField rig_pwd_text;
	private JTextField rig_sex_text;
	private JTextField rig_age_text;
	private JTextField rig_addr_text;
	
	public static String Rig_name;
	public static String Rig_pwd;
	public static String Rig_sex;
	public static int Rig_age;
	public static String Rig_addr;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Rigest frame = new Rigest();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Rigest() {
		setTitle("航空预定系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel rigestPanel = new JPanel();
		rigestPanel.setBackground(SystemColor.activeCaption);
		contentPane.add(rigestPanel, BorderLayout.CENTER);
		rigestPanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("SimSun", Font.BOLD, 25));
		nameLabel.setBounds(186, 104, 68, 45);
		rigestPanel.add(nameLabel);
		
		JLabel psdLabel = new JLabel("密码");
		psdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		psdLabel.setFont(new Font("SimSun", Font.BOLD, 25));
		psdLabel.setBounds(171, 184, 68, 24);
		rigestPanel.add(psdLabel);
		
		JLabel sexLabel = new JLabel("性别");
		sexLabel.setFont(new Font("SimSun", Font.BOLD, 25));
		sexLabel.setBounds(186, 249, 58, 29);
		rigestPanel.add(sexLabel);
		
		JLabel ageLabel = new JLabel("年龄");
		ageLabel.setFont(new Font("SimSun", Font.BOLD, 25));
		ageLabel.setBounds(186, 333, 58, 29);
		rigestPanel.add(ageLabel);
		
		JLabel adressLabel = new JLabel("地址");
		adressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		adressLabel.setFont(new Font("SimSun", Font.BOLD, 25));
		adressLabel.setBounds(171, 413, 73, 29);
		rigestPanel.add(adressLabel);
		
		rig_name_text = new JTextField();
		rig_name_text.setFont(new Font("SimSun", Font.BOLD, 20));
		rig_name_text.setBounds(363, 99, 375, 37);
		rigestPanel.add(rig_name_text);
		rig_name_text.setColumns(10);
		
		rig_pwd_text = new JTextField();
		rig_pwd_text.setFont(new Font("SimSun", Font.BOLD, 20));
		rig_pwd_text.setBounds(363, 171, 375, 37);
		rigestPanel.add(rig_pwd_text);
		rig_pwd_text.setColumns(10);
		
		rig_sex_text = new JTextField();
		rig_sex_text.setFont(new Font("SimSun", Font.BOLD, 20));
		rig_sex_text.setBounds(363, 249, 375, 37);
		rigestPanel.add(rig_sex_text);
		rig_sex_text.setColumns(10);
		
		rig_age_text = new JTextField();
		rig_age_text.setFont(new Font("SimSun", Font.BOLD, 20));
		rig_age_text.setBounds(363, 333, 375, 37);
		rigestPanel.add(rig_age_text);
		rig_age_text.setColumns(10);
		
		rig_addr_text = new JTextField();
		rig_addr_text.setFont(new Font("SimSun", Font.BOLD, 20));
		rig_addr_text.setBounds(363, 413, 375, 37);
		rigestPanel.add(rig_addr_text);
		rig_addr_text.setColumns(10);
		
		JButton rigestButton = new JButton("注册");
		
		/**
		 * 获取注册信息并写入数据库
		 * */
		rigestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				getItem();
				String sql = null;
				try {
					sql = Conn.SQL();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
				try {
					Conn.writeData(sql);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				//将更新的用户信息存储到Map中并唤醒登录界面
				try {
					Conn.writeMap();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				Conn.login_start();
				Login.rigest.dispose();
			}
            
			/**
			 * 获取用户填入的信息
			 * */
			public void getItem() {
				 Rig_name = rig_name_text.getText().toString();
				 Rig_pwd = rig_pwd_text.getText().toString();
				 Rig_sex = rig_sex_text.getText().toString();
				 Rig_age =Integer.parseInt(rig_age_text.getText().toString());
				 Rig_addr = rig_addr_text.getText().toString();
//				System.out.println(Rig_name+Rig_pwd+Rig_sex+Rig_age+Rig_addr);
			}

		});
		rigestButton.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 30));
		rigestButton.setBounds(374, 477, 146, 45);
		rigestPanel.add(rigestButton);
		
		JLabel label = new JLabel("用户信息注册");
		label.setFont(new Font("FangSong", Font.BOLD, 35));
		label.setBounds(317, 10, 291, 55);
		rigestPanel.add(label);
	}
}
