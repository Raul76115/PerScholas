package ModelClass;
import java.sql.Date;


public abstract class Customer {
	private static String firstName;
	private static String lastName;
	private static String middleName;
	private static int ssn;
	private static String creditCardNo;
	private static String aptNo;
	private static String streetName;
	private static String custCity;
	private static String custState;
	private static String custCountry;
	private static int custZip;
	private static int custPhone;
	private static String custEmail;
	private static Date timeStamp;
	
	public Customer(){
	firstName = "";
	lastName = "";
	middleName = "";
	ssn = 0;
	creditCardNo = "";
	aptNo = "";
	streetName = "";
	custCity = "";
	custState = "";
	custCountry = "";
	custZip = 0;
	custPhone = 0;
	custEmail = "";
	timeStamp = null;
	}
	
	public static void setFirstName(String fName){
		firstName = fName;
	}
	
	public static String getFirstName(){
		return firstName;
	}
	
	public static void setLastName(String lName){
		lastName = lName;
	}
	
	public static String getLastName(){
		return lastName;
	}
	
	public static void setMiddleName(String mName){
		middleName = mName;
	}
	
	public static String getMiddleName(){
		return middleName;
	}
	
	public static void setSSN(int ssno){
		ssn = ssno;
	}
	
	public static int getSSN(){
		return ssn;
	}
	public static void setCreditCardNo(String cCNo){
		creditCardNo = cCNo;
	}
	
	public static String getCreditCardNo(){
		return creditCardNo;
	}
	
	public static void setAptNo(String aNo){
		aptNo = aNo;
	}
	
	public static String getAptNo(){
		return aptNo;
	}
	
	public static void setStreetName(String strtName){
		streetName = strtName;
	}
	
	public static String getStreetName(){
		return streetName;
	}
	
	public static void setCustCity(String city){
		custCity = city;
	}
	
	public static String getCustCity(){
		return custCity;
	}
	
	public static void setCustState(String state){
		custState = state;
	}
	
	public static String getCustState(){
		return custState;
	}
	
	public static void setCustCountry(String country){
		custCountry = country;
	}
	
	public static String getCustCountry(){
		return custCountry;
	}
	
	public static void setCustZip(int zip){
		custZip = zip;
	}
	
	public static int getCustZip(){
		return custZip;
	}
	
	public static void setCustPhone(int phone){
		custPhone = phone;
	}
	
	public static int getCustPhone(){
		return custPhone;
	}
	
	public static void setCustEmail(String email){
		custEmail = email;
	}
	
	public static String getCustEmail(){
		return custEmail;
	}
	
	public static void setTimeStamp(Date time){
		timeStamp = time;
	}
	
	public static Date getTimeStamp(){
		return timeStamp;
	}
}
