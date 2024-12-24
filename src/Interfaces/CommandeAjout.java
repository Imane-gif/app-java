package Interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import DAO.CommandeDAO;
import DAO.FournisseurDAO;
import DAO.MedicamentDAO;
import metier.Commande;
import metier.Fournisseur;
import metier.Medicament;


public class CommandeAjout {
JTextField tprix,tdateCommande;
JSpinner quantite;

JComboBox<Integer> tcodeBarre;

JComboBox<Integer> tidfour;
	
	JButton valider;
	
	public JPanel getContenu() {
	JPanel contenu=new JPanel();
	contenu.setForeground(new Color(0, 0, 0));
	contenu.setBackground(SystemColor.control);
	contenu.setBounds(80, 100, 696, 592);
	contenu.setLayout(null);
	
	
	
	
	JLabel AjouterCommande= new JLabel("Ajouter Commande");
	AjouterCommande.setForeground(Color.black);
	AjouterCommande.setBackground(Color.CYAN);
	AjouterCommande.setOpaque(true);
	AjouterCommande.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
	
	AjouterCommande.setFont(new Font("Tahoma", Font.BOLD, 36));
	AjouterCommande.setHorizontalTextPosition(SwingConstants.CENTER);
	AjouterCommande.setPreferredSize(new Dimension(200, 100));
	AjouterCommande.setLocation(new Point(200, 200));
	AjouterCommande.setHorizontalAlignment(SwingConstants.CENTER);
	AjouterCommande.setIgnoreRepaint(true);
	AjouterCommande.setBounds(100, 24, 525, 46);
	contenu.add(AjouterCommande);
	
	JLabel Lidfour = new JLabel("idFournisseur :");
	Lidfour.setFont(new Font("Tahoma", Font.PLAIN, 14));
	Lidfour.setBounds(151, 105, 100, 24);
	contenu.add(Lidfour);
	
	 tidfour = new JComboBox<>();
	 tidfour.setBounds(300, 102, 208, 27);
	contenu.add(tidfour);
	FournisseurDAO fourn=new FournisseurDAO();
    
    ArrayList  <Fournisseur>  listFour=fourn.listesFournisseurs();
  // int i = 0;
    
	for (Fournisseur F:  listFour ) {
      int id= F.getIdFournisseur();
     tidfour.addItem(id);
		}
	
	JLabel lcodeBarre = new JLabel("codeBarre :");
	lcodeBarre.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lcodeBarre.setBounds(149, 164, 100, 22);
	contenu.add(lcodeBarre);
	
	tcodeBarre = new JComboBox<>();
	
	tcodeBarre.setBounds(300, 159, 208, 27);
	contenu.add(tcodeBarre);
	 MedicamentDAO mdc=new MedicamentDAO();
	    ArrayList<Medicament>lstmed=mdc.listesMedicaments();
	    
	  
	   for(Medicament m:lstmed) {
		      int code= m.getCodeBarre();
		      tcodeBarre.addItem(code);
	   }
	
	
	
	JLabel lquantite = new JLabel("Quantite:");
	lquantite.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lquantite.setBounds(151, 211, 106, 22);
	contenu.add(lquantite);
	

	 quantite = new JSpinner();
	quantite.setBounds(300, 211, 208, 27);
	contenu.add(quantite);
	
	JLabel lprix = new JLabel("Prix :");
	lprix.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lprix.setBounds(151, 263, 63, 14);
	contenu.add(lprix);
	
	tprix = new JTextField();
	tprix.setBounds(300, 259, 208, 27);
	contenu.add(tprix);
	tprix.setColumns(10);
	
	JLabel ldateCommande = new JLabel("dateCommande :");
	ldateCommande.setFont(new Font("Tahoma", Font.PLAIN, 14));
	ldateCommande.setBounds(151, 319, 110, 14);
	contenu.add(ldateCommande);
	
	tdateCommande = new JTextField();
	tdateCommande.setBounds(300, 315, 208, 27);
	contenu.add(tdateCommande);
	tdateCommande.setColumns(10);
	
	JButton ajouter = new JButton("Ajouter");
	ajouter.setBounds(200, 420, 89, 23);
	contenu.add(ajouter);
	JButton quitter =new JButton("Quitter");
    quitter.setBounds(440, 420, 89, 23);
    quitter.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent evn) {
    		 Object source =evn.getSource();
    		 if(source.equals(quitter)) {
    			 System.exit(0);
    		 }
    		 
    	 }
    });
	contenu.add(quitter);
	
	ajouter.addActionListener(new ActionListener () {
		public void actionPerformed(ActionEvent evn) {
			// TODO Auto-generated method stub
			Object source=evn.getSource();
			CommandeDAO tst =new CommandeDAO();
			int idfour=(int) tidfour.getSelectedItem();
			int qte=(int)quantite.getValue();
			int codeBarre=(int)tcodeBarre.getSelectedItem();
			
			Commande cmd=new Commande(1,idfour,codeBarre,qte,tprix.getText(),tdateCommande.getText());
			
			if(source.equals(ajouter)) {
				if(quantite.getValue()==null || tprix.getText().isEmpty() || tdateCommande.getText().isEmpty() ) {
				     JOptionPane.showMessageDialog(null, " veuillez remplir tous les champs","erreur d'authentification",2);}
				else {
			     if (tst.inserer(cmd)>0) {
			    	 JOptionPane.showMessageDialog(null, " Ok Commande ajoutee","message ok",1);
			    	 
			     }else {
			    	 JOptionPane.showMessageDialog(null, " !!!! Commande non ajoutee","erreur",4);
			    	 
			     }}
			}
			
		}

	});
	

	
	JButton vider =new JButton("vider");
	vider.setBounds(320, 420, 89, 23);
	contenu.add(vider);
	vider.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evn) {
			Object source=evn.getSource();
			if(source.equals(vider)) {
				vider();
		
			}
			
		}
	});
	
	ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
	JLabel lblNewLabel = new JLabel(background);
	lblNewLabel.setBounds(0, 0, 750, 630);
	contenu.add(lblNewLabel);
	return contenu;}
	
	public void vider() {
		tidfour.setSelectedItem(0);
		tcodeBarre.setSelectedItem(0);
		quantite.setValue(0);
		tprix.setText("");
		tdateCommande.setText("");
		
		
		
	
	
}}