package Interfaces;

import java.awt.Choice;


import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

import DAO.MedicamentDAO;
import metier.Medicament;

public class MedicamentAjout {
	JTextField tcodeBarre,tnom,tdatePeremption,tprix;

	JButton ajouter;
	JSpinner txtquantite;
  
	JSpinner qte ;
    Choice type;
	public JPanel getContenu() {
		JPanel contenu=new JPanel();
			contenu.setForeground(new Color(0, 0, 0));
			contenu.setBackground(SystemColor.control);
			contenu.setBounds(80, 100, 696, 592);
			contenu.setLayout(null);
			
			JLabel AjouterMedicament= new JLabel("Ajouter Medicament");
			AjouterMedicament.setForeground(Color.black);
			AjouterMedicament.setBackground(Color.CYAN);
			AjouterMedicament.setOpaque(true);
		
		
			AjouterMedicament.setFont(new Font("Tahoma", Font.BOLD, 36));
			AjouterMedicament.setHorizontalTextPosition(SwingConstants.CENTER);
			AjouterMedicament.setPreferredSize(new Dimension(200, 100));
			AjouterMedicament.setLocation(new Point(200, 200));
			AjouterMedicament.setHorizontalAlignment(SwingConstants.CENTER);
			AjouterMedicament.setIgnoreRepaint(true);
			AjouterMedicament.setBounds(100, 24, 525, 46);
			contenu.add(AjouterMedicament);
			
			JLabel LcodeBarre = new JLabel("CodeBarre :");
			LcodeBarre .setFont(new Font("Tahoma", Font.PLAIN, 14));
			LcodeBarre .setBounds(151, 105, 90, 24);
			contenu.add(LcodeBarre );
			
			tcodeBarre  = new JTextField();
			tcodeBarre.setBounds(340, 102, 208, 27);
			contenu.add(tcodeBarre );
			tcodeBarre.setColumns(10);
			
			JLabel lnom = new JLabel("nom :");
			lnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lnom.setBounds(149, 164, 60, 22);
			contenu.add(lnom);
			
			tnom = new JTextField();
			tnom.setBounds(340, 159, 208, 27);
			contenu.add(tnom);
			tnom.setColumns(10);
			
			JLabel ltype = new JLabel("Type:");
			ltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
			ltype.setBounds(151, 211, 60, 22);
			contenu.add(ltype);
			
		  type= new Choice();
			type.setBounds(340, 211, 208, 27);
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
			ldatePeremption .setBounds(151, 263, 120, 14);
			contenu.add(ldatePeremption );
			
			tdatePeremption  = new JTextField();
			tdatePeremption .setBounds(340, 259, 208, 27);
			contenu.add(tdatePeremption );
			tdatePeremption .setColumns(10);
			
			JLabel lprix = new JLabel("Prix :");
			lprix.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lprix.setBounds(151, 319, 60, 14);
			contenu.add(lprix);
			
			tprix = new JTextField();
			tprix.setBounds(340, 315, 208, 27);
			contenu.add(tprix);
			tprix.setColumns(10);
			
			JLabel lquantite = new JLabel("quantite :");
			lquantite.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lquantite.setBounds(151, 374, 60, 18);
			contenu.add(lquantite);
			
			SpinnerModel model=new SpinnerNumberModel(
					3,0,1000,1);
			
			
			
			 qte = new JSpinner(model);
			qte.setBounds(340, 374, 208, 27);
			contenu.add(qte);
			
			JButton quitter =new JButton("Quitter");
		    quitter.setBounds(440, 450, 89, 23);
		    quitter.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent evn) {
		    		 Object source =evn.getSource();
		    		 if(source.equals(quitter)) {
		    			 System.exit(0);
		    		 }
		    		 
		    	 }
		    });
			contenu.add(quitter);
			
		
			
            ajouter = new JButton("Ajouter");
			ajouter.setBounds(180, 450, 89, 23);
			contenu.add(ajouter);
			
			ajouter.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent evn) {
					// TODO Auto-generated method stub
					Object source=evn.getSource();
					
					if(source.equals(ajouter)) {
						int quantite=(int)qte.getValue();
						int codeBarre=Integer.parseInt(tcodeBarre.getText());
				
						MedicamentDAO tst=new MedicamentDAO();
						Medicament mdc=new Medicament(codeBarre,tnom.getText(),type.getSelectedItem(),tdatePeremption.getText(),
								tprix.getText(),quantite);
						

					     if (tst.inserer(mdc)>0) {
					    	 JOptionPane.showMessageDialog(null, " Ok Medicament inserer","message ok",2);
					     }else {
					    	 JOptionPane.showMessageDialog(null, " !!!! Medicament non inserer","erreur",2);
					    	 
					     
					
					
					     }}}});
			JButton vider =new JButton("vider");
			vider.setBounds(310, 450, 89, 23);
			contenu.add(vider);
			vider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evn) {
					Object source=evn.getSource();
					if(source.equals(vider)) {
						//tcodeBarre.setText("");
						tnom.setText("");
						type.select("");
						tdatePeremption.setText("");
						tprix.setText("");
						 qte.setValue(0);
				
					}
					
				}
			});
			
			
			ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
			JLabel lblNewLabel = new JLabel(background);
			lblNewLabel.setBounds(0, 0, 750, 630);
			contenu.add(lblNewLabel);
			
			return contenu;}
	
			
			
}
	
					

	        
		