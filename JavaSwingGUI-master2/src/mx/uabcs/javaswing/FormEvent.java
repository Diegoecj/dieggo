package mx.uabcs.javaswing;

import java.util.ArrayList;
import java.util.EventObject;

public class FormEvent  extends EventObject{

	
	private String name;
	private String ocupation;
	
	public FormEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public FormEvent(Object arg0,String name,String ocupation){
		super(arg0);
		this.name=name;
		this.ocupation=ocupation;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOcupation() {
		return ocupation;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}
	
	
	
	

}
