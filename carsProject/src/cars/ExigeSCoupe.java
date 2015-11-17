package cars;

/**
 * ExigeScoupe class;
 * Extends the Lotus Class;
 * 
 * Class defines rules used when calculating fuel consumption
 * and pollution created;
 * 
 * It also defines some states like fuel tank size, fuel type, maximum number of gears etc. 
 * @author oltea
 *
 */
public class ExigeSCoupe extends Lotus {
	protected static final float FuelTankSize =60; //Factory specifications
	protected static final String FuelType="Petrol"; //Factory specifications
	protected static final int MaxNumberOfGears=6; //Factory specifications
	protected static final float Pollution=235; //Factory specifications co2 g/km
	protected static final float FuelConsumedAtStart=0.45f;//Custom consumption of fuel at the start of the motor may vary from reality
	protected static final float FuelConsumptionAvarage = 10.1f; //Factory specifications liters/100km combined
	protected static final float FuelConsumtionAvarageUrban = 14.5f;//Factory specifications liters/100km urban environment
	protected static final float FuelConsumtionAvarageExtraUrban = 7.6f;//Factory specifications liters/100km extraUrban environment
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
			return FuelConsumtionAvarageUrban;
		}else{
			return FuelConsumtionAvarageExtraUrban;
		}
	}
	/**
	 * Calculates the fuel consumed at the start;
	 */
	@Override
	protected float calculateStarPollution() {
		float co2Produced = FuelConsumedAtStart * 2392;  //1 L of gasoline produces 2392 g of co2
		return co2Produced;
	}
	/**
	 * Returns the fuel consumed at the start 
	 */
	@Override
	protected float getFuelConsumedAtStart() {
		return FuelConsumedAtStart;
	}

/**
 * Implementation for the getCo2Emissions() method from parent class
 * returns Co2 produced for a given amount of fuel consumed;   
 */
	@Override
	protected float getCo2Emissions(float currentFuelConsumption) {
		float currentCo2Emmisions = currentFuelConsumption * Pollution / FuelConsumptionAvarage;
		return currentCo2Emmisions;
	}
	/**
	 * Constructor method for the ExigeSCpuoe class
	 * @param availableFuel 
	 * @param chassisNumber 
	 */
	public ExigeSCoupe(double availableFuel,String chassisNumber){
		super(FuelTankSize, FuelType, MaxNumberOfGears, (float)availableFuel);
		if (availableFuel>FuelTankSize ){
			System.out.println("Too much fuel");
			System.exit(0);
		}
		this.ChassisNumber = chassisNumber;
	}

	
}