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
 * Servlet implementation class Adminonline4
 */
@WebServlet("/Adminonline4")
public class Adminonline4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;
    public Adminonline4(){
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/admin";
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
		new Adminonline4();
	}
   
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		try {
			PreparedStatement	ps=con.prepareStatement("insert into adminregister values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,req.getParameter("fname"));
			ps.setString(2,req.getParameter("lname"));
			ps.setString(3,req.getParameter("email"));
			ps.setString(4,req.getParameter("dob"));
			ps.setString(5,req.getParameter("mobile"));
			ps.setString(6,req.getParameter("Aadharnum"));
			ps.setString(7,req.getParameter("address"));
			ps.setString(8,req.getParameter("password"));
			ps.setString(9,req.getParameter("Retypepassword"));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
