import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Ventana extends JFrame{
	
	private int altura =0;
	private int ancho=0;
	private String titulo=" ";
	private JButton btn;
	
	
	
	//constructor 
	public Ventana(){
		//termine de correr 
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
		 btn=new JButton ("*");
		
		 
		// setLayout(new BorderLayout());
		 

		 //instanciar el boton atravez de add.
		 this.add(btn,BorderLayout.NORTH);
		 add(new JButton ("2"),BorderLayout.SOUTH);
		 add(new JButton ("3"),BorderLayout.SOUTH);
		 add(new JButton ("4"),BorderLayout.AFTER_LINE_ENDS);
		 add(new JButton ("-"),BorderLayout.WEST);
		 add(new JButton ("+"),BorderLayout.AFTER_LAST_LINE);

	add(new TextPanel(),BorderLayout.NORTH);
		 setLayout(new GridLayout(5,5));

	}
	
	
	//construtor
	public Ventana(int ancho,int alto, String titulo){
			this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			this.setSize(altura,ancho);
			
			 this.setTitle(titulo);
			 this.setForeground(null);
			 btn=new JButton ("");
			 this.add(btn);

			 this.setVisible(true);
	}
	
	
	
	
	public void mostra(){
		this.setSize(altura,ancho);
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
