package factory;

import car.*;

public class AudiFactory implements factory {

	public Audi produceCar() {

		System.out.println("������һ��Audi");
		return new Audi();
	}
}
