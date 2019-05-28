package yyg;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class CustomerLogin extends JPanel implements ActionListener {

	CustomerSginUpMain CustomerSginUpMain;
	HaJinLoginMain HaJinLoginMain;
	HaJinmain hm;
	Customersginupsystem Customersginupsystem;
	CustomerMainLogin cml;
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
		String[] btnstitle = { "   ��   ��    ��     ", "  ȸ   ��   ��   ��     " };
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

	public CustomerLogin(HaJinmain hm, CustomerMainLogin cm, HaJinLoginMain HaJinLoginMain) {
		cml = cm;
		this.hm = hm;
		this.HaJinLoginMain = HaJinLoginMain;
		card = new CardLayout();
		totalpanel = new Panel();
		southpanel = new Panel();
		this.cml = cm;
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
		if (o == btns[0]) {// �α���
			 //DB�� ������ �� manager_info ���̺��� ������ ��ȣ�� ã�´�
			//ã�� ������ ��ȣ�� ���Ѵ�.
			String id = this.text[0].getText();//�Է��� id�� id�� ã�Ƽ� ����
			String pwd = this.text[1].getText();//�Է��� pwd�� pwd�� ã�Ƽ� ����	
			Customer_info idpwd = new Customer_info();
			idpwd.setCustomer_id(id); idpwd.setCustomer_pwd(pwd);	
			CRUDprocess crud = new CRUDprocess();
			Customer_info info = crud.selectIdPwd(idpwd);
			
			if(info == null) {//�α��� ����
				JOptionPane.showMessageDialog(hm, "ID�� PWD�� Ȯ���ϼ���");
			}else {
				JOptionPane.showMessageDialog(hm, "�α��� �Ǿ����ϴ�.");
				//�޴��� Ȱ��ȭ ���Ѿ��Ѵ�.
				hm.menu_exhibition.setEnabled(true);//�޴��� Ȱ��ȭ
				hm.menu_goodies.setEnabled(true);//�޴��� Ȱ��ȭ
				hm.menu_program.setEnabled(true);
				hm.menu_event.setEnabled(true);
				hm.card.show(hm.totalpanel, "background");
			}
			
//			hm.card.show(hm.totalpanel,"loginmain");
		}

		
		if (o == btns[1]) {// ȸ������
			cml.card.show(cml.card_pan, "CustomerSginUpMain");
		}

	}
}