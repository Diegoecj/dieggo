package calculadora2;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class crearVentana extends JFrame  {
	
	
	private int altura =0;
	private int ancho=0;
	private String titulo=" ";

	//booton
	JButton btn;
	
	
	
	//constructor 
	public crearVentana(){
		
		setLayout(new BorderLayout());
		
		add(new CustomText(),BorderLayout.NORTH );
		add(new CustomKey(),BorderLayout.CENTER );
		
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 

	}
	
	
	
	
	//construtor
	public crearVentana(int ancho,int alto, String titulo){
			//termine de correr 
			this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			//tamaño de la ventana 
			this.setSize(altura,ancho);
			
			 //titulo de la ventana
			 this.setTitle(titulo);
			 this.setForeground(null);
			 btn=new JButton ("");
			 //instanciar el boton atravez de add.
			 this.add(btn);

			 //para que sea visible la vnetana
			 this.setVisible(true);
	}
	
	
	
	
	public void mostra(){
		this.setSize(altura,ancho);
		//titulo de lag ventana
		this.setTitle(titulo);
		
		this.setVisible(true);
		
	}




	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	
	
	
	
	
	
	
	
	
	

}
