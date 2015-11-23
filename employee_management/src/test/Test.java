package test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import employee_management.*;

/**
 * Test class only purpose is to play around with the Employee management classe's 
 * @author Oltean Andrei-Florin
 *
 */
public class Test {

	public static void main(String[] args) {
		
		
		
		EmployeeManagement em = new EmployeeManagement();
		
		
			Employee e1 = new Employee("andrei","oltean",new Date(1992, 8, 27),"male");
			Employee e2 = new Employee("andrea","mihaiu",new Date(1982, 3, 20),"female");
			Employee e3 = new Employee("george","marian",new Date(1989, 2, 3),"male");
			Employee e4 = new Employee("andra","oltean",new Date(1992, 8, 19),"female");
			Employee e6 = new Employee("andra","oltean",new Date(1992, 8, 19),"female");
			Employee e5 = new Employee("darius","radu",new Date(1989, 5, 30));
			print(e1);
			print(e2);
			print(e3);
			print(e4);
			print(e5);//testing the to string from Employee class;
			
			
			
			em.addEmployee(e1);//adding employee's to the lists 
			em.addEmployee(e2);
			em.addEmployee(e3);
			em.addEmployee(e4);
			em.addEmployee(e5);
			em.addEmployee(e6);
			
			try{//trying to add an null object to the list
				em.addEmployee(null);
			}catch(NullPointerException n){
				System.out.println(n);
			}
		
			
			
		printEmployees(em);//printing all the current employees in the list 
		
			
			
		List<Employee> lFirstName = em.listEployeeByFirstName(); //Listing all the employees by name
		
		for(Employee e : lFirstName){
			System.out.println(e);
			
		}
		
		System.out.println();
		List<Employee> lLastName = em.listEployeeByLastName(); //Listing all the Employees by the LAst name 
		
		for(Employee e : lLastName){
			System.out.println(e);
		}
		System.out.println();
		
		List<Employee> lDate = em.listEployeeByDate();//listing all employees By date of birth  
		
		for(Employee e : lDate){
			System.out.println(e);
		}
		
	
		 
		System.out.println();
		em.listEmployeesWithAge(23); // all the employee's with the age 23
		
		System.out.println();
		em.listEmployeesWithLastName("oltean");// all the employee's with the name oltean
			

	}

	public static void printEmployees(EmployeeManagement em) {
		List<Employee> testL = new LinkedList<>(em.getEmployeeList());
		System.out.println();
		for(Employee e : testL){
			System.out.println(e);
		}
		System.out.println();
	}

	public static void print(Employee e) {
		System.out.println(e);
		System.out.println(e.hashCode());
	}

}
