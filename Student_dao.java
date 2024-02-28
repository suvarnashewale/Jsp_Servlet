package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bin.Student_bo;

public class Student_dao {

	public static Connection getConnection()
	{
		Connection con=null;
		
		try
		{
			String url="jdbc:mysql://localhost:3306/Min_Project_Jsp";
			String user="root";
			String password="Suvarna_2101@";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		   con=DriverManager.getConnection(url,user,password);
			
		  
		} 
		catch (Exception e)
		{
			System.out.println(e);

		}
		return con;
	}
	
	public static int signup(Student_bo em)
	{
		int status=0;
		
		try 
		{
		  Connection con= Student_dao.getConnection();
		  String query="insert into MinPro(name,age,course)values(?,?,?)";
		   PreparedStatement ps= con.prepareStatement(query);
		    ps.setString(1, em.getName());
		    ps.setString(2, em.getAge());
		    ps.setString(3, em.getCourse());
		    
		        status=ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
}
