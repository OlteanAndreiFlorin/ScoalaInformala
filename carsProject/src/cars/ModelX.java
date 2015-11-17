package cars;

public class ModelX extends Tesla {
	protected static final float Battery =100; //Factory specifications represents 100% charged batteries ~ 402.336km or 250 miles
	protected static final String FuelType="Electricity"; //Factory specifications
	protected static final int MaxNumberOfGears=1; //Factory specifications
	protected static final float BatteryUsedIn100Km=24.854f; //Represents a % of the battery used in 100 km
	protected final String ChassisNumber;
	
	public String getChassisNumber() {
		return this.ChassisNumber;
	}
	
	@Override
	protected float calculateStarPollution() {
		return 0;
	}


	@Override
	protected float getFuelConsumedAtStart() {
		return 0;
	}	

	@Override
	protected float returnFuelConsumptionAlgorithm(int gear) {
		
		if (gear == 0){
			return 0;
		}else{
			return BatteryUsedIn100Km; 
		}
	}
	
	public ModelX(double availableFuel,String chassisNumber){  //In this case i will consider the available fuel as % battery charged
		super(Battery, FuelType, MaxNumberOfGears, (float)availableFuel);
		if (availableFuel>Battery ){
			System.out.println("Too much POWER!!!");
			System.exit(0);
		}
		this.ChassisNumber = chassisNumber;
	}
}


