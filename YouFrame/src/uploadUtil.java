import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class uploadUtil {

	//jdbc:mysql://localhost:3306/YouFrame
	private static final String url="jdbc:mysql://localhost:3306/YouFrame?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password ="";
	public static Connection getConnection() {
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		//System.out.print("Connection Sucessful");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	 }
	public static void closeConnection(Connection con)
	 {
		 if(con!=null)
		 {
			 try {
				 con.close();
			 }catch (SQLException e)
			 {
				 e.printStackTrace();
			 }
		 }
	 }
	 
	 public static void closeStatement(PreparedStatement ps) {
		 if(ps!=null)
		 {
			 try {
				 ps.close();
			 }catch (SQLException e)
			 {
				 e.printStackTrace();
			 }
		 }
	 }
	 public static void closeStatement(Statement statement) {
		 if(statement!=null)
		 {
			 try {
				 statement.close();
			 }catch (SQLException e)
			 {
				 e.printStackTrace();
			 }
		 }
	 }

}
