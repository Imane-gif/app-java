package Interfaces;

import java.awt.Choice;
import java.awt.Color;




import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import DAO.MedicamentDAO;

import metier.Medicament;

public class MedicamentModifier {
	JComboBox<Integer> tcodeBarre;
	JTextField tnom,tdatePeremption,tprix;
	Choice type;
	public JPanel getContenu() {
		JPanel contenu=new JPanel();
		
	
	 //JButton modifier;
	// JSpinner quantite;
		
		
		
		
		
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(Color.LIGHT_GRAY);
		contenu.setLayout(null);
		contenu.setBounds(80, 100, 696, 592);
		
		JLabel ModifierMedicament= new JLabel("Modifier/Supprimer Medicament");
		ModifierMedicament.setForeground(Color.black);
		ModifierMedicament.setBackground(Color.CYAN);
		ModifierMedicament.setOpaque(true);
		ModifierMedicament.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
	
		ModifierMedicament.setFont(new Font("Tahoma", Font.BOLD, 36));
		ModifierMedicament.setHorizontalTextPosition(SwingConstants.CENTER);
		ModifierMedicament.setPreferredSize(new Dimension(200, 100));
		ModifierMedicament.setLocation(new Point(200, 200));
		ModifierMedicament.setHorizontalAlignment(SwingConstants.CENTER);
		ModifierMedicament.setIgnoreRepaint(true);
		ModifierMedicament.setBounds(70, 24,600, 46);
		contenu.add(ModifierMedicament);

		
		
		JLabel LcodeBarre = new JLabel("CodeBarre :");
		LcodeBarre .setFont(new Font("Tahoma", Font.PLAIN, 14));
		LcodeBarre .setBounds(130, 105, 90, 24);
		contenu.add(LcodeBarre );
		
		tcodeBarre = new JComboBox<>();
		
		 MedicamentDAO mdc=new MedicamentDAO();
		    ArrayList<Medicament>lstmed=mdc.listesMedicaments();
		    
		    
		   for(Medicament m:lstmed) {
			      int code= m.getCodeBarre();
		      tcodeBarre.addItem(code);}
		   tcodeBarre .setBounds(270, 102, 208, 27);
			contenu.add(tcodeBarre );
		
		
		
		JLabel lnom = new JLabel("nom :");
		lnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lnom.setBounds(130, 164, 76, 22);
		contenu.add(lnom);
		
		tnom = new JTextField();
		tnom.setBounds(270, 159, 208, 27);
		contenu.add(tnom);
		tnom.setColumns(10);
		
		JLabel ltype = new JLabel("Type:");
		ltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ltype.setBounds(130, 211, 76, 22);
		contenu.add(ltype);
		
		 type = new Choice();
		type.setBounds(270, 211, 208, 27);
		type.add("");
		type.add("comprimés");
		type.add("gélules");
		type.add("sirops");
		type.add("gouttes");
		type.add("pommade");
		type.add("crème");
		type.add("poudres");
		type.add("solutions");
		type.add("collyres");
		type.add("lavements");
		type.add("capsules");
		type.add("gels");
		contenu.add(type);
		
		
		JLabel ldatePeremption = new JLabel("DatePeremption :");
		ldatePeremption .setFont(new Font("Tahoma", Font.PLAIN, 14));
		ldatePeremption .setBounds(130, 263, 110, 14);
		contenu.add(ldatePeremption );
		
		tdatePeremption  = new JTextField();
		tdatePeremption .setBounds(270, 259, 208, 27);
		contenu.add(tdatePeremption );
		tdatePeremption .setColumns(10);
		
		JLabel lprix = new JLabel("Prix :");
		lprix.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lprix.setBounds(130, 319, 63, 14);
		contenu.add(lprix);
		
		tprix = new JTextField();
		tprix.setBounds(270, 315, 208, 27);
		contenu.add(tprix);
		tprix.setColumns(10);
		
		JLabel lquantite = new JLabel("quantite :");
		lquantite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lquantite.setBounds(130, 374, 60, 14);
		contenu.add(lquantite);
		
		JSpinner Quantite=new JSpinner();
		Quantite.setBounds(270, 374, 208, 27);
		contenu.add(Quantite);
		
	
		
		JButton Modifier = new JButton("Modifier");
		Modifier.setBounds(250, 460, 95, 23);
		contenu.add(Modifier);
		JButton chercher=new JButton("Chercher");
		chercher.setBounds(520,105, 95, 23);
		contenu.add(chercher);
		JButton supprimer=new JButton("Supprimer");
		supprimer.setBounds(400,460, 95, 23);
		contenu.add(supprimer);
		Modifier.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
				Object source=evn.getSource();
				
				if(source.equals(Modifier)) {
					
					MedicamentDAO tst=new MedicamentDAO();
					int quantite=(int)Quantite.getValue();
					//String codeBarre = tcodeBarre.getSelectedItem().toString();
                        int codeBarre=Integer.parseInt(tcodeBarre.getSelectedItem().toString());
					Medicament mdc=new Medicament(codeBarre,tnom.getText(),type.getSelectedItem(),tdatePeremption.getText(),tprix.getText(),quantite);
					

				     if (tst.modifier(mdc)) {
				    	 JOptionPane.showMessageDialog(null, " Ok Medicament modifie","message ok",2);
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! Medicament non modifie","erreur",2);
				    	 
				     }
				
				
				}}

				});
		
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
		   Object source=evn.getSource();
				
				if(source.equals(supprimer)) {
					
					MedicamentDAO tst=new MedicamentDAO();	
					
				
					int codeBarre=Integer.parseInt(tcodeBarre.getSelectedItem().toString());
			
					int rep=-2;
					rep= JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le cleint N°:"+codeBarre, "Confirmer", 1, 3);
					
					// JOptionPane.showMessageDialog(null, " choix"+rep,"message ok",2);
					
					 if(rep==0) {
			
			         
					if (tst.supprimer(codeBarre)==true) {
				    	 JOptionPane.showMessageDialog(null, " Ok medicament supprimé","message ok",2);
				    
						    	 
						    	 tcodeBarre.setSelectedItem("");
						    	 tnom.setText("");
									type.select("");
									tdatePeremption.setText("");
									tprix.setText("");
									Quantite.setValue(0);
									
					 }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! medicament non supprimé","erreur",2);
					 }
				     }
					
				}
			}
		});
		 chercher.addActionListener(new ActionListener() {

				public  void actionPerformed(ActionEvent evn) {
					// TODO Auto-generated method stub
			Object source=evn.getSource();
					
					if(source.equals(chercher)) {
						MedicamentDAO tst=new MedicamentDAO();
			       		
						int codeBarre=(int)tcodeBarre.getSelectedItem();
						
						Medicament mdc=tst.chercher(codeBarre);
						if(mdc.getCodeBarre()>0 ) {
							
							
						//	JOptionPane.showMessageDialog(null, " Ok  medicament existe"+tst.chercher(codeBarre).getCodeBarre,"message ok",2);
							 tnom.setText(mdc.getNom());
							  type.select(mdc.getType());
							 tdatePeremption.setText(mdc.getDatePeremption());
							 tprix.setText(mdc.getPrix());
							 Quantite.setValue(mdc.getQuantite());
							 

						
						
						
				
						  }else {
					    	 //JOptionPane.showMessageDialog(null, " !!!! medicament n'existe","erreur",2);
						
							}
						
							}} 
							
						});
			ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
			JLabel lblNewLabel = new JLabel(background);
			lblNewLabel.setBounds(0, 0, 750, 630);
			contenu.add(lblNewLabel);

		return contenu;

     
	}}


