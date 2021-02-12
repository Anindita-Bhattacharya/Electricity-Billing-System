package electricityBillingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class com {

	Connection c;
	Statement s; //it is used to access to our database 
	//it is useful when we are using static sql statements at runtime.
	public com()
	{
		//whenever we are working with some external files it is a good practise to write try catch block
		try {
			Class.forName("com.mysql.jdbc.Driver");
//we need to register jdbc driver in our program.it need to register only once in our program.
//the most common approach to do is by using ClassforName() method  to dynamically load the driver's
//class file into memory which automatically registers it.
			
			c=DriverManager.getConnection("jdbc:mysql:///ebs","root","root");
			s=c.createStatement();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}