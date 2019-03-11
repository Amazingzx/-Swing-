package com.Mysql;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sel.GUI.Login;
import com.sel.GUI.Order_print;
import com.sel.GUI.Rigest;
import com.sel.GUI.outTickets;
import com.sel.GUI.sel_ticket;

public class Conn {
	
	public static String uname;
	public static String upsd;
	public static Map<String, String> name_psd;
	public static Statement st ;
	public static ResultSet rs ;
	public static Connection conn;
	public static int i;
	public static String out_title;
	public static String msg_sear;
	public static String Message_flight;
	public static String fid;
	public static String uno;
	public static String uid;
	public static String outOrderMsg;
	public static String outmsg;
	public static String AreaMsg;
	
	
	public static void main(String[] args) throws Exception {
		conn_sql();
	    writeMap();
		login_start();
	}


	/**
	 * 调用登录界面
	 * */
	public static void login_start() {
		Login.login  = new Login();
		Login.login.setVisible(true);
	}
	
	
	/**
	 * 连接数据库
	 * */
	public static  Connection conn_sql() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
//		System.out.println("sucess! loading!");
		String url = "jdbc:mysql://localhost:3306/fly_tickets";
		String user = "root";
		String psd = "root";
		conn = (Connection) DriverManager.getConnection(url,user,psd);
//		System.out.println("sucess connect!");
		return conn;
	}

	
	/**
	 * 将数据库user写入map
	 * */
	public static void writeMap() throws SQLException {
		select_method("select * from user");
		name_psd = new HashMap();
		while(rs.next()) {
			uname = rs.getString("uname");
			upsd =  rs.getString("psd");
			uid = rs.getString("uid");
			name_psd.put(uname,upsd);
//			System.out.println(uid+uname);
		}
	}


	/**
	 * 返回完整的向数据库中添加信息的SQL语句
	 * */
	public static String  SQL() throws Exception {
		DataInputStream dis = new DataInputStream(new FileInputStream("uid.txt"));
	    i = dis.readInt();
		dis.close();
//	    System.out.println(i);
		String uid1 = "a00";
		String rihst_uid = uid1 + i;
//		System.out.println(uid);
		String SQL = "insert into user(uid,uname,psd,sex,age,adress) values (\'" + 
				rihst_uid + "\'," + "\'" + Rigest.Rig_name + "\'," + "\'" + Rigest.Rig_pwd + "\'," + 
				"\'" + Rigest.Rig_sex + "\'," +Rigest.Rig_age +","+"\'" + Rigest.Rig_addr + "\')"+";";
		//将增加后的i写入uid.txt
		DataOutputStream dps = new DataOutputStream(new FileOutputStream("uid.txt"));
		i+=1;
		dps.writeInt(i);
		dps.close();
//	    System.out.println("i="+i);
//		System.out.println(SQL);
		return SQL;
	}
	

	/**
	 * 执行SQL,插入用户注册信息
	 * @throws Exception 
	 * */
	public static void writeData(String SQL) throws Exception {
//		System.out.println(SQL);
		PreparedStatement ps = null;
		ps = (PreparedStatement) conn.prepareStatement(SQL);
		ps.executeUpdate();
//		System.out.println("sucess write!");
	}
	
	/**
	 * 预定机票实现
	 * */
	public static void order() throws Exception {
		String sql1 = "SELECT uid FROM `user` WHERE uname = \'"+Login.name+"\';";
		select_method(sql1);
		uno = null;
		while(rs.next()) {
			uno = rs.getString("uid");
		}
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderdate = sdf.format(d);
//		System.out.println(orderdate);
		
//		System.out.println(uno);
//		System.out.println(fid);
		String order_sql = null;
		order_sql = "INSERT INTO orders VALUES(NULL,\'"+orderdate+"\',\'"+uno+"\',\'"+fid+"\');";
//		System.out.println(order_sql);
		writeData(order_sql);
		outTickets.outticket.dispose();
//		System.out.println("Order sucess!");
	}
	
	/**
	 * SQL查询
	 * */
	public static void select_method(String sel_sql) throws SQLException {
		st = (Statement) conn.createStatement();
		rs = st.executeQuery(sel_sql);
	}
	
	
	/**
	 * 航班查询功能实现
	 * @throws Exception 
	 * */
	public static void Search() throws Exception {
		String flight_sql = "SELECT * FROM flight WHERE fbegin = \'" + 
				sel_ticket.beginCityText + "\' AND fEnd = \'" + sel_ticket.endCityText  + "\';" ;
//		System.out.println(flight_sql);
		select_method(flight_sql);
		while(rs.next()) {
			fid = rs.getString("fid");
			String fBegin = rs.getString("fBegin");
			String sEnd = rs.getString("fEnd");
			String sTime = rs.getString("sTime");
			String eTime = rs.getString("eTime");
			String price = rs.getString("price");
			out_title = "--航班号--"+"起点站----"+"终点站"+"---价格--------"+"起飞时间------------------"+"到达时间---------";
			msg_sear = "-- "+fid+"      "+fBegin+"    "+sEnd+"   "+
					price+"   "+sTime+"~~~"+eTime;
			Message_flight = out_title + "\n\n" + msg_sear;
			outTickets.outticket = new outTickets();
			outTickets.outticket.setVisible(true);
//			System.out.println(out_title);
//			System.out.println(msg_sear);
			}
			}

	/**
	 * 查询订单信息实现
	 * @throws Exception 
	 * */
	public static void search_userOrder() throws Exception {

		//		select_method(sql);
		String sql = "SELECT o.oid,u.uname,f.fid,f.fBegin,f.fEnd,f.price,"
				+ "f.sTime,f.eTime,o.oTime FROM `user` AS u LEFT JOIN orders AS o ON "
				+ " u.uid = o.uno LEFT JOIN flight AS f ON  f.fid = o.fno WHERE uname = \'"+Login.name+"';";
		select_method(sql);
		outOrderMsg =  "-订单号--"+"姓名--"+"航班号"+"---起点---"+"终点--"+"价格--------"
				+"起飞时间------------------"+"到达时间-------------------"+"下单时间" + "---";
		
		while(rs.next()) {
			String oid = rs.getString("oid");
			String name = rs.getString("uname");
			String fid = rs.getString("fid");
			String begCity = rs.getString("fBegin");
			String endCity = rs.getString("fEnd");
			String price = rs.getString("price");
			String stime = rs.getString("sTime");
			String etime = rs.getString("eTime");
			String oTime = rs.getString("oTime");
			outmsg = "   "+oid+"     " + name +"    "+ fid+"    " + begCity+"   " + endCity+"   " + price+"   " + 
			stime+"    " + etime+"    " + oTime;
		}
			AreaMsg = outOrderMsg + "\n" + outmsg;
		
		Order_print.orderPrint = new Order_print();
		Order_print.orderPrint.setVisible(true);
//		System.out.println("chauxn chenggong");
		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
