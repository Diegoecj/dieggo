package mx.uabcs.javaswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DateBaseLayer {
	
	private String sql;
	private Connection  conn;
	private Statement stm;
	private ResultSet rs;
	
	private String server= "localhost:3306";
	private String db="mydb";
	private String user="root";
	private String pwd="1234";
	
	
	
	public DateBaseLayer(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://"+server+"/"+db,user,pwd);
			stm= conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public boolean isConnected(){
		
	
		try {
			return !conn.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
			return false;
		}
	
		
	}
	public void queryExect(String sql){
		try {
			
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public ArrayList<FormEvent>resultqueryExec(String sql){
		 ArrayList<FormEvent>Lista =new ArrayList <FormEvent>();
		
		try {
			rs=stm.executeQuery(sql);
			while(rs.next()){
				FormEvent item = new FormEvent(this);
				item.setChec(rs.getString("pais"));
				item.setName(rs.getString("nombre"));
				item.setGenero(rs.getString("genero"));
				item.setOccupation(rs.getString("ocupacion"));
				item.setEmpleadotexto(rs.getString("tipo_empleado"));
				item.setRangoedad("30");
				Lista.add(item);
			}
			rs.close();
			return Lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public ArrayList<Nacionalidad>resultqueryNacion(String sql){
		 ArrayList<Nacionalidad>ListaNacion =new ArrayList <Nacionalidad>();
		
		try {
			rs=stm.executeQuery(sql);
			while(rs.next()){
				Nacionalidad item = new Nacionalidad(rs.getInt("idnacionalidad"),rs.getString("nacion"));
				
				ListaNacion.add(item);
			}
			rs.close();
			return ListaNacion;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public ArrayList<Ocupacion>resultqueryOcupacion(String sql){
		 ArrayList<Ocupacion>ListaOcupacion =new ArrayList <Ocupacion>();
		
		try {
			rs=stm.executeQuery(sql);
			while(rs.next()){
				Ocupacion item = new Ocupacion(rs.getInt("idempleado"),rs.getString("tipoEmpleado"));
				
				ListaOcupacion.add(item);
			}
			rs.close();
			return ListaOcupacion;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}


	

}
