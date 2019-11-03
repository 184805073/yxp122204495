import utility.XMLUtility;
import car.*;
import factory.*;

public class Costumer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		TaxiBase st=new TaxiBase();
		
		InPut input=new InPut(st);
		OutPut output=new OutPut(st);
		
		
		new Thread(output).start();
		Thread.sleep(1000);
		new Thread(input).start();
		
		
	}

}
class TaxiBase{
	
	private BMW[] car=new BMW[10];
	private int inPos,outPos;
	private int cnt;
	
	public TaxiBase(){
		
		BMWFactory carFactory=(BMWFactory)XMLUtility.getBean();
		for(int i=0;i<10;i++){
			
			car[i]=carFactory.produceCar();
		}
		
		System.out.println("create 10  cars------");
	}
	
	public synchronized void put() {
		
		try {
			
		
		if(cnt==car.length) {
			
			this.wait();
		}
		
		System.out.println("车辆" + inPos + ", " + car[inPos].toString() + "入库");
		inPos++;
		
		if(inPos==car.length)
			inPos=0;
		
		cnt++;
		Thread.sleep(100);
		this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void get() {
		
		try {
			
		
		if(cnt==0) {
			
			this.wait();
		}
		
		System.out.println("车辆" + outPos + ", " + car[outPos].toString() + "出库。计费费率" + car[outPos].getRatio());
		
		outPos++;
		if(outPos==car.length)
			outPos=0;
		cnt--;
		Thread.sleep(100);
		this.notify();
	}catch(Exception e) {
		
		e.printStackTrace();
	}
		
	}
	
	
}
class OutPut implements Runnable{
	
	private TaxiBase st;
	
	OutPut(TaxiBase st){
		this.st=st;
	}
	
	public void run() {
		
		while(true) {
			st.get();
		}
	}
	
}
class InPut implements Runnable{
	
	private TaxiBase st;
	private int num;
	
	InPut(TaxiBase st){
		
		this.st=st;
	}
	
	public void run() {
		
		while(true) {
			
			st.put();
		}
	}
	
}
