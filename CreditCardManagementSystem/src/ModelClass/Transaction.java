package ModelClass;

public abstract class Transaction {
	private static int transactionId;
	private static int day;
	private static int month;
	private static int year;
	private static String zip;
	private static String creditCardNo;
	private static int custSSN;
	private static String transactionType;
	private static double transactionValue;
	private static String branchState;

	
	public Transaction(){
		transactionId = 0;
		day = 0;
		month = 0;
		year = 0;
		creditCardNo = "";
		custSSN = 0;
		transactionType = "";
		transactionValue = 0.00;
		branchState = "";
	}
	
	public  static void setTransactionId(int transId){
		transactionId = transId;
	}
	public int getTransactionId(){
		return transactionId;
	}
	
	public static void setDay(int diem){
		day = diem;
	}
	public static int getDay(){
		return day;
	}
	
	public static void setMonth(int mon){
		month = mon;
	}
	public static int getMonth(){
		return month;
	}
	
	public static void setYear(int yr){
		year = yr;
	}
	public static int getYear(){
		return year;
	}
	
	public static void setZip(String zp) {
		zip = zp;
	}
	public static String getZip() {
		return zip;
	}
	
	public static void setCrediCardNo(String ccNo){
		creditCardNo = ccNo;
	}
	public static String getCreditCardNo(){
		return creditCardNo;
	}
	
	public static void setCustSSN(int SSN){
		custSSN = SSN;
	}
	public static int getCustSSN(){
		return custSSN;
	}
	
	public static void setTransactionType(String transType){
		transactionType = transType;
	}
	public static String getTransactionType(){
		return transactionType;
	}
	
	public static void setTransactionValue(double transValue){
		transactionValue = transValue;
	}
	public static double getTransactionValue(){
		return transactionValue;
	}
	
	public static void setBranchState(String branchSt){
		branchState = branchSt;
	}
	public static String getBranchState(){
		return branchState;
	}
}
