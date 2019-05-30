package yyg;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NcustomerSginUp extends JPanel implements ActionListener {

	
	HaJinLoginMain HaJinLoginMain;
	NcustomerMain NcustomerMain;
	CustomerMainLogin CustomerMainLogin;
	CustomerLogin CustomerLogin;
	HaJinmain hm;
	CardLayout card;
	Panel totalpanel;
	JPanel[] panel;
	JLabel[] label, beelabel;
	JButton[] btns;
	JTextField[] inputs;

	void doIt() {
		panel = new JPanel[4];
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		inputs = new JTextField[3];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new JTextField(20);
		}
		String[] label_name = { "이름", "E-mail", "연락처" };// 기초정보
		label = new JLabel[3];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(label_name[i]);
			panel[i].add(label[i]);
		}

		String[] btnstitle = { "가입", "취소" };
		btns = new JButton[2];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(btnstitle[i]);
			btns[i].addActionListener(this);
		}

		panel[0].add(label[0]);// 이름
		panel[0].add(inputs[0]);
		panel[1].add(label[1]);// mail
		panel[1].add(inputs[1]);
		panel[2].add(label[2]);// 연락처
		panel[2].add(inputs[2]);
		panel[3].add(btns[0]); //버튼
		panel[3].add(btns[1]);

		for (int i = 0; i < panel.length; i++) {
			totalpanel.add(panel[i]);
			totalpanel.setLayout(new GridLayout(4, 1));
		}
		panel[0].setBackground(new Color(153, 255, 255));
		panel[1].setBackground(new Color(153, 255, 255));
		panel[2].setBackground(new Color(153, 255, 255));
		panel[3].setBackground(new Color(153, 255, 255));
	}

	public NcustomerSginUp(HaJinmain hm, CustomerMainLogin CustomerMainLogin) {
		this.hm = hm;
		this.CustomerMainLogin = CustomerMainLogin;
		HaJinLoginMain HaJinLoginMain;
		NcustomerMain NcustomerMain;
		card = new CardLayout();
		totalpanel = new Panel();
		totalpanel.setLayout(card);
		doIt();
		this.add("Center", totalpanel);
		this.setBounds(300, 300, 700, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		CRUDprocess crud = new CRUDprocess();
		if (o == btns[0]) { //가입
			String ncustomer_name = 
			String ncustomer_email = 
			int ncustomer_phone = Integer.valueOf((inputs[5].getText() + inputs[6].getText()));
			
			NCustomer_info cust = new NCustomer_info();
			cust.setNcustomer_name(ncustomer_name);
			cust.setNcustomer_email(ncustomer_email);
			cust.setNcustomer_phone(ncustomer_phone);
			int r = crud.insertNCustomer(cust);
			if (r > 0) {
				JOptionPane.showMessageDialog(hm, "고객정보가 등록되었습니다.");
			} else {
				JOptionPane.showMessageDialog(hm, "고객정보 등록 중 문제가 발생했습니다.");
			}
		}
			
		if (o == btns[1]) { //취소 메인으로 돌아감
			hm.card.show(hm.totalpanel, "image");
			hm.btnspanel.setVisible(true);
		}

	}
}