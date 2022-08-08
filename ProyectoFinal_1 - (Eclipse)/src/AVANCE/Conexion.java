package AVANCE;

import java.sql.*;

public class Conexion {
	private static Connection cn;
	Statement stm;
	ResultSet rst;
	
	void Connection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=VENTA", "sa", "123");
		}
		catch (Exception e) {
			cn = null;
		}
	}
	public Statement Statements() throws SQLException {
		stm = cn.createStatement();
		return stm;
	}
	ResultSet ResultS(String inSQL) throws SQLException {
		//System.out.println(cn);
		rst = stm.executeQuery(inSQL);
		return rst;
	}	
}
