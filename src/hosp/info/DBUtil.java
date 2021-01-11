package hosp.info;
import java.sql.*;
public class DBUtil
{
	public static Connection con;

    static
    {
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pallavi","Pallavi@210");
    		System.out.println("Drivers Loaded");
    		
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception "+e.getMessage());
    	}
    }
    public static Connection getDBConnection()
    {
    	return con;
    }
}
