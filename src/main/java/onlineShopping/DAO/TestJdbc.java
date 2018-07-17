package onlineShopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	
	public static void main(String []args){
		String jdbcUrl="jdbc:mysql://localhost:3306/onlineshopping?useSSL=false";
		String user="root";
		String pass="123456";
		
		try{
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("get connection successful");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
