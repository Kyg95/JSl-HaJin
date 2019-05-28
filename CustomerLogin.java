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
		if (o == btns[0]) {// 로그인
			 //DB에 접속한 후 manager_info 테이블에서 계정과 암호를 찾는다
			//찾은 계정과 암호를 비교한다.
			String id = this.text[0].getText();//입력한 id를 id에 찾아서 저장
			String pwd = this.text[1].getText();//입력한 pwd를 pwd에 찾아서 저장	
			Customer_info idpwd = new Customer_info();
			idpwd.setCustomer_id(id); idpwd.setCustomer_pwd(pwd);	
			CRUDprocess crud = new CRUDprocess();
			Customer_info info = crud.selectIdPwd(idpwd);
			
			if(info == null) {//로그인 실패
				JOptionPane.showMessageDialog(hm, "ID와 PWD를 확인하세요");
			}else {
				JOptionPane.showMessageDialog(hm, "로그인 되었습니다.");
				//메뉴를 활성화 시켜야한다.
				hm.menu_exhibition.setEnabled(true);//메뉴바 활성화
				hm.menu_goodies.setEnabled(true);//메뉴바 활성화
				hm.menu_program.setEnabled(true);
				hm.menu_event.setEnabled(true);
				hm.card.show(hm.totalpanel, "background");
			}
			
//			hm.card.show(hm.totalpanel,"loginmain");
		}

		
		if (o == btns[1]) {// 회원가입
			cml.card.show(cml.card_pan, "CustomerSginUpMain");
		}

	}
}