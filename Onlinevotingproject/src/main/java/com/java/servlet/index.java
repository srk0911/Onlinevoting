package com.java.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
String email,pass;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		email=request.getParameter("t1");
		pass=request.getParameter("t2");
		if(validate.checkuser(email, pass)) {
			response.sendRedirect("main.html");
		}
		else {
			PrintWriter out=response.getWriter();
			out.print("User name or password wrong");
		}
	}
public class validate{
	public static boolean checkuser(String voterid,String password)
	{
		boolean st=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voteforonline","root","4455");
			PreparedStatement ps=con.prepareStatement("select * from sign_in where voterid=? and password=?");
			ps.setString(1, voterid);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			st=rs.next();
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return st;
	}
}
}
