package factory;

import car.*;

public class BenzFactory implements factory {

	public Benz produceCar() {

		System.out.println("生产了一辆奔驰");
		return new Benz();
	}

}
