package factory;

import car.*;

public class BMWFactory implements factory {

	public BMW produceCar() {

		System.out.println("生产了一辆宝马");
		return new BMW();
	}
}
