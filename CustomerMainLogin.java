package yg;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CustomerMainLogin extends JPanel {
	
	NcustomerSginUp NcustomerSginUp;
	HaJinLoginMain HaJinLoginMain;
	CustomerMainLogin CustomerMainLogin;
	CustomerLogin pan1;
	NcustomerMain pan2;
	JTabbedPane tabs;
	CardLayout card;
	JPanel card_pan;
	CustomerSginUpMain CustomerSginUpMain;
	
	CustomerMainLogin(HaJinmain hm){
		card = new CardLayout();
		card_pan = new JPanel(card);
		tabs = new JTabbedPane();
		CustomerSginUpMain = new CustomerSginUpMain(hm);
		NcustomerSginUp = new NcustomerSginUp(hm,this);
		pan1 = new CustomerLogin(hm,this,HaJinLoginMain); 
		pan2 = new NcustomerMain(hm,this);
		tabs.addTab("    회           원    ", pan1);
		tabs.addTab("    비     회     원    ", pan2);
		card_pan.add(tabs,"tabs");
		card_pan.add(CustomerSginUpMain,"CustomerSginUpMain");
		card_pan.add(NcustomerSginUp,"NonSginUp");
		this.add("Center",card_pan);
		this.setBounds(300, 300, 700, 600);
	}
	public static void main(String[] args) {
	}

}