import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
public static boolean validate(String uname, String passwd){
	boolean status = false;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Servletexample", "root", "1234");
		PreparedStatement ps=con.prepareStatement(  
				"select * from RegisterUser where name = ? and password = ?"); 
		ps.setString(1, uname);
		ps.setString(2, passwd);
		ResultSet rs = ps.executeQuery();
		status = rs.next();
	}catch(Exception e){
		System.out.println(e);
	}
	return status;
}
	
}
