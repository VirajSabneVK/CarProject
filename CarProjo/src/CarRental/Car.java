package CarRental;

public class Car {

	private String carbrand;
	private String carid;
	private String carmodel;
	private double carbasepriceperDay;
	private boolean isavalebal;
	
	public Car(String carbarnd, String carid,String carmodel, double carbasepriceperDay) {
		this.carbrand = carbarnd;
		this.carid = carid;
		this.carmodel = carmodel;
		this.carbasepriceperDay = carbasepriceperDay;
		this.isavalebal = true;
	}
		
		public String getCarid() {
			return carid;
		}
		public String getCarmodel() {
			return carmodel;
		}
		public String getCarbrand() {
			return carbrand;
		}
		
		public double calculatePrice(int rentalDays) {
			return carbasepriceperDay * rentalDays;
		}
		
		public boolean isavalebal() {
			return isavalebal;
		}
		public void rent() {
			isavalebal = false;
		}
		public void returnCar() {
			isavalebal = true;
		}
}