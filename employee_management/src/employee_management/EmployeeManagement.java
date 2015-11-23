package employee_management;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * EmployeeManagement class defines which can store Employee's in am list 
 * remove Employees from a list 
 * List employee's by name and date 
 * or list employees with the same age/last name;  
 * @author Oltean Andrei-Florin;
 *
 */
public class EmployeeManagement {

	private static final Comparator<Employee> COMPARE_BY_FIRST_NAME = new Comparator<Employee>(){//Custom Comparator for first name
		@Override
		public int compare(Employee e1 , Employee e2){
			return e1.getFirstName().compareTo(e2.getFirstName());
			}
	};
	private static final Comparator<Employee> COMPARE_BY_LAST_NAME = new Comparator<Employee>(){//Custom Comparator for Last name
		@Override
		public int compare(Employee e1 , Employee e2){
			return e1.getLastName().compareTo(e2.getLastName());
			}
	};
	private static final Comparator<Employee> COMPARE_BY_DATE_OF_BIRTH = new Comparator<Employee>(){//Custom Comparator for Date
		@Override
		public int compare(Employee e1 , Employee e2){
			return e1.getDateOfBirth().compareTo(e2.getDateOfBirth());
			}
	};
	
	
	private List<Employee> employeeList = new ArrayList<>();//The list where the employees will be stored
	


	/**
	 * @return the Employee list or null if the employeeList is empty
	 */
	public final List<Employee> getEmployeeList() {
		return new ArrayList<>(employeeList);
	}


/**
 * Adds an employee to an internal list;
 * @param e Employee to be added;
 * @throws ClassCastException
 * @throws NullPointerException
 */
	public final void addEmployee(Employee e) throws ClassCastException,NullPointerException{
	
		if (e!=null){
			employeeList.add(e);
		}else{
			throw new NullPointerException("Invalid employee to be added");
		}
			
		
	}
	/**
	 * Deletes an employee from the list;
	 * @param e Employee to be removed;
	 * @return true if the employee was in the list;
	 * @throws ClassCastException
	 * @throws NullPointerException
	 */
	public final boolean deleteEmployee(Employee e)throws ClassCastException,NullPointerException{
		if(e!=null){
			return (employeeList.remove(e));
		}else{
			throw new NullPointerException("Employee can not be null");
		}
	}
	/**
	 * @return A list with the employee's sorted by First name;
	 */
	public final List<Employee> listEployeeByFirstName(){
		List<Employee> list = new LinkedList<Employee>(employeeList);
		Collections.sort(list, COMPARE_BY_FIRST_NAME);
		return list;
	}
	/**
	 * 
	 * @return A list with the employee's sorted by Last name;
	 */
	public final List<Employee> listEployeeByLastName(){
		List<Employee> list = new LinkedList<Employee>(employeeList);
		Collections.sort(list, COMPARE_BY_LAST_NAME);
		return list;
	}
	/**
	 * 
	 * @return A list with the employee's sorted by DATE not by age;
	 */
	public final List<Employee> listEployeeByDate(){
		List<Employee> list = new LinkedList<Employee>(employeeList);
		Collections.sort(list, COMPARE_BY_DATE_OF_BIRTH);
		return list;
	}
	/**
	 * 
	 * @param age
	 * @return A list with the employee's that share the same age
	 */
	public final List<Employee>  listEmployeesWithAge(int age){
		List<Employee> list = new LinkedList<>();
		for (Employee e : employeeList){
			if (e.getAge() == age){
				list.add(e);
			}
		}
		for(Employee e : list){
			System.out.println(e);
		}
		return list;
			
	}
	/**
	 * 
	 * @param lastName
	 * @returnA list with the employee's that share the same Last name;
	 */
	public final List<Employee>  listEmployeesWithLastName(String lastName){
		List<Employee> list = new LinkedList<>();
		for (Employee e : employeeList){
			if (e.getLastName().equals(lastName) ){
				list.add(e);
			}
		}
		for(Employee e : list){
			System.out.println(e);
		}
		return list;
			
	}


	public EmployeeManagement() {
		super();
	}
	
}
	
	

