package animales;

public class Ave  extends Animal implements Necesidades{

	
	//constructor
	public Ave(){
		
	}
	
	
	@Override
	public void comer(String comida) {
		// TODO Auto-generated method stub
		this.setPeso(10);
		
	}

	@Override
	public void dormir(String dormir) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void moverse(String movimiento) {
		// TODO Auto-generated method stub
		
	}

	
	
}
