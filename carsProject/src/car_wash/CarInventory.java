package car_wash;
import cars.Car;
import cars.Elise;
import cars.ExigeSCoupe;
import cars.Lotus;
import cars.Tesla;
import cars.ModelS;
import cars.ModelX;
import cars.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Hashtable;



public class CarInventory {

	private Hashtable<String,Car> carInventory = new Hashtable<>();
	
	
	public final void addCar(Car car) {
		carInventory.put(car.getChassisNumber(), car);
	}

	public final Car findCar(String chassisNumber) {
		
		return carInventory.get(chassisNumber);
		
	}

	public final void removeCar(String chassisNumber) {
		
		carInventory.remove(chassisNumber);
		
	}

	public final List<Car> getMostFuelEfficientCars() {
		List<Car> carList = new ArrayList<Car>(carInventory.values());
		Collections.sort(carList,COMPARE_BY_FUEL_CONSUMPTION_ASCENDING);
		return carList;
	}
	
	private static final Comparator<Car> COMPARE_BY_FUEL_CONSUMPTION_ASCENDING = new Comparator<Car>(){
		public final int compare(Car c1 , Car c2){
			return Float.compare(c1.getFuelConsumptionAverage(), c2.getFuelConsumptionAverage());
		}
	};
	
	
	
	

	public CarInventory() {
		
	}

	/**
	 * @return the carInventory
	 */
	public final Hashtable<String, Car> getCarInventory() {
		return new Hashtable<>(carInventory);
	}
	
}
