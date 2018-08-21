package com.jda.advancecCore;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class boom {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=(Connection) DriverManager.getConnection(  
				"jdbc:mysql://10.0.0.160/db1000228?user=u1000228&password=fh6cwAoYt2");  
			//here sonoo is database name, root is username and password  
			java.sql.Statement stmt=con.createStatement();  
			/* ResultSet rs=stmt.executeQuery("select * from emp");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			*/
			System.out.println(con);
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		// TODO Auto-generated method stub

	}

}
