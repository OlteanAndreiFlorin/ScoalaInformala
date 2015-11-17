package cars;
/**
 * Tesla is the abstract bases class for all Tesla cars created
 * Extends from Car() class;
 * Calculates the fuel consumption /100km this trip
 * In case of the Tesla the pollution will always be 0 
 * so the calculatePollution() method returns 0; 
 */

public abstract class Tesla extends Car {

	public Tesla(float fuelTankSize, String fuelType, int maxNumberOfGears, float availableFuel) {
		super(fuelTankSize, fuelType, maxNumberOfGears, availableFuel);

	}
/**
 * Calculates the fuel consumption /100km this trip;
 */
	@Override
	protected float calculateFuelConsumption(float tripLength, int gear) {
		float fuelConsumed = returnFuelConsumptionAlgorithm(gear)/100 * tripLength;
		return fuelConsumed;
	}

	protected abstract float returnFuelConsumptionAlgorithm(int gear); 
/**
 * Tesla dose not created any co2 so this method return 0;
 */
	@Override
	protected float calculatePollution(float tripLength, float fuelConsumed) {
		//System.out.println("Dude it's a Tesla what pollution???");
		return 0;
	}

}
