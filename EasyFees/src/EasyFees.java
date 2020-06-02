import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;


public class EasyFees implements ActionListener {
	
	JFrame f = new JFrame("EasyFees");
	Container c = f.getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JButton b1 = new JButton("Tariffe eBay + PayPal");
	JButton b2 = new JButton("Tariffe SOLO eBay");
	JButton b3 = new JButton("Tariffe SOLO PayPal");
	JLabel l1 = new JLabel("Sviluppato da Michele Coladangelo :)");
	JLabel l2 = new JLabel("Versione 1.0");
	JButton b4 = new JButton("Twitter");
	JButton b5 = new JButton("Contatti");
	
	ImageIcon imageIcon;
	
	JLabel img = new JLabel();
	
	public EasyFees() {
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.setLayout(new GridLayout(3,1,20,20));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.add(p1,BorderLayout.CENTER);
		
		p2.add(l1);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
	    l1.setFont(new Font("Verdana", Font.PLAIN, 15));
	    p2.add(l2);
	    l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setFont(new Font("Verdana",Font.PLAIN,15));
		p2.add(b4);
		b4.setForeground(Color.BLUE);
		p2.add(b5);
		b5.setForeground(Color.BLUE);
		p2.setLayout(new GridLayout(4,1,10,10));
		f.add(p2,BorderLayout.SOUTH);
		
		imageIcon = new ImageIcon(getClass().getClassLoader().getResource("easyfeeicon.png"));
	    Image image = imageIcon.getImage();
	    Image newimg = image.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH);
		img.setIcon(new ImageIcon(newimg));
		p3.add(img);
		f.add(p3,BorderLayout.NORTH);
		
		f.setSize(350,400);
		f.setLocation(450,250);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			new eBayPP();
			f.setVisible(false);
		}
		
		if(e.getSource()==b2) {
			new eBay();
			f.setVisible(false);
		}
		
		if(e.getSource()==b3) {
			new PayPal();
			f.setVisible(false);
		}
		
		if(e.getSource()==b4) {
			openWebPage("https://twitter.com/colamiki30");
		}
		
		if(e.getSource()==b5) {
			Desktop desktop = Desktop.getDesktop();
			String message = "mailto:colamiki30@gmail.com?subject=Vorrei%20Dirti%20Qualcosa%20Riguardo%20Ad%20EasyFees!";
			URI uri = URI.create(message);
			try {
				desktop.mail(uri);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private void openWebPage(String string) {
		
			try {         
			     java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://twitter.com/colamiki30"));
			   }
			   catch (java.io.IOException e) {
			       System.out.println(e.getMessage());
			   }

	}

	public static void main(String[] args) {
		EasyFees o = new EasyFees();
	}

}
