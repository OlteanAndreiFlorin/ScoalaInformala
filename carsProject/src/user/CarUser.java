package user;

/**
 * The CarUser class implements an application 
 * that serves as an user interface for the car project.
 * The class  uses objects created using classes imported 
 * from the cars package;
 * It also receives input from the user such as:
 * the chassis number,fuel level and gear (validates every input);
 *  
 */

import java.util.Scanner;

import cars.*;

public class CarUser {

	private String carName;
	private String chassisNumber;
	private String temporaryInput;
	private double fuel;
	private String currentAction;
	private Car newCar;
	
/**
 * The main method creates a new CarUser() and invokes the 
 * createNewCar() method followed by the useCar() method 
 */
	public static void main(String[] args) {
		CarUser newCarUser = new CarUser();
		newCarUser.createNewCar();
		newCarUser.useCar();

	}

	/**
	 * Creates a new Car() and initializes it with a user specified type;
	 * 
	 */
	public void createNewCar() {
		boolean okInput;
		do{
			System.out.println("What car do you want to drive?");
			System.out.println("You have 4 cars. 2 Lotus(Elise and Exige )and 2 Tesla(Model S and Model X)");
			readInput("CarName");
			okInput=verifyInput("CarName");
			if (!okInput) {
				System.out.println("You dont have that car try again");
				System.out.println();
			}
		}while(!okInput);
		getCarNecessities();
		setNewCar();
	}
	
	private void getCarNecessities() { //Asks for details on the current car and validates the input
		System.out.println("Give me FUEL give me Power give me a chassis number :P");
		boolean okInput;
		do{
			System.out.println("Type fuel ammount");
			readInput("TemporaryInput");
			okInput = verifyIfNumber(temporaryInput, "Double");
			if (okInput) {
				this.fuel= Float.parseFloat(temporaryInput);
			}else{
				System.out.println("What? T.. try again.");
			}
		}while(!okInput);
		System.out.println("Type in the cassis Number");
		readInput("ChassisNumber");
	}
	private void setNewCar() {// initializes the car with the provided info
		switch (carName){
		case "Elise":
			this.newCar = new Elise(this.fuel,this.chassisNumber);
			break;
		case "Exige":
			this.newCar = new ExigeSCoupe(this.fuel,this.chassisNumber);
			break;
		case "Model S":
			this.newCar = new ModelS(this.fuel,this.chassisNumber);
			break;
		case "Model X":
			this.newCar = new ModelX(this.fuel,this.chassisNumber);
			break;
		}
	}

	/**
	 * Prints out instructions for the user
	 * receives and validates input from the user
	 * and saves the current action in a field
	 * executes the action ;
	 */
	public void useCar() {
		System.out.println("You have selected the "+carName+" nice choice");
		boolean ok;
		do{
			System.out.println("What do you want to do with the car");
			System.out.println("You can : star, drive, stop, shift gear,");
			System.out.println("  *get trip length, get pollution, get fuel consumption,");
			System.out.println("  *get available fuel, type chassis number");
			System.out.println("You can also exit the car by typing in exit");
			readInput("CurrentAction");
			if("exit".equals(currentAction)){
				System.out.println("See you later");
				System.exit(0);
			}
			ok=verifyInput("CurrentAction");
			if (!ok) {
				System.out.println("You dont have that option try again");
				System.out.println();
			}else{
				executeUserRequest();
			}
		}while(true);
		
	}
	
	private void executeUserRequest() {//For the currentAction invokes the necessary method 
		switch (this.currentAction){
		case "start":
			newCar.start();
			break;
		case "drive":
			System.out.println("How mutch do you want to drive?");
			readInput("TemporaryInput");
			if(!verifyIfNumber(temporaryInput, "Double")){ // verifyes if the given nr is a double by invoking a method
				System.out.println(temporaryInput+" Is not a valid trip length!!! Comme on");
				System.exit(0);
			}
			double tripLength = Double.parseDouble(temporaryInput);
			newCar.drive(tripLength);
			break;			
		case "stop":
			newCar.stop();
			break;
		case "shift gear":
			System.out.println("What gear?");
			readInput("TemporaryInput");
			if(!verifyIfNumber(temporaryInput, "int")){
				System.out.println(temporaryInput+" Is not a valid gear!!! Comme on");
				System.exit(0);
			}
			int gear = Integer.parseInt(temporaryInput);
			newCar.shiftGear(gear);
			break;
		case "get trip length":
			System.out.println("you drove for "+newCar.getTripTotalLength());
			break;
		case "get pollution":
			System.out.println("You polluted an avarage of "+newCar.getPollution()+" Co2 g/km this trip");
			break;
		case "get fuel consumption":
			System.out.println("You consumed an avarage of "+newCar.getAverageFuelConsumption()+"L/% "+newCar.getFuelType()+" this trip");
			break;
		case "get available fuel":
			System.out.println("You have "+newCar.getAvailableFuel()+" fuel left");
			break;
		case "type chassis number":
			printChassisNumber();
			break;
		}
		
	}

	private void printChassisNumber() {//prints the chassis number for the current car;
		switch (this.carName){
		case "Elise":
			Elise elise;
			elise = (Elise)newCar;
			System.out.println("The number is "+elise.getChassisNumber());
			break;
		case "Exige":
			ExigeSCoupe exige;
			exige = (ExigeSCoupe)newCar;
			System.out.println("The number is "+exige.getChassisNumber());
			break;
		case "Model S":
			ModelS modelS;
			modelS = (ModelS)newCar;
			System.out.println("The number is "+modelS.getChassisNumber());
			break;
		case "Model X":
			ModelX modelX;
			modelX = (ModelX)newCar;
			System.out.println("The number is "+modelX.getChassisNumber());
			break;
		}
			
		
	}


	private void readInput(String argument) {//reads the input from the user
		Scanner sc = new Scanner(System.in);
		switch (argument){
		case "CarName":
			this.carName = sc.nextLine();
			break;
		case "CurrentAction":
			this.currentAction = sc.nextLine();
			break;
		case "TemporaryInput":
			this.temporaryInput = sc.nextLine();
			break;
		case "ChassisNumber" :
			this.chassisNumber = sc.nextLine();
			break;
		}
	}
	private boolean verifyInput(String argument) {//verifies the user input
		switch (argument){
		case "CarName":
			switch (this.carName){
			case "Elise":
				return true;
			case "Exige":
				return true;
			case "Model S":
				return true;
			case "Model X":
				return true;
			default: 
				return false;
			}
		case "CurrentAction":
			switch (this.currentAction){
			case "start":
				return true;
			case "drive":
				return true;
			case "stop":
				return true;
			case "shift gear":
				return true;
			case "get trip length":
				return true;
			case "get pollution":
				return true;
			case "get fuel consumption":
				return true;
			case "get available fuel":
				return true;
			case"type chassis number":
				return true;
			
			default:
				return false;
			}
		default:
			System.out.println("Error in code!!!!!");
			return false;
			
		}
	}
	private boolean verifyIfNumber(String temp ,String typeOfNo){//verifies if the given param temp is a specified number type 
		if("int".equals(typeOfNo)){
			int intNumber;
			try {
				intNumber = Integer.parseInt(temp);
			}catch(NumberFormatException ignore){
				return false;
			}
			if (intNumber >= 0){
				return true;
			}else{
				System.out.println("The number ca not be negative");
				return false;
			}
		}else{
			double doubleNumber;
			try {
				doubleNumber = Double.parseDouble(temp);
			}catch(NumberFormatException ignore){
				return false;
			}
			if (doubleNumber>= 0){
				return true;
			}else{
				System.out.println("The number ca not be negative");
				return false;
			}
		}
	}
	

}
