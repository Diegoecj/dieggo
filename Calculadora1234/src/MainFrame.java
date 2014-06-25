import java.awt.BorderLayout;

import javax.swing.JFrame;



public class MainFrame extends JFrame {

	
	private CajaDeTexto textPanel;
	
	
	MainFrame(){
		super("calculadora");
		
		setLayout(new BorderLayout());
		textPanel = new CajaDeTexto();
		add(textPanel, BorderLayout.CENTER);

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	
}
