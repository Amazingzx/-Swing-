package com.sel.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import com.Mysql.Conn;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class outTickets extends JFrame {

	private JPanel contentPane;
	public static JTextArea outArea ;
	public static outTickets outticket;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					outTickets frame = new outTickets();
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
	public outTickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel outPanel = new JPanel();
		outPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		outPanel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(outPanel, BorderLayout.CENTER);
		outPanel.setLayout(null);
		
		JTextArea outArea = new JTextArea(Conn.Message_flight);
		outArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		outArea.setBackground(SystemColor.activeCaption);
		outArea.setBounds(10, 78, 961, 436);
		outPanel.add(outArea);
		
		JButton orderButton = new JButton("预定");
		orderButton.addMouseListener(new MouseAdapter() {
			/**
			 * 实现预定功能将当前用户id 与 航班 id 写入 order表
			 * */
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					Conn.order();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		orderButton.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 22));
		orderButton.setBounds(197, 537, 104, 35);
		outPanel.add(orderButton);
		
		JButton backButton = new JButton("返回");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 关闭显示界面,返回查询界面
			 * */
			public void mouseReleased(MouseEvent e) {
				outticket.dispose();
			}
		});
		backButton.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 22));
		backButton.setBounds(604, 539, 104, 31);
		outPanel.add(backButton);
		
		JLabel outtitle = new JLabel("                             你所查询的航班如下");
		outtitle.setToolTipText("");
		outtitle.setBackground(SystemColor.inactiveCaption);
		outtitle.setFont(new Font("SimSun", Font.BOLD, 25));
		outtitle.setBounds(10, 20, 700, 35);
		outPanel.add(outtitle);
	}
}
