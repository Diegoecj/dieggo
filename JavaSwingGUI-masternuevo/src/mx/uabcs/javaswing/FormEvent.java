package mx.uabcs.javaswing;

import java.util.EventObject;

public class FormEvent extends EventObject{

	private String name;
	private String occupation;
	private int ageCategoryID;
	private int Empleoid;
	private String rangoedad;
	private String genero;
	private String empleadotexto;
	private String chec;
	private String chec2;
	
	
	
	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public FormEvent(Object source, String name, String occupation,int ageCategoryID,int Empleoid,String rangoedad,String genero,String empleadotexto,String chec,String chec2){
		super(source);
		this.genero=genero;
		this.rangoedad=rangoedad;
		this.name = name;
		this.occupation = occupation;
		this.ageCategoryID=ageCategoryID;
		this.Empleoid=Empleoid;
		this.empleadotexto=empleadotexto;
		this.chec=chec;
		
		this.chec2=chec2;
	}

	public void setEmpleadotexto(String empleadotexto) {
		this.empleadotexto = empleadotexto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getAgeCategoryID() {
		return ageCategoryID;
	}

	public void setAgeCategoryID(int ageCategoryID) {
		this.ageCategoryID = ageCategoryID;
	}

	public int getEmpleoid() {
		return Empleoid;
	}

	public void setEmpleoid(int empleoid) {
		Empleoid = empleoid;
	}

	public String getRangoedad() {
		return rangoedad;
	}

	public void setRangoedad(String rangoedad) {
		this.rangoedad = rangoedad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmpleadotexto() {
		return empleadotexto;
	}

	public String getChec() {
		return chec;
	}

	public void setChec(String chec) {
		this.chec = chec;
	}

	public String getChec2() {
		return chec2;
	}

	public void setChec2(String chec2) {
		this.chec2 = chec2;
	}

	
	
	
	
	
	
	
}
