package user;
import car_wash.CarInventory;
import car_wash.CarWash;
import cars.*;
import java.util.List;

public class CarWashMain {

	public static void main(String[] args) { 
		runCarInventoryTest();
		
		runCarWashTest();
	}

	public static void runCarWashTest() {
		Car car1 = new ModelS(50,"CarS");
		Car car2 = new ModelX(50,"CarS");
		Car car3 = new Elise(50,"CarEl");
		
		CarWash carWash = new CarWash();

		carWash.openShop();

		carWash.standInLine(car1); // car stands in line to get washed.

		carWash.standInLine(car2); // car2 stands in line to get washed.

		carWash.washCar(); // will wash the first car standing in line, which is car1

		carWash.standInLine(car3);

		carWash.washCar(); // will wash the next car standing in line, which is car2

		carWash.standInLine(car1);

		carWash.washCar();
		
		carWash.washCar();
		carWash.washCar();
		carWash.washCar();
		carWash.washCar();
		carWash.washCar();

		carWash.standInLine(car2);

		carWash.standInLine(car3);

		carWash.standInLine(car3);

		carWash.closeShop();

		List<Car> todaysClients = carWash.getTodaysClients(); // returns all clients that have visited the shop today. If car was washed twice, it should be returned once.

		for (Car i : todaysClients){
			System.out.println("the cars are: "+i);
		}
		System.out.println();
		List<Car> postponedClients = carWash.getPostponedClients(); // returns a list of clients who did not get to have their car washed. The shop closed while they were standing in line.
		for (Car i : postponedClients){
			System.out.println("the cars are: "+i);
		}
	}

	public static void runCarInventoryTest() {
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
