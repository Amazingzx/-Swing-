package com.sel.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Mysql.Conn;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

//��¼����
//****************************************************************
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField psdTextField;
	public static String name;
	public static String psd;
	public static Login login;
	public static Rigest rigest;


	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("��Ʊ��ѯԤ��ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(SystemColor.activeCaption);
		loginPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(null);
		
		JLabel user_loginLabel = new JLabel("����");
		user_loginLabel.setFont(new Font("SimSun", Font.BOLD, 30));
		user_loginLabel.setBounds(164, 86, 66, 68);
		loginPanel.add(user_loginLabel);
		
		JLabel psd_loginLabel = new JLabel("����");
		psd_loginLabel.setFont(new Font("SimSun", Font.BOLD, 30));
		psd_loginLabel.setBounds(164, 188, 66, 58);
		loginPanel.add(psd_loginLabel);
		
		userTextField = new JTextField();
		userTextField.setFont(new Font("SimSun", Font.BOLD, 20));
		userTextField.setBounds(342, 106, 246, 34);
		loginPanel.add(userTextField);
		userTextField.setColumns(10);
		
		psdTextField = new JTextField();
		psdTextField.setFont(new Font("SimSun", Font.BOLD, 20));
		psdTextField.setBounds(342, 203, 246, 34);
		loginPanel.add(psdTextField);
		psdTextField.setColumns(10);
		
		JButton loginButton = new JButton("��¼");
		/**
		 * 
		 * ��¼�¼�,��֤�û�������ȷ����ò�ѯ����,or����ע�����
		 */
		loginButton.addMouseListener(new MouseAdapter() {
			
			@Override
			//��¼�����ò�ѯ(sel_ticket)����
			public void  mouseReleased(MouseEvent e) {
			     name = userTextField.getText().toString();
				 psd = psdTextField.getText().toString();
//				 System.out.println(name+psd);
				 for (String key : Conn.name_psd.keySet()) {
					 if(key.equals(name)) {
						 if(Conn.name_psd.get(key).equals(psd)) {
//							 System.out.println("sucess login");
							 
//							 ��½�ɹ���ת����ѯ���ڲ��ر�login
							 select_tickets();
							 login.dispose();
						 }
					 }
				}
			}
			
			//ʵ����ѯ���淽��
			private void select_tickets() {
				sel_ticket seltic = new sel_ticket();
				seltic.setVisible(true);
			}
		});
		
		loginButton.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 30));
		loginButton.setBounds(165, 326, 126, 49);
		loginPanel.add(loginButton);
		
		JButton rigest_logbutton = new JButton("ע��");
		/**
		 * ���ע�����ע����沢�ر�login
		 */
		rigest_logbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				rigest = new Rigest();
				rigest.setVisible(true);
				login.dispose();
				
			}
		});
		rigest_logbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rigest_logbutton.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 30));
		rigest_logbutton.setBounds(443, 326, 126, 49);
		loginPanel.add(rigest_logbutton);
		
		JLabel logLabel = new JLabel("�����ѯϵͳ");
		logLabel.setFont(new Font("SimSun", Font.BOLD, 20));
		logLabel.setBounds(314, 21, 297, 26);
		loginPanel.add(logLabel);
		
		
	}
	
	
	
}
