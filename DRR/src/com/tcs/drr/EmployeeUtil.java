package com.tcs.drr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class EmployeeUtil 
{
	DataSource datasource;

	public EmployeeUtil(DataSource datasource) 
	{
		this.datasource = datasource;
	}

public boolean login(Employee employee)
{
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
//connect to database
	try
	{
		conn=datasource.getConnection();
		stmt=conn.createStatement();
		
		String sql=   "select * from employee where employee_name='"+employee.getEmployee_name()+"' AND employee_password='"+employee.getEmployee_password()+"'";
		rs=stmt.executeQuery(sql);
	    boolean more=rs.next();
	    
	    if(!more)
	    {
	    	return false;
	    }
	    else
	    {
	    	return true;
	    }
	}
	catch(Exception e)
	{
		System.out.println("Log In failed: An Exception has occurred! " + e);
	}
	
	//some exception handling
    finally 
    {
       if (rs != null)	{
          try {
             rs.close();
          } catch (Exception e) {}
             rs = null;
          }
	
       if (stmt != null) {
          try {
             stmt.close();
          } catch (Exception e) {}
             stmt = null;
          }
	
       if (conn != null) {
          try {
             conn.close();
          } catch (Exception e) {
          }

          conn = null;
       }
    }
	return false;

}}