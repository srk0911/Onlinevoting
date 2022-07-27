package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class voteonlin3
 */
@WebServlet("/voteonlin3")
public class voteonlin3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	public voteonlin3(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/voteforonline";
		String userName = "root";
		String password = "4455";

		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection successfully;" + con);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String Aadharnum=req.getParameter("Aadharnum");
		String uname=req.getParameter("uname");
		String selectyourstate=req.getParameter("selectyourstate"); 
		String selectyourdistrict=req.getParameter("selectyourdistrict");
		String voteridnum=req.getParameter("voteridnum");
		String selectyourparty=req.getParameter("selectyourparty");
	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into vote values(?,?,?,?,?,?)");
			ps.setString(1, Aadharnum);
			ps.setString(2, uname);
			ps.setString(3, selectyourstate);
			ps.setString(4, selectyourdistrict);
			ps.setString(5, voteridnum);
			ps.setString(6,selectyourparty);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static void main(String[] args) {
		new voteonlin3();
	}

}
