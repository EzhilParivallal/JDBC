package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String db_url = "jdbc:mysql://localhost:3306";
		String user="root";
		String password="root";
		try {
			Connection connection = DriverManager.getConnection(db_url,user,password);
			if(connection!=null) {
				System.out.println("Connection is successful");
			}
			else {
				System.out.println("Connection is unsucessful");
			}
			String createDB=" CREATE DATABASE JDBC_DEMO";
			String use="USE JDBC_DEMO";
			String createTable=" CREATE TABLE EMPL (empcode int, empname varchar(15),empage int, esalary int)";
			String insert="INSERT INTO EMPL VALUES(101,'Jenny',25,10000),(102,'Jacky',30,20000),(103,'Joe',20,40000),(104,'John',40,80000),(105,'Shameer',25,90000)";
		    String select="SELECT * FROM EMPL";
			Statement stmt = connection.createStatement();
		    stmt.execute(createDB);
		    stmt.execute(use);
		    stmt.execute(createTable);
		    stmt.executeUpdate(insert);
		    ResultSet res = stmt.executeQuery(select);
		    while(res.next()) {
		    	System.out.println(res.getInt("empcode")+" "+res.getString("empname")+" "+res.getInt("empage")+" "+res.getInt("esalary"));
		    }
		    connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}

}
