package Interfaces;

import java.awt.Color;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;


import DAO.UserDAO;
import metier.User;

public class UserAjout {
JTextField tnom,tprenom,tlogin,tnumtel,tadresse;
JPasswordField password;
JRadioButton ch1, ch2;	
	JButton ajouter;
	
	
	public JPanel getContenu() {
		JPanel contenu=new JPanel();
		contenu.setForeground(new Color(0, 0, 0));
		contenu.setBackground(Color.LIGHT_GRAY);
		contenu.setLayout(null);
		contenu.setBounds(80, 100, 696, 592);
		
		JLabel AjouterUser= new JLabel("Ajouter utilisteur");
		AjouterUser.setForeground(Color.black);
		AjouterUser.setBackground(Color.CYAN);
		AjouterUser.setOpaque(true);
		AjouterUser.setBorder(BorderFactory.createEtchedBorder(new Color(0,0,0),null));
		AjouterUser.setFont(new Font("Tahoma", Font.BOLD, 36));
		AjouterUser.setHorizontalTextPosition(SwingConstants.CENTER);
		AjouterUser.setPreferredSize(new Dimension(200, 100));
		AjouterUser.setLocation(new Point(200, 200));
		AjouterUser.setHorizontalAlignment(SwingConstants.CENTER);
		AjouterUser.setIgnoreRepaint(true);
		AjouterUser.setBounds(100, 24, 525, 46);
		contenu.add(AjouterUser);
		
		JLabel Lnom = new JLabel("Nom :");
		Lnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lnom.setBounds(151, 105, 46, 24);
		contenu.add(Lnom);
		
		tnom = new JTextField();
		tnom.setBounds(300, 102, 208, 27);
		contenu.add(tnom);
		tnom.setColumns(10);
		
		JLabel lprenom = new JLabel("Prenom :");
		lprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lprenom.setBounds(149, 164, 76, 22);
		contenu.add(lprenom);
		
		tprenom = new JTextField();
		tprenom.setBounds(300, 159, 208, 27);
		contenu.add(tprenom);
		tprenom.setColumns(10);
		
		JLabel llogin = new JLabel("Login:");
		llogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		llogin.setBounds(151, 211, 106, 22);
		contenu.add(llogin);
		
		 tlogin = new JTextField();
		tlogin.setBounds(300, 211, 208, 27);
		contenu.add(tlogin);
		tlogin.setColumns(10);
		
		JLabel lpassword = new JLabel("Password :");
		lpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lpassword.setBounds(151, 263, 80, 14);
		contenu.add(lpassword);
		
		JPasswordField password = new JPasswordField(); 
		password.setBounds(300, 259, 208, 27);
		contenu.add(password);
		password.setColumns(10);
		
		JLabel ltype = new JLabel("Type :");
		ltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ltype.setBounds(151, 319, 63, 14);
		contenu.add(ltype);
		
        ButtonGroup g1=new ButtonGroup();
        ch1 =new JRadioButton ("employé");
        ch2 =new JRadioButton("gérant");
        
        ch1.setBounds(300, 315, 80, 30);
        ch2.setBounds(430,315, 80, 30);
        g1.add(ch1);
        g1.add(ch2);
        contenu.add(ch1);
        contenu.add(ch2);
        

		JLabel Lnumtel = new JLabel("numTel :");
		Lnumtel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lnumtel .setBounds(151, 370, 90, 24);
		contenu.add(Lnumtel );
		
		JLabel Ladresse = new JLabel("Adresse:");
		Ladresse .setFont(new Font("Tahoma", Font.PLAIN, 14));
		Ladresse .setBounds(151, 420, 90, 24);
		contenu.add(Ladresse );
		
			
		tnumtel = new JTextField();
		
		tnumtel.setBounds(300, 370, 208, 27);
		contenu.add(tnumtel);
		
		tadresse = new JTextField();
		tadresse.setBounds(300, 420, 208, 27);
		contenu.add(tadresse);
		tadresse.setColumns(10);
        
        JButton quitter =new JButton("Quitter");
	    quitter.setBounds(440, 470, 89, 23);
	    quitter.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent evn) {
	    		 Object source =evn.getSource();
	    		 if(source.equals(quitter)) {
	    			 System.exit(0);
	    		 }
	    		 
	    	 }
	    });
		contenu.add(quitter);
        
        JButton ajouter = new JButton("Ajouter");
		ajouter.setBounds(200, 470, 89, 23);
		contenu.add(ajouter);
		
		ajouter.addActionListener(new ActionListener () {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evn) {
				// TODO Auto-generated method stub
				Object source=evn.getSource();
				
				
					String type="";
					if(ch1.isSelected()) {
						type="employe";
					}else {
						type="gerant";
					}
					UserDAO tst=new UserDAO();
					
					User use=new User(1,tnom.getText(),tprenom.getText(),tlogin.getText(),password.getText(),type,tnumtel.getText(),tadresse.getText());
					if(source.equals(ajouter)) {
						if(tnom.getText().isEmpty() || tprenom.getText().isEmpty() || password.getText().isEmpty() ) {
								     JOptionPane.showMessageDialog(null, " veuillez remplir tous les champs","Avertissement",2);}
								
								else {

				     if (tst.inserer(use)>0) {
				    	 JOptionPane.showMessageDialog(null, " ok Utilisateur ajouté","message ok",2);
				     }else {
				    	 JOptionPane.showMessageDialog(null, " !!!! Utilisateur non ajouté","erreur",2);
				    	 
				     }
				}}
				
			}

		});JButton vider =new JButton("vider");
		vider.setBounds(320, 470, 89, 23);
		
		vider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				Object source=evn.getSource();
				if(source.equals(vider)) {
					tnom.setText("");
					tprenom.setText("");
					tlogin.setText("");
					password.setText("");
					ch1.setSelected(false);
					ch2.setSelected(false);
					tnumtel.setText("");
					tadresse.setText("");
			
				}
				
			}
		});
		contenu.add(vider);
		ImageIcon background=new ImageIcon(".\\figures\\bac.jpg");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 750, 630);
		contenu.add(lblNewLabel);
		return contenu;}
	
	

        
        

        
        
        
		
}



