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
		
		while(flag==true) {
		
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
				
				

				boolean in_userMenu=true;
				int temp1=addApplication(app);
				if(temp1==1) {
				while(in_userMenu) {
					int new_user=newUserMenu();
					
					if(new_user==1) {
						System.out.println("Application was sent and Pending approval");
						in_userMenu=false;
					}
					if(new_user==2) {
						in_userMenu=false;
					}
				}
				
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
						System.out.println(appps.toString());
						System.out.print("Please Enter Id of applicant you would like to except: ");
						System.out.println("1.Exit");
						
						Scanner ssc=new Scanner(System.in);
						int ip=0;
						while(ip==0)
						{
							try {
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
						System.out.println("\n\nPlease enter the account number: ");
						
						Scanner cancell=new Scanner(System.in);
						int cacl=0;
						while(cacl==0){
							try {
								cacl=cancell.nextInt();
							}catch(Exception e) {
								System.out.println("Wrong Input!");
								cancell.next();
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
		
		while(selection==0) {
			try {
        
			
        	if(selection<=0||selection>4) 
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
public static int newUserMenu() {
	
	int selection;
	
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
			System.out.println("User already exists");
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
public static void employeeMenu(Employee employee) {
	welcomeMessage("Welcome "+employee.getFirstname());
	System.out.println("What would like to do today?");
	System.out.println("1.See your customers");
	System.out.println("2.Approve Applications");
	System.out.println("3.Cancell Accounts");
	System.out.println("4.Exit Portal");
}

}
		