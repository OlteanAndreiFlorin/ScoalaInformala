package user;
import car_wash.CarInventory;
import cars.*;
import java.util.List;
public class Main {

	public static void main(String[] args) { 
		Car car1 = new ModelS(50,"CarS");
		Car car2 = new ModelX(50,"CarS");
		Car car3 = new Elise(50,"CarEl");
		Car car4 = new ExigeSCoupe(50,"CarEx");
		Car car5 = new ModelS(30,"CarS1");
		Car car6 = new ModelX(10,"Carx1");
		Car car7 = new Elise(27,"CarEl1");
		Car car8 = new ExigeSCoupe(34.5,"CarEx1");
		
		
		CarInventory ci = new CarInventory();

		ci.addCar(car1); // car is any type of Car extension you have implemented in your previous homework.
		ci.addCar(car2);
		ci.addCar(car3);
		ci.addCar(car4);
		ci.addCar(car5);
		ci.addCar(car6);
		ci.addCar(car7);
		ci.addCar(car8);
		
		
		
		String[] chassisNumber = new String[ci.getCarInventory().size()];
		int i = 0;
		for (Car tempCar : ci.getCarInventory().values()){
			chassisNumber[i++] = tempCar.getChassisNumber();
		}
		
		for(Car temp :ci.getCarInventory().values()){
			System.out.println(temp);
		}
		
		System.out.println();
		
		Car carToFind = ci.findCar("CarS1"); // I should be able to get back the car object based on its unique chassis number
		if (carToFind == null){
			System.out.println("404 car not found");
		}else{
			System.out.println(carToFind);
		}
		System.out.println();
		
		ci.removeCar(chassisNumber[3]); // removes the car from the collection if it exists.
 
		for(Car temp :ci.getCarInventory().values()){
			System.out.println(temp);
		}
		
		List<Car> cars = ci.getMostFuelEfficientCars(); // returns the cars that consume the least amount fuel.

		System.out.println();
		System.out.println("The cars in order");
		for(Car temp :cars){
			System.out.println(temp);
			System.out.println("With a consumtion of "+temp.getFuelConsumptionAverage());
		}
	}
	
	
	

}
