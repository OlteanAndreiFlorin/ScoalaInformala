package cars;

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
	@Override
	protected float calculateStarPollution() {
		float co2Produced = FuelConsumedAtStart * 2392;  //1 L of gasoline produces 2392 g of co2
		return co2Produced;
	}
	@Override
	protected float getFuelConsumedAtStart() {
		return FuelConsumedAtStart;
	}


	@Override
	protected float getCo2Emissions(float currentFuelConsumption) {
		float currentCo2Emmisions = currentFuelConsumption * Pollution / FuelConsumptionAvarage;
		return currentCo2Emmisions;
	}
	
	public ExigeSCoupe(double availableFuel,String chassisNumber){
		super(FuelTankSize, FuelType, MaxNumberOfGears, (float)availableFuel);
		if (availableFuel>FuelTankSize ){
			System.out.println("Too much fuel");
			System.exit(0);
		}
		this.ChassisNumber = chassisNumber;
	}

	
}