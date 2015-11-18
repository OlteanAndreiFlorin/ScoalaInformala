package car_wash;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


import cars.Car;

public class CarWash {
	private Queue<Car> carWashClients =new LinkedList<Car>();
	private Queue<Car> todaysCarWashClients =new LinkedList<Car>();
	private Queue<Car> posponedCarWashClients =new LinkedList<Car>();
	private boolean shopOpened;
	public final void openShop() {
		shopOpened = true;
	}

	public final void standInLine(Car car) {
		if(!shopOpened){
			System.out.println("Shop is closed come back later");
			System.exit(0);
		}else{
			try{
			carWashClients.add(car);
			}catch(Exception ignore){
				System.out.println("We are to bussy come back later");
				System.exit(0);
			}
		}
		
	}

	public final void washCar() {
		if(!shopOpened){
			System.out.println("Shop is closed come back later");
			System.exit(0);
		}
		if (carWashClients.size()==0){
			System.out.println("No more cars chief guess we are done for today");
		}else{
			todaysCarWashClients.add(carWashClients.poll());
		}
		
		
	}

	public final void closeShop() {
		if(!shopOpened){
			System.out.println("Shop is alredy closed!?!? ");
		}else{
			shopOpened = false;
			if(carWashClients.size()!=0){
				posponedCarWashClients.addAll(carWashClients);
				carWashClients.clear();
			}
		}
	}

	public final List<Car> getTodaysClients() {
		if (todaysCarWashClients.size()==0){
			System.out.println("We aint done s... today no cars have been washed");
			return null;
		}
		Set<Car> temp = new LinkedHashSet<>(todaysCarWashClients);
		List<Car> temp2 = new LinkedList<>(temp); //temp2 will be a List with only 1 copy of each car washed today
		if (shopOpened){
			System.out.println("Shop is not closed yet but we washed the following cars:");
			return temp2;
		}
		
		return temp2;
	}

	public final List<Car> getPostponedClients() {
		if (posponedCarWashClients.size()==0){
			System.out.println("We have done all the work no more cars");
			return null;
		}
		if (shopOpened){
			System.out.println("The shop is not closed yet");
			return null;
		}
		List<Car> temp = new LinkedList<Car>();
		temp.addAll(posponedCarWashClients);
		return temp;
	}
	

}
