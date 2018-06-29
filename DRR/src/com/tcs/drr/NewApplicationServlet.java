package com.tcs.drr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/NewApplicationServlet")
public class NewApplicationServlet extends HttpServlet 
{
	@Resource(name="jdbc/customer-tracker")
	DataSource datasource;
	CustomerUtil customerutil;
	//pass datasource to customerutil class 
	@Override
	public void init() throws ServletException 
	{
		try
		{
			customerutil=new CustomerUtil(datasource);
		}
		catch(Exception e)
		{
			throw new ServletException(e);
		}
	}
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
		//take user input
		
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String phn=request.getParameter("phn");
		String email=request.getParameter("email");
		String aadhar_card=request.getParameter("aadhar_card");
		String pan_card=request.getParameter("pan_card");
		String income=request.getParameter("income");
		out.println("income"+income);
		
		// store it in Customer class
		
		Customer customer=new Customer(first_name, last_name, gender, address, phn, email, aadhar_card, pan_card, income);
		out.println("222");
		
		//call insert method
		
		customerutil.insert(customer);	
		out.println("333");
	}
}
