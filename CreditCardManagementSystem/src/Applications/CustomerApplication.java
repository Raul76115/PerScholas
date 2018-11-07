package Applications;

import java.io.IOException;
import java.sql.*;
import CoreJavaDAO.*;
import ModelClass.Customer;
import Queries.*;

public class CustomerApplication extends Customer{
	private static ResultSet rs;
	private static mySQLConnection ds;
	private static int count;
	private static double sum;
	
	public CustomerApplication() {
		rs = null;
		ds = null;
		count = 0;
		sum = 0.00;
	}
	
	public  static void selectAllBySSN(int ssn ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectAllBySSN(con, ssn);	
			){
			rs = pstatement.executeQuery();
		
			System.out.format("%15s | %15s | %15s | %10s | %18s | %6s | %20s | %10s | %7s | %15s | %7s | %9s | %20s | %s\n",
					"FIRST NAME","MIDDLE NAME", "LAST NAME","SSN", "CREDIT CARD NO", "APT NO", "STREET NAME","CITY", "STATE",
					"COUNTRY","ZIP","PHONE","EMAIL","LAST UPDATED" );
			System.out.println("--------------------------------------------------------------------------------------------"
					+ "------------------------------------------------------------------------------------------------------"
					+ "---------------------------------------------");
			while(rs.next()) {
				setFirstName(rs.getString("FIRST_NAME"));
				setMiddleName(rs.getString("MIDDLE_NAME"));
				setLastName(rs.getString("LAST_NAME"));
				setSSN(rs.getInt("SSN"));
				setCreditCardNo(rs.getString("CREDIT_CARD_NO"));
				setAptNo(rs.getString("APT_NO"));
				setStreetName(rs.getString("STREET_NAME"));
				setCustCity(rs.getString("Cust_City"));
				setCustState(rs.getString("CUST_STATE"));
				setCustCountry(rs.getString("CUST_COUNTRY"));
				setCustZip(rs.getInt("CUST_ZIP"));
				setCustPhone(rs.getInt("CUST_PHONE"));
				setCustEmail(rs.getString("CUST_EMAIL"));
				setTimeStamp(rs.getDate("LAST_UPDATED"));
				System.out.format("%15s | %15s | %15s | %10d | %18s | %6s | %20s | %10s | %7s | %15s | %7d | %9d | %20s | %tD\n",
						getFirstName(),getMiddleName(),getLastName(),getSSN(),getCreditCardNo(),getAptNo(),getStreetName(),
						getCustCity(),getCustState(), getCustCountry(),getCustZip(),getCustPhone(),getCustEmail(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public  static void selectAllByName(String fName,String mName, String lName ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectAllByName(con, fName,mName,lName);	
			){
			rs = pstatement.executeQuery();
		
			System.out.format("%15s | %15s | %15s | %10s | %18s | %6s | %20s | %10s | %7s | %15s | %7s | %9s | %20s | %s\n",
					"FIRST NAME","MIDDLE NAME", "LAST NAME","SSN", "CREDIT CARD NO", "APT NO", "STREET NAME","CITY", "STATE",
					"COUNTRY","ZIP","PHONE","EMAIL","LAST UPDATED" );
			System.out.println("--------------------------------------------------------------------------------------------"
					+ "------------------------------------------------------------------------------------------------------"
					+ "---------------------------------------------");
			while(rs.next()) {
				setFirstName(rs.getString("FIRST_NAME"));
				setMiddleName(rs.getString("MIDDLE_NAME"));
				setLastName(rs.getString("LAST_NAME"));
				setSSN(rs.getInt("SSN"));
				setCreditCardNo(rs.getString("CREDIT_CARD_NO"));
				setAptNo(rs.getString("APT_NO"));
				setStreetName(rs.getString("STREET_NAME"));
				setCustCity(rs.getString("Cust_City"));
				setCustState(rs.getString("CUST_STATE"));
				setCustCountry(rs.getString("CUST_COUNTRY"));
				setCustZip(rs.getInt("CUST_ZIP"));
				setCustPhone(rs.getInt("CUST_PHONE"));
				setCustEmail(rs.getString("CUST_EMAIL"));
				setTimeStamp(rs.getDate("LAST_UPDATED"));
				System.out.format("%15s | %15s | %15s | %10d | %18s | %6s | %20s | %10s | %7s | %15s | %7d | %9d | %20s | %tD\n",
						getFirstName(),getMiddleName(),getLastName(),getSSN(),getCreditCardNo(),getAptNo(),getStreetName(),
						getCustCity(),getCustState(), getCustCountry(),getCustZip(),getCustPhone(),getCustEmail(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public  static void selectAllByCCNo(String ccNo ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectAllByCCNo(con, ccNo);	
			){
			rs = pstatement.executeQuery();
		
			System.out.format("%15s | %15s | %15s | %10s | %18s | %6s | %20s | %10s | %7s | %15s | %7s | %9s | %20s | %s\n",
					"FIRST NAME","MIDDLE NAME", "LAST NAME","SSN", "CREDIT CARD NO", "APT NO", "STREET NAME","CITY", "STATE",
					"COUNTRY","ZIP","PHONE","EMAIL","LAST UPDATED" );
			System.out.println("--------------------------------------------------------------------------------------------"
					+ "------------------------------------------------------------------------------------------------------"
					+ "---------------------------------------------");
			while(rs.next()) {
				setFirstName(rs.getString("FIRST_NAME"));
				setMiddleName(rs.getString("MIDDLE_NAME"));
				setLastName(rs.getString("LAST_NAME"));
				setSSN(rs.getInt("SSN"));
				setCreditCardNo(rs.getString("CREDIT_CARD_NO"));
				setAptNo(rs.getString("APT_NO"));
				setStreetName(rs.getString("STREET_NAME"));
				setCustCity(rs.getString("Cust_City"));
				setCustState(rs.getString("CUST_STATE"));
				setCustCountry(rs.getString("CUST_COUNTRY"));
				setCustZip(rs.getInt("CUST_ZIP"));
				setCustPhone(rs.getInt("CUST_PHONE"));
				setCustEmail(rs.getString("CUST_EMAIL"));
				setTimeStamp(rs.getDate("LAST_UPDATED"));
				System.out.format("%15s | %15s | %15s | %10d | %18s | %6s | %20s | %10s | %7s | %15s | %7d | %9d | %20s | %tD\n",
						getFirstName(),getMiddleName(),getLastName(),getSSN(),getCreditCardNo(),getAptNo(),getStreetName(),
						getCustCity(),getCustState(), getCustCountry(),getCustZip(),getCustPhone(),getCustEmail(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}	
	}

	public  static void selectTransactionBetweenDates(int ssn, int m1, int m2, int d1, int d2, int yr1, int yr2) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectTransactionsBetweenDates(con, ssn, m1, m2, d1, d2, yr1, yr2);	
			){
			rs = pstatement.executeQuery();
			setSSN(ssn);
			System.out.println("Transaction for SSN: "+ getSSN());
			System.out.format("%10s | %15s|\t %s\n","DATE","TRANSACTION TYPE", "AMOUNT");
			System.out.println("---------------------------------------------------------");
			int month,day,year = 0;
			String transType = "";
			double transValue = 0.00;
			while(rs.next()) {
				month = rs.getInt("month");
				day = rs.getInt("day");
				year =rs.getInt("year");
				transType = rs.getString("transaction_type");
				transValue = rs.getDouble("transaction_value");
				System.out.format("%02d-%02d-%-2d | %15s |\t %.2f \n", month ,day , year ,transType, transValue);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void selectTransactionBetweenDatesCCNo(String ccNo, int m1, int m2, int d1, int d2, int yr1, int yr2) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectTransactionsBetweenDatesCCNo(con, ccNo, m1, m2, d1, d2, yr1, yr2);	
			){
			rs = pstatement.executeQuery();
			setCreditCardNo(ccNo);
			System.out.println("Transaction for Credit Card No: "+ getCreditCardNo());
			System.out.format("%10s | %15s|\t %s\n","DATE","TRANSACTION TYPE", "AMOUNT");
			System.out.println("---------------------------------------------------------");
			int month,day,year = 0;
			String transType = "";
			double transValue = 0.00;
			while(rs.next()) {
				month = rs.getInt("month");
				day = rs.getInt("day");
				year =rs.getInt("year");
				transType = rs.getString("transaction_type");
				transValue = rs.getDouble("transaction_value");
				System.out.format("%02d-%02d-%-2d | %15s |\t %.2f \n", month ,day , year ,transType, transValue);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public  static void selectTransactionBetweenDatesName(String fname,String mname,String lname, int m1, int m2, int d1, int d2, int yr1, int yr2) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectTransactionsBetweenDatesName(con, fname,mname,lname, m1, m2, d1, d2, yr1, yr2);	
			){
			rs = pstatement.executeQuery();
			setFirstName(fname);
			setLastName(lname);
			setMiddleName(mname);
			System.out.printf("Generating monthly bill for %s %s %s: \n ", getFirstName(),getMiddleName(),getLastName());
			System.out.format("%10s | %15s|\t %s\n","DATE","TRANSACTION TYPE", "AMOUNT");
			System.out.println("---------------------------------------------------------");
			int month,day,year = 0;
			String transType = "";
			double transValue = 0.00;
			while(rs.next()) {
				month = rs.getInt("month");
				day = rs.getInt("day");
				year =rs.getInt("year");
				transType = rs.getString("transaction_type");
				transValue = rs.getDouble("transaction_value");
				System.out.format("%02d-%02d-%-2d | %15s |\t %.2f \n", month ,day , year ,transType, transValue);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void selectAddress(int ssn ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectAddressInfo(con,ssn);	
			){
			rs = pstatement.executeQuery();
			setSSN(ssn);
			System.out.println("Address Information for SSN: " + getSSN());
			System.out.format("%6s | %20s| %15s | %10s | %20s | %9s | %s\n","APT NO","STREET NAME", "CITY", "STATE","COUNTRY","ZIPCODE","LAST UPDATE");
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			while(rs.next()) {
				setAptNo(rs.getString("apt_no"));
				setStreetName(rs.getString("street_name"));
				setCustCity(rs.getString("cust_city"));
				setCustState(rs.getString("cust_state"));
				setCustCountry(rs.getString("cust_country"));
				setCustZip(rs.getInt("cust_zip"));
				setTimeStamp(rs.getDate("LAST_UPDATED"));
				System.out.format("%6s | %20s| %15s | %10s | %20s | %9s | %s\n", getAptNo(),getStreetName(),getCustCity(),getCustState(),getCustCountry(),getCustZip(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void selectAddressCCNo(String ccNo ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectAddressInfoCCNo(con,ccNo);	
			){
			rs = pstatement.executeQuery();
			setCreditCardNo(ccNo);
			System.out.println("Address Information for Credit Card No: " + getCreditCardNo());
			System.out.format("%6s | %20s| %15s | %10s | %20s | %9s | %s\n","APT NO","STREET NAME", "CITY", "STATE","COUNTRY","ZIPCODE","LAST UPDATE");
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			while(rs.next()) {
				setAptNo(rs.getString("apt_no"));
				setStreetName(rs.getString("street_name"));
				setCustCity(rs.getString("cust_city"));
				setCustState(rs.getString("cust_state"));
				setCustCountry(rs.getString("cust_country"));
				setCustZip(rs.getInt("cust_zip"));
				setTimeStamp(rs.getDate("LAST_UPDATED"));
				System.out.format("%6s | %20s| %15s | %10s | %20s | %9s | %s\n", getAptNo(),getStreetName(),getCustCity(),getCustState(),getCustCountry(),getCustZip(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void selectAddressName(String f, String m,String l ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectAddressInfoName(con,f,m,l);	
			){
			rs = pstatement.executeQuery();
			setFirstName(f);
			setLastName(l);
			setMiddleName(m);
			System.out.printf("Address Information for: %s %s %s\n" , getFirstName(),getMiddleName(),getLastName());
			System.out.format("%6s | %20s| %15s | %10s | %20s | %9s | %s\n","APT NO","STREET NAME", "CITY", "STATE","COUNTRY","ZIPCODE","LAST UPDATE");
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			while(rs.next()) {
				setAptNo(rs.getString("apt_no"));
				setStreetName(rs.getString("street_name"));
				setCustCity(rs.getString("cust_city"));
				setCustState(rs.getString("cust_state"));
				setCustCountry(rs.getString("cust_country"));
				setCustZip(rs.getInt("cust_zip"));
				setTimeStamp(rs.getDate("LAST_UPDATED"));
				System.out.format("%6s | %20s| %15s | %10s | %20s | %9s | %s\n", getAptNo(),getStreetName(),getCustCity(),getCustState(),getCustCountry(),getCustZip(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public  static void selectContact(int ssn ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectContactInfo(con,ssn);	
			){
			rs = pstatement.executeQuery();
			setSSN(ssn);
			System.out.println("Address Information for SSN: " + getSSN());
			System.out.format("%8s | %20s| %s\n","PHONE","EMAIL","LAST UPDATE");
			System.out.println("---------------------------------------------------------");
			while(rs.next()) {
				setCustPhone(rs.getInt("cust_phone"));
				setCustEmail(rs.getString("cust_email"));
				setTimeStamp(rs.getDate("last_updated"));
				System.out.format("%8s | %20s| %s\n", getCustPhone(),getCustEmail(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void selectContactCCNo(String ccNo ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectContactInfoCCNo(con,ccNo);	
			){
			rs = pstatement.executeQuery();
			setCreditCardNo(ccNo);
			System.out.println("Address Information for Credit Card No: " + getCreditCardNo());
			System.out.format("%8s | %20s| %s\n","PHONE","EMAIL","LAST UPDATE");
			System.out.println("---------------------------------------------------------");
			while(rs.next()) {
				setCustPhone(rs.getInt("cust_phone"));
				setCustEmail(rs.getString("cust_email"));
				setTimeStamp(rs.getDate("last_updated"));
				System.out.format("%8s | %20s| %s\n", getCustPhone(),getCustEmail(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void selectContactName(String f,String m, String l ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.selectContactInfoName(con,f,m,l);	
			){
			rs = pstatement.executeQuery();
			setFirstName(f);
			setMiddleName(m);
			setLastName(l);
			System.out.printf("Address Information for: %s %s %s\n", getFirstName(),getMiddleName(),getLastName());
			System.out.format("%8s | %20s| %s\n","PHONE","EMAIL","LAST UPDATE");
			System.out.println("---------------------------------------------------------");
			while(rs.next()) {
				setCustPhone(rs.getInt("cust_phone"));
				setCustEmail(rs.getString("cust_email"));
				setTimeStamp(rs.getDate("last_updated"));
				System.out.format("%8s | %20s| %s\n", getCustPhone(),getCustEmail(),getTimeStamp());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------------------------------------------
	public  static void modifyAddress(int ssn, String aptNo,String st,String cty, String ste, String cntry, int zip ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.updateAddressInfo(con,aptNo,st,cty,ste,cntry,zip,ssn);	
			){
			pstatement.executeUpdate();
			setSSN(ssn);
			System.out.println("Modifying address Information for SSN: " + getSSN());
			System.out.println("---------------------------------------------------------");
			int rowAffected = pstatement.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void modifyAddressCCNo(String ccNo, String aptNo,String st,String cty, String ste, String cntry, int zip ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.updateAddressInfoCCNo(con,aptNo,st,cty,ste,cntry,zip,ccNo);	
			){
			pstatement.executeUpdate();
			setCreditCardNo(ccNo);
			System.out.println("Modifying address Information for Credit Card No: " + getCreditCardNo());
			System.out.println("---------------------------------------------------------");
			int rowAffected = pstatement.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void modifyAddressName(String f,String m, String l, String aptNo,String st,String cty, String ste, String cntry, int zip ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =CustomerQuery.updateAddressInfoName(con,aptNo,st,cty,ste,cntry,zip,f,m,l);	
			){
			pstatement.executeUpdate();
			setFirstName(f);
			setMiddleName(m);
			setLastName(l);
			System.out.printf("Modifying address Information for: %s %s %s", getFirstName(),getMiddleName(),getLastName());
			System.out.println("---------------------------------------------------------");
			int rowAffected = pstatement.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void modifyContact(int ssn, int phone,String email) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement = CustomerQuery.updateContactInfo(con,phone,email,ssn);	
			){
			pstatement.executeUpdate();
			setSSN(ssn);
			System.out.println("Modifying Contact Information for SSN: " + getSSN());
			System.out.println("---------------------------------------------------------");
			int rowAffected = pstatement.executeUpdate();
            System.out.println(String.format("Row affected %d\n", rowAffected));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void modifyContactCCNo(String ccNo, int phone,String email) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement = CustomerQuery.updateContactInfoCCNo(con,phone,email,ccNo);	
			){
			pstatement.executeUpdate();
			setCreditCardNo(ccNo);
			System.out.println("Modifying Contact Information for Credit Card Number: " + getCreditCardNo());
			System.out.println("---------------------------------------------------------");
			int rowAffected = pstatement.executeUpdate();
            System.out.println(String.format("Row affected %d\n", rowAffected));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void modifyContactName(String f,String m,String l, int phone,String email) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement = CustomerQuery.updateContactInfoName(con,phone,email,f,m,l);	
			){
			pstatement.executeUpdate();
			setFirstName(f);
			setMiddleName(m);
			setLastName(l);
			System.out.printf("Modifying Contact Information for: %s %s %s\n", getFirstName(),getMiddleName(),getLastName());
			System.out.println("---------------------------------------------------------");
			int rowAffected = pstatement.executeUpdate();
            System.out.println(String.format("Row affected %d\n", rowAffected));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------
		public  static void getMonthlyBill(int ssn, int m,int yr) throws SQLException, ClassNotFoundException, IOException{
			ds = new mySQLConnection();
			rs = null;
			try(Connection con = ds.getConnection();
				PreparedStatement pstatement = CustomerQuery.generateMonthlyBill(con,ssn,m,yr);	
				){
				rs = pstatement.executeQuery();
				setSSN(ssn);
				System.out.println("Generating monthly bill for SSN: " + getSSN());
				System.out.format("%8s | %s\n","DATE","Bill AMOUNT");
				System.out.println("---------------------------------------------------------");
				double sum = 0.00;
				int mon = 0, y = 0;
				while(rs.next()) {
					mon = rs.getInt("month");
					y = rs.getInt("year");
					sum = rs.getDouble("SUM(transaction_value)");
					System.out.format("%02d/%4d | %.2f\n", mon,y,sum);
				}
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
			public  static void getMonthlyBillCCNo(String ccNo, int m,int yr) throws SQLException, ClassNotFoundException, IOException{
				ds = new mySQLConnection();
				rs = null;
				try(Connection con = ds.getConnection();
					PreparedStatement pstatement = CustomerQuery.generateMonthlyBillCCNo(con,ccNo,m,yr);	
					){
					rs = pstatement.executeQuery();
					setCreditCardNo(ccNo);
					System.out.println("Generating monthly bill for Credit Card No: "+ getCreditCardNo());
					System.out.format("%8s | %s\n","DATE","Bill AMOUNT");
					System.out.println("---------------------------------------------------------");
					double sum = 0.00;
					int mon = 0, y = 0;
					while(rs.next()) {
						mon = rs.getInt("month");
						y = rs.getInt("year");
						sum = rs.getDouble("SUM(transaction_value)");
						System.out.format("%02d/%4d | %.2f\n", mon,y,sum);
					}
				
				} catch(SQLException e) {
					e.printStackTrace();
				}
	}
	
			public  static void getMonthlyBillName(String fname,String mname,String lname, int m,int yr) throws SQLException, ClassNotFoundException, IOException{
				ds = new mySQLConnection();
				rs = null;
				try(Connection con = ds.getConnection();
					PreparedStatement pstatement = CustomerQuery.generateMonthlyBillName(con,fname,mname,lname,m,yr);	
					){
					rs = pstatement.executeQuery();
					setFirstName(fname);
					setLastName(lname);
					setMiddleName(mname);
					System.out.printf("Generating monthly bill for %s %s %s:\n " , getFirstName(),getMiddleName(),getLastName());
					System.out.format("%6s | %s\n","DATE","BILLING AMOUNT");
					System.out.println("---------------------------------------------------------");
					double sum = 0.00;
					int mon = 0, y = 0;
					while(rs.next()) {
						mon = rs.getInt("month");
						y = rs.getInt("year");
						sum = rs.getDouble("SUM(transaction_value)");
						System.out.format("%02d/%4d | %.2f\n", mon,y,sum);
					}
				
				} catch(SQLException e) {
					e.printStackTrace();
				}
	}
			
			
			
}
