package com.reveture.mohamad;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin implements EmployeeImpDb {
	private int id;
	private String userName;
	private String password;
	List<Customer> customers= new ArrayList<>();
	List<Applications> apps=new ArrayList<>();
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + "]";
	}
	
	
	public void adminMenu() {
		boolean flag=true;
		while(flag) {
		System.out.println("Admin Menu");
		CustomersImp customersImp=new CustomersImp();
		CustomerImp customerImp=new CustomerImp();
		this.customers=customersImp.getAllCustomer();
		this.apps=customerImp.getAllApplications();
		System.out.println(this.apps.toString());
		System.out.println(this.customers.toString());
		System.out.println("0.To Exit");
		System.out.println("1.Edit Applicants");
		System.out.println("2.Edit Customers");
		
		
		//System.out.println("Please Enter Account number and name you would like to edit or zero to exit");
		Scanner scanner=new Scanner(System.in);
		int aNumber=-111;
		while(aNumber==-111) {
			try {
				aNumber=scanner.nextInt();
				if(aNumber<0||aNumber>2){
					aNumber=-111;
					System.out.println("Invalid Entry!");
				}
			}catch(Exception e){
				System.out.println("Invalid Entry!");
				scanner.next();
			}
		}
		if(aNumber==1){
			editApplications();
			
		}
		else if(aNumber==2){
			editCustomers();
			
			}
		else if(aNumber==0) {
				flag=false;
			}
		}
		
		
	}
	public void editApplications() {
		System.out.println(this.apps);
		boolean flag=false;
		System.out.println("Please enter the username you would like to edit: ");
		Scanner scanner=new Scanner(System.in);
		String username=null;
		while(username==null) {
			try {
				username=scanner.nextLine();
			}catch(Exception e){
				System.out.println("Invalid Entry!");
			}
		}
		Applications t_app=new Applications();
		for(Applications app:apps) {
			if(app.getUsername().equals(username)){
				t_app=app;
				flag=true;
				
			}
		}
		if(flag==true){
			System.out.println("0.Exit");
			System.out.println("1.Approve");
			System.out.println("2.Deny");
			int mat=-111;
			while(mat==-111) {
			try {
				mat=scanner.nextInt();
				if(mat<0||mat>2){
					mat=-111;
					System.out.println("Invalid Entry!");
				}
				
			}catch(Exception e){
				System.out.println("Invalid Entry!");
				
			}
		}
		if(mat==1){
			CustomersImp customersImp=new CustomersImp();
			Customer customa=new Customer();
			List<Customer> cuz=new ArrayList<>();
			cuz=customersImp.getAllCustomer();
			
			boolean t_flag=false;
			int a_number=0;
			int contoller=0;
			while(contoller==0) {
				System.out.println("Please give customer an account number");
			try {
			 a_number=scanner.nextInt();
			}catch(Exception e){
				System.out.print("Wrong input");
				scanner.next();
			}
			
			for(Customer c:cuz) {
				if(a_number==c.getA_number()) {
					System.out.println("Sorry Account number already in use!");
					t_flag=true;
					break;
				}
			  }
			if(t_flag==false) {
				contoller=1;
				System.out.println("User has been added!");
				break;
			}
		}
			customa.setA_number(a_number);
			customa.setFirstName(t_app.getFirstname());
			customa.setLastName(t_app.getLastname());
			customa.setUserName(t_app.getUsername());
			customa.setPassword(t_app.getPassword());
			customa.setS_balance(0);
			customa.setC_balance(0);
			customa.setApproved(true);
			customa.setEmployeid(1234);
			customa.setA_number(a_number);
			customersImp.saveApplication(customa);
			//customerImp.deleteApp(application);
			
			
			
		}
		else if(mat==2){
			CustomerImp customerImp=new CustomerImp();
			List<Applications> appps=new ArrayList<>();
			CustomerImp customer=new CustomerImp();
			appps=customer.getAllApplications();
			List<Applications> a_apps=new ArrayList<>();
			for(Applications p:appps)
			{
				if(p.isApplied()==true){
					a_apps.add(p);
					
				}
				
			}
			System.out.println(a_apps.toString());
			System.out.print("Please Enter Id of applicant you would like to except or Press 1 to exit: ");
			
			Scanner ssc=new Scanner(System.in);
			int ip=0;
			while(ip==0)
			{
				try{
					ip=ssc.nextInt();
				}catch(Exception e) {
					System.out.println("Oops it looks like this account does not exist!");
					ssc.next();
				}
			}
			Applications application=new Applications();
			boolean exists=false;
			for(Applications ap : appps) {
				if(ap.getId()==ip) {
					exists=true;
					application=ap;
				}
			}
			if(exists==true) {
			RejectedApps rejectedApps=new RejectedApps();
			try {
				rejectedApps.saveApplication(application);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customer.deleteApp(application);
		}
			else {
				
					System.out.println("Sorry application does not exist");
				}
			}
		
		
		}
		else {
			adminMenu();
		}
		
		}
	public void editCustomers() {
		CustomersImp customersImp=new CustomersImp();
		System.out.println(this.customers.toString());
		Customer customer=new Customer();
		System.out.println("0 to Exit");
		System.out.println("Please Enter Username and account number you would like to edit: ");
		Scanner scanner = new Scanner(System.in);
		 String username=null;
		 System.out.println("username: ");
		while(username==null){
			try{
				username=scanner.nextLine();
				
			}catch(Exception e){
				System.out.println("Invalid Entry");
				scanner.next();
			}
		}
		System.out.println("account number: ");
		int aNumber=-111;
		while(aNumber==-111){
			try{
				aNumber=scanner.nextInt();
				
			}catch(Exception e){
				System.out.println("Invalid Entry");
			}
		}
		boolean opt=false;
		for(Customer c:customers){
			if(c.getA_number()==aNumber){
				if(c.getUserName().equals(username))
				customer=c;
				opt=true;
				break;
			}
		}
		if(opt==false) {
			System.out.println("Customer does not exists");
		}
		else if(opt==true){
			boolean editMenu=true;
			while(editMenu) {
			System.out.println("Customer: "+customer.toString());
			System.out.println("0.To Exit");
			System.out.println("1.Check checking Balance");
			System.out.println("2.Check savings Balance");
			System.out.println("3.Deposit into Checking");
			System.out.println("4.Deposit into Savings");
			System.out.println("5.Checking withdrawl");
			System.out.println("6.Savings withdrawl");
			System.out.println("7.Transfer");
			
			Scanner c_choice=new Scanner(System.in);
			int cc_choice=-111;
			while(cc_choice==-111){
				try {
				cc_choice=c_choice.nextInt();
				if(cc_choice<0||cc_choice>7){
					cc_choice=-111;
					System.out.println("Input not valid");
				}
				
			}catch(Exception e){
				System.out.println("Wrong Input!");
				c_choice.next();
				
			
				}
			}
			if(cc_choice==0)
			{
				editMenu=false;
			}
			else if(cc_choice==1){
				
				System.out.println("Your checking account balance: "+customer.getC_balance());
			}
			else if(cc_choice==2){
				System.out.println("Your savings account balance: "+customer.getS_balance());
			}
			else if(cc_choice==3){
				System.out.println("How much would like to deposit?");
				double amount=0;
				while(amount==0) {
					try {
				amount=c_choice.nextDouble();
				if(amount<0){
					System.out.println("invalid operation!");
					amount=0;
				}
					}catch(Exception e){
						c_choice.next();
						System.out.println("invalid operation!");
						
					}
				}
				customersImp.depositChecking(amount, customer);
				customer.setC_balance(customer.getC_balance()+amount);
				System.out.println("Here is your new balance: "+customer.getC_balance());
				
				
			}
			else if(cc_choice==4) {
				System.out.println("How much would like to deposit?");
				double amount=0;
				while(amount==0) {
					try {
				amount=c_choice.nextDouble();
				if(amount<0){
					System.out.println("invalid operation!");
					amount=0;
				}
					}catch(Exception e){
						c_choice.next();
						System.out.println("invalid operation!");
						
					}
				}
				customersImp.depositSavings(amount, customer);
				customer.setS_balance(customer.getS_balance()+amount);
				System.out.println("Here is your new balance: "+customer.getS_balance());
				
			}
			else if(cc_choice==5){
				System.out.println("How much would like to withdrawl?: 0 to exit ");
				double amount=-111;
				while(amount==-111) {
					try {
				amount=c_choice.nextDouble();
				if(amount<0){
					System.out.println("invalid operation!");
					amount=-111;
				}
					}catch(Exception e){
						c_choice.next();
						System.out.println("invalid operation!");
						
					}
				}
				customersImp.widthrawlChecking(amount, customer);
				if(amount>customer.getC_balance()) {
					System.out.println("insufficient funds for withdrawl");
				}
				else {
				customer.setC_balance(customer.getC_balance()-amount);
				System.out.println("Here is your new balance: "+customer.getC_balance());
				}
				
			}
			else if(cc_choice==6) {
				System.out.println("How much would like to withdrawl?: 0 to exit ");
				double amount=-111;
				while(amount==-111) {
					try {
				amount=c_choice.nextDouble();
				if(amount<0){
					System.out.println("invalid operation!");
					amount=-111;
				}
					}catch(Exception e){
						c_choice.next();
						System.out.println("invalid operation!");
						
					}
				}
				customersImp.widthrawlSavings(amount, customer);
				if(amount>customer.getS_balance()) {
					System.out.println("insufficient funds for withdrawl");
				}
				else {
				customer.setS_balance(customer.getS_balance()-amount);
				System.out.println("Here is your new balance: "+customer.getS_balance());
				}
				
			}
			else if(cc_choice==7) {
				System.out.println("Would you like to transfer from your\n1.checking account\n2.savings account\npress 0 to exit");
				
				int trans=-111;
				while(trans==-111){
					try {
						trans=scanner.nextInt();
						if(trans<0||trans>2){
							trans=-111;
							System.out.println("invalid input!");
							
						}
					}catch(Exception e) {
						System.out.println("invalid input!");
						scanner.next();
					}
				}
				if(trans==1){
					double amount=-111;
					System.out.println("Please enter username of the account you would like to send funds to or 0 to exit a: ");
					Scanner o_c= new Scanner(System.in);
					String r_an=null;
					while(r_an==null){
						try {
							r_an=o_c.nextLine();
							
						}catch(Exception e) {
							o_c.next();
							System.out.println("Invalid Input!");
						}
					}
					boolean user=false;
					Customer t_trans=new Customer();
					for(Customer c:customers) {
						if(c.getUserName().equals(r_an)) {
							t_trans=c;
							System.out.println("How much would like to transfer? 0 to exit");
							while(amount==-111) {
							try{
								amount=o_c.nextDouble();
								if(amount<0) {
									amount=-111;
									System.out.println("Operation invalid");
								}
								}catch(Exception e) {
									System.out.println("Operation invalid");
									o_c.next();
								}
							
							}
							if(amount<customer.getC_balance()) {
								System.out.println("Transfer to "+ t_trans.getUserName()+" Was successful!");
								customersImp.transferS(amount, customer, t_trans);
								customer.setS_balance(customer.getS_balance()-amount);
								user=true;
								}
								else {
									System.out.println("Not enough Funds!");
								}
						}
					}
					
				}
				else if(trans==2){
					double amount=-111;
					System.out.println("Please enter username of the account you would like to send funds to or 0 to exit a: ");
					Scanner o_c= new Scanner(System.in);
					CustomersImp customers=new CustomersImp();
					List<Customer> customerrs=new ArrayList<>();
					customerrs=customers.getAllCustomer();
					String r_an=null;
					while(r_an==null){
						try {
							r_an=o_c.nextLine();
							
						}catch(Exception e) {
							o_c.next();
							System.out.println("Invalid Input!");
						}
					}
					boolean user=false;
					Customer t_trans=new Customer();
					for(Customer c:customerrs) {
						if(c.getUserName().equals(r_an)) {
							t_trans=c;
							System.out.println("How much would like to transfer? 0 to exit");
							while(amount==-111) {
							try{
								amount=o_c.nextDouble();
								if(amount<0) {
									amount=-111;
									System.out.println("Operation invalid");
								}
								}catch(Exception e) {
									System.out.println("Operation invalid");
									o_c.next();
								}
							
							}
							if(amount<customer.getC_balance()) {
								System.out.println("Transfer to "+ t_trans.getUserName()+" Was successful!");
								customersImp.transferS(amount, customer, t_trans);
								customer.setS_balance(customer.getS_balance()-amount);
								user=true;
								}
								else {
									System.out.println("Not enough Funds!");
								}
						}
					}
					
					
				}
				
				
			}
			
			
			
		}
	}
		
	
	
}
	public void AdminLogin() {
		System.out.println("Please Enter Username: ");
		Scanner sc= new Scanner(System.in);
		String username=null;
		String password=null;
		CustomerImp customerImp=new CustomerImp();
		List<Admin> admins=new ArrayList<>();
		admins=customerImp.getAllAdmins();
		
		
		while(username==null) {
			try {
				username=sc.nextLine();
			}catch(Exception e) {
				System.out.println("Invalid Input!");
				sc.next();
			}
		}
		System.out.println("Please Enter your password: ");
		while(password==null) {
			try {
				password=sc.nextLine();
			}catch(Exception e) {
				System.out.println("Invalid Input!");
				sc.next();
			}
		}
		for(Admin a:admins)
		{
			if(a.getUserName().equals(username)){
				if(a.getPassword().equals(password)) {
					adminMenu();
					
				}
				else {
					System.out.println("Wrong Password!");
				}
			}
		}
		
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
