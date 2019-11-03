package car;

public class BMW implements Car {

	private double ratio = 1.0;

	public double getRatio() {

		return ratio;
	}
	
	public void run() {
		
		System.out.println("bmw is running");
	}

}
