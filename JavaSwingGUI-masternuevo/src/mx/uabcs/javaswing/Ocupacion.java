package mx.uabcs.javaswing;

public class Ocupacion {
	
	
	private int id;
	private String ocupacion;
	
	
	public Ocupacion (int id,String ocupacion){
		this.id=id;
		this.ocupacion=ocupacion;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOcupacion() {
		return ocupacion;
	}


	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}


	@Override
	public String toString() {
		return ocupacion ;
	}
	
	
	
	

}
