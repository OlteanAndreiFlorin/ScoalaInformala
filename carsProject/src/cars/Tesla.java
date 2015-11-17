package cars;
/**
 * Tesla is the abstract bases class for all Tesla cars created
 * Extends from Car() class
 */

public abstract class Tesla extends Car {

	public Tesla(float fuelTankSize, String fuelType, int maxNumberOfGears, float availableFuel) {
		super(fuelTankSize, fuelType, maxNumberOfGears, availableFuel);

	}

	@Override
	protected float calculateFuelConsumption(float tripLength, int gear) {
		float fuelConsumed = returnFuelConsumptionAlgorithm(gear)/100 * tripLength;
		return fuelConsumed;
	}

	protected abstract float returnFuelConsumptionAlgorithm(int gear); 

	@Override
	protected float calculatePollution(float tripLength, float fuelConsumed) {
		//System.out.println("Dude it's a Tesla what pollution???");
		return 0;
	}

}
