package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class voteonline1
 */
@WebServlet("/voteonline1")
public class voteonline1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	public voteonline1(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/voteforonline";
			String userName = "root";
			String password = "4455";

			con = DriverManager.getConnection(url, userName, password);
			System.out.println("connection successfully;" + con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	 public static void main(String[] args) {
		 new voteonline1();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String voterid=req.getParameter("voterid");
		String dob=req.getParameter("dob");
		String mobile=req.getParameter("mobile");
		String Aadharnum=req.getParameter("Aadharnum");
		String address=req.getParameter("address");
		String pass=req.getParameter("password");
		String retypepass=req.getParameter("Retypepassword");
		try {
			PreparedStatement	ps=con.prepareStatement("insert into sign_in values(?,?,?,?,?,?,?,?,?,?)");
		    ps.setString(1, fname);
		    ps.setString(2, lname);
		    ps.setString(3, email);
		    ps.setString(4, voterid);
		    ps.setString(5, dob);
		    ps.setString(6, mobile);
		    ps.setString(7, Aadharnum);
		    ps.setString(8, address);
		    ps.setString(9, pass);
		    ps.setString(10, retypepass);
			int i=ps.executeUpdate();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	
	
}
