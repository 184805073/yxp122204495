package factory;

import car.*;

public class BMWFactory implements factory {

	public BMW produceCar() {

		System.out.println("������һ������");
		return new BMW();
	}
}
