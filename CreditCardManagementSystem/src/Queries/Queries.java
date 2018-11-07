package Queries;

public abstract class Queries {
	//Transactional Queries---------------------------------------------------------------------------------------------------
	public static String getSelectByZipMonthYear() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT month,day,year,transaction_type,transaction_value ");
		string.append("FROM cdw_sapp_creditcard t ");
		string.append("JOIN cdw_sapp_customer c ON t.cust_ssn = c.ssn ");
		string.append("WHERE cust_zip = ? AND month = ? AND year = ? ");
		string.append("ORDER BY day DESC;");
		return string.toString();
	}
	
	public static String getSelectCountSumForType() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT COUNT(transaction_type),transaction_type,SUM(transaction_value) ");
		string.append("FROM cdw_sapp_creditcard t ");
		string.append("WHERE transaction_type = ?;");
		return string.toString();
	}
	
	public static String getSelectCountSumForBranches() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT COUNT(transaction_type), transaction_type, SUM(transaction_value) ");
		string.append("FROM cdw_sapp_creditcard t ");
		string.append("JOIN cdw_sapp_branch b ON t.branch_code = b.branch_code ");
		string.append("GROUP BY transaction_type, branch_state ");
		string.append("HAVING branch_state = ?;");
		return string.toString();
	}
	//Customer Queries----------------------------------------------------------------------------------------------------------------
	
	public static String getSelectAllFromCustomer() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT * FROM cdw_sapp_customer ");
		string.append("WHERE ssn = ?;");
		return string.toString();
	}
	
	public static String getSelectAllFromCustomerCCNo() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT * FROM cdw_sapp_customer ");
		string.append("WHERE credit_card_no = ?;");
		return string.toString();
	}
	
	public static String getSelectAllFromCustomerName() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT * FROM cdw_sapp_customer ");
		string.append("WHERE first_name = ? AND middle_name = ? AND last_name = ? ;");
		return string.toString();
	}
//----------------------------------------------------------------------------------------------------------------------------	
//-----------------------------------------------------------------------------------------------------------------------------	
	public static String getCurrentAddress() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT apt_no,street_name,cust_city,cust_state, cust_country,cust_zip, last_updated ");
		string.append("FROM cdw_sapp_customer ");
		string.append("WHERE ssn = ?;");
		return string.toString();
	}
	
	public static String getCurrentAddressCCNo() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT apt_no,street_name,cust_city,cust_state, cust_country,cust_zip, last_updated ");
		string.append("FROM cdw_sapp_customer ");
		string.append("WHERE credit_card_no = ?;");
		return string.toString();
	}
	
	public static String getCurrentAddressName() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT apt_no,street_name,cust_city,cust_state, cust_country,cust_zip, last_updated ");
		string.append("FROM cdw_sapp_customer ");
		string.append("WHERE first_name = ? AND middle_name = ? AND last_name = ?;");
		return string.toString();
	}
	
//------------------------------------------------------------------------------------------------------------------------------	
	public static String setAddressUpdate() {
		StringBuilder string = new StringBuilder();
		string.append("UPDATE cdw_sapp_customer ");
		string.append("SET apt_no = ?, street_name = ?,cust_city= ?,cust_state = ?, ");
		string.append("cust_country = ?, cust_zip = ?, last_updated = current_timestamp() ");
		string.append("WHERE ssn = ?;");
		return string.toString();
	}
	
	public static String setAddressUpdateCCNo() {
		StringBuilder string = new StringBuilder();
		string.append("UPDATE cdw_sapp_customer ");
		string.append("SET apt_no = ?, street_name = ?,cust_city= ?,cust_state = ?, ");
		string.append("cust_country = ?, cust_zip = ?, last_updated = current_timestamp() ");
		string.append("WHERE credit_card_no = ?;");
		return string.toString();
	}
	
	public static String setAddressUpdateName() {
		StringBuilder string = new StringBuilder();
		string.append("UPDATE cdw_sapp_customer ");
		string.append("SET apt_no = ?, street_name = ?,cust_city= ?,cust_state = ?, ");
		string.append("cust_country = ?, cust_zip = ?, last_updated = current_timestamp() ");
		string.append("WHERE first_name = ? AND middle_name = ? AND last_name = ?;");
		return string.toString();
	}
//-------------------------------------------------------------------------------------------------------------------------	
	public static String getCurrentContact() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT cust_phone,cust_email,last_updated ");
		string.append("FROM cdw_sapp_customer ");
		string.append("WHERE ssn = ?;");
		return string.toString();
	}
	
	public static String getCurrentContactCCNo() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT cust_phone,cust_email,last_updated ");
		string.append("FROM cdw_sapp_customer ");
		string.append("WHERE credit_card_no = ?;");
		return string.toString();
	}
	
	public static String getCurrentContactName() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT cust_phone,cust_email,last_updated ");
		string.append("FROM cdw_sapp_customer ");
		string.append("WHERE first_name = ? AND middle_name = ? AND last_name = ?;");
		return string.toString();
	}
//----------------------------------------------------------------------------------------------------------------------		
	public static String setContactUpdate() {
		StringBuilder string = new StringBuilder();
		string.append("UPDATE cdw_sapp_customer ");
		string.append("SET cust_phone = ?,cust_email = ?,last_updated = current_timestamp ");
		string.append("WHERE ssn =?;");
		return string.toString();
	}
	
	public static String setContactUpdateCCNo() {
		StringBuilder string = new StringBuilder();
		string.append("UPDATE cdw_sapp_customer ");
		string.append("SET cust_phone = ?,cust_email = ?,last_updated = current_timestamp() ");
		string.append("WHERE credit_card_no =?;");
		return string.toString();
	}
	
	public static String setContactUpdateName() {
		StringBuilder string = new StringBuilder();
		string.append("UPDATE cdw_sapp_customer ");
		string.append("SET cust_phone = ?,cust_email = ?,last_updated = current_timestamp() ");
		string.append("WHERE first_name =? AND middle_name = ? AND last_name = ?;");
		return string.toString();
	}
	//---------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	public static String getMonthlyBillMonthYrBySSN() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT month,year,SUM(transaction_value) ");
		string.append("FROM cdw_sapp_customer c ");
		string.append("JOIN cdw_sapp_creditcard t ON c.ssn = t.cust_ssn ");
		string.append("WHERE t.cust_ssn = ? AND month = ? AND year = ?;");
		return string.toString();
	}
	
	public static String getMonthlyBillByCCNo() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT month,year,SUM(transaction_value) ");
		string.append("FROM cdw_sapp_customer c ");
		string.append("JOIN cdw_sapp_creditcard t ON c.ssn = t.cust_ssn ");
		string.append("WHERE t.credit_card_no = ? AND month = ? AND year = ?;");
		return string.toString();
	}
	
	public static String getMonthlyBillByName() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT month,year,SUM(transaction_value) ");
		string.append("FROM cdw_sapp_customer c ");
		string.append("JOIN cdw_sapp_creditcard t ON c.ssn = t.cust_ssn ");
		string.append("WHERE first_name = ? AND middle_name = ? AND last_name = ? AND month = ? AND year = ?;");
		return string.toString();
	}
//--------------------------------------------------------------------------------------------------------------------	
	
	public static String getTransactionsBetweenDates() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT month,day,year,transaction_type,transaction_value ");
		string.append("FROM cdw_sapp_creditcard t ");
		string.append("JOIN cdw_sapp_customer c ON t.cust_ssn = c.ssn ");
		string.append("WHERE ssn = ? AND (month BETWEEN ? AND  ?) ");
		string.append("AND (day BETWEEN ? AND ?) AND (year BETWEEN ? AND ?) ");
		string.append("ORDER BY year DESC,month DESC, day DESC;");
		return string.toString();
	}
	
	public static String getTransactionsBetweenDatesCCNo() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT month,day,year,transaction_type,transaction_value ");
		string.append("FROM cdw_sapp_creditcard t ");
		string.append("JOIN cdw_sapp_customer c ON t.cust_ssn = c.ssn ");
		string.append("WHERE t.credit_card_no = ? AND (month BETWEEN ? AND  ?) ");
		string.append("AND (day BETWEEN ? AND ?) AND (year BETWEEN ? AND ?) ");
		string.append("ORDER BY year DESC,month DESC, day DESC;");
		return string.toString();
	}
	
	public static String getTransactionsBetweenDatesName() {
		StringBuilder string = new StringBuilder();
		string.append("SELECT month,day,year,transaction_type,transaction_value ");
		string.append("FROM cdw_sapp_creditcard t ");
		string.append("JOIN cdw_sapp_customer c ON t.cust_ssn = c.ssn ");
		string.append("WHERE first_name = ? AND middle_Name = ? AND last_name = ? AND (month BETWEEN ? AND  ?) ");
		string.append("AND (day BETWEEN ? AND ?) AND (year BETWEEN ? AND ?) ");
		string.append("ORDER BY year DESC,month DESC ,day DESC;");
		return string.toString();
	}
	
}
