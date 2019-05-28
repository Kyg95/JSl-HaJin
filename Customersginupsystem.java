package yyg;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Customersginupsystem extends JPanel implements ActionListener {

	
	HaJinmain hm;
	CustomerMainLogin CustomerMainLogin;
	CardLayout card;
	Panel centerpanel;
	JPanel[] panel;
	JLabel[] label, labels,labelss;
	JButton[] btns;
	JTextField[] inputs;
	JRadioButton[] gender;
	ButtonGroup group;
	JComboBox combo,combo1;
	
	void doIt() {
		panel = new JPanel[9];
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		inputs = new JTextField[7];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new JTextField(10);
		}
		String[] label_name = { "ID", "비밀번호", "이름", "E-mail", "연락처", "성별" };// 기초정보
		label = new JLabel[6];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(label_name[i]);
			panel[i].add(label[i]);
		}
		String[] label_name1 = {"*","*","*","@","*","*필수"};
		labels = new JLabel[6];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(label_name1[i]);
		}
		String[] label_name2 = {"","","","","",""};
		labelss = new JLabel[6]; //공간채우기 라벨
		for (int i = 0; i < labels.length; i++) {
			labelss[i] = new JLabel(label_name2[i]);
		}
			
		String[] btnstitle = { "중복확인", "가입", "취소" };
		btns = new JButton[3];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(btnstitle[i]);
			btns[i].addActionListener(this);
		}
		
		group = new ButtonGroup();// 라디오버튼을 위한 그룹생성
		gender = new JRadioButton[2]; // 2배열생성
		gender[0] = new JRadioButton("남성", true); // 기본선택
		gender[1] = new JRadioButton("여성", false);
		group.add(gender[0]);
		group.add(gender[1]);
		combo = new JComboBox();
		combo.addItem("010");
		combo1 = new JComboBox();
		combo1.addItem("naver.com");
		combo1.addItem("gmail.com");
		combo1.addItem("daum.net");
		
		
		panel[0].add(labels[0]);panel[0].add(label[0]);
		panel[0].add(inputs[0]);panel[0].add(labelss[0]);panel[0].add(btns[0]);// id
		panel[1].add(labels[1]);panel[1].add(label[1]);panel[1].add(inputs[1]);// 비밀번호
		panel[2].add(labels[2]);panel[2].add(label[2]);panel[2].add(inputs[2]);// 이름
		panel[3].add(label[3]); panel[3].add(inputs[3]);panel[3].add(labels[3]);panel[3].add(inputs[4]);panel[3].add(combo1);// e-mail
		panel[4].add(labels[4]);panel[4].add(label[4]);panel[4].add(combo);panel[4].add(inputs[5]);panel[4].add(inputs[6]);// 연락처
		panel[5].add(labels[5]);
		panel[6].add(label[5]);panel[6].add(gender[0]);panel[6].add(gender[1]);// 성별
		panel[7].add(btns[1]); panel[7].add(btns[2]);
		
		for (int i = 0; i < panel.length - 1; i++) {
			centerpanel.add(panel[i]);
			centerpanel.setLayout(new GridLayout(8, 1));
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

	public Customersginupsystem(HaJinmain hm) {
		this.hm = hm;
		card = new CardLayout();
		centerpanel = new Panel();
		centerpanel.setLayout(card);
		doIt();
		this.add("Center", centerpanel);
		this.setBounds(300, 300, 700, 600);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btns[0]) { //중복확인
//			String id = inputs[0].getText();// 입력한 id불러옴
//			if (id == null) {
//				JOptionPane.showMessageDialog(hm, "고객ID가 존재하지 않아서 작업을 진행할 수 없습니다.");
//			} else {
//				CRUDprocess crud = new CRUDprocess();
//				Customer_info ci = crud.selectIdAndPwd(ci);
//				if (ci == null) {
//					Customer_info cust = new Customer_info();
//					cust.setCustomer_id(id);
//					int r = crud.selectIdAndPwd(cust);
//					if (r > 0) {
//						JOptionPane.showMessageDialog(hm, "고객정보가 등록되었습니다.");
//					} else {
//						JOptionPane.showMessageDialog(hm, "고객정보 등록 중 문제가 발생했습니다.");
//					}
//				} else {
//					JOptionPane.showMessageDialog(hm, "이미 동일한 ID가 존재합니다.");
//				}
//			}
			
		}
		if (o == btns[1]) {
			System.out.println("가입누름");
			
		}
		if (o == btns[2]) {
			hm.card.show(hm.totalpanel, "image");
			hm.btnspanel.setVisible(true);
		}

	}
}