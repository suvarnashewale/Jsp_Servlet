<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 
 try {

		Class.forName("com.mysql.cj.jdbc.Driver");

		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Min_Project_Jsp","root", "suvarna_2101@");
		String sql = "insert into minpro0(id,name,age,course)values(?,?,?,?) ";
		
	      PreparedStatement ps = con.prepareStatement(sql);

		
	      String id = request.getParameter("id");
		  String name= request.getParameter("name");
          String age= request.getParameter("age");
          String course= request.getParameter("course");
          
          
          ps.setString(1,id);
          ps.setString(2,name);
          ps.setString(3,age);
          ps.setString(4,course);
          
          
          int status=ps.executeUpdate();
          if(status>0)
          {
        	  out.print("Data succesfully inserted");
          }
          else
          {
        	  out.print("Data not  succesfully inserted");
          }

		

		System.out.println("Your data has been inserted ");
		}
 		catch (Exception e) 
 		{
		e.printStackTrace();
	}
 
 %>
     
</body>
</html>
