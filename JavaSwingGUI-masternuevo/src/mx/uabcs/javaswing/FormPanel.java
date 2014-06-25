package mx.uabcs.javaswing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	private JCheckBox checnacionalidad;
	
	DateBaseLayer dbl;
	//RAdio buton seleccion con punto.
	private JRadioButton femradio;
	private JRadioButton masradio;
	private JRadioButton otrosradio;
	private ButtonGroup gendergroup;
	//le da clic y salen mas opcciones.
	private JComboBox  empCombo;//empleado contratos
	private JComboBox  nacion;//para escoger la nacion
	private JComboBox  ocupacion;//para escoger la ocupacion
	private JTextField cuadroextra;
	private JLabel nacionalidad;
	
	
	private JList ageList;//lista de las edades.
	
	
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		nameLabel = new JLabel("Nombre: ");
		occupationLabel = new JLabel("Ocupacion: ");
		nameField = new JTextField(10);
		nacionalidad=new JLabel("NACIONALIDAD");
		cuadroextra= new JTextField(10);
		dbl=new DateBaseLayer();
		occupationField = new JTextField(10);
		empCombo= new  JComboBox();
		nacion= new  JComboBox();
		ocupacion= new  JComboBox();
		checnacionalidad=new JCheckBox("mexicano");
		checnacionalidad.setBounds(10,50,150,30);
		ageList=new JList();
		
		femradio=new JRadioButton("FEMENINO");
		femradio.setActionCommand("femenino");
		masradio=new JRadioButton("MASCULINO");
		masradio.setActionCommand("masculino");
		otrosradio=new JRadioButton("OTROS");
		otrosradio.setActionCommand("gays u otras cosas raras.");
		gendergroup=new ButtonGroup();
		
		masradio.setSelected(true);
		gendergroup.add(masradio);
		gendergroup.add(femradio);
		gendergroup.add(otrosradio);
		
		DefaultListModel ageModel=new DefaultListModel();
		
		ageModel.addElement(new AgeCategory(0,"18- 35"));
		ageModel.addElement(new AgeCategory(56,"36- 55"));
		ageModel.addElement(new AgeCategory(20,"mas de 56"));
		
		ageList.setModel(ageModel);
		
		ageList.setPreferredSize(new Dimension(110,70));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(0);
		
		//comboBox tipo de empleado
		/*DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement(new EmployeCategory(0,"empleado"));
		empModel.addElement(new EmployeCategory(1,"por contrato)"));
		empModel.addElement(new EmployeCategory(2,"no es empleado"));
		
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);
		*/
		//combobox tipo de nacion
		/*DefaultComboBoxModel nacModel = new DefaultComboBoxModel();
		nacModel.addElement(new EmployeCategory(2,"mexico"));
		nacModel.addElement(new EmployeCategory(3,"españa"));
		nacModel.addElement(new EmployeCategory(4,"polonia"));
		*/
	
		//ocupacion combobox	
		
		//ArrayList<Ocupacion> ListaOcupacion = dbl.resultqueryOcupacion("select * from empleado");
		
		DefaultComboBoxModel ocuModel = new DefaultComboBoxModel();
		if(dbl.isConnected()){
		
			for(Ocupacion fe:dbl.resultqueryOcupacion("select * from empleado")){
				ocuModel.addElement(fe);
			}
		}
		
			ocupacion.setModel(ocuModel);
		ocupacion.setSelectedIndex(0);
		
		
		//nacionalidad combobox

		ArrayList<Nacionalidad> Lista = dbl.resultqueryNacion("select * from nacionalidad");
		DefaultComboBoxModel nacModel = new DefaultComboBoxModel();

			for(Nacionalidad fe:Lista){
				
				nacModel.addElement(new NacionCategory(fe.getId(),fe.getNacion()));
			}
			nacion.setModel(nacModel);
			nacion.setSelectedIndex(0);
		
		
		
		checnacionalidad.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
			        if (checnacionalidad.isSelected()) {
			          
			 
			        	cuadroextra.setEnabled(false);
			        	
			        	
			        	
			        }else {
			        	
			        	cuadroextra.setEnabled(true);
			        	
			        }
			        
				
				
			}
			
		});
		
		
		okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat= (AgeCategory)ageList.getSelectedValue();
				EmployeCategory empCat= (EmployeCategory)empCombo.getSelectedItem();
				
			
				int edad= ageCat.getId();	
				int empleo=empCat.getId();
				String empleadotexto=empCat.toString();
				String rangoedad=ageCat.toString();
				String genero=gendergroup.getSelection().getActionCommand();
				String chec=checnacionalidad.getText();
				String chec2=cuadroextra.getText();
				FormEvent ev = new FormEvent(this, name, occupation,edad,empleo,rangoedad,genero,empleadotexto,chec,chec2);
				
				if(formListener != null) {
					formListener.formEventOcurred(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Agregar Persona");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		//////////// First row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
	////////////Second row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);
		
		gc.gridy = 1;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);
////////////////////////////////////////////////////////lista!!!!!!
		

		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 1;
		gc.gridy = 3;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(ageList, gc);
///////////////////////////////////////////////////radio buton!///////////7
		
		
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridy=4;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(masradio, gc);
		
		
		
		gc.gridy=5;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(femradio, gc);
		
		
		
		gc.gridy=6;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(otrosradio, gc);
		//////////////////////////////checkbox///////////////////
		gc.gridy=7;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(checnacionalidad, gc);
				
		///////////////////////////ComboBox/////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 1;
		gc.gridy = 2;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(empCombo, gc);
		
		/////////////////////////////////
		
		
		gc.gridx = 1;
		gc.gridy = 2;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(empCombo, gc);
		
		
		////////////Third row ///////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 8;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nacionalidad, gc);
		
		gc.gridx = 1;
		gc.gridy = 8;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(cuadroextra, gc);
		
		////////////////////////////////////////////
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridy = 9;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);
			/////////////////Combobox nacion////////////////
					
			gc.weightx = 1;
			gc.weighty = 0.2;
			
			gc.gridx = 0;
			gc.gridy = 9;
			
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 0, 5);
			add(nacion, gc);
			
			//////////////////////////////////////////////////combo box empleado
			gc.weightx = 1;
			gc.weighty = 0.2;
			
			gc.gridx = 1;
			gc.gridy = 9;
			
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 0, 5);
			add(ocupacion, gc);
		}
	//}
	
	
	public void setFormListener(FormListener listener){
		this.formListener = listener;
	}
}


class AgeCategory{
	
	private int id;
	private String text;
	
	public AgeCategory(int id,String text){
		this.id=id;
		this.text=text;
		
	}
	
	public String toString(){
		return text;
	}
	
	public int getId(){
		return id;
	}


	
	
	
}

class EmployeCategory{
	private int id;
	private String text;
	
	public EmployeCategory(int id,String text){
		this.id=id;
		this.text=text;
		
	}
	
	public String toString(){
		return text;
	}
	
	public int getId(){
		return id;
	}
	
	
	
	
}

class NacionCategory{
	private int id;
	private String text;
	
	public NacionCategory(int id,String text){
		this.id=id;
		this.text=text;
		
	}
	
	public String toString(){
		return text;
	}
	
	public int getId(){
		return id;
	}
	
	
	
	
}
class OcupacionCategory{
	private int id;
	private String text;
	
	public OcupacionCategory(int id,String text){
		this.id=id;
		this.text=text;
		
	}
	
	public String toString(){
		return text;
	}
	
	public int getId(){
		return id;
	}
	
	
	
	
}

