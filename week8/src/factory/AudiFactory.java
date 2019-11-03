package factory;

import car.*;

public class AudiFactory implements factory {

	public Audi produceCar() {

		System.out.println("生产了一辆Audi");
		return new Audi();
	}
}
