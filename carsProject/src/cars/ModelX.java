package cars;
/**
 * ModelX class
 * Extends Tesla
 * 
 * Class defines states and behaviors for all the instances of ModelX;
 * It provides the algorithm for the fuel consumption specific to this
 * type of car;
 * It also provides factory specifications like range for a full battery
 * and % battery used in 100km;
 * @author Oltean Andrei-Florin
 *
 */
public class ModelX extends Tesla {
	protected static final float BATTERY =100; //Factory specifications represents 100% charged batteries ~ 402.336km or 250 miles
	protected static final String FUEL_TYPE="Electricity"; //Factory specifications
	protected static final int MaAX_NUMER_OF_GEARS=1; //Factory specifications
	protected static final float BATTERY_USED_IN_100KM=24.854f; //Represents a % of the battery used in 100 km
	protected final String chassisNumber;
	
	public String getChassisNumber() {
		return this.chassisNumber;
	}
	/**
	 * Returns 0 a ModelX dose not consume fuel at start;
	 */
	@Override
	protected float calculateStarPollution() {
		return 0;
	}

/**
 * Returns 0. Dose not pollute at start;
 */
	@Override
	protected float getFuelConsumedAtStart() {
		return 0;
	}	
/**
 * Method calculates the fuel consumption;
 */
	@Override
	protected float returnFuelConsumptionAlgorithm(int gear) {
		
		if (gear == 0){
			return 0;
		}else{
			return BATTERY_USED_IN_100KM; 
		}
	}
	
	/**
	 * Getter for fuel consumption avarage;
	 * @return BATTERY_USED_IN_100Km;
	 */
	public final float getFuelConsumptionAverage() {
		return BATTERY_USED_IN_100KM;
	}
	
	
	/**
	 * Constructor for the ModelX;
	 * @param availableFuel
	 * @param chassisNumber
	 */
	public ModelX(double availableFuel,String chassisNumber){  //In this case i will consider the available fuel as % battery charged
		super(BATTERY, FUEL_TYPE, MaAX_NUMER_OF_GEARS, (float)availableFuel);
		if (availableFuel>BATTERY ){
			System.out.println("Too much POWER!!!");
			System.exit(0);
		}
		this.chassisNumber = chassisNumber;
	}
}


