package factory;

import car.*;

public class BenzFactory implements factory {

	public Benz produceCar() {

		System.out.println("������һ������");
		return new Benz();
	}

}
