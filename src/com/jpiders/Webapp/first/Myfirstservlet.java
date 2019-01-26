package com.jpiders.Webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class Myfirstservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con=null;
		Statement stm=null;
		ResultSet rs=null;
	  
		try{
			com.mysql.jdbc.Driver REF=new Driver();
			DriverManager.registerDriver(REF);
			
			String dburl="jdbc:mysql://localhost:3306/bejm28?user=root&&password=root";
			con=DriverManager.getConnection(dburl);
			
			String query="select * from studentinfo";
			stm=con.createStatement();
			rs=stm.executeQuery(query);
			
			PrintWriter out=resp.getWriter();
			int regno=0;
			String FirstNames="",MiddleName="",LastName="";
			while(rs.next())
			{
			    regno=rs.getInt("id");
				 FirstNames=rs.getString("FirstName");
				 MiddleName=rs.getString("MiddleName");
				 LastName=rs.getString("LastName");
			
								
			out.println("Regno "+regno);
			out.println("FirstNames "+FirstNames);
			out.println("MiddleName "+MiddleName);
			out.println("LastName "+LastName);
			}
		
		}
		catch(Exception e){e.printStackTrace();}
	}

}
