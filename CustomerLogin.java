package yg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class CustomerLogin extends JPanel implements ActionListener {

	CustomerSginUpMain CustomerSginUpMain;
	HaJinLoginMain HaJinLoginMain;
	HaJinmain hm;
	Customersginupsystem Customersginupsystem;
	CustomerMainLogin CustomerMainLogin;
	CardLayout card;
	Panel totalpanel, southpanel;
	JPanel[] panel;
	JLabel[] label;
	JPanel btnpanel;
	JTextField[] text;
	JButton[] btns;

	void make() {
		panel = new JPanel[9];
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		String[] labeltitle = { "", " ID ", " Pw ", "" };
		label = new JLabel[3];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(labeltitle[i]);
		}
		text = new JTextField[2];
		for (int i = 0; i < text.length; i++) {
			text[i] = new JTextField(15);
		}
		String[] btnstitle = { "   로   그    인     ", "  회   원   가   입     " };
		btns = new JButton[2];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(btnstitle[i]);
			btns[i].addActionListener(this);
		}
		panel[0].add(label[1]);
		panel[0].add(text[0]);
		panel[1].add(label[2]);
		panel[1].add(text[1]);
		panel[2].add(btns[0]);
		panel[2].add(btns[1]);
		panel[3].add(label[0]);panel[4].add(label[0]);panel[5].add(label[0]);
		panel[6].add(label[0]);panel[7].add(label[0]);
		
		
		for (int i = 0; i < panel.length - 1; i++) {
			totalpanel.add(panel[i]);
			totalpanel.setLayout(new GridLayout(8, 1));
		}
		panel[0].setBackground(new Color(153, 255, 255));
		panel[1].setBackground(new Color(153, 255, 255));
		panel[2].setBackground(new Color(153, 255, 255));
		panel[3].setBackground(new Color(153, 255, 255));
		panel[4].setBackground(new Color(153, 255, 255));
		panel[5].setBackground(new Color(153, 255, 255));
		panel[6].setBackground(new Color(153, 255, 255));
		panel[7].setBackground(new Color(153, 255, 255));
	}

	CustomerLogin(HaJinmain hm, CustomerMainLogin CustomerMainLogin, HaJinLoginMain HaJinLoginMain) {
		this.hm = hm;
		this.HaJinLoginMain = HaJinLoginMain;
		card = new CardLayout();
		totalpanel = new Panel();
		southpanel = new Panel();
		this.CustomerMainLogin = CustomerMainLogin;
		Customersginupsystem = new Customersginupsystem(hm);
		CustomerSginUpMain = new CustomerSginUpMain(hm);
		southpanel.setLayout(card);
		totalpanel.setLayout(card);
		make();
		this.add("Center", totalpanel);
		this.add("South", southpanel);
		this.setBackground(new Color(153,255,255));
		this.setBounds(300, 300, 700, 600);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if (o == btns[0]) {// 로그인
			//MainLogin.card.show(MainLogin.card_pan, "HaJinLoginMain");
			hm.card.show(hm.totalpanel,"loginmain");
		}
		
		if (o == btns[1]) {// 회원가입
			CustomerMainLogin.card.show(CustomerMainLogin.card_pan, "CustomerSginUpMain");
		}

	}
}