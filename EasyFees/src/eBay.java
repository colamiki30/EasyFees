import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class eBay implements ActionListener {

	private static final String Static = null;
	JFrame f = new JFrame("Calcolo Tariffe eBay");
	Container c = f.getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p5 = new JPanel();
	JButton b1 = new JButton("CALCOLA");
	JButton b2 = new JButton("AIUTO");
	JButton b3 = new JButton("INDIETRO");
	JButton b4 = new JButton("DONAZIONI");
	JLabel l1 = new JLabel("Inserire il prezzo di vendita (NO SPESE DI SPEDIZIONE)");
	JLabel l2 = new JLabel("Al netto delle tariffe eBay otterrai l'importo indicato di seguito.");
	JLabel l3 = new JLabel("A sinistra di ogni simbolo troverai il guadagno netto con solo le tariffe del servizio indicato.");
	JLabel l4 = new JLabel("A destra di ogni simbolo troverai la tariffa applicata dal servizio indicato.");
	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	JTextField t3 = new JTextField(10);
	JTextField t6 = new JTextField(10);
	
	ImageIcon imageIcon;
	
	JLabel img = new JLabel();
	
	JLabel message = new JLabel();
	
	public eBay() {
		p1.add(l1);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(t1);
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(l3);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(l4);
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(p1,BorderLayout.NORTH);
		p1.setLayout(new GridLayout(6,2,2,2)); 
		
		
		p2.add(t3);
		imageIcon = new ImageIcon(getClass().getClassLoader().getResource("ebay.png"));
	    Image image = imageIcon.getImage();
		img.setIcon(new ImageIcon(image));
		p2.add(img);
		p2.add(t6);
		f.add(p2,BorderLayout.WEST);
		
		
		f.add(p2,BorderLayout.WEST);
		p3.add(l2);
		p3.add(t2);
		p3.add(b1);
		f.add(p3,BorderLayout.SOUTH);
		
		
		p5.add(b2);
		p5.add(b3);
		p5.add(b4);
		p5.setLayout(new GridLayout(3,1,20,20)); 
		f.add(p5,BorderLayout.CENTER);
		
		t2.setEditable(false);
		t3.setEditable(false);
		t6.setEditable(false);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(450,250);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		double tot=0,tot1,calcPP,tot2,tot3,tot4,tt;
		final int eBayFee=10,t=100;
		final double PPfee=3.4,mustPP=0.35;
		String nulla = "";
		int ascii;
		if(e.getSource()==b1) {
			if(nulla.equals(t1.getText())){
				message.setText("Per favore inserisci il prezzo!");
				JOptionPane.showMessageDialog(null,message,"ATTENZIONE!",JOptionPane.WARNING_MESSAGE);
			}
			
			String p=t1.getText();
			boolean a=false;
			for(int i=0;i<p.length();i++) {				
				ascii = (int)((CharSequence) p).charAt(i);
				
				p=p.replace(",",".");
				
				if(ascii>=0&&ascii<46&&ascii!=44&&a==false) {
					a = true;
				}
				
				if(ascii>46&&ascii<48&&ascii>57&&a==false) {
					a = true;
				}
				
				if(ascii==47&&a==false) {
					a = true;
				}
			}
		
		if(a==true) {
			message.setText("Per favore non inserire caratteri non ammessi!");
			JOptionPane.showMessageDialog(null,message,"ATTENZIONE!",JOptionPane.WARNING_MESSAGE);
			t2.setText("");
			t3.setText("");
			t6.setText("");
		}
		
		else {
			double pu=Double.parseDouble(p);
			tot = (eBayFee*pu)/t; //percentuale di fee ebay (10%)
			tot1 = pu-tot; //togliamo dal totale la percentuale calcolata es. 100€-10€=90€
			String totalebay=String.format("%.2f",tot1);
			calcPP = (PPfee*pu)/t; //fee PP (3.4%)*val inserito, fratto 100
			tot2 = pu-calcPP; 
			tot3 = calcPP+mustPP;
			tt = tot2-mustPP;
			tot4 = pu-tot3-tot;
			String totale=String.format("%.2f",tot4);
			String totalePP=String.format("%.2f",tt);
			String feebay=String.format("%.2f", tot);
			t2.setText(totalebay+"€");
			t3.setText(totalebay+"€");
			t6.setText(feebay+"€");
			}
		}
		
		if(e.getSource()==b2) {
			new aiutoebay();
			f.setVisible(false);
		}
		
		if(e.getSource()==b3) {
			new EasyFees();
			f.setVisible(false);
		}
		
		if(e.getSource()==b4) {
	        openWebPage("https://www.paypal.me/colamiki30");

		}
	}

	private void openWebPage(String string) {
		try {         
		     java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.paypal.me/colamiki30"));
		   }
		   catch (java.io.IOException e) {
		       System.out.println(e.getMessage());
		   }
	}

}