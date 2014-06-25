package mx.uabcs.javaswing;


import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			Connection conexion=null;
		try {
			conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("fallo");
			e.printStackTrace();
		}
		
		if(conexion!=null){
			System.out.println("si hay conexion ");
		}else{
			System.out.println("fallo la conexion ");
			
		}
		
		try {
			Statement stm =conexion.createStatement();
			String sql ="INSERT INTO trabajador"+"(nombre,ocupacion,edad,genero,pais,tipo_empleado)"+
			"VALUES('diego','mecanico',20,'masculino','mexicano','empleado')";
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*DateBaseLayer dbl=new DateBaseLayer();
		
		if(dbl.isConnected()){
			String sql="INSERT INTO trabajador"+
					"(tipo_empleado,nombre,ocupacion,edad,genero,pais)"+
					"VALUES('Fijo','Cristian Manuel', 'Maestro', 20 , 'Masculino','Jamaica')";//insercion
			//dbl.queryExect(sql);
			////
			ResultSet rs = dbl.resultqueryExec("select * from trabajador" );
			try {
				while(rs.next()){
					System.out.println(rs.getString("nombre"));
				}
				rs.close();//cerrar el flujo
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/////
		}*/
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
				
			}
		});	
	}

}
