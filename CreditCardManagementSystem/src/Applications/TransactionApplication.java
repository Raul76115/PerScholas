package Applications;

import java.io.IOException;
import java.sql.*;
import CoreJavaDAO.*;
import Queries.*;
import ModelClass.Transaction;

public class TransactionApplication extends Transaction{
	private static ResultSet rs;
	private static mySQLConnection ds;
	private static int count;
	private static double sum;
	
	public TransactionApplication() {
		rs = null;
		ds = null;
		count = 0;
		sum = 0.00;
				}
	
	public  static void selectByZipMonthYear(String zip, int month,int year ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =TransactionQuery.selectByZipMonthYear(con,zip,month,year);	
			){
			rs = pstatement.executeQuery();
			setZip(zip);
			System.out.format("%10s | %15s|\t %s\n","DATE","TRANSACTION TYPE", "AMOUNT");
			System.out.println("---------------------------------------------------------");
			while(rs.next()) {
				setMonth(rs.getInt("month"));
				setDay(rs.getInt("day"));
				setYear(rs.getInt("year"));
				setTransactionType(rs.getString("transaction_type"));
				setTransactionValue(rs.getDouble("transaction_value"));
				System.out.format("%02d-%02d-%-2d | %15s |\t %.2f \n", getMonth(),getDay(),getYear(),getTransactionType(), getTransactionValue());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public  static void selectCountSumForType(String transType) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =TransactionQuery.selectCountSumForType(con,transType);	
			){
			rs = pstatement.executeQuery();
			System.out.format("%10s | %15s|\t %s\n","COUNT","TRANSACTION TYPE", "AMOUNT");
			System.out.println("---------------------------------------------------------");
			count = 0;
			sum = 0.00;
			while(rs.next()) {
				count = rs.getInt("COUNT(transaction_type)");
				setTransactionType(rs.getString("transaction_type"));
				sum = rs.getDouble("SUM(transaction_value)");
				System.out.format("%10d | %15s |\t %.2f \n", count , getTransactionType() , sum);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  static void selectCountSumForBranches(String state ) throws SQLException, ClassNotFoundException, IOException{
		ds = new mySQLConnection();
		rs = null;
		
		try(Connection con = ds.getConnection();
			PreparedStatement pstatement =TransactionQuery.selectCountSumForBranches(con,state);	
			){
			rs = pstatement.executeQuery();
			setBranchState(state);
			System.out.println("State: "+getBranchState());
			System.out.format("%10s | %15s|\t %s\n","COUNT","TRANSACTION TYPE", "AMOUNT");
			System.out.println("---------------------------------------------------------");
			count = 0;
			sum = 0.00;
			while(rs.next()) {
				count = rs.getInt("COUNT(transaction_type)");
				setTransactionType(rs.getString("transaction_type"));
				sum = rs.getDouble("SUM(transaction_value)");
				System.out.format("%10d | %15s |\t %.2f \n", count , getTransactionType() , sum);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
