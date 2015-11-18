package cars;
/**
 *Car is the abstract bases class for all cars created.
 *It implements the Vehicle() interface.
 *
 *
 * @author Oltean Andrei-Florin
 *
 */
public abstract class Car implements Vehicle {

	protected final float FuelTankSize; //Factory specifications
	protected final String FuelType; //Factory specifications
	protected final int MaxNumberOfGears; //Factory specifications
	protected float availableFuel;
	protected float fuleConsumedThisTrip = 0;
	protected float pollutionThisTrip  = 0;
	protected float tripLengthTotal=0;
	private int currentGear=0;
	private float totalFuelUsed=0;
	private float totalPollutionStats=0;
	private boolean carStatus;
	
/**
 * Overwrites the vehicle() implementation 
 * implementing the start() method for the Car() object;
 * saves the fuel consumed and pollution created when "starting a car";
 * invokes the System.exit(); method when the 
 * car is started while running or
 * when the car is started in a >1'st gear ;
 */
	@Override
	public void start() {
		if (carStatus){
			System.out.println("The car was alredy started you broke it!!");
			System.exit(0);
		}
		this.carStatus = true;
		if (this.currentGear>1){
			System.out.println("Nice you broke the car :|,who starts their car in "+ this.currentGear+"nd/rd gear");
			System.exit(0);
		}
		System.out.println("Car has started");
		saveStats(getFuelConsumedAtStart(),calculateStarPollution());
		resetStats();

	}

	/**
	 *Calculates the fuel consumed in a certain trip length;
	 *Invokes System.exit() if the car remains with no fuel 
	 *Saves the fuel consumed and pollution for the given length;
	 */
	@Override
	public void drive(double tripLength) {
		if(!carStatus){
			System.out.println("The car was not started yet, i will start it for you!");
			start();
		}
		float fuelConsumed = calculateFuelConsumption((float)tripLength, getGear());
		if ((this.availableFuel - fuelConsumed)<=0){
			System.out.println("Well shoot no more gass");
			System.exit(0);
		}
		manadgeDriveModificationsToFields(tripLength, fuelConsumed);
	}

	private void manadgeDriveModificationsToFields(double tripLength, float fuelConsumed) {//Manages the states of the car 
		this.availableFuel-=fuelConsumed;
		this.fuleConsumedThisTrip += fuelConsumed;
		this.pollutionThisTrip += calculatePollution((float)tripLength, fuelConsumed);
		this.tripLengthTotal += tripLength;
	}

	/**
	 * Saves consumption and pollution;
	 * Prints out a message confirming the invoking of the method
	 * sets the car status; 
	 */
	@Override
	public void stop() {
		saveStats(getfuleConsumedThisTrip(),getPollutionThisTrip());
		System.out.println("The car has stoped.");
		this.carStatus = false;

	}
/**
 * Shifts the gear saving the new value in the same field 
 * invokes System.exit() if the gear dose not exist
 * @param gear current gear
 */
	public void shiftGear(int gear) {
		if (!carStatus){
			System.out.println("You broke the car!! Dont shift gear when the car stoped!");
			System.out.println(0);
		}
		if (gear >MaxNumberOfGears ){
			System.out.println("Nice you broke the car :| the car only has "+MaxNumberOfGears+" gear/s dude");
			System.exit(0);
		}
		setGear(gear);
	
		
	}
	
	protected abstract float calculateFuelConsumption (float tripLength , int gear);
	
	protected abstract float calculatePollution(float tripLength, float fuelConsumed);
	
	protected abstract float calculateStarPollution();
	
	protected abstract float getFuelConsumedAtStart();
	
	public abstract String getChassisNumber();
	public abstract float getFuelConsumptionAverage();

	
	private void saveStats(float fuelConsumed , float pollution){//Saves the fuel and pollutuin
		this.totalFuelUsed += fuelConsumed;
		this.totalPollutionStats += pollution;
	}

	private void resetStats() {//resets the fuel consumed and pollution when the car is started
		setFuleConsumedThisTrip(0);
		setPollutionThisTrip(0);		
	}
	/**
	 * 
	 * @return The fuel type
	 */
	public String getFuelType() {
		return FuelType;
	}
	
	
	public float getAverageFuelConsumption() {//calculates the avarage fuel consumption / 100km
		if (carStatus&&tripLengthTotal == 0){
			return getFuelConsumedAtStart();
		}
		if (tripLengthTotal == 0){
			return 0;
		}
		float fuelConsumedPer100Km = totalFuelUsed / tripLengthTotal *100 ;
		return fuelConsumedPer100Km;
	}
	public float getPollution() {
		if (carStatus&&tripLengthTotal == 0){
			return calculateStarPollution();
		}
		if (tripLengthTotal == 0){
			return 0;
		}
		float pollutionPerKm = totalPollutionStats / tripLengthTotal;
		return pollutionPerKm;
	}
	
	
	public float getAvailableFuel() {
		return availableFuel;
	}
	
	private float getfuleConsumedThisTrip() {
		return fuleConsumedThisTrip;
	}


	private void setFuleConsumedThisTrip(float fuleConsumedThisTrip) {
		this.fuleConsumedThisTrip = fuleConsumedThisTrip;
	}

	private float getPollutionThisTrip() {
		return pollutionThisTrip;
	}
	
	private void setPollutionThisTrip(float pollutionThisTrip) {
		this.pollutionThisTrip = pollutionThisTrip;
	}

	private int getGear() {
		return currentGear;
	}

	private void setGear(int gear) {
		if(gear < 0){
			System.out.println("That gear dose not exist");
			System.exit(0);
		}
		this.currentGear = gear;
	}

	public float getTripTotalLength() {
		return tripLengthTotal;
	}
	
/**
 * Constructor for the Car class
 * @param fuelTankSize
 * @param fuelType
 * @param maxNumberOfGears
 * @param availableFuel
 */
	public Car(float fuelTankSize, String fuelType, int maxNumberOfGears, float availableFuel) {
		this.FuelTankSize = fuelTankSize;
		FuelType = fuelType;
		MaxNumberOfGears = maxNumberOfGears;
		this.availableFuel = availableFuel;
	}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Car [ChassisNumber=" + getChassisNumber() +", FuelTankSize=" + FuelTankSize + ", FuelType=" + FuelType + ", MaxNumberOfGears=" + MaxNumberOfGears
			+ "]";
}

}
