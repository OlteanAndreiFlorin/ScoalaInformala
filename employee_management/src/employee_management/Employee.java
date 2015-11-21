package employee_management;

import java.util.Date;

public class Employee {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	
	
	


	public Employee(String firstName, String lastName, Date dateOfBirth, String gender) throws RuntimeException {
		super();
		if (firstName.isEmpty()){
			throw new NullPointerException("Name can't be empty");
		}else{
			this.firstName = firstName;
		}
		if (lastName.isEmpty()){
			throw new NullPointerException("Name can't be empty");
		}else{
			this.lastName = lastName;
		}
		if (validateAge(dateOfBirth)){
			this.dateOfBirth = dateOfBirth;
		}else{
			throw new IllegalArgumentException("The date must be between 1900 and current year - 18");
		}
		if(validateGender(gender)){
			this.gender = gender;
		}else{
			throw new IllegalArgumentException("The gender must be <male>,<female> or undeclared");
		}
		
	}
	
	private final boolean validateGender(String gender){
		if ("male".equals(gender)){
			return true;
		}
		if ("female".equals(gender)){
			return true;
		}
		if (gender == null){
			return true;
		}
		return false;
	}
	
 	private final boolean validateAge(Date dateOfBirth){
 		if (dateOfBirth == null){
 			return false;
 		}
		if (dateOfBirth.getYear()<1900){
			return false;
		}
		
		Date date = new Date();
		int currentYear = date.getYear()+1900;
		
		if (dateOfBirth.getYear()>currentYear-18){
			return false;
		}
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + "]";
	}
	
	
	
	
}


