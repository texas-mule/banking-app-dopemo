package com.reveture.mohamad;
import java.util.List;
import java.util.ArrayList; 
import java.util.InputMismatchException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		List<Applications> apps=new ArrayList<>();
		CustomerImp customer=new CustomerImp();
		apps=customer.getAllApplications();
		System.out.println(apps.toString());
		List<Employee> employee=new ArrayList<>();
		EmployeeImp employeeImp=new EmployeeImp();
		employee=employeeImp.getAllEmployees();
		System.out.println(employee.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		boolean flag=true;
//		
//		while(flag) {
//		
//		System.out.println("Welcome to our Bank!");
//		
//		System.out.println("Please Select from the following options...\n");
//		
//		System.out.print("1.Register for Account\n\n2.Login in to your account\n\n3.Employee Login\n\n4.Exit\n\n");
//		
//		Scanner sc=new Scanner(System.in);
//		
//		Bank bank=new Bank();
//		
//		String s=bank.toString();
//		
//		int choice=0;
//		
//		
//		try {
//		choice=sc.nextInt();
//		}catch (InputMismatchException e) {
//            sc.next();
//           
//            System.out.println("Invalid choice");
//        }
//		if(choice==4) {
//			
//
//			flag=false;
//		}
//		else if(choice==1) {
//			boolean registration=true;
//			while(registration) {
//			System.out.println("Please Enter Username and Password");
//			Scanner user_scan=new Scanner(System.in);
//			String user_name=user_scan.nextLine();
//			String password=user_scan.nextLine();
//			System.out.println("Here is Your User Name: "+user_name+" and Password "+password+"\n");
//			System.out.println("Would you like to register for a bank account?\n\n1.Apply for Bank Account\n\n2.Exit");
//			int a_option=user_scan.nextInt();
//			if(a_option==1){
//				System.out.println("Please Enter first name followed by the last name");
//				Scanner app_info=new Scanner(System.in);
//				String f_name=app_info.nextLine();
//				String l_name=app_info.nextLine();
//				
//				
//			}
//			else if(a_option==2){
//				registration=false;
//				
//				}
//			
//			
//			}
//			
//			
//			
//		}
//		
//		
//	}
//		System.out.println("Thank you!");
			

	}
}


	
