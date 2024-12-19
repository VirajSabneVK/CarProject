package CarRental;

public class Main {

	public static void main(String[] args) {
		CarRentalSyatem rentalsystem = new CarRentalSyatem();

		Car car1 = new Car("MH20","Fortuner","BlackLegender", 70.90);
		Car car2 = new Car("M002","Thar", "BlackAccord", 40.30);
		Car car3 = new Car("MH29","Enova", "Luxzari", 70.20);
		rentalsystem.addCar(car1);
		rentalsystem.addCar(car2);
		rentalsystem.addCar(car3);
		
		rentalsystem.menu();
	}
}
