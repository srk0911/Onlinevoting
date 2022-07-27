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
 * Servlet implementation class voteonline2
 */
@WebServlet("/voteonline2")
public class voteonline2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;
    
    public voteonline2(){
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/voteforonline";
			String userName = "root";
			String password = "4455";
			con = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		System.out.println("connection successfully;" + con);

		
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String uname=req.getParameter("uname");
		String selectyourstate=req.getParameter("selectyourstate");
		String selectyourdistrict=req.getParameter("selectyourdistrict");
		String voteridnum=req.getParameter("voteridnum");
		String Aadharnum=req.getParameter("Aadharnum");
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into vote values(?,?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, selectyourstate);
			ps.setString(3, selectyourdistrict);
			ps.setString(4, voteridnum);
			ps.setString(5, Aadharnum);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
