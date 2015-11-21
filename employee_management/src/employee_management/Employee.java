package employee_management;


import java.util.Date;

public class Employee {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private int age;
	@SuppressWarnings("deprecation")
	private final int CURRENT_YEAR = new Date().getYear() +1900;
	
	
	
	


	public Employee(String firstName, String lastName, Date dateOfBirth, String gender) throws NullPointerException,IllegalArgumentException {
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
		if (validateDate(dateOfBirth)){
			this.dateOfBirth = dateOfBirth;
		}else{
			throw new IllegalArgumentException("The date must be between 1900 and current year - 18");
		}
		if(validateGender(gender)){
			this.gender = gender;
		}else{
			throw new IllegalArgumentException("The gender must be <male>,<female> or undeclared");
		}
		setAge(dateOfBirth);
		
	}
	
	public Employee(String firstName, String lastName, Date dateOfBirth) throws NullPointerException,IllegalArgumentException {
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
		if (validateDate(dateOfBirth)){
			this.dateOfBirth = dateOfBirth;
		}else{
			throw new IllegalArgumentException("The date must be between 1900 and current year - 18");
		}
		setAge(dateOfBirth);
		
	}
	
	/**
	 * @return the age
	 */
	protected final int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	@SuppressWarnings("deprecation")
	private final void setAge(Date date) {
		this.age =CURRENT_YEAR-date.getYear();
	}

	/**
	 * @return the firstName
	 */
	protected final String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	protected final String getLastName() {
		return lastName;
	}
	/**
	 * @return the dateOfBirth
	 */
	protected final Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	protected final String getGender() {
		return gender;
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
	
 	@SuppressWarnings("deprecation")
	private final boolean validateDate(Date dateOfBirth){
 		if (dateOfBirth == null){
 			return false;
 		}
		if (dateOfBirth.getYear()<1900){
			return false;
		}
		
		if (dateOfBirth.getYear()>CURRENT_YEAR-18){
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
		result = prime * result + age;
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
		if (age != other.age)
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

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age
				+ "]";
	}

	
	
	
	
	
}


