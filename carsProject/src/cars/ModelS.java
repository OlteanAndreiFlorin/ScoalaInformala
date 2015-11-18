package cars;
/**
 * ModelS class
 * Extends Tesla
 * 
 * Class defines states and behaviors for all the instances of ModelS;
 * It provides the algorithm for the fuel consumption specific to this
 * type of car;
 * It also provides factory specifications like range for a full battery
 * and % battery used in 100km;
 * @author Oltean Andrei-Florin
 *
 */
public class ModelS extends Tesla {
	protected static final float BATTERY =100; //Factory specifications represents 100% charged batteries ~ 434.523km or 270 miles
	protected static final String FUEL_TYPEe="Electricity"; //Factory specifications
	protected static final int MAX_NUMBER_OF_GEARS=1; //Factory specifications
	protected static final float BATTERY_USED_IN_100Km=23.0137f; //Represents a % of the battery used in 100 km
	protected final String chassisNumber;
	
	public String getChassisNumber() {
		return this.chassisNumber;
	}
	/**
	 * Method calculates the fuel consumption;
	 */

	@Override
	protected float returnFuelConsumptionAlgorithm(int gear) {
		
		if (gear == 0){
			return 0;
		}else{
			return BATTERY_USED_IN_100Km; 
		}
	}
	/**
	 * Returns 0. No pollution at start;
	 */
	@Override
	protected float calculateStarPollution() {
		return 0;
	}

/**
 * returns 0; No fuel consumed at start;
 */
	@Override
	protected float getFuelConsumedAtStart() {
		return 0;
	}
	
	/**
	 * Getter for fuel consumption avarage;
	 * @return BATTERY_USED_IN_100Km;
	 */
	public final float getFuelConsumptionAverage() {
		return BATTERY_USED_IN_100Km;
	}
	
	
	/**
	 * Constructor for the ModelS;
	 * @param availableFuel
	 * @param chassisNumber
	 */
	public ModelS(double availableFuel,String chassisNumber){  //In this case i will consider the available fuel as % battery charged
		super(BATTERY, FUEL_TYPEe, MAX_NUMBER_OF_GEARS, (float)availableFuel);
		if (availableFuel>BATTERY ){
			System.out.println("Too much POWER!!!");
			System.exit(0);
		}
		this.chassisNumber = chassisNumber;
	}

}


