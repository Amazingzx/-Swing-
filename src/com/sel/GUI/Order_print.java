package com.sel.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import com.Mysql.Conn;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Order_print extends JFrame {

	private JPanel contentPane;
	public static  Order_print orderPrint;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Order_print frame = new Order_print();
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
	public Order_print() {
		setTitle("航班查询系统v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea(Conn.AreaMsg);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setBackground(SystemColor.activeCaption);
		textArea.setBounds(10, 65, 965, 385);
		panel.add(textArea);
		
		JLabel label = new JLabel("订单信息如下");
		label.setFont(new Font("SimSun", Font.BOLD, 25));
		label.setBounds(413, 26, 220, 29);
		panel.add(label);
		
		JButton button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			/**
			 * 返回查询界面
			 * */
			@Override
			public void mouseReleased(MouseEvent e) {
				orderPrint.dispose();
			}
		});
		button.setBackground(SystemColor.activeCaption);
		button.setFont(new Font("SimSun", Font.BOLD, 25));
		button.setBounds(428, 473, 97, 35);
		panel.add(button);
	}
}
