package Applications;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;



public class MainApplication {
	


	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Scanner input = new Scanner(System.in);
		String str = "";
		boolean isvalid = false;
		HashMap<Integer,String> prompt1 = new HashMap<>();
		prompt1.put(1,"transactions");
		prompt1.put(2,"customers");
		System.out.println("Welcome to the Credit Card Managment System. ");
		System.out.println("The CCMS manages the following information.");
		do {
			System.out.println("1.Transactions\n2.Customers");
			System.out.print("Enter the type of information you would like to manage to see further options (i.e. 1, Customers, ...): ");
			str =input.nextLine();
			try {
			if(prompt1.containsValue(str.toLowerCase())) {
				if(Objects.equals(str.toLowerCase(),"transactions")) { 
					transactionInterface();
					System.out.println("Transaction Details Module : OFF");
				}
				else if(Objects.equals(str.toLowerCase(),"customers")) {
					customerInterface();
					System.out.println("Customer Details Module : OFF");

				}
			}
			else if(prompt1.containsKey(Integer.parseInt(str))) {
				if(Integer.parseInt(str) == 1) {
					transactionInterface();
					System.out.println("Transaction Details Module : OFF");
				}
				else if (Integer.parseInt(str) == 2) {
					customerInterface();
					System.out.println("Customer Details Module : OFF");
				}
			}
			else {
				throw new Exception();
			}
			}catch(Exception e) {
				System.out.println("An error occured in entering input.");
				continue;
			}
			
			System.out.print("Continue with CCMS?(Y/N): ");
			str = input.next();
			if (Objects.equals(str.toUpperCase(), "N")) {
				isvalid = true;
				System.out.println("...Exiting CCMS...");
			}
		}while(!isvalid);

		//input.close();
	}
//Transaction User Interface	
//--------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static void transactionInterface() {
		Scanner input1 = new Scanner(System.in);
		boolean isValid = false;
		int inputval = 0;
		String str= "";
		String delim = ",";
		System.out.println("Transaction Details Module : ON");
		System.out.println("The TDM allows for the following actions.");
		do {
		System.out.println("1.Display the transactions made by customers living in a given zipcode"
				+ " for a given month and year");
		System.out.println("2.Display the number and total values of transactions for a given type");
		System.out.println("3.Display the number and total values of transactions for branches in a given state");
		System.out.print("Enter the numeric value corresponding to the desired action: ");
		inputval = input1.nextInt();
		input1.nextLine();
		switch(inputval) {
		case 1:
			String zip = "";
			int m = 0, yr = 0;
			boolean valZip = false, valMon = false,valYr = false;
			do {
			System.out.print("Enter zipcode, month, year (Separate values using commas i.e. 91180,01,1990) : ");
			str = input1.nextLine();
			String[] tokens = str.split(delim);
			zip = tokens[0];
			m = Integer.parseInt(tokens[1]);
			yr = Integer.parseInt(tokens[2]);
			valZip = isValidZip(zip);
			valMon = isValidMonth(m);
			valYr = isValidYr(yr);
			try {
				if(valZip && valMon && valYr) {
					try {
						TransactionApplication.selectByZipMonthYear(zip, m, yr);
					} catch (ClassNotFoundException | SQLException | IOException e) {
						System.out.println("Error occurred.");
						e.printStackTrace();
				}
				break;
				}
				else {
					throw new Exception();
				}
			}catch(Exception e) {
				System.out.println("Error!");
				System.out.print("Continue?(Y/N): ");
				str = input1.nextLine();
				if (Objects.equals(str.toUpperCase(), "N")) {
					isValid = true;
				}
			}
			}while(!valZip && !valMon && !valYr);
			
			break;
		case 2:
			HashMap<Integer,String> map = new HashMap<>();
			map.put(1, "education");
			map.put(2,"entertainment");
			map.put(3,"grocery");
			map.put(4,"gas");
			map.put(5,"bills");
			map.put(6, "test");
			map.put(7,"healthcare");
			do {
			System.out.print("Choose from the following transaction types:\n "
					+ "1.Education\n2.Entertainment\n3.Grocery\n4.Gas\n5.Bills\n6.Test\n7.Healthcare\n");
			System.out.print("Enter numeric value corresponding to the desired transaction or enter transaction type: ");
			str  = input1.nextLine();
			try {
				
				if (map.containsValue(str.toLowerCase())) {
					TransactionApplication.selectCountSumForType(str.toLowerCase());
					break;
				}
				else if(map.containsKey(Integer.parseInt(str))) {
					TransactionApplication.selectCountSumForType(map.get(Integer.parseInt(str)));
					break;
				}
				else {
					throw new Exception();
				}
			}catch (Exception e) {
				System.out.println("Error occurred in entering transaction type.");
				System.out.print("Continue?(Y/N): ");
				str = input1.nextLine();
				if (Objects.equals(str.toUpperCase(), "N")) {
					break;
				}
			}
			}while(!isValid);
			break;
		case 3:
			do {
			System.out.print("Enter the initials of the desired state to view transactions details: ");
			str = input1.nextLine();
			try {
				if(isValidSt(str)) {
					TransactionApplication.selectCountSumForBranches(str.toUpperCase());
					break;
				}
				else {
					throw new Exception();
				}
			} catch(Exception e) {
				System.out.println("Error occurred in entering input.");
			}
			}while(!isValid);
			break;
		default:
			System.out.println("Invalid input.");
			System.out.println("...Exiting TDM ...");
			break;
		}
		System.out.print("Continue with TDM?(Y/N): ");
		str = input1.nextLine();
		if (Objects.equals(str.toUpperCase(), "N")) {
			isValid = true;
		}
		}while(!isValid);
		//input1.close();
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	
	//Customer Module User Interface
	//-----------------------------------------------------------------------------------------------------------------------------------
	public static void customerInterface() {
		Scanner input = new Scanner(System.in);
		boolean isValid = false;
		int inputval = 0;
		String str= "";
		String delim = ",";
		System.out.println("Customers Details Module : ON");
		System.out.println("The CDM allows for the following actions.");
		do {
			System.out.println("1.Display existing account details of a customer.");
			System.out.println("2.Modify the existing account details of a customer.");
			System.out.println("3.Generate monthly bill for a credit card number for a given month and year");
			System.out.println("4.Display transactions between two dates.");
			System.out.println("***THESE ACTIONS REQUIRE THE SSN TO RETRIEVE CUSTOMER DETAILS***");
			System.out.print("Enter the numeric value corresponding to the desired action: ");
			inputval = input.nextInt();
			input.nextLine();
			switch(inputval) {
			case 1:
				System.out.print("Enter Customer SSN(No spaces), Full Name(Use Full Name format: John A Smith ), or Credit Card Number(No spaces): ");
				str = input.nextLine();
				try {
				if(isValidSSN(str)) {
					int ssn = Integer.parseInt(str);
					CustomerApplication.selectAllBySSN(ssn);
					break;
				}
				else if (isValidCCNo(str)) {
					CustomerApplication.selectAllByCCNo(str);
					break;
				}
				else if (isValidFullName(str)) {
					String[] strArray = str.split(" ");
					CustomerApplication.selectAllByName(strArray[0], strArray[1], strArray[2]);
					break;
				}
				else {
					throw new Exception();
				}
				}catch(Exception e) {
					System.out.println("An error occurred.");
				}
				break;
			case 2:
				System.out.printf("Modify:\n1.Address Information\n2.Contact Information\n");
				System.out.print("Enter numeric values, address, or contact:");
				str = input.nextLine();
				if(Objects.equals(str.toLowerCase(), "address") || Integer.parseInt(str)==1) {
				System.out.print("Enter Customer SSN(No spaces), Full Name(Use Full Name format: John A Smith ), or Credit Card Number(No spaces): ");
				str = input.nextLine();
				String aptNo,st,cty,ste,ctry;
				int zip;
				try {
					if(isValidSSN(str)) {
						int ssn = Integer.parseInt(str);
						CustomerApplication.selectAddress(ssn);
						System.out.print("Apt No: ");
						aptNo = input.nextLine();
						System.out.print("Street Name: ");
						st = input.nextLine();
						System.out.print("City: ");
						cty = input.nextLine();
						System.out.print("State: ");
						ste = input.nextLine();
						System.out.print("Country: ");
						ctry = input.nextLine();
						System.out.print("Zipcode: ");
						zip = input.nextInt();
						input.nextLine();
						CustomerApplication.modifyAddress(ssn, aptNo, st, cty, ste, ctry, zip);
						CustomerApplication.selectAddress(ssn);

						break;
					}
					else if (isValidCCNo(str)) {
						CustomerApplication.selectAddressCCNo(str);
						System.out.print("Apt No: ");
						aptNo = input.nextLine();
						System.out.print("Street Name: ");
						st = input.nextLine();
						System.out.print("City: ");
						cty = input.nextLine();
						System.out.print("State: ");
						ste = input.nextLine();
						System.out.print("Country: ");
						ctry = input.nextLine();
						System.out.print("Zipcode: ");
						zip = input.nextInt();
						input.nextLine();
						CustomerApplication.modifyAddressCCNo(str, aptNo, st, cty, ste, ctry, zip);
						CustomerApplication.selectAddressCCNo(str);

						break;
					}
					else if (isValidFullName(str)) {
						String[] strArray = str.split(" ");
						CustomerApplication.selectAddressName(strArray[0], strArray[1], strArray[2]);
						System.out.print("Apt No: ");
						aptNo = input.nextLine();
						System.out.print("Street Name: ");
						st = input.nextLine();
						System.out.print("City: ");
						cty = input.nextLine();
						System.out.print("State: ");
						ste = input.nextLine();
						System.out.print("Country: ");
						ctry = input.nextLine();
						System.out.print("Zipcode: ");
						zip = input.nextInt();
						input.nextLine();
						CustomerApplication.modifyAddressName(strArray[0], strArray[1], strArray[2], aptNo,st,cty,ste,ctry,zip);
						CustomerApplication.selectAddressName(strArray[0], strArray[1], strArray[2]);

						break;
					}
					else {
						throw new Exception();
					}
					}catch(Exception e) {
						System.out.println("An error occurred.");
					}
				}
				else if(Objects.equals(str.toLowerCase(), "contact")||Integer.parseInt(str)==2) {
					System.out.print("Enter Customer SSN(No spaces), Full Name(Use Full Name format: John A Smith ), or Credit Card Number(No spaces): ");
					str = input.nextLine();
					String email;
					int phone;
					try {
						if(isValidSSN(str)) {
							int ssn = Integer.parseInt(str);
							CustomerApplication.selectContact(ssn);
							System.out.print("Phone: ");
							phone = input.nextInt();
							input.nextLine();
							System.out.println("Email: ");
							email = input.nextLine();
							CustomerApplication.modifyContact(ssn,phone,email);
							CustomerApplication.selectContact(ssn);

							break;
						}
						else if (isValidCCNo(str)) {
							CustomerApplication.selectContactCCNo(str);
							System.out.print("Phone: ");
							phone = input.nextInt();
							input.nextLine();
							System.out.println("Email: ");
							email = input.nextLine();
							CustomerApplication.modifyContactCCNo(str,phone,email);
							CustomerApplication.selectContactCCNo(str);

							break;
						}else if (isValidFullName(str)) {
							String[] strArray = str.split(" ");
							CustomerApplication.selectContactName(strArray[0], strArray[1], strArray[2]);
							System.out.print("Phone: ");
							phone = input.nextInt();
							input.nextLine();
							System.out.println("Email: ");
							email = input.nextLine();
							CustomerApplication.modifyContactName(strArray[0], strArray[1], strArray[2], phone,email);
							CustomerApplication.selectContactName(strArray[0], strArray[1], strArray[2]);

							break;
						}
						else {
							throw new Exception();
						}
						}catch(Exception e) {
							System.out.println("An error occurred.");
						}
				}
				break;
			case 3:
				String str2 = "";
				String delim2 = "/";
				System.out.print("Enter Customer SSN(No spaces), Full Name(Use Full Name format: John A Smith ), or Credit Card Number(No spaces): ");
				str = input.nextLine();
				System.out.print("Enter month, year (Separate values using a slash i.e. 01/1990): ");
				str2 = input.nextLine();
				String[] tokens = str2.split(delim2);
				int m = Integer.parseInt(tokens[0]);
				int yr = Integer.parseInt(tokens[1]);
				try {
				if(isValidSSN(str) && isValidMonth(m) && isValidYr(yr)) {
					int ssn = Integer.parseInt(str);
					CustomerApplication.getMonthlyBill(ssn, m, yr);
					isValid = true;
					break;
				}
				else if (isValidCCNo(str) && isValidMonth(m) && isValidYr(yr)) {
					CustomerApplication.getMonthlyBillCCNo(str, m, yr);
					isValid = true;
					break;
				}
				else if (isValidFullName(str)&& isValidMonth(m) && isValidYr(yr)) {
					String[] strArray2 = str.split(" ");
					CustomerApplication.getMonthlyBillName(strArray2[0], strArray2[1], strArray2[2], m, yr);
					isValid = true;
					break;
				}
				else {
					throw new Exception();
				}
				}catch(Exception e) {
					System.out.println("An error occurred.");
				}
				break;
			case 4:
				String str3 = "";
				String delim3 = ",";
				System.out.print("Enter Customer SSN(No spaces), Full Name(Use Full Name format: John A Smith ), or Credit Card Number(No spaces): ");
				str = input.nextLine();
				System.out.print("Enter month1,day1, year1, month2,day2,year2 (Separate all values using commas i.e. 01,10,1990): ");
				str3 = input.nextLine();
				String[] token = str3.split(delim3);
				int m1 = Integer.parseInt(token[0]);
				int d1 = Integer.parseInt(token[1]);
				int yr1 = Integer.parseInt(token[2]);
				int m2 = Integer.parseInt(token[3]);
				int d2 = Integer.parseInt(token[4]);
				int yr2 = Integer.parseInt(token[5]);
				try {
					if(isValidMonth(m1) & isValidDay(d1) & isValidYr(yr1) & isValidMonth(m2) & isValidYr(yr2) & isValidDay(d2)) {
						if(isValidSSN(str)) {
							int ssn = Integer.parseInt(str);
							CustomerApplication.selectTransactionBetweenDates(ssn, m1,m2,d1,d2,yr1,yr2);
							break;
						}
						else if (isValidCCNo(str)) {
							CustomerApplication.selectTransactionBetweenDatesCCNo(str, m1,m2,d1,d2,yr1,yr2 );
							break;
						}
						else if (isValidFullName(str)) {
							String[] strArray3 = str.split(" ");
							CustomerApplication.selectTransactionBetweenDatesName(strArray3[0], strArray3[1], strArray3[2], m1,m2,d1,d2,yr1,yr2);
							break;
						}
					}
				else {
					throw new Exception();
				}
				}catch(Exception e) {
					System.out.println("An error occurred.");
				}
				break;
			default:
				System.out.println("Invalid input.");
				System.out.println("...Exiting CDM ...");
				break;
			}
			System.out.print("Continue with CDM?(Y/N): ");
			str = input.nextLine();
			if (Objects.equals(str.toUpperCase(), "N")) {
				isValid = true;
			}
			}while(!isValid);
			//input.close();
	}
	//-----------------------------------------------------------------------------------------------------------------------------------
	//Validating Methods
	//---------------------------------------------------------------------------------------------------------------------------------
	public static boolean isValidZip(String zip) {
		boolean isvalid = true;
		if(zip.length()==5) {
			for(int i =0;i<zip.length();i++) {
				if(!((int)zip.charAt(i)>47 && (int)zip.charAt(i)<58)) {
					 isvalid = false;
					 break;
				}
			}
		}
		else {
			isvalid = false;
		}
		return isvalid;
	}
	
	public static boolean isValidMonth(int m) {
		boolean isvalid;
		if(m>0 && m<13) {
			isvalid = true;
		}
		else {
			isvalid = false;
		}
		return isvalid;
	}
	
	public static boolean isValidYr(int yr) {
		boolean isValid;
		if(yr>1997 && yr<2019) {
			isValid = true;
		}
		else {
			isValid = false;
		}
		return isValid;
	}
	
	public static boolean isValidSt(String st) {
		boolean isValid = true;
		if(st.length()==2) {
			for(int i =0;i<st.length();i++) {
				if(!(st.toUpperCase().charAt(i)>64 && st.toUpperCase().charAt(i)<91)) {
					isValid = false;
					break;
				}
			}
		}
		else {
			isValid = false;
		}
		return isValid;
	}
	
	public static boolean isValidSSN(String ssn) {
		boolean isValid = true;
		if(ssn.length()==9) {
			for(int i =0;i<ssn.length();i++) {
				if(!((int)ssn.charAt(i)>47 && (int)ssn.charAt(i)<58)) {
					 isValid = false;
					 break;
				}
			}
		}
		else {
			isValid = false;
		}
		return isValid;
	}
	
	public static boolean isValidCCNo(String ccNo) {
		boolean isValid = true;
		if(ccNo.length()==16) {
			for(int i =0;i<ccNo.length();i++) {
				if(!((int)ccNo.charAt(i)>47 && (int)ccNo.charAt(i)<58)) {
					 isValid = false;
					 break;
				}
			}
		}
		else {
			isValid = false;
		}
		return isValid;
	}
	
	public static boolean isValidDay(int d) {
		boolean isValid;
		if(d>0 && d<32) {
			isValid = true;
		}
		else {
			isValid = false;
		}
		return isValid;
	}
	
	public static boolean isValidName(String s) {
		boolean isValid=true;
		for(int i =0;i<s.length();i++) {
			if(!((int)s.toUpperCase().charAt(i)>64 && (int)s.toUpperCase().charAt(i)<91)) {
				 isValid = false;
				 break;
			}
		}
		return isValid;
	}
	
	public static boolean isValidFullName(String s) {
		boolean isValid;
		String[] tokens = s.split(" ");
		if(tokens.length == 3 & isValidName(tokens[0]) & isValidName(tokens[1]) & isValidName(tokens[2])) {
			isValid = true;
		}
		else {
			isValid = false;
		}
		return isValid;
	}
}
