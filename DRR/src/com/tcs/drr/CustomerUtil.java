package com.tcs.drr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;

public class CustomerUtil 
{
	
DataSource datasource;

public CustomerUtil(DataSource datasource) 
{
	this.datasource = datasource;
}

public void insert(Customer customer)
{
	
	Connection conn=null;	
	PreparedStatement stmt=null;
	
//connect to database
	try
	{
		conn=datasource.getConnection();
		String sql="INSERT into customer "+
					"(first_name, last_name, gender, address, phn, email, aadhar_card, pan_card, income) "+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		stmt=conn.prepareStatement(sql);
		stmt.setString(1,customer.getFirst_name());
		stmt.setString(2,customer.getLast_name());
		stmt.setString(3,customer.getGender());
		stmt.setString(4,customer.getAddress());
		stmt.setString(5,customer.getPhn());
		stmt.setString(6,customer.getEmail());
		stmt.setString(7,customer.getAadhar_card());
		stmt.setString(8,customer.getPan_card());
		stmt.setString(9,customer.getIncome());
			
		//insert to database
		stmt.execute();
	}
	catch(Exception e)
	{
		
	}
}
}
