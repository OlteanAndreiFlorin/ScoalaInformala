package cars;

/**
 * ExigeScoupe class;
 * Extends the Lotus Class;
 * 
 * Class defines rules used when calculating fuel consumption
 * and pollution created;
 * 
 * It also defines some states like fuel tank size, fuel type, maximum number of gears etc. 
 * @author Oltean Andrei-Florin
 *
 */
public class ExigeSCoupe extends Lotus {
	protected static final float FUEL_TANK_SIZE =60; //Factory specifications
	protected static final String FUEL_TYPE="Petrol"; //Factory specifications
	protected static final int MAX_NUMBER_OF_GEARS=6; //Factory specifications
	protected static final float POLLUTION=235; //Factory specifications co2 g/km
	protected static final float FUEL_CONSUMPTION_AT_START=0.45f;//Custom consumption of fuel at the start of the motor may vary from reality
	protected static final float FUEL_CONSUMPTION_AVERAGE = 10.1f; //Factory specifications liters/100km combined
	protected static final float FUEL_CONSUMPTION_AVERAGE_URBAN = 14.5f;//Factory specifications liters/100km urban environment
	protected static final float FUEL_CONSUMPTION_AVERAGE_EXTRA_URBAN = 7.6f;//Factory specifications liters/100km extraUrban environment
	protected final String ChassisNumber;
	
	public String getChassisNumber() {
		return this.ChassisNumber;
	}
	
	/**
	 * calculates the fuel consumption/100km for a given gear;
	 */
	@Override
	protected final float calculateFuelConsumptionAlgorithm(int gear) {
		if (gear == 0){
			return 0;
		}else
		if (gear<4){
			return FUEL_CONSUMPTION_AVERAGE_URBAN;
		}else{
			return FUEL_CONSUMPTION_AVERAGE_EXTRA_URBAN;
		}
	}
	/**
	 * Calculates the fuel consumed at the start;
	 */
	@Override
	protected float calculateStarPollution() {
		float co2Produced = FUEL_CONSUMPTION_AT_START * 2392;  //1 L of gasoline produces 2392 g of co2
		return co2Produced;
	}
	/**
	 * Returns the fuel consumed at the start 
	 */
	@Override
	protected float getFuelConsumedAtStart() {
		return FUEL_CONSUMPTION_AT_START;
	}

/**
 * Implementation for the getCo2Emissions() method from parent class
 * returns Co2 produced for a given amount of fuel consumed;   
 */
	@Override
	protected float getCo2Emissions(float currentFuelConsumption) {
		float currentCo2Emmisions = currentFuelConsumption * POLLUTION / FUEL_CONSUMPTION_AVERAGE;
		return currentCo2Emmisions;
	}
	/**
	 * Constructor method for the ExigeSCpuoe class
	 * @param availableFuel 
	 * @param chassisNumber 
	 */
	public ExigeSCoupe(double availableFuel,String chassisNumber){
		super(FUEL_TANK_SIZE, FUEL_TYPE, MAX_NUMBER_OF_GEARS, (float)availableFuel);
		if (availableFuel>FUEL_TANK_SIZE ){
			System.out.println("Too much fuel");
			System.exit(0);
		}
		this.ChassisNumber = chassisNumber;
	}

	
}