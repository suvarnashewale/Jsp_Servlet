package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student_Controller
 */
@WebServlet("/Student_Controller")
public class Student_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("Add")) {
            try {
				Add(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (action.equals("List")) {
            try {
				List(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

	private void Add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
	
		 String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String course = request.getParameter("course");
        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/Min_Project_Jsp";
		String user="root";
		String password="suvarna_2101@";
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,password);
		String query = "INSERT INTO minpro0(id, name, age, course) VALUES (?,?,?,?)";
		
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
       
        
			preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, course);

            preparedStatement.executeUpdate();
        }
  

    response.sendRedirect("Info.html");
}


private void List (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException { 		 
     
response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    Connection conn=null;
    String url="jdbc:mysql://localhost:3306/ Min_Project_Jsp";
	String user="root";
	String password="suvarna_2101@";
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url,user,password);
        String query = "select * FROM minpro0";
        
    
        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            out.println("<html><body><table border=\"1\">");
            out.println("<tr> <th>id</th> <th>name</th><th>age</th><th>course</th></tr>");
            while (resultSet.next()) {
                // out.println("<tr><td>" + resultSet.getInt("book_id") + "</td>");
            	
            	 out.println("<td>" + resultSet.getString("id") + "</td>");
                 out.println("<td>" + resultSet.getString("name") + "</td>");
                 out.println("<td>" + resultSet.getString("age") + "</td>");
                 out.println("<td>" + resultSet.getString("course") + "</td></tr>");
            
             }
         
	 
	 
                 
                 
             out.println("</table></body></html>");
         }
}
}
            