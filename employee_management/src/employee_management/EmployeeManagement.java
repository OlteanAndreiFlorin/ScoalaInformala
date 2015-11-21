package employee_management;

import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class EmployeeManagement {

	private static final Comparator<Employee> COMPARE_BY_FIRST_NAME = new Comparator<Employee>(){
		@Override
		public int compare(Employee e1 , Employee e2){
			return e1.getFirstName().compareTo(e2.getFirstName());
			}
	};
	private static final Comparator<Employee> COMPARE_BY_LAST_NAME = new Comparator<Employee>(){
		@Override
		public int compare(Employee e1 , Employee e2){
			return e1.getLastName().compareTo(e2.getLastName());
			}
	};
	private static final Comparator<Employee> COMPARE_BY_DATE_OF_BIRTH = new Comparator<Employee>(){
		@Override
		public int compare(Employee e1 , Employee e2){
			return e1.getDateOfBirth().compareTo(e2.getDateOfBirth());
			}
	};
	
	
	private Hashtable<Employee,Employee> employeeMap = new Hashtable<>();
	
	


	/**
	 * @return the Employee list
	 */
	protected final Hashtable<Employee, Employee> getEmployeeList() {
		return new Hashtable<>(employeeMap);
	}



	public final void addEmployee(Employee e){
	
		employeeMap.put(e, e);
	}
	
	public final Employee deleteEmployee(Employee e){
		return (employeeMap.remove(e));
	}
	
	public final List<Employee> listEployeeByFirstName(){
		List<Employee> list = new LinkedList<Employee>(employeeMap.values());
		Collections.sort(list, COMPARE_BY_FIRST_NAME);
		return list;
	}
	
	public final List<Employee> listEployeeByLastName(){
		List<Employee> list = new LinkedList<Employee>(employeeMap.values());
		Collections.sort(list, COMPARE_BY_LAST_NAME);
		return list;
	}
	
	public final List<Employee> listEployeeByDate(){
		List<Employee> list = new LinkedList<Employee>(employeeMap.values());
		Collections.sort(list, COMPARE_BY_DATE_OF_BIRTH);
		return list;
	}
	
	public final List<Employee>  listEmployeesWithAge(int age){
		List<Employee> list = new LinkedList<>();
		for (Employee e : employeeMap.values()){
			if (e.getAge() == age){
				list.add(e);
			}
		}
		for(Employee e : list){
			System.out.println(e);
		}
		return list;
			
	}
	
	public final List<Employee>  listEmployeesWithLastName(String lastName){
		List<Employee> list = new LinkedList<>();
		for (Employee e : employeeMap.values()){
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
	
	

