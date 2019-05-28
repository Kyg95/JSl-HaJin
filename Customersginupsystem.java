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
		String[] label_name = { "ID", "��й�ȣ", "�̸�", "E-mail", "����ó", "����" };// ��������
		label = new JLabel[6];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(label_name[i]);
			panel[i].add(label[i]);
		}
		String[] label_name1 = {"*","*","*","@","*","*�ʼ�"};
		labels = new JLabel[6];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(label_name1[i]);
		}
		String[] label_name2 = {"","","","","",""};
		labelss = new JLabel[6]; //����ä��� ��
		for (int i = 0; i < labels.length; i++) {
			labelss[i] = new JLabel(label_name2[i]);
		}
			
		String[] btnstitle = { "�ߺ�Ȯ��", "����", "���" };
		btns = new JButton[3];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(btnstitle[i]);
			btns[i].addActionListener(this);
		}
		
		group = new ButtonGroup();// ������ư�� ���� �׷����
		gender = new JRadioButton[2]; // 2�迭����
		gender[0] = new JRadioButton("����", true); // �⺻����
		gender[1] = new JRadioButton("����", false);
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
		panel[1].add(labels[1]);panel[1].add(label[1]);panel[1].add(inputs[1]);// ��й�ȣ
		panel[2].add(labels[2]);panel[2].add(label[2]);panel[2].add(inputs[2]);// �̸�
		panel[3].add(label[3]); panel[3].add(inputs[3]);panel[3].add(labels[3]);panel[3].add(inputs[4]);panel[3].add(combo1);// e-mail
		panel[4].add(labels[4]);panel[4].add(label[4]);panel[4].add(combo);panel[4].add(inputs[5]);panel[4].add(inputs[6]);// ����ó
		panel[5].add(labels[5]);
		panel[6].add(label[5]);panel[6].add(gender[0]);panel[6].add(gender[1]);// ����
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
		if (o == btns[0]) { //�ߺ�Ȯ��
//			String id = inputs[0].getText();// �Է��� id�ҷ���
//			if (id == null) {
//				JOptionPane.showMessageDialog(hm, "��ID�� �������� �ʾƼ� �۾��� ������ �� �����ϴ�.");
//			} else {
//				CRUDprocess crud = new CRUDprocess();
//				Customer_info ci = crud.selectIdAndPwd(ci);
//				if (ci == null) {
//					Customer_info cust = new Customer_info();
//					cust.setCustomer_id(id);
//					int r = crud.selectIdAndPwd(cust);
//					if (r > 0) {
//						JOptionPane.showMessageDialog(hm, "�������� ��ϵǾ����ϴ�.");
//					} else {
//						JOptionPane.showMessageDialog(hm, "������ ��� �� ������ �߻��߽��ϴ�.");
//					}
//				} else {
//					JOptionPane.showMessageDialog(hm, "�̹� ������ ID�� �����մϴ�.");
//				}
//			}
			
		}
		if (o == btns[1]) {
			System.out.println("���Դ���");
			
		}
		if (o == btns[2]) {
			hm.card.show(hm.totalpanel, "image");
			hm.btnspanel.setVisible(true);
		}

	}
}