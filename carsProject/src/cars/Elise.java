package cars;

public class Elise extends Lotus {
	protected static final float FuelTankSize =60; //Factory specifications
	protected static final String FuelType="Petrol"; //Factory specifications
	protected static final int MaxNumberOfGears=6; //Factory specifications
	protected static final float Pollution=149; //Factory specifications
	protected static final float FuelConsumedAtStart=0.23f;//Custom consumption of fuel at the start of the motor may vary from reality
	protected static final float FuelConsumptionAvarage = 6.3f;//Factory specifications
	protected final String ChassisNumber;

	public String getChassisNumber() {
		return this.ChassisNumber;
	}
	
	


	@Override
	protected final float calculateFuelConsumptionAlgorithm(int gear) {
		
		switch (gear){
		case 1:
			return 9.95f;
		case 2:
			return 8.3f;
		case 3:
			return 6.55f;
		case 4:
			return 5.65f;
		case 5:
			return 5;
		case 6:
			return 4.34f;
		default:
			return 0;
			
		}
	}


	@Override
	protected float getCo2Emissions(float currentFuelConsumption) {
		float currentCo2Emmisions = currentFuelConsumption * Pollution / FuelConsumptionAvarage;
		return currentCo2Emmisions;
	}
	@Override
	protected float getFuelConsumedAtStart() {
		return FuelConsumedAtStart;
	}
	@Override
	protected float calculateStarPollution() {
		float co2Produced =FuelConsumedAtStart * 2392;  //1 L of gasoline produces 2392 g of co2
		return co2Produced;
	}
	
	public Elise(double availableFuel,String chassisNumber){
		super(FuelTankSize, FuelType, MaxNumberOfGears, (float)availableFuel);
		if (availableFuel>FuelTankSize ){
			System.out.println("Too much fuel");
			System.exit(0);
		}
		this.ChassisNumber = chassisNumber;
	}


	
}
