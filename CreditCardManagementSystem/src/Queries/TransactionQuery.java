package Queries;
import java.sql.*;
import CoreJavaDAO.*;

public class TransactionQuery extends Queries {
	private static String str;
	private static PreparedStatement ps;
	
	public TransactionQuery() {
		str = "";
		ps = null;
	}
	
	public static PreparedStatement selectByZipMonthYear(Connection con,String zip,int month,int year) throws SQLException {
		str = Queries.getSelectByZipMonthYear();
		ps = con.prepareStatement(str);
		ps.setString(1,zip);
		ps.setInt(2, month);
		ps.setInt(3, year);
		return ps;
	}
	
	public static PreparedStatement selectCountSumForType(Connection con,String transType) throws SQLException {
		str = Queries.getSelectCountSumForType();
		ps = con.prepareStatement(str);
		ps.setString(1,transType);
		return ps;
	}
	
	public static PreparedStatement selectCountSumForBranches(Connection con,String state) throws SQLException {
		str = Queries.getSelectCountSumForBranches();
		ps = con.prepareStatement(str);
		ps.setString(1,state);
		return ps;
	}
	
	
}
