import car.*;
import factory.*;
import utility.*;

public class Main {

	public static void main(String[] args) {
		 
		BMW bmw;
		BMWFactory bmwFactory; 
		
		bmwFactory=(BMWFactory)XMLUtility.getBean();
		bmw=bmwFactory.produceCar();
		
		bmw.run();
	}

}
