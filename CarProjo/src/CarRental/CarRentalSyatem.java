package CarRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSyatem {

	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rental;

	public CarRentalSyatem() {
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rental = new ArrayList<>();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void rentalCar(Car car, Customer customer, int Days) {
		if (car.isavalebal()) {
			car.rent();
			rental.add(new Rental(car, customer, Days));
		} else {
			System.out.println("Car Is Not Availabel For Rent..!");
		}
	}

	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove = null;
		for (Rental rental : rental) {
			if (rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			}
		}

		if (rentalToRemove != null) {
			rental.remove(rentalToRemove);
			System.out.println("Car Returned Successfully. ");
		} else {
			System.out.println("Car Was Not rented. ");
		}
	}

	public void menu() {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("---- Car Rental Syatem ----");
			System.out.println("1. Rent a Car");
			System.out.println("2. Return a Car");
			System.out.println("3. Exit ");
			System.out.println("Enter Your Choice");

			int choice = scanner.nextInt();
			// Consume New Line
			scanner.nextLine();

			if (choice == 1) {
				System.out.println("\n --- rent  a Car --- \n");
				
				System.out.println("Enter Your Full  Name :");
				String customerName = scanner.nextLine();

				System.out.println("\n--- Avabileas Cars ---\n");
				for (Car car : cars) {
					if (car.isavalebal()) {
						System.out.println(car.getCarid() + " - " + car.getCarbrand() + " - " + car.getCarmodel());
					}
				}

				System.out.println("\n Enter The Caar Id You Want for Rent : ");
				String carId = scanner.nextLine();

				System.out.println("Enter The Number Of Days for Rental: ");
				int rentalDays = scanner.nextInt();
				scanner.nextLine();

				Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
				addCustomer(newCustomer);

				Car selectdCar = null;
				for (Car car : cars) {
					if (car.getCarid().equals(carId) && car.isavalebal()) {
						selectdCar = car;
						break;
					}
				}

				if (selectdCar != null) {
					double totalPrice = selectdCar.calculatePrice(rentalDays);
					System.out.println(" \n --- Rental Information --- \n");
					System.out.println("Customer Id: " + newCustomer.getCustomerId());
					System.out.println("Customer Name: " + newCustomer.getCustomerName());
					System.out.println("Car: " + selectdCar.getCarbrand() + " " + selectdCar.getCarmodel());
					System.out.println("Rental Days: " + rentalDays);
					System.out.printf("Total Price: ", totalPrice);

					System.out.println("\n Confirm Rental (Y|M) : ");
					String confirm = scanner.nextLine();

					if (confirm.equalsIgnoreCase("Y")) {
						rentalCar(selectdCar, newCustomer, rentalDays);
						System.out.println("\n Car Rented Succesfully..");
					} else {
						System.out.println("\n Rental Canclead /n ");
					}
				} else {
					System.out.println("\n Invalied Car Selection or Car Not available For Rent. ");
				}
			} else if (choice == 2) {
				System.out.println("\n --- rental A Car --- \n");
				System.out.println("Enter The Car id You Want To Return: ");
				String carId = scanner.nextLine();

				Car CarToReturn = null;
				for (Car car : cars) {
					if (car.getCarid().equals(carId) && !car.isavalebal()) {
						CarToReturn = car;
						break;
					}
				}

				if (CarToReturn != null) {
					Customer customer = null;
					for (Rental rental : rental) {
						if (rental.getCar() == CarToReturn) {
							customer = rental.getCustomer();
							break;
						}
					}

					if (customer != null) {
						returnCar(CarToReturn);
						System.out.println("Car Return Succesfully By " + customer.getCustomerName());
					} else {
						System.out.println("Car Is Not Returned Or Rental informeation Is Meassing.");
					}
				} else {
					System.out.println("invalied Car Id Or Rntal Information Is Missing..");
				}
			}else if(choice == 3) {
				break;
			}else {
				System.out.println("Invalied Choice Pleasevalied option.");
			}
		}
		
		System.out.println("\n ~~~~~~ THANKU FOR USING OUR CAR RENTAL SYSTEM ~~~~~~\n");
	}
}