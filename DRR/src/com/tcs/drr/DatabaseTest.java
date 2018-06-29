package com.tcs.drr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/DatabaseTest")
public class DatabaseTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/customer-tracker")
	private DataSource datasource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
			Connection conn=datasource.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from customer");
			 while(rs.next())
			 {
				 String name=rs.getString("first_name");
				 out.println("name="+name);
				 
			 }
			
		}
		catch(Exception e)
		{
			
		}
		
		
		

	}}
