import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class aiutoebayPP implements ActionListener{

	JFrame f = new JFrame("Aiuto - Calcolo tariffe eBay + PayPal");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JLabel info1=new JLabel();
	JLabel info2=new JLabel();
	JButton b1 = new JButton("<< - Indietro - >>");
    
	private Color color=Color.LIGHT_GRAY;
	
	public aiutoebayPP() 
	{
		
		f.add(p1);
		p1.setBackground(color);
		p1.setLayout(new GridLayout(5,1));

		
		info1.setText("Ricorda! Le tariffe eBay ammontano al 10% del prezzo di vendita (salvo promo).");	
		info1.setFont(new Font("Arial_Black",Font.PLAIN,20));
		p1.add(info1);
		info2.setText("Ricorda! Le tariffe PayPal ammontano al 3.4% del prezzo di vendita + 0.35� fissi (solo per pagamenti in zona �).");
		info2.setFont(new Font("Arial_Black",Font.PLAIN,20));
		p1.add(info2);
		
		p2.add(b1);
		f.add(p2,BorderLayout.SOUTH);
		
		b1.addActionListener(this);
		f.pack();	
		f.setLocation(450,250);
		f.setVisible(true);	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			new eBayPP();
			f.setVisible(false);
		}
	}

}
