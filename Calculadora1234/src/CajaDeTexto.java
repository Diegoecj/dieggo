import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CajaDeTexto extends JPanel {
	
	private JTextArea textArea;
	
	
	CajaDeTexto(){
		
		textArea= new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.NORTH);
		
		add(textArea, BorderLayout.CENTER);

	}
	
	public void appendText(String text) {
		textArea.append(text);
	}	

}
