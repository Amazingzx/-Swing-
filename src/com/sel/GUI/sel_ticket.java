package com.sel.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import com.Mysql.Conn;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class sel_ticket extends JFrame {

	private JPanel contentPane;
	private JTextField arriveTextField;
	private JTextField endTextField;
	public static String beginCityText;
	public static String endCityText;


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					sel_ticket frame = new sel_ticket();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public sel_ticket() {
		setTitle("航班查询系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel1, BorderLayout.CENTER);
		panel1.setLayout(null);
		
		JLabel arriveCity = new JLabel("出发城市");
		arriveCity.setBounds(153, 147, 190, 60);
		arriveCity.setFont(new Font("KaiTi", Font.BOLD, 34));
		arriveCity.setBackground(SystemColor.menu);
		panel1.add(arriveCity);
		
		JLabel endCity = new JLabel("到达城市");
		endCity.setBounds(153, 252, 141, 48);
		endCity.setForeground(SystemColor.desktop);
		endCity.setFont(new Font("KaiTi", Font.BOLD, 34));
		endCity.setBackground(SystemColor.activeCaptionText);
		panel1.add(endCity);
		
		arriveTextField = new JTextField();
		arriveTextField.setBackground(SystemColor.inactiveCaptionBorder);
		arriveTextField.setFont(new Font("KaiTi", Font.BOLD, 25));
		arriveTextField.setBounds(406, 157, 300, 48);
		panel1.add(arriveTextField);
		arriveTextField.setColumns(10);
		
		endTextField = new JTextField();
		endTextField.setFont(new Font("KaiTi", Font.BOLD, 25));
		endTextField.setBackground(SystemColor.inactiveCaptionBorder);
		endTextField.setBounds(406, 252, 300, 46);
		panel1.add(endTextField);
		endTextField.setColumns(10);
		
		JButton searchButton = new JButton("查询");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 查询航班功能实现
			 * */
			public void mouseReleased(MouseEvent e) {
				beginCityText = arriveTextField.getText().toString();
				endCityText = endTextField.getText().toString();
				try {
					Conn.Search();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
//				System.out.println(arriveText+endText+dateText);
				
			}
		});
		searchButton.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 20));
		searchButton.setBackground(SystemColor.activeCaptionBorder);
		searchButton.setBounds(213, 362, 121, 48);
		panel1.add(searchButton);
		
		JButton orderButton = new JButton("购票信息");
		orderButton.addMouseListener(new MouseAdapter() {
			/**
			 * 查询用户购票信息
			 * */
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					Conn.search_userOrder();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		orderButton.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 20));
		orderButton.setBackground(SystemColor.controlShadow);
		orderButton.setBounds(458, 362, 125, 48);
		panel1.add(orderButton);
		
		//title
		JLabel title = new JLabel("航班查询 V1.0");
		title.setFont(new Font("楷体", Font.BOLD, 25));
		title.setBackground(SystemColor.activeCaption);
		title.setBounds(324, 34, 228, 36);
		panel1.add(title);
	}
}
