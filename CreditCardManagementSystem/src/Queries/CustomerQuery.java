package Queries;
import java.sql.*;
import CoreJavaDAO.*;

public class CustomerQuery extends Queries {
	private static String str;
	private static PreparedStatement ps;
	
	public CustomerQuery() {
		str = "";
		ps = null;
	}
	
	public static PreparedStatement selectAllBySSN(Connection con,int ssn) throws SQLException {
		str = Queries.getSelectAllFromCustomer();
		ps = con.prepareStatement(str);
		ps.setInt(1,ssn);
		return ps;
	}
	
	public static PreparedStatement selectAllByCCNo(Connection con,String ccNo) throws SQLException {
		str = Queries.getSelectAllFromCustomerCCNo();
		ps = con.prepareStatement(str);
		ps.setString(1,ccNo);
		return ps;
	}
	
	public static PreparedStatement selectAllByName(Connection con,String fname,String mname, String lname) throws SQLException {
		str = Queries.getSelectAllFromCustomerName();
		ps = con.prepareStatement(str);
		ps.setString(1,fname);
		ps.setString(2, mname);
		ps.setString(3, lname);
		return ps;
	}
	
	public static PreparedStatement selectAddressInfo(Connection con,int ssn) throws SQLException {
		str = Queries.getCurrentAddress();
		ps = con.prepareStatement(str);
		ps.setInt(1,ssn);
		return ps;
	}
	
	public static PreparedStatement selectAddressInfoCCNo(Connection con,String ccNo) throws SQLException {
		str = Queries.getCurrentAddressCCNo();
		ps = con.prepareStatement(str);
		ps.setString(1,ccNo);
		return ps;
	}
	
	public static PreparedStatement selectAddressInfoName(Connection con,String f, String m, String l) throws SQLException {
		str = Queries.getCurrentAddressName();
		ps = con.prepareStatement(str);
		ps.setString(1,f);
		ps.setString(2, m);
		ps.setString(3, l);
		return ps;
	}
	
	public static PreparedStatement updateAddressInfo(Connection con, String aptNo, String street, String city,String state, String country, int zip, int ssn) throws SQLException {
		str = Queries.setAddressUpdate();
		ps = con.prepareStatement(str);
		ps.setString(1,aptNo);
		ps.setString(2, street);
		ps.setString(3, city);
		ps.setString(4, state);
		ps.setString(5, country);
		ps.setInt(6, zip);
		ps.setInt(7, ssn);
		return ps;
	}
	
	public static PreparedStatement updateAddressInfoCCNo(Connection con, String aptNo, String street, String city,String state, String country, int zip, String ccNo) throws SQLException {
		str = Queries.setAddressUpdate();
		ps = con.prepareStatement(str);
		ps.setString(1,aptNo);
		ps.setString(2, street);
		ps.setString(3, city);
		ps.setString(4, state);
		ps.setString(5, country);
		ps.setInt(6, zip);
		ps.setString(7, ccNo);
		return ps;
	}
	
	public static PreparedStatement updateAddressInfoName(Connection con, String aptNo, String street, String city,String state, String country, int zip, String f, String m,String l) throws SQLException {
		str = Queries.setAddressUpdateName();
		ps = con.prepareStatement(str);
		ps.setString(1,aptNo);
		ps.setString(2, street);
		ps.setString(3, city);
		ps.setString(4, state);
		ps.setString(5, country);
		ps.setInt(6, zip);
		ps.setString(7, f);
		ps.setString(8, m);
		ps.setString(9, l);
		return ps;
	}
	public static PreparedStatement selectContactInfo(Connection con,int ssn) throws SQLException {
		str = Queries.getCurrentContact();
		ps = con.prepareStatement(str);
		ps.setInt(1,ssn);
		return ps;
	}
	
	public static PreparedStatement selectContactInfoCCNo(Connection con,String ccNo) throws SQLException {
		str = Queries.getCurrentContactCCNo();
		ps = con.prepareStatement(str);
		ps.setString(1,ccNo);
		return ps;
	}
	
	public static PreparedStatement selectContactInfoName(Connection con,String f,String m,String l) throws SQLException {
		str = Queries.getCurrentContactName();
		ps = con.prepareStatement(str);
		ps.setString(1,f);
		ps.setString(2, m);
		ps.setString(3, l);
		return ps;
	}
	
	public static PreparedStatement updateContactInfo(Connection con,int phone,String email, int ssn) throws SQLException {
		str = Queries.setContactUpdate();
		ps = con.prepareStatement(str);
		ps.setInt(1,phone);
		ps.setString(2, email);
		ps.setInt(3, ssn);
		return ps;
	}
	
	public static PreparedStatement updateContactInfoCCNo(Connection con,int phone,String email, String ccNo) throws SQLException {
		str = Queries.setContactUpdateCCNo();
		ps = con.prepareStatement(str);
		ps.setInt(1,phone);
		ps.setString(2, email);
		ps.setString(3, ccNo);
		return ps;
	}
	
	public static PreparedStatement updateContactInfoName(Connection con,int phone,String email, String f,String m,String l) throws SQLException {
		str = Queries.setContactUpdateName();
		ps = con.prepareStatement(str);
		ps.setInt(1,phone);
		ps.setString(2, email);
		ps.setString(3, f);
		ps.setString(4, m);
		ps.setString(5, l);
		return ps;
	}
	
	public static PreparedStatement selectTransactionsBetweenDates(Connection con, int ssn, int m1, int m2, int d1, int d2, int yr1, int yr2) throws SQLException {
		str = Queries.getTransactionsBetweenDates();
		ps = con.prepareStatement(str);
		ps.setInt(1,ssn);
		ps.setInt(2, m1);
		ps.setInt(3, m2);
		ps.setInt(4, d1);
		ps.setInt(5, d2);
		ps.setInt(6, yr1);
		ps.setInt(7, yr2);
		return ps;
	}
	
	public static PreparedStatement selectTransactionsBetweenDatesCCNo(Connection con, String ccNo, int m1, int m2, int d1, int d2, int yr1, int yr2) throws SQLException {
		str = Queries.getTransactionsBetweenDatesCCNo();
		ps = con.prepareStatement(str);
		ps.setString(1,ccNo);
		ps.setInt(2, m1);
		ps.setInt(3, m2);
		ps.setInt(4, d1);
		ps.setInt(5, d2);
		ps.setInt(6, yr1);
		ps.setInt(7, yr2);
		return ps;
	}
	
	public static PreparedStatement selectTransactionsBetweenDatesName(Connection con, String fname,String mname,String lname, int m1, int m2, int d1, int d2, int yr1, int yr2) throws SQLException {
		str = Queries.getTransactionsBetweenDatesName();
		ps = con.prepareStatement(str);
		ps.setString(1,fname);
		ps.setString(2, mname);
		ps.setString(3, lname);
		ps.setInt(4, m1);
		ps.setInt(5, m2);
		ps.setInt(6, d1);
		ps.setInt(7, d2);
		ps.setInt(8, yr1);
		ps.setInt(9, yr2);
		return ps;
	}
	
	public static PreparedStatement generateMonthlyBill(Connection con, int ssn, int m, int yr) throws SQLException {
		str = Queries.getMonthlyBillMonthYrBySSN();
		ps = con.prepareStatement(str);
		ps.setInt(1, ssn);
		ps.setInt(2, m);
		ps.setInt(3, yr);
		return ps;
	}
	
	public static PreparedStatement generateMonthlyBillCCNo(Connection con, String ccNo, int m, int yr) throws SQLException {
		str = Queries.getMonthlyBillByCCNo();
		ps = con.prepareStatement(str);
		ps.setString(1, ccNo);
		ps.setInt(2, m);
		ps.setInt(3, yr);
		return ps;
	}
	
	public static PreparedStatement generateMonthlyBillName(Connection con, String fName,String mName,String lName, int m, int yr) throws SQLException {
		str = Queries.getMonthlyBillByName();
		ps = con.prepareStatement(str);
		ps.setString(1, fName);
		ps.setString(2, mName);
		ps.setString(3, lName);
		ps.setInt(4, m);
		ps.setInt(5, yr);
		return ps;
	}
}
