package jframe;

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
		//termine de correr 
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
		 btn=new JButton ("norte");
		
		 
		 setLayout(new BorderLayout());
		 //instanciar el boton atravez de add.
		 this.add(btn,BorderLayout.NORTH);
		 add(new JButton ("sur"),BorderLayout.SOUTH);
		 add(new JButton ("oeste"),BorderLayout.WEST);
		 add(new JButton ("este"),BorderLayout.EAST);

		 add(new TextPanel(),BorderLayout.CENTER);

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
		//titulo de la ventana
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
