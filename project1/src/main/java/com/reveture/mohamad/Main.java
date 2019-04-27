package com.reveture.mohamad;
import java.util.List;
import java.util.ArrayList; 
import java.util.InputMismatchException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
//		
//		CustomerImp customer=new CustomerImp();
//		apps=customer.getAllApplications();
//		System.out.println(apps.toString());
//		List<Employee> employee=new ArrayList<>();
//		EmployeeImp employeeImp=new EmployeeImp();
//		employee=employeeImp.getAllEmployees();
//		System.out.println(employee.toString());
		
		
		
		boolean flag=true;
		Applications dude=new Applications();
		while(flag==true) {
		System.out.println(dude.isApplied());
			int input=menu();
			if(input==1) {
				String appInfo=RegisterMenu();
				
				
				
				String temp[]=appInfo.split(" ");
				
				Applications app=new Applications();
				
				app.setFirstname(temp[0]);
				app.setLastname(temp[1]);
				app.setUsername(temp[2]);
				app.setPassword(temp[3]);
				app.setC_score(Integer.parseInt(temp[4]));
				app.setApplied(false);
				
				

				boolean in_userMenu=true;
				int temp1=addApplication(app);
				if(temp1!=1) {
					System.out.println("Sorry User Already exists!");
				
				}
				else {
					while(in_userMenu) {
					int so=newUserMenu(app);
					if(so==1) {
						CustomerImp cst=new CustomerImp();
						cst.apply(app);
						System.out.println("Application has been sent!");
						in_userMenu=false;
					}
					else if(so==2) {
						in_userMenu=false;
					}
					}
				}
			}
			
			else if(input==5) {
				CustomerImp last=new CustomerImp();
				List<Applications> apps=new ArrayList<>();
				Applications user=userlogMenu();
				if(user!=null)
				{
					boolean in_userMnu=true;
					
					while(in_userMnu) {
						System.out.println("Welcome "+ user.getUsername());
						System.out.println("1.Apply for Account");
					    System.out.println("2.Back to Main Menu");
					    System.out.println("3.Check Application Status");
						
						Scanner opt=new Scanner(System.in);
						int t_opt=0;
						while(t_opt==0)
						{
							try {
							t_opt=opt.nextInt();
							}catch(Exception e){
								opt.next();
							}
						}
						if(t_opt==2){
							in_userMnu=false;
							
						}
						if(t_opt==1) 
						{
							if(user.isApplied()){
								System.out.println("Your Application has already been sent!");
								//in_userMnu=false;
							}
							else {
								last.apply(user);
								System.out.println("Application has been sent!");
								//in_userMnu=false;
							}
							
							
						}
					}
					
					
				}
				else {
					System.out.println("Sorry user Does not exist!");
				}
			}

			else if(input==2) {
				boolean random=false;
				Employee employee=new Employee();
				employee=EmpLogginMenu();
				if(!employee.getUsername().equals("non-exist")) {
					
					random=true;
				}
				else {
					System.out.println("Sorry this employee does not exist");
				}
				while(random==true) {
					welcomeMessage("Welcome "+employee.getFirstname());
					System.out.println("What would like to do today?");
					System.out.println("1.See your customers");
					System.out.println("2.Approve Applications");
					System.out.println("3.Cancell Accounts");
					System.out.println("4.Exit Portal");
					Scanner scanner=new Scanner(System.in);
					int temp=0;
							while(temp==0) {
								try{
									temp=scanner.nextInt();
									}catch(Exception e) {
										System.out.print("Wrong input");
										scanner.next();
									}
								}
					if(temp==4) {
						random=false;
					}
					else if(temp==2) {
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
						System.out.println("1.Exit");
						
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
						try {
							
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
							 a_number=ssc.nextInt();
							}catch(Exception e){
								System.out.print("Wrong input");
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
							customa.setFirstName(application.getFirstname());
							customa.setLastName(application.getLastname());
							customa.setUserName(application.getUsername());
							customa.setPassword(application.getPassword());
							customa.setS_balance(0);
							customa.setC_balance(0);
							customa.setApproved(true);
							customa.setEmployeid(employee.getEmployeeid());
							customa.setA_number(a_number);
							customersImp.saveApplication(customa);
							customerImp.deleteApp(application);
							RejectedApps rejectedapps=new RejectedApps();
							rejectedapps.saveApplication(application);
							
							
						}
						 catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
						else if(exists==false) {
							System.out.println("Application does not exists!");
							
						}
						
						
						
						
						
					}
					else if(temp==1) {
						
						CustomersImp customersImps=new CustomersImp();
						
						List<Customer> couts = new ArrayList<>();
						
						couts = customersImps.getAllCustomer();
					
						
						for(Customer cout: couts) {
							if(cout.getEmployeid()==employee.getEmployeeid()){
								
								System.out.println(cout.toString());
								
								
								
							}
						}
						
						
						
						
						
					}
					else if(temp==3) {
						
						
						CustomersImp customersImps=new CustomersImp();
						
						List<Customer> couts = new ArrayList<>();
						
						couts = customersImps.getAllCustomer();
					
						
						for(Customer cout: couts) {
							if(cout.getEmployeid()==employee.getEmployeeid()){
								
								System.out.println(cout.toString());
							}
							
							}
						System.out.println("\n\nPlease enter the account number: or 0 to exit");
						
						
						Scanner cancell=new Scanner(System.in);
						int cacl=0;
						while(cacl==0){
							try {
								cacl=cancell.nextInt();
							}catch(Exception e) {
								System.out.println("Wrong Input!");
								cancell.next();
							}
							if(cacl==0) {
								break;
							}
							
						for(Customer cou: couts) {
							if(cou.getA_number()==cacl) {
								System.out.println("You are deleting "+cou.getFirstName());
								CancelInterface cancelInterface=new CancelInterface();
								try {
									cancelInterface.saveCAccount(cou);
									customersImps.deleteCustomer(cou);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							
						}
						
						
						}
					}
					
				}
				
			}
			else if(input==3){
				boolean pls=true;
				Customer log=userLogin();
				if(log==null) {
					System.out.println("Sorry user does not exist");
				}
				else {
				while(pls) {
				
				CustomersImp cuz=new CustomersImp(); 
				System.out.println("Hello! "+log.getUserName());
				System.out.println("0.To Exit");
				System.out.println("1.Check checking Balance");
				System.out.println("2.Check savings Balance");
				System.out.println("3.Deposit into Checking");
				System.out.println("4.Deposit into Savings");
				System.out.println("5.Checking withdrawl");
				System.out.println("6.Savings withdrawl");
				System.out.println("7.Transfer");
				
				
					
//					System.out.println("Hello "+log.getUserName());
//					System.out.println("1.Check checking Balance");
//					System.out.println("2.Check savings Balance");
//					System.out.println("3.Withdrawl money");
//					System.out.println("4.Deposit");
//					System.out.println("5.Transfers");
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
				if(cc_choice==1){
					
					System.out.println("Your checking account balance: "+log.getC_balance());
				}
				else if(cc_choice==0){
					break;
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
					cuz.depositChecking(amount, log);
					log.setC_balance(log.getC_balance()+amount);
					System.out.println("Here is your new balance: "+log.getC_balance());
					
					
				}
				else if(cc_choice==2){
					System.out.println("Your savings account balance: "+log.getS_balance());
				}
				else if(cc_choice==7) {
					System.out.println("Would you like to transfer from your checking or savings account?");
					
				}
				else if(cc_choice==5){
					System.out.println("How much would like to withdrawl?: ");
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
					cuz.widthrawlChecking(amount, log);
					if(amount>log.getC_balance()) {
						System.out.println("insufficient funds for withdrawl");
					}
					else {
					log.setC_balance(log.getC_balance()-amount);
					System.out.println("Here is your new balance: "+log.getC_balance());
					}
					
				}
					
					
					
				}
				}
				//System.out.println("Sorry User does not exist");
			}
				
}

			
			
			
			
			
		System.out.println("Have a good day!");
		
		}
		
	

	public static int menu() {
		
		int selection=0;
		
        Scanner input = new Scanner(System.in);
       
        
        System.out.println("Welcome to our Bank!");
		
		System.out.println("Please Select from the following options...\n");
		
		System.out.println("1.Register for Account");
		System.out.println("2.Employee Login");
		System.out.println("3.Customer Login");
		System.out.println("4.Admin Login");
		System.out.println("5.User Login");
		
		while(selection==0) {
			try {
        
			
        	if(selection<=0||selection>5) 
        	{
        	
        	selection=0;
        }
        	selection = input.nextInt();
        
			}catch(Exception e) {
				input.next();
				System.out.println("Sorry wrong input");
				
			}
			
		}
        return selection;  
	}
	
	
public static String RegisterMenu() {
		String firstname=null;
		String lastname=null;
		String username=null;
		String password=null;
		int credit_score=0;
		int selection=0;
		
       Scanner input = new Scanner(System.in);
       
       System.out.println("Please Enter: ");
       System.out.println("first name: ");
       while(firstname==null) {
       	try {
           firstname=input.nextLine();
       	}catch(Exception e){
       		System.out.println("Wrong Input");
       		input.next();
       	}
          }
       System.out.println("lastname: ");
       while(lastname==null) {
       	try {
           lastname=input.nextLine();
       	}catch(Exception e){
       		System.out.println("Wrong Input");
       		input.next();
       	}
          }
       System.out.println("Username: ");
       while(username==null) {
    	try {
        username=input.nextLine();
    	}catch(Exception e){
    		System.out.println("Wrong Input");
    	}
       }
       System.out.println("Password: ");
       while(password==null){
    	   try{
    		   password=input.nextLine();
    		   
    	   }catch(Exception e) {
    		   System.out.println("Wrong Input!");
    	   }
       }
       System.out.println("Credit Score: ");
       while(credit_score==0){
    	   try{
    		   credit_score=input.nextInt();
    		   
    	   }catch(Exception e) {
    		   System.out.println("Wrong Input!");
    	   }
       }
       
      
		
		
        
        return firstname+" "+lastname+" "+username+" "+password+" "+Integer.toString(credit_score);  
	}
public static int newUserMenu(Applications app) {
	
	int selection;
	System.out.println("Welcome "+app.getUsername());
    Scanner input = new Scanner(System.in);
    System.out.println("1.Apply for Account");
    System.out.println("2.Back to Main Menu");
	
	
    selection = input.nextInt();
    return selection;  
}
public static int addApplication(Applications app){
	List<Applications>apps=new ArrayList<>();
	
	boolean exists=false;
	
	CustomerImp customerImp=new CustomerImp();
	
	apps=customerImp.getAllApplications();
	//1System.out.print(apps.toString());
	
	for(Applications ap : apps) {
		if(ap.getUsername().equals(app.getUsername())) {
			exists=true;
			return 1;
		}
		
		
	}
	if(exists==false) {
	try {
		customerImp.saveApplication(app);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	else if(exists==true) {
		System.out.println("Start over!\nUser Already exists\n");
		return 2;
	}
	return 1;
}
public static Employee EmpLogginMenu() {
	boolean flag=false;
	Employee t_emp=new Employee();
	String username=null;
	String password=null;
	Scanner sc=new Scanner(System.in);
	System.out.println("Please Enter User Name");
	while(username==null) {
		try {
			username=sc.nextLine();
		}catch(Exception e){
			System.out.print("Wrong input");
		}
	}
	System.out.println("Please Enter Password");
	while(password==null) {
		try {
			password=sc.nextLine();
		}catch(Exception e){
			System.out.print("Wrong input");
		}
		
		
	}
	EmployeeImp employeeImp=new EmployeeImp();
	List<Employee> employees=new ArrayList<>();
	employees=employeeImp.getAllEmployees();
	for(Employee employee: employees) {
		if(employee.getUsername().equals(username)) {
			if(employee.getPassword().equals(password)) {
				flag=true;
				t_emp=employee;
				return t_emp;
				 
			}
			
		}
		else {
			flag=false;
		}
	}
	if(flag==false) {
		t_emp.setUsername("non-exist");
	}
	return t_emp;
	
}
public static void welcomeMessage(String message) {
	System.out.println(message);
}
public static Customer userLogin() {
	
	Scanner sc=new Scanner(System.in);
	String username=null;
	String password=null;
	boolean flag=true;
	System.out.println("Please Enter Username: ");
	while(username==null){
		try{
			username=sc.nextLine();
		}catch(Exception e){
			System.out.println("Wrong input!");
			sc.next();
		}
	}
	
	System.out.println("Please Enter Password:  ");
	while(password==null) {
		try {
			password=sc.nextLine();
		}catch(Exception e) {
			System.out.println("Wrong input!");
			sc.next();
			
		}
	}
	CustomersImp customerImp=new CustomersImp();
	List<Customer> customers=new ArrayList<>();
	customers=customerImp.getAllCustomer();
	Customer cust=new Customer();
	for(Customer c: customers) {
		if(c.getUserName().equals(username)) {
			if(c.getPassword().equals(password)){
				cust=c;
				return cust;
				
			}
		}
	}
	return null;
	
}
static Applications userlogMenu() {
	
	
	Scanner sc=new Scanner(System.in);
	String username=null;
	String password=null;
	boolean flag=true;
	System.out.println("Please Enter Username: ");
	while(username==null){
		try{
			username=sc.nextLine();
		}catch(Exception e){
			System.out.println("Wrong input!");
			sc.next();
		}
	}
	
	System.out.println("Please Enter Password:  ");
	while(password==null) {
		try {
			password=sc.nextLine();
		}catch(Exception e) {
			System.out.println("Wrong input!");
			sc.next();
			
		}
	}
	CustomerImp customerImp=new CustomerImp();
	List<Applications> customers=new ArrayList<>();
	customers=customerImp.getAllApplications();
	Applications cust=new Applications();
	for(Applications c: customers) {
		if(c.getUsername().equals(username)) {
			if(c.getPassword().equals(password)){
				cust=c;
				return cust;
				
			}
		}
	}
	return null;
}

}
		